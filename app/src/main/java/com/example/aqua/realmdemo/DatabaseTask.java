package com.example.aqua.realmdemo;

import android.os.AsyncTask;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by aqua on 12/18/2016.
 */
//
    //olacab
/*
    why should do the database task or internet task run on a separate thread?
when the application starts executing, by ART(android run time) it creates only one
thread by the name main thread or the ui thread. the main thread is responsible for
the all the user interactions with the activity.
=>if the main thread runs a long running task then

*/
public class DatabaseTask{
    private static Realm realm = Realm.getDefaultInstance();


    private static User u1=null;
    public static boolean addUser(SignupActivity s, String name, String email, String password) {


        if (name.length() != 0 && email.length() != 0 && password.length() != 0) {
            realm.beginTransaction();
            User  user = realm.createObject(User.class);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            //  Toast.makeText(s, "inside success", Toast.LENGTH_LONG).show();
            realm.commitTransaction();
            return true;
        } else {
            Toast.makeText(s, "0 length", Toast.LENGTH_LONG).show();

            return false;
        }


    }

    public static  RealmResults<User> getUserDetails(String email) {
        //Add query conditions
        RealmResults<User> userRealmResults = realm.where(User.class)
                .equalTo("email", email).findAll();
        return userRealmResults;


    }

    public static  RealmResults<User> getAll() {
        //Add query conditions
        RealmResults<User> userRealmResults = realm.where(User.class).findAll();
        return userRealmResults;


    }


    public static  boolean updateuser(String email,String newpassword)
    {

        u1=realm.where(User.class).equalTo("email",email).findFirst();
        if(u1!=null) {
            realm.beginTransaction();
            u1.setPassword(newpassword);
            realm.commitTransaction();
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean deleteUser(String email)
    {
        //Add query conditions
        RealmResults<User> userRealmResults = realm.where(User.class).equalTo("email",email).findAll();

        if(userRealmResults!=null) {
            realm.beginTransaction();
            userRealmResults.deleteFirstFromRealm();    //delete object from database

            realm.commitTransaction();
            return true;
        }
        else
        {
            return false;
        }

    }


}
