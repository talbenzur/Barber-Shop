package com.example.authapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.authapp.Adapter.CustomAdapter;
import com.example.authapp.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {



    private CardView profile_card;
    private CardView booking_card;
    private CardView showBooking_card;

    private ArrayList<DataModel> dataSet;

    private RecyclerView recycleView;
    private LinearLayoutManager layoutManager;
    private CustomAdapter addapter;


    private CardView whatsapp_card;
    private CardView facebook_card;
    private CardView instagram_card;
    private CardView call_card;
    private CardView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profile_card = (CardView) findViewById(R.id.card_view_Profile);
        profile_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
            }
        });

        booking_card = (CardView) findViewById(R.id.card_view_booking);
        booking_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,BookingActivity.class));
            }
        });

        showBooking_card = (CardView) findViewById(R.id.card_view_showbooking);
        showBooking_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ShowBookingActivity.class));
            }
        });

        recycleView = (RecyclerView) findViewById(R.id.my_recycler_view);

        layoutManager = new LinearLayoutManager(this); // new GridLayoutManager
        recycleView.setLayoutManager(layoutManager);

        recycleView.setItemAnimator(new DefaultItemAnimator());

        dataSet = new ArrayList<DataModel>();

        for(int i = 0; i< MyData.nameArray.length ; i++)
        {
            dataSet.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]


            ));
        }

        addapter = new CustomAdapter(dataSet);
        recycleView.setAdapter(addapter);


        whatsapp_card = (CardView)findViewById(R.id.card_view_whatsapp);
        whatsapp_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editText_mobile = "548083353";
                String editText_msg = "hii";
                String mobileNumber = editText_mobile.toString();
                String message = editText_msg.toString();

                boolean installed = appInstallOrNot("com.whatsapp");
                if (installed) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + "+972" + mobileNumber + "&text=" + message));
                    startActivity(intent);
                }
                else {
                    Toast.makeText(HomeActivity.this, "whatsapp not installed on your device", Toast.LENGTH_SHORT);}
            }
        });

        facebook_card = (CardView) findViewById(R.id.card_view_facebook);
        facebook_card.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                gotUrl("https://facebook.com");
            }
        });

        instagram_card=(CardView) findViewById(R.id.card_view_instagram);
        instagram_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://www.instagram.com/talbenzur/");
                Intent instagram=new Intent(Intent.ACTION_VIEW,uri);
                instagram.setPackage("com.instagram.android");
                try{
                    startActivity(instagram);
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/talbenzur/")));
                }
            }
        });

        call_card=(CardView) findViewById(R.id.card_view_contact);
        call_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone= "0548083353";
                String s="tel:"+phone;
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData((Uri.parse(s)));
                startActivity(intent);

            }
        });
        map=(CardView) findViewById(R.id.card_view_map);
        map.setOnClickListener(new View.OnClickListener(){
            String sSource="home";
            String sDestination="Barbar_Shop";
            @Override
            public void onClick(View view) {
                DisplayTrack(sSource,sDestination);
            }

    });
    }

        private  void DisplayTrack(String sSource,String sDestination){

            //if the device does not have map installed, then redirect it to play store
            try{
                //when google map is installed
                Uri uri=Uri.parse("https://www.google.co.in/maps/dir/"+sSource+"/"+sDestination);
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }catch (ActivityNotFoundException e)
            {
                //when google map is not installed
                Uri uri=Uri.parse(("//https://play.google.com/store/apps/details?id=com.google.android.apps.maps"));
                Intent intent= new Intent(Intent.ACTION_VIEW,uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        }
        private void gotUrl(String s) {
            Uri uri=Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }

        private boolean appInstallOrNot(String url) {
            PackageManager packageManager = getPackageManager();
            boolean app_installed;
            try {
                packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);
                app_installed = true;

            } catch (PackageManager.NameNotFoundException e) {

                app_installed = false;
            }
            return app_installed;
        }

}