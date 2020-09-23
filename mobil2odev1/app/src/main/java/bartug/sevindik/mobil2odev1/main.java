package bartug.sevindik.mobil2odev1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class main extends AppCompatActivity {

    ArrayList<ModelListView> arrayList;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        arrayList  =new ArrayList<>();
        lv = (ListView) findViewById(R.id.myListView);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Bilgiler().execute(Interface.JSONURL);
            }
        });


    }

    class Bilgiler  extends AsyncTask<String,Integer,String> {


        TextView isim = (TextView)findViewById(R.id.PersonName);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String...params) {


            return readUrl(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray=jsonObject.getJSONArray("data");


                    JSONObject kisiobje=jsonArray.getJSONObject(new Random().nextInt(jsonArray.length()));
                    arrayList.add(new ModelListView(   //
                            kisiobje.getString("first_name"),
                            kisiobje.getString("last_name"),
                            kisiobje.getString("email"),
                            kisiobje.getString("avatar"),
                            kisiobje.getString("id")



                    ));

            } catch (JSONException e) {
                e.printStackTrace();
            }


            adapter adapter = new adapter(
                    getApplicationContext(),R.layout.row,arrayList
            );
            lv.setAdapter(adapter);


        }

    }

    private static String readUrl(String theUrl){
        StringBuilder content = new StringBuilder();
        try{
            URL url = new URL(theUrl);
            URLConnection urlconnection = url.openConnection();
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
            while ((line=bufferedReader.readLine())!=null)
            {
                content.append(line+"\n");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}
