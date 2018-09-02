package databasedemo.com.example.raj.ivy.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import databasedemo.com.example.raj.ivy.model.UserData;

public class UserList extends AppCompatActivity {

    ListView usersList_Users;
    DBAdapter dbAdapter;
    ArrayList<UserData> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        dbAdapter = new DBAdapter(UserList.this);
        users = dbAdapter.displayUser();


        usersList_Users = findViewById(R.id.userList_Users);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.userlistlayout, users);
        usersList_Users.setAdapter(adapter);
    }
}
