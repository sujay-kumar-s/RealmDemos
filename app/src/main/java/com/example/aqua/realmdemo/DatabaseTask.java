package com.example.aqua.realmdemo;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by aqua on 12/18/2016.
 */

public class DatabaseTask {
    private static Realm realm = Realm.getDefaultInstance();

    public static boolean addUser(String name, String email, String password) {
        if (name.length() != 0 && email.length() != 0 && password.length() != 0) {
            realm.beginTransaction();
            User user = realm.createObject(User.class);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            realm.commitTransaction();
            return true;
        } else {
            return false;
        }


    }

    public static RealmResults<User> getUserDetails(String usn) {
        //Build the query
      //  RealmQuery<User> query = realm.where(User.class);
        //Add query conditions
        RealmResults<User> userRealmResults = realm.where(User.class)
                .equalTo("name", usn).findAll();
       return userRealmResults;
        //Execute the query


    }

}
