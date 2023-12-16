package com.example.doshop2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.doshop2.Domain.PopularDomain;
import com.example.doshop2.Helper.MangmentCart;
import com.example.doshop2.R;

public class DetailActivity2 extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView titleTxt,feeTxt,descriptionTxt,reviewTxt,scoreTxt;
    private ImageView picItem,backBtn;
    private PopularDomain object;
    private int numberOrder=1;
    private MangmentCart mangmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        mangmentCart=new MangmentCart(this);

        initView();
        getBundle();
    }

    private void getBundle() {
        object =(PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(object.getPicUrl(),"drawable",this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picItem);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getPrice());
        descriptionTxt.setText(object.getDescription());
        reviewTxt.setText(object.getReview()+"");
        scoreTxt.setText(object.getScore()+"");

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberIncart(numberOrder);
                mangmentCart.insertFood(object);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        addToCartBtn=findViewById(R.id.addTocCartBtn);
        feeTxt=findViewById(R.id.priceTxt);
        titleTxt=findViewById(R.id.titleTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        picItem=findViewById(R.id.itemPic);
        reviewTxt=findViewById(R.id.reviewTxt);
        scoreTxt=findViewById(R.id.scoreTxt);
        backBtn=findViewById(R.id.backBtn);

    }
}