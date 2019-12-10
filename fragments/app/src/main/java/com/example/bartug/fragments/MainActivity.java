package com.example.bartug.fragments;

import android.content.SharedPreferences;

import android.preference.PreferenceManager;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//AndroidManifest.xml de yönleri nasıl kullanılacağını verdim. Kitap ve film fragmentlerinden 2 farklı activty gidiliyor.
public class MainActivity extends AppCompatActivity {
int sayac1,sayac2;
Button kitapbutton;
Button filmbutton;
SharedPreferences.Editor mPrefsEditor;
SharedPreferences.Editor mPrefsEditor1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kitapbutton = findViewById(R.id.sayackitap);   //sayac butonnu bu  da .
        filmbutton = findViewById(R.id.sayacfilm);  //sayac buttonlar bunlar

        SharedPreferences mSharedPrefs = getSharedPreferences("xmlFile",   //tıklandığında artan sayacı kaydediyorum
                MODE_PRIVATE);
        SharedPreferences mSharedPrefs1 = getSharedPreferences("xmlFile1",
                MODE_PRIVATE);
         mPrefsEditor = mSharedPrefs.edit();
        mPrefsEditor1 = mSharedPrefs1.edit();

         sayac1 = mSharedPrefs.getInt("counter", 0);
        kitapbutton.setText("Kitap Buttona Tıklanma Sayısı" + sayac1);
        sayac2 = mSharedPrefs1.getInt("counter1", 0);
        filmbutton.setText("film Buttona Tıklanma Sayısı" + sayac2);





    }



    public void KitaplarıGoster(View view){ //kitap fragmentini açıyorum.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        KitapFragmenti kitapFragmenti = new KitapFragmenti();
        fragmentTransaction.replace(R.id.frame_layout,kitapFragmenti).commit();
        mPrefsEditor.putInt("counter", ++sayac1);
        mPrefsEditor.commit();
        kitapbutton.setText("Kitap Buttona Tıklanma Sayısı" + sayac1);

    }
    public void FilmleriGoster(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FilmFragmenti filmFragmenti = new FilmFragmenti();
        fragmentTransaction.replace(R.id.frame_layout,filmFragmenti).commit();
        mPrefsEditor1.putInt("counter1", ++sayac2);
        mPrefsEditor1.commit();
        filmbutton.setText("Film Buttona Tıklanma Sayısı" + sayac2);
    }
}
