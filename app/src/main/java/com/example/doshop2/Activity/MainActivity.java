package com.example.doshop2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.doshop2.R;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterPopular;
private RecyclerView recyclerViewPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiRecyclerView();
    }

    private void intiRecyclerView() {
    }
}