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
import android.widget.ListView;

import java.util.ArrayList;
                    //Bu fragmentte listeler olusturup oradan activity3 e geçişte verileri yolluyorum.
public class FilmFragmenti extends Fragment {  //film fragmenti
    static Bitmap selectedImage;
    int sayac = 0;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_film,container,false);
        ListView listView = view.findViewById(R.id.Listview1);






        final ArrayList<String> filmlist = new ArrayList<>();  //film listesini oluşturuyor.
        filmlist.add("Truva");
        filmlist.add("Gladyatör");
        filmlist.add("Yüzük Kardeşliği");
        final ArrayList<String> index = new ArrayList<>();  //filmin içeriğini bu listede.
        index.add("Yıl Milattan Önce 1250. Bronz Çağının sonlarına doğru. İki gelişmekte olan millet, Truva Prensi Paris’in ardından çatışmaya girer.  Menelaus, karısının Truvalılar tarafından ele geçirildiğini öğrenince kardeşi Agamemnon’dan yardım ister.  Bunun üzerine 50.000 Yunanlı taşıyan 1000 gemiyle Truva’ya savaş açarlar.   ");
        index.add("Gladyatör'de,İmparator Marcus Aurelius’un hüküm sürdüğü Roma’da bir general olan Maximus imparatorluğun hiyerarşik basamaklarında gitgide yükselmektedir.  Ölümden zor kurtulan Maximus artık bir gladyatör olarak eğitilmek üzere arenaya gönderilir. Maximus’un aklında tek bir istek vardır, Commodus’u öldürmek ve ailesinin intikamını bir an önce almak.  ");
        index.add("Yüzüklerin Efendisi: Yüzük Kardeşliği, dünyanın kaderini değişterecek olan yüzükten kurtulmak için verilen mücadeleyi konu ediyor. Yıllar önce üretilen ve Orta Dünya topraklarına kandan başka hiçbir şey getirmeyen yüzüklerin sonuncusu, üretiminden yüz yıllar sonra ortaya çıkar. Orta Dünya'nın kaderi, bu insanların ellerindedir. ");
        Bitmap glad = BitmapFactory.decodeResource(getResources(),R.drawable.glad);
        Bitmap troy = BitmapFactory.decodeResource(getResources(),R.drawable.troy);
        Bitmap lotr = BitmapFactory.decodeResource(getResources(),R.drawable.lotr); //resimi listelemek için bitmape çevirip ordan array yapcam.


        final ArrayList<Bitmap> filmResimleri = new ArrayList<>(); //resim listesi
        filmResimleri.add(troy);
        filmResimleri.add(glad);
        filmResimleri.add(lotr);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,filmlist);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {  //clicklistener olusutrup intentler activityler klasik işleri yapıyom devamı putextrada tıklananın içeriğini alıp dinamik işi.
                Intent in = new Intent(getActivity(),Main3Activity.class );
                in.putExtra("title",filmlist.get(i));
                in.putExtra("index",index.get(i));
                selectedImage=filmResimleri.get(i);
                startActivity(in);
            }
        });




        return  view;

    }
}
