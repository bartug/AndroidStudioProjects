package bartug.sevindik.mobil2odev1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity {
ImageButton emailbuton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_details); //xmli bağlıyorum
        emailbuton  = findViewById(R.id.mailButton);

        String first_name = null,last_name = null,email = null,avatar = null,id=null;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                first_name= null;
            } else { //önceki activityden gelen verileri alıyorum
                first_name= extras.getString("first_name");
                last_name= extras.getString("last_name");
                email= extras.getString("email");
                avatar= extras.getString("avatar");
                id=extras.getString("id");
            }
        } else {
            first_name=(String) savedInstanceState.getSerializable("first_name");
            last_name =(String) savedInstanceState.getSerializable("last_name");
            email=(String) savedInstanceState.getSerializable("email");
            avatar=(String) savedInstanceState.getSerializable("avatar");
            id=(String) savedInstanceState.getSerializable("id");

        }
        TextView textView =(TextView)findViewById(R.id.first_name);  //burada textleri yerleştiriyorum
        TextView textView1 =(TextView)findViewById(R.id.last_name);
        TextView textView2 =(TextView)findViewById(R.id.email);
        ImageView imageview =(ImageView) findViewById(R.id.avatar);
        final TextView textView3 = (TextView) findViewById(R.id.id);
        textView.setText(first_name);
        textView1.setText(last_name);      //textviewlere setliyorum.
        textView2.setText(email);
        textView3.setText(id);
        Picasso.get().load(avatar).into(imageview);

        emailbuton.setOnClickListener(new View.OnClickListener() {//Email at butonu tıklanınca

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Konu");//Email konusu
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Bu Mail Ödev için gönderilior");//Email içeriği
                startActivity(Intent.createChooser(emailIntent, "E-mail Göndermek için Seçiniz:")); //birden fazla email uygulaması varsa seçmek için
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, textView3.getText()); //önceki yerde text3e setlediğimizin verisini getliyorum.
                startActivity(emailIntent);
            }
        });

    }
}
