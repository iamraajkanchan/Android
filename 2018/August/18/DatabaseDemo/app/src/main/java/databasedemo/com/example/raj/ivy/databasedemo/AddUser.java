package databasedemo.com.example.raj.ivy.databasedemo;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import databasedemo.com.example.raj.ivy.model.UserData;

public class AddUser extends AppCompatActivity {

    EditText addUser_Username;
    EditText addUser_Name;
    EditText addUser_Email;
    EditText addUser_Password;
    ImageView addUser_Image;

    public static final int PICK_IMAGE = 100;
    Uri imageURI;
    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        addUser_Username = findViewById(R.id.addUser_Username);
        addUser_Name = findViewById(R.id.addUser_Name);
        addUser_Email = findViewById(R.id.addUser_Email);
        addUser_Password = findViewById(R.id.addUser_Password);
        addUser_Image = findViewById(R.id.addUser_Image);

        dbAdapter = new DBAdapter(AddUser.this);
    }

    public void addUser_AddButtonClicked(View view){

        UserData userData = new UserData(addUser_Username.getText().toString(), addUser_Name.getText().toString(), addUser_Email.getText().toString(), addUser_Password.getText().toString(), imageURI.toString());

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

    public void addUser_Image_Clicked(View view){
        openGallery();
    }

    public void openGallery(){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageURI = data.getData();
            addUser_Image.setImageURI(imageURI);
        }
    }
}
