package com.maick400.recyclerviewcardviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

public class detailsProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_product);


        RecyclerView rc = (RecyclerView) findViewById(R.id.images);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new GridLayoutManager(this,2));
        rc.setItemAnimator(new DefaultItemAnimator());
        int resId = R.anim.layout_animation_down_to_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                resId);
        rc.setLayoutAnimation(animation);
        detailsProduct imagess = new detailsProduct(this, bnd.getStringArrayList("imgs"));
        rc.setAdapter(imagess);

    }
}