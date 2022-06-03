package com.example.practiceriyadh.blurImage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.practiceriyadh.R;

import java.util.ArrayList;

public class TryActivity extends AppCompatActivity {


    RecyclerView recyclerView ;
    ArrayList<String> list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);
        recyclerView = findViewById(R.id.blurRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        BlurImageAdapter adapter = new BlurImageAdapter(list);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstPos = layoutManager.findFirstVisibleItemPosition();
                int lastPos = layoutManager.findLastVisibleItemPosition();
            //    int middlePos = layoutManager.findFirstCompletelyVisibleItemPosition();
                int middle = Math.abs(lastPos - firstPos) / 2 + firstPos;

                int selectedPos = -1;
                for (int i = 0; i < adapter.getItemCount(); i++) {
                    if (i == middle) {

                    } else {


                    }
                }

                adapter.notifyDataSetChanged();

            }
        });
    }
}