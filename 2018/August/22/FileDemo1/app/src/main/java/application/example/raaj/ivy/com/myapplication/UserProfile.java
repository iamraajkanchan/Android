package application.example.raaj.ivy.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class UserProfile extends AppCompatActivity {

    EditText userprofile_Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_user_profile );

        userprofile_Message = (EditText) findViewById ( R.id.userprofile_message );

        Intent mainIntent = getIntent ();
        Bundle mainBundle = mainIntent.getExtras ();
        String userName = mainBundle.getString ( "username_intent" );

        userprofile_Message.setText ( "Welcome" + userName );
    }

}
