package com.life.shelter.people.homeless;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class usersAccounts extends AppCompatActivity {

    CircleImageView homelessPic;
    EditText homelessName, homelessAddress, homelessCity;
    Button cancelHomelessInfo, submitHomelessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_accounts);

        Intent intent = getIntent();
        Bitmap imageBitmap = (Bitmap) intent.getParcelableExtra("IMAGE_BITMAP");

        homelessPic = (CircleImageView) findViewById(R.id.profile_image);
        homelessPic.setImageBitmap(imageBitmap);

        homelessName = (EditText) findViewById(R.id.homeless_name);
        homelessAddress = (EditText) findViewById(R.id.homeless_address);
        homelessCity = (EditText) findViewById(R.id.homeless_city);

        cancelHomelessInfo = (Button) findViewById(R.id.push_button);
        cancelHomelessInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelIntent = new Intent(usersAccounts.this, Account.class);
                homelessName.getText().clear();
                homelessAddress.getText().clear();
                homelessCity.getText().clear();
                homelessPic.setBackgroundResource(R.drawable.user);
                startActivity(cancelIntent);
            }
        });

        submitHomelessInfo = (Button) findViewById(R.id.push_button1);
        submitHomelessInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submitIntent = new Intent(usersAccounts.this, Account.class);

                //Here to save Homeless picture and information to database

                startActivity(submitIntent);
            }
        });

    }
}