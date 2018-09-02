package databasedemo.com.example.raj.ivy.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import databasedemo.com.example.raj.ivy.model.UserData;

public class UserProfile extends AppCompatActivity {

    EditText userProfile_Username;
    EditText userProfile_Name;
    EditText userProfile_Email;
    EditText userProfile_Password;

    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userProfile_Username = (EditText) findViewById(R.id.userProfile_Username);
        userProfile_Name = (EditText) findViewById( R.id.userProfile_Name);
        userProfile_Email = (EditText) findViewById( R.id.userProfile_Email);
        userProfile_Password = (EditText) findViewById( R.id.userProfile_Password);

        dbAdapter = new DBAdapter(UserProfile.this);
    }

    public void userProfileUpdateButton_Clicked(View view){

        String username = userProfile_Username.getText().toString();
        String name = userProfile_Name.getText().toString();
        String email = userProfile_Email.getText().toString();
        String password = userProfile_Password.getText().toString();

        UserData userData = new UserData(username, name, email, password);
        dbAdapter.updateUser(userData);
    }

    public void userProfileDeleteButton_Clicked (View view){

        String deleteusername = userProfile_Username.getText().toString();
        dbAdapter.deleteUser(deleteusername);

    }

}
