package com.example.doshop2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.doshop2.Adabter.PopularAdapter;
import com.example.doshop2.Domain.PopularDomain;
import com.example.doshop2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterPopular;
private RecyclerView recyclerViewPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));


    }

    private void intiRecyclerView() {
        ArrayList<PopularDomain> items =new ArrayList<>();
        items.add(new PopularDomain("T-shirt black","the Classic Black T-Shirt. Embrace timeless style with this wardrobe staple that effortlessly combines comfort, simplicity, and an understated sense of cool.","item_1",15,4,500));
        items.add(new PopularDomain("SmartWatch","the Smart Horizon X Watch. This sleek and sophisticated timepiece seamlessly integrates cutting-edge innovation with timeless design, making it the ultimate companion for the modern, connected lifestyle.","item_2",10,4.5,400));
        items.add(new PopularDomain("IPhone 14","The iPhone 14 features a stunning all-new design that captivates with its sleek lines and premium materials. The edge-to-edge ProMotion XDR display delivers an immersive visual experience with true-to-life colors, deep blacks, and a buttery-smooth 120Hz refresh rate. Whether you're watching videos, playing games, or browsing content, every interaction feels fluid and responsive.","item_3",15,4.3,800));
        items.add(new PopularDomain("VisionX Pro Led TV","\n" +
                "Introducing the Vision X Pro LED TV, a cutting-edge marvel that seamlessly blends artistry with technology to redefine your viewing experience. Immerse yourself in a world of unparalleled clarity and brilliance as this state-of-the-art television transports you to the forefront of visual innovation.\n" +
                "\n" +
                "Boasting a sleek, ultra-slim design, the Vision X Pro is not just a television; it's a statement piece that elevates the aesthetics of any room. The bezel-less display creates an immersive canvas, allowing every pixel to come to life in vivid detail, whether you're watching your favorite blockbuster movie or enjoying the latest in gaming.","item_4",18,4,2000));

        recyclerViewPopular =findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapterPopular=new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}