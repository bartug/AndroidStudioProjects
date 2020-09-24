package bask.studios.listeki;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class First extends Fragment {
    RecyclerView recyclerView;
    List<ListEkiModel> postlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        recyclerView=view.findViewById(R.id.firtView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       // initData();

        recyclerView.setAdapter(new ListDeliverAdapter(initData()));
        return view;

    }

    private List<ListEkiModel> initData() {
        postlist = new ArrayList<>();
        postlist.add(new ListEkiModel("Netflix Dizi Tavsiyeleri",R.drawable.dizi));
        postlist.add(new ListEkiModel("Netflix Dizi Tavsiyeleri",R.drawable.dizi));
        postlist.add(new ListEkiModel("Netflix Dizi Tavsiyeleri",R.drawable.dizi));
        postlist.add(new ListEkiModel("Netflix Dizi Tavsiyeleri",R.drawable.dizi));
        postlist.add(new ListEkiModel("Netflix Dizi Tavsiyeleri",R.drawable.dizi));

        return postlist;
    }

}

