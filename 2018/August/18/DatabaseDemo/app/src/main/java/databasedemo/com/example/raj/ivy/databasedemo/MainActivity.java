package databasedemo.com.example.raj.ivy.databasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

import databasedemo.com.example.raj.ivy.model.UserData;

public class MainActivity extends AppCompatActivity {

    EditText main_Username;
    EditText main_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_Username = (EditText) findViewById(R.id.main_Username);
        main_Password = (EditText) findViewById(R.id.main_Password);
    }

    public void main_LoginButtonClicked (View view){

        String username = main_Username.getText().toString();
        String password = main_Password.getText().toString();
        DBAdapter dbAdapter = new DBAdapter(MainActivity.this);
        boolean login = false;
        ArrayList<UserData> users;
        users = dbAdapter.displayUser();
        Iterator i = users.listIterator();
        Integer user_index = 0;
        while(i.hasNext()){
            if(username.equals(users.get(user_index).getUsername())&& password.equals(users.get(user_index).getPassword())){
                login = true;
                break;
            }
            user_index++;
        }
        if(username.equals("admin") && password.equals("password")){
            Intent userListIntent = new Intent(MainActivity.this, UserList.class);
            startActivity(userListIntent);
        }
        else if(login){
            Intent userProfileIntent = new Intent(MainActivity.this, UserProfile.class);
            userProfileIntent.putExtra("username", users.get(user_index).getUsername());
            userProfileIntent.putExtra("name", users.get(user_index).getUsername());
            userProfileIntent.putExtra("email", users.get(user_index).getEmail());
            userProfileIntent.putExtra("password", users.get(user_index).getPassword());
            startActivity(userProfileIntent);
        }
        else {
            Toast.makeText(this, "Please try again", Toast.LENGTH_SHORT).show();
        }
    }
    public void main_RegisterButtonClicked (View view){
        Intent addUserIntent = new Intent(MainActivity.this, AddUser.class);
        startActivity(addUserIntent);
    }
}
