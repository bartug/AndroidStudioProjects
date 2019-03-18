package com.example.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

static Bitmap selectedimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);

        final ArrayList<String> landmarknames = new ArrayList<>();
        landmarknames.add("Cevikbir");
        landmarknames.add("uckuyular");
        landmarknames.add("dokuzcesmeler");
        landmarknames.add("hasanaga");

        Bitmap cevikbir = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ekle1);
        Bitmap uckuyular = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ekle2);
        Bitmap dokuzcesme = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ekle3);
        Bitmap hasanaa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ekle4);

        final ArrayList<Bitmap> landmarkimages = new ArrayList<>();
        landmarkimages.add(cevikbir);
        landmarkimages.add(uckuyular);
        landmarkimages.add(dokuzcesme);
        landmarkimages.add(hasanaa);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarknames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),detaylar.class);
                intent.putExtra("name",landmarknames.get(position));
                selectedimage = landmarkimages.get(position);

                startActivity(intent);
            }
        });

    }
}
