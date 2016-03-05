package com.example.android.contextexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //int thisInt = savedInstanceState.getInt("passedTextView");

        Bundle getData = getIntent().getExtras();
        int getInfo = getData.getInt("passedTextView");

        //Log.i("Activity2", "thisInt: " + String.valueOf(thisInt));
        Log.i("Activity2", "getInfo: " + String.valueOf(getInfo));
        Log.i("Activity2", "R.id.contextTest: " + String.valueOf(R.id.contextTest));

        Log.i("Activity2", "Find View: " + String.valueOf(findViewById(getInfo)));

        String message;

        message = "Activity 2 Context: \n" + String.valueOf(this);
        TextView textViewActivity = new TextView(this);
        textViewActivity.setTextSize(20);
        textViewActivity.setText(message);

        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        Log.i("Activity2", "rootView: " + String.valueOf(rootView));
        Log.i("Activity2", "rootView TextView (getInfo): " + String.valueOf(rootView.findViewById(getInfo)));
        TextView rootTextView = (TextView) getWindow().getDecorView().findViewById(R.id.contextTest);
        Log.i("Activity2", "rootTextView: " + String.valueOf(rootTextView));
        //Log.i("Activity2", "rootTextView TextView: " + String.valueOf(rootTextView.findViewById(R.id.contextTest)));

        //TextView rootTextView2 = (TextView) getWindow().getDecorView().findViewById(android.R.id.content);
        //Log.i("Activity2", "rootTextView2: " + String.valueOf(rootTextView2));
        //Log.i("Activity2", "rootTextView2 TextView: " + String.valueOf(rootTextView2.findViewById(R.id.contextTest)));

        TextView rootTextView2 = (TextView) rootView.findViewById(R.id.contextTest);
        Log.i("Activity2", "rootTextView2: " + String.valueOf(rootTextView2));

        TextView rootTextView3 = (TextView) findViewById(getInfo);
        Log.i("Activity2", "rootTextView3 (getInfo): " + String.valueOf(rootTextView3));

        Log.i("MainActivity", "Application Context:" + String.valueOf(getApplicationContext()));
        /*Log.i("MainActivity","Activity context:" + String.valueOf(this));
        if (rootView == null) {
            Log.i("MainActivity","rootView is null");
        }

        if (rootView.findViewById(R.id.contextTest) == null) {
            Log.i("MainActivity", "Create view");

            TextView myTextView = new TextView(getApplicationContext());
            //TextView myTextView = new TextView(this);

            Log.i("MainActivity", "View context:" + String.valueOf(myTextView.getContext()));

            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formattedDate = df.format(c.getTime());

            myTextView.setText(formattedDate);
            myTextView.setId(R.id.contextTest);
            myTextView.setTextSize(40);
            myTextView.setTextColor(Color.RED);

            setContentView(myTextView);
        } else {
            Log.i("MainActivity", "Found view");
            setContentView(rootView.findViewById(R.id.contextTest));
        }
        */
        /*
        message = "Application Context: \n" + String.valueOf(getApplicationContext());
        TextView textViewApp = new TextView(getApplicationContext());
        textViewApp.setTextSize(20);
        textViewApp.setText(message);
        */

        LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout);
        //LinearLayout layout =  new LinearLayout(this, );
        layout.addView(textViewActivity);
        //layout.addView(textViewApp);

    }
}
