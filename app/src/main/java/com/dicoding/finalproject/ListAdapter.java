package com.dicoding.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<Laptop>listLaptop;
    private Context context;


    public ListAdapter(Context context, ArrayList<Laptop> listLaptop) {
        this.context=context;
        this.listLaptop = listLaptop;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_laptop, parent, false);
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Laptop laptop = listLaptop.get(position);
        holder.image.setImageResource(laptop.getPicture());
        holder.name.setText(laptop.getName());
        holder.price.setText(laptop.getPrice());

        holder.itemView.setOnClickListener(view -> {
            viewData(laptop.getPicture() ,laptop.getName(), laptop.getPrice(), laptop.getSpecification(), laptop.getLink());

        });

    }
    private void viewData(Integer picture,String name, String price, String spec, String link){
        Intent intent = new Intent(context, Detail.class);
        intent.putExtra(Detail.EXTRA_PICTURE, picture.toString());
        intent.putExtra(Detail.EXTRA_NAME, name);
        intent.putExtra(Detail.EXTRA_PRICE, price);
        intent.putExtra(Detail.EXTRA_DESCRIPTION, spec);
        intent.putExtra(Detail.EXTRA_LINK, link);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        return listLaptop.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);

        }
    }
}
