package com.example.textutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageUrlActivity extends AppCompatActivity {
    EditText enterImgUrlTxt;
    Button previewBtn;
    String imageUrl;
    ImageView imageViewImg;
    ImageButton leftRotateBtn;
    ImageButton rightRotateBtn;
    Button flipHorizontalBtn;
    Button flipVerticalBtn;
    int angle = 0;
    int scaleX = 1;
    int scaleY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_url);
        getSupportActionBar().setTitle("Image Utils");
        imageViewImg = findViewById(R.id.image_view_img);
        enterImgUrlTxt = findViewById(R.id.enter_image_url_txt);
        previewBtn = findViewById(R.id.preview_btn);
        leftRotateBtn = findViewById(R.id.left_rotate_img_btn);
        rightRotateBtn = findViewById(R.id.right_rotate_img_btn);
        flipHorizontalBtn = findViewById(R.id.flip_horizontal_btn);
        flipVerticalBtn = findViewById(R.id.flip_vertical_btn);
        handleLeftBtn();
        handleRightBtn();
        previewBtn();
        handleHorizontalFlip();
        handleVerticalFlip();
    }

    public void previewBtn() {
        previewBtn.setOnClickListener(view -> {
            angle = 0;
            scaleX = 1;
            scaleY = 1;
            imageViewImg.setScaleX(scaleX);
            imageViewImg.setScaleY(scaleY);
            imageUrl = enterImgUrlTxt.getText().toString();
            Picasso.get().load(imageUrl).into(imageViewImg);
        });
    }

    public void handleLeftBtn() {
        leftRotateBtn.setOnClickListener(view -> {
            angle = angle + (scaleX * scaleY * -90);
            Picasso.get().load(imageUrl).rotate(angle).into(imageViewImg);
        });
    }

    public void handleRightBtn() {
        rightRotateBtn.setOnClickListener(view -> {
            angle = angle + (scaleX * scaleY * 90);
            Picasso.get().load(imageUrl).rotate(angle).into(imageViewImg);
        });
    }

    public void handleHorizontalFlip() {
        flipHorizontalBtn.setOnClickListener(view -> {
            scaleX = scaleX * -1;
            imageViewImg.setScaleX(scaleX);
        });
    }

    public void handleVerticalFlip() {
        flipVerticalBtn.setOnClickListener(view -> {
            scaleY = scaleY * -1;
            imageViewImg.setScaleY(scaleY);
        });
    }
}