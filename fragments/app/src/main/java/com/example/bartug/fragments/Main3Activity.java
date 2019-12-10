package com.example.bartug.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageView ımageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.title);
        TextView textView1 = findViewById(R.id.index);
        Intent intent = getIntent();
        String filmlist = intent.getStringExtra("title");
        String index = intent.getStringExtra("index");
        textView.setText(filmlist);
        textView1.setText(index);
        ımageView.setImageBitmap(FilmFragmenti.selectedImage);
    }
}
