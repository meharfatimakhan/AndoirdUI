package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Contact extends AppCompatActivity {

    private ArrayList<String> mImageNames=new ArrayList<>();
    private ArrayList<String> mImages=new ArrayList<>();
    private ArrayList<String> mContact=new ArrayList<>();
    private ArrayList<String> mEmail=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        setTitle("Contact List");

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initImage();

    }

    private void initImage(){
        Uri path = Uri.parse("android.resource://com.example.contacts"+"/drawable/me");
        mImages.add("https://i.insider.com/5c76768aeb3ce82b1f044ac4?width=1300&format=jpeg&auto=webp");
        mImageNames.add("Mehar Fatima Khan");
        mContact.add("+92 324 4429111");
        mEmail.add("mehrf4@gmail.com");

        mImages.add("https://m.media-amazon.com/images/M/MV5BMjI4NjM1NDkyN15BMl5BanBnXkFtZTgwODgyNTY1MjE@._V1_.jpg");
        mImageNames.add("Hania Khan");
        mContact.add("+92 320 4899222");
        mEmail.add("haniak@gmail.com");

        mImages.add("https://pmcvariety.files.wordpress.com/2017/03/robert-downey-jr1.jpg?w=1000&h=563&crop=1");
        mImageNames.add("Feroz Khan");
        mContact.add("+92 323 5958888");
        mEmail.add("ferozk@gmail.com");

        mImages.add("https://www.biography.com/.image/t_share/MTE1ODA0OTcyMDUyMzUwNDc3/85th-annual-academy-awards---arrivals.jpg");
        mImageNames.add("Kamila Gohar");
        mContact.add("+92 323 9996666");
        mEmail.add("kamila@gmail.com");
        initRecyclerView();
    }


    private void initRecyclerView(){
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        AdapterContact adapterContact=new AdapterContact(mImageNames,mImages,mContact,mEmail,this);
        recyclerView.setAdapter(adapterContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}