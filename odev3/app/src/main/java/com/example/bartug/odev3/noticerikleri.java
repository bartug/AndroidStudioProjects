package com.example.bartug.odev3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class noticerikleri extends AppCompatActivity {
    EditText bslk,index;
    Button save;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticerikleri);
        index = findViewById(R.id.index);
        bslk= findViewById(R.id.baslik);
        save=findViewById(R.id.save);
        database=this.openOrCreateDatabase("odev3",MODE_PRIVATE,null);
        Intent intent = getIntent();
        String info = intent.getStringExtra("info");
        if (info.matches("new")){
        bslk.setText("");
        index.setText("");
        save.setVisibility(View.VISIBLE);
        }else{
        int idnot = intent.getIntExtra("iddizi",1);
        save.setVisibility(View.INVISIBLE);
             database = this.openOrCreateDatabase("odev3",MODE_PRIVATE,null);
            Cursor cursor = database.rawQuery("SELECT * FROM notlar WHERE id =?",new  String[]{String.valueOf(idnot)});

            int NotBaslik = cursor.getColumnIndex("notbaslik");
            int Noticerik=cursor.getColumnIndex("noticerik");
            while (cursor.moveToNext()){
                index.setText(cursor.getString(NotBaslik));
                bslk.setText(cursor.getString(Noticerik));
            }
        cursor.close();


        }

    }
    public void save(View view){
        String icerik = index.getText().toString();
        String baslik =  bslk.getText().toString();
        try{
             database = this.openOrCreateDatabase("odev3",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS notlar (iddizi INTEGER PRIMARY KEY , notbaslik VARCHAR ,noticerik VARCHAR)");
            String sqlString ="INSERT INTO notlar (notbaslik,noticerik) VALUES(?,?)";
            SQLiteStatement sqLiteStatement = database.compileStatement(sqlString);
            sqLiteStatement.bindString(1,baslik);
            sqLiteStatement.bindString(2,icerik);
            sqLiteStatement.execute();

        }
        catch (Exception e){

        }
        finish();
    }
}
