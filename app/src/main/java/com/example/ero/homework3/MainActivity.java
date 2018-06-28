package com.example.ero.homework3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.AbstractSequentialList;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    private int REQUEST_CODE = 3;
    Uri imageUri;

    String ImageUrl = "https://t-l.ru/i/n/807/240807/240807_b789bdb65021.jpg";
    private ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button11 = findViewById(R.id.button1);
        final Button button22 = findViewById(R.id.button2);
        final Button button33 = findViewById(R.id.button3);
        imageView1 = findViewById(R.id.a7);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.setImageResource(R.drawable.a777);
            }
        });

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.get().load(ImageUrl).fit().into(imageView1);
            }
        });

        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              openGallery();
            }
        });
    }

    public void openGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == RESULT_OK && requestCode == PICK_IMAGE){
               imageUri = data.getData();
               imageView1.setImageURI(imageUri);
            }
        }
}
