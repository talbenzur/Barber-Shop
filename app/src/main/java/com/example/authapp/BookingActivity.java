package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import com.example.authapp.Adapter.MyViewPagerAdapter;
import com.shuhart.stepview.StepView;


import java.util.ArrayList;
import java.util.List;

//import butterknife.ButterKnife;

public class BookingActivity extends AppCompatActivity {

    StepView stepView;
    ViewPager viewPager;
    Button btn_previous_step;
    Button btn_next_step;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //ButterKnife.bind(BookingActivity.this);
        setupStepView();
        setColorButton();

        //view

        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int i) {
                if(i ==0)
                    btn_previous_step.setEnabled(false);
                else
                    btn_previous_step.setEnabled(true);

                setColorButton();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }




    private void setColorButton(){
            if ((btn_next_step.isEnabled())){
                btn_next_step.setBackgroundResource((R.color.teal_200));
            }

            else {
                btn_next_step.setBackgroundResource((android.R.color.holo_orange_light));
            }

        if ((btn_previous_step.isEnabled())){
            btn_previous_step.setBackgroundResource((R.color.teal_200));
        }

        else {
            btn_previous_step.setBackgroundResource((android.R.color.holo_orange_light));
        }

        }


    private void setupStepView(){
        List<String>stepList = new ArrayList<>();
        stepList.add("Salon");
        stepList.add("Barber");
        stepList.add("Time");
        stepList.add("Confirm");
        stepView.setSteps(stepList);

    }

}