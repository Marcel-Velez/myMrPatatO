package com.example.mymrpotato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        // get text of checkbox
        String checkText = "potato" + checkbox.getText().toString();

        // get if checked
        Boolean checked = checkbox.isChecked();
        int resID = getResources().getIdentifier(checkText, "id", getPackageName());

        if (checked) {
            String res = (String) resID;
            Log.d("potato",(String) checkText);
            ImageView image = (ImageView) findViewById(resID);
            image.setVisibility(View.VISIBLE);
        } else {
            Log.d("potato","unchecked");
            ImageView image = (ImageView) findViewById(resID);
            image.setVisibility(View.INVISIBLE);
        }
    }

    public void onSaveInstanceState(currentState) {
        super.onSaveInstanceState(savedInstanceState);
        (GridLayout) findViewById(R.id.RelativeLayout01);

        int count = mlayout.getChildCount();
        for(int i = 0 ; i <count ; i++){
            View checkbox = mlayout.getChildAt(i);
            String checkText = "potato" + checkbox.getText().toString();
            Boolean checked = checkbox.isChecked();

            savedInstanceState.putBoolean(checkText, checked);
        }

    }
}
