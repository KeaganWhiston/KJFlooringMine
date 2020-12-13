package com.example.kjflooring;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kjflooring.JavaBean.Products;

import java.util.ArrayList;

import static com.example.kjflooring.nav_products.PRODUCT;



/**
 * @author keaganwhiston
 * A simple {@link Fragment} subclass.
 */
public class nav_item extends Fragment {

    String itemName="test";
    String desc="test2";
    int pic = 2;
    int itemSize=3;


    public nav_item() {
        // Required empty public constructor
    }

    /**
     *
     * @param inflater - instantiates fragment_nav_contact.xml into the view.
     * @param container - decides the organization, size, and position of the view.
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     * @return - returns the view holding the item.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_item, container, false);
        Bundle extra = getArguments();

        ArrayList<Products> products = new ArrayList<>();

        //grab the values from the bundle and add them all
        if(extra !=null) {
            for (int i = 0; i <= itemSize; i++) {
                itemName = extra.getString("item_name" + i, null);
                desc = extra.getString("desc"+i, "");
                pic = extra.getInt("item_image"+i, R.drawable.stock);
                if(itemName != null) {
                    products.add(new Products(itemName, desc, pic));
                }
            }
        }




        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(products);
        recyclerView.setAdapter(adapter);


        return view;
    }


}
