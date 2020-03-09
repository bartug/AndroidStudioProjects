package bartug.sevindik.mobil2odev1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class adapter extends ArrayAdapter<ModelListView> {
    ArrayList<ModelListView> kisiler;
    Context context;
    int resource;


    public adapter(@NonNull Context context, int resource, @NonNull ArrayList<ModelListView> kisiler) {
        super(context, resource, kisiler);
        this.kisiler=kisiler;
        this.context=context;
        this.resource=resource;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            LayoutInflater layoutinflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutinflater.inflate(R.layout.row,null,true);
        }
        ModelListView kisiler = getItem(position);
        ImageView image = (ImageView) convertView.findViewById(R.id.PersonPicture);
        Picasso.get().load(kisiler.getAvatar()).into(image);
  //Main listemdeki resim ve ismini burada getliyorum.

        TextView txt = (TextView) convertView.findViewById(R.id.PersonName);
        txt.setText(kisiler.getFirst_name()); //
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(context , SecondActivity.class);
                ModelListView list=getItem(position);

                String id,first_name,last_name,email,avatar;

                id=list.getId();
                first_name=   list.getFirst_name();
                last_name= list.getLast_name();
                email= list.getEmail();
                avatar= list.getAvatar();

  //diğer aktiviteyi açmak için extraları burada veriyorum
                intent.putExtra("first_name", first_name);
                intent.putExtra("last_name", last_name);
                intent.putExtra("email", email);
                intent.putExtra("avatar", avatar);
                intent.putExtra("id",id);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
