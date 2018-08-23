package application.example.raaj.ivy.com.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText main_Username;
    EditText main_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        main_Username = (EditText) findViewById ( R.id.main_username );
        main_Pass = (EditText) findViewById ( R.id.main_password );

    }

    public void onMainLoginClicked(View view){

        String username = main_Username.getText ().toString ();
        String password = main_Pass.getText ().toString ();

        try{
            File file = new File ( "userProfile.txt" );
            FileInputStream fis = openFileInput ( file.toString () );
            InputStreamReader isr = new InputStreamReader ( fis );
            BufferedReader br = new BufferedReader ( isr );
            Boolean status = false;
            String line = br.readLine ();
            Toast.makeText ( this, "Login Attempted", Toast.LENGTH_SHORT ).show ();

            if(line != null){
                String[] arr = line.split ( "~" );
                if(username.equals ( arr[0] ) && password.equals ( arr[3] )){
                    status = true;
                }
                else{
                    Toast.makeText ( this, "Incorrect password", Toast.LENGTH_SHORT ).show ();
                }
                if(status){
                    Toast.makeText ( this, "Login Successful", Toast.LENGTH_SHORT ).show ();
                    final Intent navUserProfile = new Intent ( MainActivity.this, UserProfile.class );
                    navUserProfile.putExtra ( "username_intent", username );
                    new Handler ( ).postDelayed ( new Runnable () {
                        @Override
                        public void run() {
                            startActivity ( navUserProfile );
                        }
                    }, 1000 );
                }

            }
        }
        catch(Exception e){
            Toast.makeText ( this, e.getMessage (), Toast.LENGTH_SHORT ).show ();
        }
    }

    public void onMainRegisterClicked(View view){
        final Intent navRegisteration = new Intent ( MainActivity.this, Registration.class );

        new Handler ( ).postDelayed ( new Runnable () {
            @Override
            public void run() {
                startActivity ( navRegisteration );
            }
        }, 1000 );
    }
}