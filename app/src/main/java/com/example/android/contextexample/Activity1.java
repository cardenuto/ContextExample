package com.example.android.contextexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Activity1 extends AppCompatActivity {

    TextView textViewApp;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    // comment added to text/document upload to GitHub

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        String message;

        message = "Activity 1 Context: \n" + String.valueOf(this);
        TextView textViewActivity = new TextView(this);
        textViewActivity.setTextSize(20);
        textViewActivity.setText(message);

        message = "Application Context: \n" + String.valueOf(getApplicationContext());
        //TextView
        textViewApp = new TextView(getApplicationContext());
        textViewApp.setTextSize(20);
        textViewApp.setText(message);
        textViewApp.setId(R.id.contextTest);

        LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout);
        //LinearLayout layout =  new LinearLayout(this, );
        layout.addView(textViewActivity);
        layout.addView(textViewApp);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void sendMessage(View view) {
        Log.i("Activity1", "In sendMessage");
        Log.i("Activity1", "textViewApp: " + String.valueOf(textViewApp));
        Log.i("Activity1", "textViewApp: " + String.valueOf(R.id.contextTest));
        Bundle myBundle = new Bundle();
        myBundle.putInt("passedTextView", R.id.contextTest);
        Intent intent = new Intent(getApplicationContext(), Activity2.class);
        intent.putExtras(myBundle);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Activity1 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.android.contextexample/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Activity1 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.android.contextexample/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
