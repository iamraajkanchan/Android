package application.example.raaj.ivy.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Registration extends AppCompatActivity {

    EditText reg_Username, reg_Name, reg_Email, reg_Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_registration );

        reg_Username = (EditText) findViewById ( R.id.reg_username );
        reg_Name = (EditText) findViewById ( R.id.reg_name );
        reg_Email = (EditText) findViewById ( R.id.reg_email );
        reg_Password = (EditText) findViewById ( R.id.reg_password );

    }

    public void onRegRegisterClicked(View view){

        String userName = reg_Username.getText ().toString ();
        String name = reg_Name.getText ().toString ();
        String email = reg_Email.getText ().toString ();
        String password = reg_Password.getText ().toString ();

        try{

            File file = new File("userProfile.txt");
            FileOutputStream fos = openFileOutput ( file.toString (), MODE_APPEND );
            OutputStreamWriter osw = new OutputStreamWriter ( fos );
            osw.append ( userName + "~" + name + "~" + email + "~" + password );
            Toast.makeText ( this, "Registered Successfully", Toast.LENGTH_SHORT ).show ();

        }
        catch(Exception e){
            Toast.makeText ( this, e.getMessage (), Toast.LENGTH_SHORT ).show ();
        }

        final Intent navMain = new Intent ( Registration.this, MainActivity.class );

        new Handler (  ).postDelayed ( new Runnable () {
            @Override
            public void run() {
                startActivity ( navMain );
            }
        }, 1000 );

    }

}
