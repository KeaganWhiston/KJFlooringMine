package com.example.kjflooring;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * @author jordanflorence
 * A simple {@link Fragment} subclass.
 * nav_home - hosts the home page of the application
 */
public class nav_home extends Fragment {
    //permissions
    public static final int PERMISSION_CALL_PHONE = 2;
    public static final int PERMISSION_SEND_SMS = 1;

    //phone numbers
    String phoneNumber = "123 456 7891";
    String phoneNumber2 = "519 817 4023";

    public nav_home() {

    }

    /**
     *
     * @param inflater - instantiates fragment_nav_home.xml into the view.
     * @param container - decides the organization, size, and position of the view.
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     * @return - returns the view holding the home page for KJFlooring.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_home, container, false);
        ViewPager pager = view.findViewById(R.id.homePager);
        nav_home.CustomViewPagerAdapter adapter =
                new nav_home.CustomViewPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);

        //Keagan email intent
        Button contactButton = view.findViewById(R.id.contactButton);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_contact);
            }
        });

        //Keagan phone intent
        Button phoneButton = view.findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.CALL_PHONE)) {
                        final AlertDialog alertDialog =
                                new AlertDialog.Builder(getContext())
                                        .setTitle("CALL")
                                        .setMessage("We need access to your phone to call a desired location.")
                                        .create();
                        alertDialog.setButton(
                                AlertDialog.BUTTON_NEUTRAL,
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.dismiss();
                                        ActivityCompat.requestPermissions(getActivity(),
                                                new String[]{Manifest.permission.CALL_PHONE},
                                                PERMISSION_CALL_PHONE);
                                    }
                                });
                        alertDialog.show();
                    }
                    else {
                        //ask for the permission for the first time
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.CALL_PHONE},
                                PERMISSION_CALL_PHONE);
                    }
                }
            }
        });

        //Keagan sms intent
        Button smsButton = view.findViewById(R.id.smsButton);
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.SEND_SMS)) {
                        final AlertDialog alertDialog =
                                new AlertDialog.Builder(getContext())
                                        .setTitle("SEND SMS")
                                        .setMessage("We need access to your SMS" +
                                                "to be able to send an SMS message")
                                        .create();
                        alertDialog.setButton(
                                AlertDialog.BUTTON_NEUTRAL,
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.dismiss();
                                        ActivityCompat.requestPermissions(getActivity(),
                                                new String[]{Manifest.permission.SEND_SMS},
                                                PERMISSION_SEND_SMS);
                                    }
                                });
                        alertDialog.show();

                    }
                    else {
                        //ask for the permission for the first time
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.SEND_SMS},
                                PERMISSION_SEND_SMS);
                    }
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:"));
                    intent.putExtra("address", phoneNumber);
                    intent.putExtra("sms_body", "Hey, I would like to enquire about a quote.");
                    if(intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getContext(), "No software installed to complete task", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //Jordan phone intent
        Button phoneButton2 = view.findViewById(R.id.phoneButton2);
        phoneButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.CALL_PHONE)) {
                        final AlertDialog alertDialog =
                                new AlertDialog.Builder(getContext())
                                        .setTitle("CALL")
                                        .setMessage("We need access to your phone to call a desired location.")
                                        .create();
                        alertDialog.setButton(
                                AlertDialog.BUTTON_NEUTRAL,
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.dismiss();
                                        ActivityCompat.requestPermissions(getActivity(),
                                                new String[]{Manifest.permission.CALL_PHONE},
                                                PERMISSION_CALL_PHONE);
                                    }
                                });
                        alertDialog.show();
                    }
                    else {
                        //ask for the permission for the first time
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.CALL_PHONE},
                                PERMISSION_CALL_PHONE);
                    }
                }
            }
        });

        //Jordan email intent
        Button contactButton2 = view.findViewById(R.id.contactButton2);
        contactButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_contact);
            }
        });

        //Jordan sms intent
        Button smsButton2 = view.findViewById(R.id.smsButton2);
        smsButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.SEND_SMS)) {
                        final AlertDialog alertDialog =
                                new AlertDialog.Builder(getContext())
                                        .setTitle("SEND SMS")
                                        .setMessage("We need access to your SMS" +
                                                " to be able to send an SMS message")
                                        .create();
                        alertDialog.setButton(
                                AlertDialog.BUTTON_NEUTRAL,
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.dismiss();
                                        ActivityCompat.requestPermissions(getActivity(),
                                                new String[]{Manifest.permission.SEND_SMS},
                                                PERMISSION_SEND_SMS);
                                    }
                                });
                        alertDialog.show();

                    }
                    else {
                        //ask for the permission for the first time
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.SEND_SMS},
                                PERMISSION_SEND_SMS);
                    }
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:"));
                    intent.putExtra("address", phoneNumber2);
                    intent.putExtra("sms_body", "Hey, ");
                    if(intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getContext(), "No software installed to complete task", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }

    /**
     * CustomViewPagerAdapter - passes the custom information into the viewPager on the home page.
     */
    public class CustomViewPagerAdapter extends FragmentPagerAdapter {
        public CustomViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //Case 0: First Screen (First piece of content)
            switch (position) {
                case 0:
                    return HomeViewPager.newInstance(R.drawable.homesplash2);
                case 1:
                    return HomeViewPager.newInstance(R.drawable.homesplash);
                case 2:
                    return HomeViewPager.newInstance(R.drawable.homesplash3);
                case 3:
                    return HomeViewPager.newInstance(R.drawable.homesplash4);


                default:
                    return HomeViewPager.newInstance(R.drawable.ic_launcher_background);
            }
        }

        /**
         *
         * @return - the count of the # of items inside the viewpager.
         */
        @Override
        public int getCount() {
            return 4;
        }
    }
}