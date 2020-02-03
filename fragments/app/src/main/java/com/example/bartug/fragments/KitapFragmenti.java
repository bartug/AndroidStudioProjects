package com.example.bartug.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class KitapFragmenti extends Fragment {
    static Bitmap selectedImage;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        //listeleri olusturuyourm. İndexlerini veriyorum. Activity 3 e bunları seçileni yolluyorum.
        View view = inflater.inflate(R.layout.fragment_kitap,container,false);
        ListView listView = view.findViewById(R.id.Listview);
        final ArrayList<String> booklist = new ArrayList<>();
        booklist.add("Ateş Yakmak");
        booklist.add("Ay'a Yolculuk");
        booklist.add("Hayvan Çiftliği");
        final ArrayList<String> index = new ArrayList<>();
        index.add("Yazarın Ateş Yakmak adlı öyküsü, Jack London’un   Alaska , klondike’ki bu günlerinde şahit olduğu izlenimlerinden ortaya çıkan bir öyküsüdür. Yazar bu yıllarını   Bir Kuzey Macerası, Beyaz Diş , Vahşetin Çağrısı, romanlarında da anlatmıştır. Yazarın en beğenilen öykülerinden birisi olan bu öyküsü  de yazarın Alaska ve Klondike’de altın aramaya gittiği maceralı yıllarında görüp yaşadığı izlenimlerinden süzülen bir öykü olmaktadır.");
        index.add("Ay'a Yolculuk, yirmi sekiz bölümden oluşuyor. Büyük bir insan topluluğunun Ay'a gönderilecek olan bir mermi için yaptıkları hazırlıkları ve yaşadıkları heyecanı konu alıyor.");
        index.add("Kendi döneminin sosyalizmini ve aslında Stalin’i eleştirdiği kanısına varılan kitapta insanın bireysel yanlışlarına da sitem ediyor bence. Dili de üslubu da oldukça sade ve akıcıdır. Farklı bir pencereden dünyayı ve sistemi incelemek istiyorsanız kitap önerileri listemde Hayvan Çiftliği’ne şans verin derim. ");
        Bitmap ates = BitmapFactory.decodeResource(getResources(),R.drawable.ates);
        Bitmap ay = BitmapFactory.decodeResource(getResources(),R.drawable.ay);
        Bitmap hayvan = BitmapFactory.decodeResource(getResources(),R.drawable.hayvan);


        final ArrayList<Bitmap> kitapResimleri = new ArrayList<>();
        kitapResimleri.add(ates);
        kitapResimleri.add(ay);
        kitapResimleri.add(hayvan);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,booklist);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getActivity(),Main2Activity.class );
                in.putExtra("title",booklist.get(i));
                in.putExtra("index",index.get(i));
                selectedImage=kitapResimleri.get(i);
                startActivity(in);
            }

        });








        return  view;

    }
}
