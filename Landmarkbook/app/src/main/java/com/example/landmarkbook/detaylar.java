package com.example.landmarkbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detaylar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaylar);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView.setText(name);

        imageView.setImageBitmap(MainActivity.selectedimage);
    }
}
