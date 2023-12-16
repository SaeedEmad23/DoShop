package com.example.doshop2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.doshop2.Adabter.CartAdabter;
import com.example.doshop2.Helper.ChangeNumberItemsListener;
import com.example.doshop2.Helper.MangmentCart;
import com.example.doshop2.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private MangmentCart mangmentCart;
    private TextView totalTxt,totalFeeTxt,deliveryTxt,taxTxt,emptyTxt;
    private ScrollView scrollView;
    private double tax;
    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mangmentCart =new MangmentCart(this);
        initView();
        setVariable();
        calculatorCart();
        initList();
    }

    private void initList() {
        if(mangmentCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter=new CartAdabter(mangmentCart.getListCart(), this, () -> calculatorCart());
        recyclerView.setAdapter(adapter);
    }
    private void calculatorCart() {
        double precentTax=0.02;
        double delivrey=10;
        tax=Math.round(mangmentCart.getTotalFee()*precentTax*100.0)/100.0;

        double total =Math.round((mangmentCart.getTotalFee() + tax + delivrey) * 100) / 100;
        double itemTotal=Math.round(mangmentCart.getTotalFee() *100 )/100;

        totalFeeTxt.setText("$" +itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$"+delivrey);
        totalTxt.setText("$"+ total);
    }

    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }


    private void initView() {
        totalFeeTxt=findViewById(R.id.totalFeeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.delivreyTxt);
        recyclerView=findViewById(R.id.view2);
        scrollView=findViewById(R.id.scroll2);
        backBtn=findViewById(R.id.backBtn);
        totalTxt=findViewById(R.id.totalTxt);
        emptyTxt=findViewById(R.id.emptyTXT);

    }

}