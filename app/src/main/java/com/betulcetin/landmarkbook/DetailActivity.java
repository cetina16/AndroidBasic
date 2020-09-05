package com.betulcetin.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView header1;
    TextView header2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.imageView);
        header1 = findViewById(R.id.header1);
        header2 = findViewById(R.id.header2);

        Intent intent = getIntent();
        String headerGet= intent.getStringExtra("name");
        String textGet = intent.getStringExtra("text1");
        header1.setText(headerGet);
        header2.setText(textGet);

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());

    }
}