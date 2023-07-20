package Adapters;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.maick400.recyclerviewcardviewapp.MainActivity;
import com.maick400.recyclerviewcardviewapp.R;

import java.util.List;

import Model.Product;

public class productAdapter extends RecyclerView.Adapter<productAdapter.ProductViewHolder> {
     Context context;
     List<Product> lstProducts;
    @NonNull
    @Override
    public productAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ly_product_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productAdapter.ProductViewHolder holder, int position) {
        Product producto = lstProducts.get(position);
        holder.txtTitle.setText(producto.getTitle());

        holder.txtPrice.setText( producto.getPrice().toString());
        holder.txtDescription.setText(producto.getDescription().toString());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putStringArray("images", producto.getImages());
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });
        Glide.with(context).load(producto.getThumbnail()).into(holder.imgImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductViewHolder extends  RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imgImage;
        TextView txtTitle, txtDescription, txtPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescripcion);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            imgImage = itemView.findViewById(R.id.imgThumbnail);
            cardView = itemView.findViewById(R.id.cviewPordcuctItem);
        }





    }
}
