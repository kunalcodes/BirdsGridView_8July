package com.example.birds_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ArrayList<Bird> birdList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecyclerviewData();
        setRecyclerViewAdapter();
    }

    private void setRecyclerViewAdapter() {
        BirdAdapter birdAdapter = new BirdAdapter(birdList, this);
        recyclerView.setAdapter(birdAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void buildRecyclerviewData() {
        for (int i=0; i<100; i++){
            if( i%4 ==0 ) { birdList.add(new Bird(R.drawable.eagle, "Eagle")); }
            else if(i% 4 ==1 ) { birdList.add(new Bird(R.drawable.crow, "Crow")); }
            else if(i% 4 ==2 ) { birdList.add(new Bird(R.drawable.sparrow, "Sparrow")); }
            else if(i% 4 ==3 ) { birdList.add(new Bird(R.drawable.parrot, "Parrot")); }
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClicked(int position, Bird bird) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("Bird Name is:")
                .setMessage(bird.getName())
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}