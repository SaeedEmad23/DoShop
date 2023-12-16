package com.example.doshop2.Adabter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.doshop2.Activity.CartActivity;
import com.example.doshop2.Domain.PopularDomain;
import com.example.doshop2.Helper.ChangeNumberItemsListener;
import com.example.doshop2.Helper.MangmentCart;
import com.example.doshop2.R;

import java.util.ArrayList;

public class CartAdabter extends RecyclerView.Adapter<CartAdabter.Viewholder> {
    ArrayList<PopularDomain> listItemSelcted;
    private MangmentCart mangmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdabter(ArrayList<PopularDomain> listItemSelcted, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listItemSelcted = listItemSelcted;
        mangmentCart=new MangmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdabter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdabter.Viewholder holder, int position) {
        holder.title.setText(listItemSelcted.get(position).getTitle());
        holder.feeEachItem.setText("$"+listItemSelcted.get(position).getPrice());
        holder.totalEachItem.setText("$"+Math.round((listItemSelcted.get(position).getNumberIncart()*listItemSelcted.get(position).getPrice())));
        holder.num.setText(String.valueOf(listItemSelcted.get(position).getNumberIncart()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(listItemSelcted.get(position).getPicUrl(),
                "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,30,30))
                .into(holder.pic);

        holder.plusItem.setOnClickListener(v -> mangmentCart.plusNumberItem(listItemSelcted, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.change();
        }));

        holder.minusItem.setOnClickListener(v -> mangmentCart.minusNumberItem(listItemSelcted, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.change();
        }));

    }

    @Override
    public int getItemCount() {
        return listItemSelcted.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView title,feeEachItem,plusItem,minusItem;
        ImageView pic;
        TextView totalEachItem,num;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.titleTxt);
            pic=itemView.findViewById(R.id.pic);
            feeEachItem=itemView.findViewById(R.id.feeEachitem);
            totalEachItem=itemView.findViewById(R.id.totalEachitem);
            plusItem=itemView.findViewById(R.id.plusCartBtn);
            minusItem=itemView.findViewById(R.id.minusCartBtn);
            num=itemView.findViewById(R.id.numberitemTxt);
        }
    }
}
