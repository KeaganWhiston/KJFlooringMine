package com.example.kjflooring;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kjflooring.JavaBean.Products;

import java.util.ArrayList;


/**
 * @author keaganwhiston
 * A simple {@link Fragment} subclass.
 */
public class nav_products extends Fragment {

    ListView listView;
    SharedPreferences sharedPreferences;

    public static final String PRODUCT="TEST";

    public nav_products() {
        // Required empty public constructor
    }

    /**
     *
     * @param inflater - instantiates fragment_nav_contact.xml into the view.
     * @param container - decides the organization, size, and position of the view.
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     * @return - returns the populated view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_products, container, false);



        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        listView = view.findViewById(R.id.productsList);

        final ArrayList<String> products = new ArrayList<>();
        products.add("Hardwood");
        products.add("Laminate");
        products.add("Vinyl");
        products.add("Tile");

        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,products);

        CustomListViewAdapter adapter1 = new CustomListViewAdapter(getContext(),products);

        listView.setAdapter(adapter1);

        //using a bundle to pass along all the information of the different items into a recycler view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Bundle bundle = new Bundle();
               switch(position){
                   case 0:
                       //HARDWOOD CASE
                        bundle.putString("item_name0", "Admiria Acacia");
                        bundle.putString("desc0","Rich soft color");
                        bundle.putInt("item_image0",R.drawable.hardwood1);
                        bundle.putString("item_name1", "Dream Sun");
                        bundle.putString("desc1","Golden Brown Color");
                        bundle.putInt("item_image1",R.drawable.hardwood2);
                        bundle.putString("item_name2", "Mine Craft");
                        bundle.putString("desc2","A pale and birchy feeling");
                        bundle.putInt("item_image2",R.drawable.hardwood3);
                        Navigation.findNavController(view).navigate(R.id.action_nav_products_to_nav_item, bundle);
                   break;
                   case 1:
                       //LAMINATE CASE
                       bundle.putString("item_name0", "Bilgewater");
                       bundle.putString("desc0","Blueish Greenish hue of laminate");
                       bundle.putInt("item_image0",R.drawable.laminate1);
                       bundle.putString("item_name1", "Bright Wood");
                       bundle.putString("desc1","Rustic Oak feeling");
                       bundle.putInt("item_image1",R.drawable.laminate2);
                       bundle.putString("item_name2", "Hoth");
                       bundle.putString("desc2","Very white and pale soft coloring");
                       bundle.putInt("item_image2",R.drawable.laminate3);
                       Navigation.findNavController(view).navigate(R.id.action_nav_products_to_nav_item, bundle);
                   break;
                   case 2:
                       //VINYL CASE
                       bundle.putString("item_name0", "Xayah's Oak");
                       bundle.putString("desc0","Smooth brownish tone");
                       bundle.putInt("item_image0",R.drawable.vinyl1);
                       Navigation.findNavController(view).navigate(R.id.action_nav_products_to_nav_item, bundle);
                   break;
                   case 3:
                       //TILE CASE
                       bundle.putString("item_name0", "Ivory Bathroom Tile");
                       bundle.putString("desc0","Blueish Greenish tile");
                       bundle.putInt("item_image0",R.drawable.tile1);
                       bundle.putString("item_name1", "Checkered Tile");
                       bundle.putString("desc1","Very homely coloring, comes in white and black");
                       bundle.putInt("item_image1",R.drawable.tile2);
                       Navigation.findNavController(view).navigate(R.id.action_nav_products_to_nav_item, bundle);
                   break;

                   default:
                   break;
               }
           }
        });
        return view;
    }

    /**
     *
     */
    public class CustomListViewAdapter extends ArrayAdapter<String>{
        public CustomListViewAdapter(@NonNull Context context, ArrayList<String> items){
            super(context,0,items);
        }

        /**
         *
         * @param position - position of the item.
         * @param convertView - view that is being inflated.
         * @param parent - The ViewGroup, where the new View will be added after being bound to an adapter position.
         * @return
         */
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            String item = getItem(position);
            if(convertView == null){
                convertView=LayoutInflater.from(getContext()).inflate(R.layout.listview_products,parent,false);
            }

            TextView name = convertView.findViewById(R.id.product_name);
            int fontSize = Integer.parseInt(sharedPreferences.getString("fontSize", "16"));
            name.setTextSize(fontSize);
            name.setText(item);
            return convertView;
        }
    }

}
