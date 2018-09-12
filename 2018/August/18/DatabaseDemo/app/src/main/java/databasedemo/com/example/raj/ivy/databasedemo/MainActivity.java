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

        main_Username = findViewById(R.id.main_Username);
        main_Password = findViewById(R.id.main_Password);
    }

    public void main_LoginButtonClicked (View view){

        //
        String username = main_Username.getText().toString();
        String password = main_Password.getText().toString();
        DBAdapter dbAdapter = new DBAdapter(MainActivity.this);
        Intent userProfileIntent = new Intent(MainActivity.this, UserProfile.class);
        boolean login = false;
        ArrayList<UserData> users = dbAdapter.displayUser();
        Iterator i = users.iterator();
        while(i.hasNext()){
            UserData user = (UserData) i.next();
            if(username.equals(user.getUsername ()) && password.equals(user.getPassword ())){
                login = true;
                userProfileIntent.putExtra("username", user.getUsername ());
                userProfileIntent.putExtra("name", user.getName ());
                userProfileIntent.putExtra("email", user.getEmail ());
                userProfileIntent.putExtra("password", user.getPassword ());
                userProfileIntent.putExtra ( "image", user.getImageURI ());
            }
        }
        if(username.equals("admin") && password.equals("password")){
            Intent userListIntent = new Intent(MainActivity.this, UserList.class);
            startActivity(userListIntent);
        }

        else if(login){
            startActivity(userProfileIntent);
        }

        else {
            Toast.makeText(this, "Check Username and Password", Toast.LENGTH_SHORT).show();
        }
    }
    public void main_RegisterButtonClicked (View view){
        Intent addUserIntent = new Intent(MainActivity.this, AddUser.class);
        startActivity(addUserIntent);
    }
}
