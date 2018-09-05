package databasedemo.com.example.raj.ivy.databasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import databasedemo.com.example.raj.ivy.model.UserData;

public class AddUser extends AppCompatActivity {

    EditText addUser_Username;
    EditText addUser_Name;
    EditText addUser_Email;
    EditText addUser_Password;

    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        addUser_Username = (EditText) findViewById(R.id.addUser_Username);
        addUser_Name = (EditText) findViewById(R.id.addUser_Name);
        addUser_Email = (EditText) findViewById(R.id.addUser_Email);
        addUser_Password = (EditText) findViewById(R.id.addUser_Password);

        dbAdapter = new DBAdapter(AddUser.this);
    }

    public void addUser_AddButtonClicked(View view){

        UserData userData = new UserData(addUser_Username.getText().toString(), addUser_Name.getText().toString(), addUser_Email.getText().toString(), addUser_Password.getText().toString());

        long i = dbAdapter.addUser(userData);

        if(i > 0){
            Toast.makeText(this, "Data saved to database successfully", Toast.LENGTH_SHORT).show();
            Intent mainIntent = new Intent(AddUser.this, MainActivity.class);
            startActivity(mainIntent);
        }
        else {
            Toast.makeText(this, "Error Occured", Toast.LENGTH_SHORT).show();
        }
    }
}
