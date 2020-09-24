package bask.studios.listeki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ListDeliverAdapter extends RecyclerView.Adapter<ListDeliverAdapter.ViewHolder> {
    private Context context;
    private List<ListEkiModel> mList;

    public ListDeliverAdapter(List<ListEkiModel> list){
        this.mList = list;
    }

    @Override
    public ListDeliverAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListDeliverAdapter.ViewHolder holder, int position) {
        holder.item_image.setImageResource(mList.get(position).getItem_image());
        holder.item_name.setText(mList.get(position).getItem_name());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView item_image;
         TextView item_name;
         LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
//
            item_image = itemView.findViewById(R.id.rv_item_img);
            item_name = itemView.findViewById(R.id.rv_item_name);
            linearLayout=itemView.findViewById(R.id.linearlay);

        }
    }
}
