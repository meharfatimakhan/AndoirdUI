package com.example.contacts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHolder>{

    private ArrayList<String> mImageNames=new ArrayList<>();
    private ArrayList<String> mImages=new ArrayList<String>();
    private ArrayList<String> mEmail=new ArrayList<>();
    private ArrayList<String> mContact=new ArrayList<String>();
    private Context mContext;


    public AdapterContact(ArrayList<String> imageNames, ArrayList<String> images,ArrayList<String> contact, ArrayList<String> email,Context context){
        mImageNames=imageNames;
        mImages=images;
        mEmail=email;
        mContact=contact;
        mContext=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //holder.image.setImageResource(mImages.get(position));
        holder.imageName.setText(mImageNames.get(position));
        Glide.with(mContext).asDrawable().load(mImages.get(position)).into(holder.image);

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, MyDetail.class);
                intent.putExtra("picture", mImages.get(position));
                intent.putExtra("name",mImageNames.get(position));
                intent.putExtra("contact",mContact.get(position));
                intent.putExtra("email",mEmail.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName=itemView.findViewById(R.id.image_name);
            parentLayout=itemView.findViewById(R.id.parent_layout);
        }
    }
}
