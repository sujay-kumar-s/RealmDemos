package com.example.aqua.realmdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) findViewById(R.id.usersrv);
        linearLayoutManager = new LinearLayoutManager(HomeActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
//call database task
        Realm.init(HomeActivity.this);
        RealmResults<User> realmResults = DatabaseTask.getAll();

        UserAdapter adapter=new UserAdapter(HomeActivity.this,realmResults);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option1:
                Intent intent=new Intent(HomeActivity.this,UpdateProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.option2:
                Intent delete_intent=new Intent(HomeActivity.this,DeleteUserActivity.class);
                startActivity(delete_intent);
                Toast.makeText(HomeActivity.this, "Delete Profile", Toast.LENGTH_LONG).show();
                break;
            case R.id.option3:
                Toast.makeText(HomeActivity.this, "Help", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    }
