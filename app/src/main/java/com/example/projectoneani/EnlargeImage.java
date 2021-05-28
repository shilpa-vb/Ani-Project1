package com.example.projectoneani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class EnlargeImage extends AppCompatActivity {

    GridImages_Class images_class;
    ImageView enlargeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge_image);

        enlargeImage = findViewById(R.id.enlarge_image);

        Intent intent_img = getIntent();
        if(intent_img.getExtras() != null){
            images_class = (GridImages_Class) intent_img.getSerializableExtra("largeImage");
            Glide.with(this)
                    .load(images_class.getLargeImageURL())
                    .into(enlargeImage);


        }


    }
}