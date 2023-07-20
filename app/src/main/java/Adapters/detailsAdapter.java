package Adapters;

import android.app.Dialog;
import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.maick400.recyclerviewcardviewapp.R;

import java.util.List;

public class detailsAdapter extends RecyclerView.Adapter<detailsAdapter.DetailsViewAdapte>  {

    private Context context;
    private List<String> images;
    public detailsAdapter(Context con, List<String> product) {
        this.images = product;
        context= con;
    }
    @Override
    public detailsAdapter.CelularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ly_product_detail_item, null);
        return new detailsAdapter(view);
    }
    @Override
    public void onBindViewHolder(detailsAdapter.CelularViewHolder holder, int position) {
        String prod = images.get(position);
        
        Glide.with(context).load(prod).into(holder.imageView);
        holder.imageView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(context)
                        .load(prod)
                        .into(image);
                gels.show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return images.size(); 
    }
    class DetailsViewAdapte extends RecyclerView.ViewHolder {
        ImageView imageView;
        public CelularViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.images);
        }
    }

}
