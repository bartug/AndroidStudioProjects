package com.example.bartug.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.bartug.fragments.KitapFragmenti.selectedImage;

public class Main2Activity extends AppCompatActivity {
//Kitap fragmentinden gelecek verileri kontol edip yerleştirip gösteriyor.
    @Override
    protected void onCreate(Bundle savedInstanceState) {   //kitap fragmentinden açılan activity burası. Gelen resim index kitap adını burada çağırığ listeliyom o text ve resimde.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView ımageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.title);
        TextView textView1 = findViewById(R.id.index);

        Intent intent = getIntent();
        String booklist = intent.getStringExtra("title");
        String index = intent.getStringExtra("index");
        textView.setText(booklist);
        textView1.setText(index);
        ımageView.setImageBitmap(selectedImage);

    }
}
