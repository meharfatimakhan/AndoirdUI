package com.example.contacts;
import android.os.Bundle;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MyDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_detail);
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("picture") && getIntent().hasExtra("name") && getIntent().hasExtra("email") && getIntent().hasExtra("contact"))
        {
            String img = getIntent().getStringExtra("picture");
            String imgName=getIntent().getStringExtra("name");
            setTitle(imgName);
            String imgContact=getIntent().getStringExtra("contact");
            String imgEmail=getIntent().getStringExtra("email");
            setImage(img,imgName, imgContact,imgEmail);

        }

    }

    private void setImage(String img, String imgName, String imgContact, String imgEmail){
        TextView name=findViewById(R.id.image_name);
        name.setText(imgName);
        CircleImageView picture=findViewById(R.id.image1);
        Glide.with(this).asDrawable().load(img).into(picture);
        CircleImageView picture2=findViewById(R.id.image2);
        Glide.with(this).asDrawable().load(img).into(picture2);
        TextView email=findViewById(R.id.email_id);
        email.setText(imgEmail);
        TextView contact=findViewById(R.id.contact_number);
        contact.setText(imgContact);


    }
}

