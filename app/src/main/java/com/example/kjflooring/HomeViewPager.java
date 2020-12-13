package com.example.kjflooring;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kjflooring.R;

import androidx.fragment.app.Fragment;

/**
 * @author jordanflorence
 * HomeViewPager - this class is used to instantiate the viewPager on nav_home.xml
 */
public class HomeViewPager extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private int mParam1;

    /**
     * empty constructor
     */
    public HomeViewPager() {

    }

    /**
     * @param param1 - gets the current instance of viewpager.
     * @return - returns a new instance HomeViewPager()
     */
    public static HomeViewPager newInstance(int param1) {
        HomeViewPager fragment = new HomeViewPager();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    /**
     *
     * @param inflater - instantiates home_viewpager.xml into the view.
     * @param container - decides the organization, size, and position of the view.
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     * @return - returns the view with the populated data from the home_viewpager.xml
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_viewpager, container, false);
        ImageView imageView = view.findViewById(R.id.homePagerImageView);
        if(mParam1 != 0) {
            imageView.setImageResource(mParam1);
        }
        return view;
    }
}
