package com.example.mymrpotato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            int resID = getResources().getIdentifier("gridLayout", "id", getPackageName());
            android.support.v7.widget.GridLayout mlayout = (android.support.v7.widget.GridLayout) findViewById(resID);

            int count = mlayout.getChildCount();
            for (int i = 0; i < count; i++) {
                CheckBox checkbox = (CheckBox) mlayout.getChildAt(i);
                String checkText = "potato" + checkbox.getText().toString();
                boolean myBoolean = savedInstanceState.getBoolean(checkText);

                if (myBoolean) {
                    int resID2 = getResources().getIdentifier(checkText, "id", getPackageName());
                    ImageView image = (ImageView) findViewById(resID2);
                    image.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void resetAll(View v) {

        int resID = getResources().getIdentifier("gridLayout", "id", getPackageName());
        android.support.v7.widget.GridLayout mlayout = (android.support.v7.widget.GridLayout) findViewById(resID);

        int count = mlayout.getChildCount();
        for(int i = 0 ; i < count ; i++){
            CheckBox checkbox = (CheckBox) mlayout.getChildAt(i);
            checkbox.setChecked(false);
        }

        int resID2 = getResources().getIdentifier("frameLayout", "id", getPackageName());
        FrameLayout mlayouty = (FrameLayout) findViewById(resID2);

        int county = mlayouty.getChildCount();
        for(int j = 1 ; j < county ; j++){
            ImageView image = (ImageView) mlayouty.getChildAt(j);
            image.setVisibility(View.INVISIBLE);
        }
    }

    public void checkClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        // get text of checkbox
        String checkText = "potato" + checkbox.getText().toString();

        // get if checked
        Boolean checked = checkbox.isChecked();
        int resID = getResources().getIdentifier(checkText, "id", getPackageName());
        ImageView image = (ImageView) findViewById(resID);

        if (checked) {
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        int resID = getResources().getIdentifier("gridLayout", "id", getPackageName());
        android.support.v7.widget.GridLayout mlayout = (android.support.v7.widget.GridLayout) findViewById(resID);

        int count = mlayout.getChildCount();
        for(int i = 0 ; i <count ; i++){
            CheckBox checkbox = (CheckBox) mlayout.getChildAt(i);
            String checkText = "potato" + checkbox.getText().toString();
            Boolean checked = checkbox.isChecked();

            savedInstanceState.putBoolean(checkText, checked);
        }

    }
}
