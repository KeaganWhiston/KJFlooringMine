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

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static com.example.kjflooring.nav_home.PERMISSION_CALL_PHONE;


/**
 * @author jordanflorence
 * A simple {@link Fragment} subclass.
 * nav_contact holds all common intents and contact information for the company.
 */
public class nav_contact extends Fragment {

    //company email
    String[] emailListKJ = {"kjflooring1104@gmail.com"};

    //personal emails
    String[] emailList = {"jordansstclairdummy@gmail.com", "keagansstclairdummy@gmail.com"};

    //permission
    public static final int PERMISSION_CALL_PHONE = 2;
    public static final int PERMISSION_SEND_SMS = 1;

    //phone number
    String phoneNumber = "123 456 7891";

    public nav_contact() {
        // Required empty public constructor
    }

    /**
     *
     * @param inflater - instantiates fragment_nav_contact.xml into the view.
     * @param container - decides the organization, size, and position of the view.
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     * @return - returns the view holding the several buttons used to contact KJFlooring.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_contact, container, false);

        //CALL BUTTON
        Button callButton = view.findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
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

        //SMS BUTTON
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
                                        .setMessage("We need access to your SMS " +
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

        //EMAIL BUTTON
        Button emailButton = view.findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, emailListKJ);
                intent.putExtra(Intent.EXTRA_CC, emailList);
                intent.putExtra(Intent.EXTRA_SUBJECT, "KJ Flooring");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello, \n");
                startActivity(intent);
            }
        });

        //ADD CONTACT BUTTON
        Button addContactButton = view.findViewById(R.id.addContactButton);
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.COMPANY, "KJ Flooring");
                intent.putExtra(ContactsContract.Intents.Insert.EMAIL, "kjflooring1104@gmail.com");
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, "1234567891");
                startActivity(intent);
            }
        });

        //WEB BUTTON/SOCIAL MEDIA BUTTON
        Button webButton = view.findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/FlooringKj"));
                if(intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        //MAP BUTTON
        Button locationButton = view.findViewById(R.id.locationButton);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri location = Uri.parse("geo:0,0?q=42.214794, -83.090092(KJ Flooring)");
                Intent intent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(intent);
            }
        });
        return view;
    }

}
