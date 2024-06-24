package com.example.foodtrackerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_TASK = "com.example.android.foodtrackerapplication.task";


    private Button startTrackingButton;

    private Button viewDataButton;

    /**
     * This method lets you navigate between the different pages.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        startTrackingButton = findViewById(R.id.buttonStartTracking);
        viewDataButton = findViewById(R.id.buttonViewData);


        startTrackingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TaskDisplayActivity.class);
                DailyMeals meals=new DailyMeals();
                intent.putExtra("meals",meals);
                startActivity(intent);

            }
        });

        viewDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), DataActivity.class);
                startActivity(intent);

            }
        });


    }


}