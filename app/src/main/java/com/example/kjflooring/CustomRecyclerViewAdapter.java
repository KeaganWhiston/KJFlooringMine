package com.example.kjflooring;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kjflooring.JavaBean.Products;

import java.util.ArrayList;

/**
 * @author keaganwhiston
 * CustomRecyclerViewAdapter - creates a custom adapter that populates the recyclerView on fragment_nav_products.xml
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Products> products;
    public CustomRecyclerViewAdapter(ArrayList<Products> products){this.products=products;}

    /**
     *
     * @param parent - The ViewGroup, where the new View will be added after being bound to an adapter position.
     * @param viewType
     * @return - returns the customViewHolder.
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row,null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    /**
     *
     * @param holder - holds the information that is to be recycled.
     * @param position - position of the product in the ArrayList<Products>
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        Products product = products.get(position);
        ((CustomViewHolder)holder).name.setText(product.getName());
        ((CustomViewHolder)holder).definition.setText(product.getDefinition());
        ((CustomViewHolder)holder).recycle_image.setImageResource(product.getRecycle_image());
    }

    /**
     *
     * @return - returns the length of the ArrayList
     */
    @Override
    public int getItemCount(){
        if(products!=null){
            return products.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView definition;
        protected ImageView recycle_image;

        /**
         *
         * @param view - uses the view created in the super class and populates the data.
         */
        public CustomViewHolder(View view){
            super(view);
            this.name=view.findViewById(R.id.product_name);
            this.definition=view.findViewById(R.id.product_definition);
            this.recycle_image=view.findViewById(R.id.recycle_image);
        }
    }
}
