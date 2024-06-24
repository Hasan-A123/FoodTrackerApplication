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


public class DataActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private SimpleCursorAdapter myCursorAdapter;

    private Button buttonHomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_data);


        buttonHomePage = findViewById(R.id.buttonHomePage);

        buttonHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);

            }
        });


        dbHelper = new MyDatabaseHelper(this);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TaskDisplayActivity.class);
                DailyMeals meals=new DailyMeals();
                intent.putExtra("meals",meals);
                startActivityForResult(intent, 1);
            }
        });


        ListView listViewData;
        listViewData = findViewById(R.id.listViewData);
        Cursor cursor = dbHelper.getAllData();
        String[] fromFieldNames = dbHelper.getAllColumns();
        int[] toViewIDs = new int[]{R.id.textViewID, R.id.textViewDay, R.id.textViewMeal, R.id.textViewFood, R.id. textViewDrink, R.id. textViewSnacks};
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.item_layout, cursor, fromFieldNames, toViewIDs);
        listViewData.setAdapter(myCursorAdapter);
        listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent intent = new Intent(getBaseContext(), TaskDisplayActivity.class);
                DailyMeals meals=new DailyMeals(String.valueOf(id),dbHelper.getData(id).getString(1),
                        dbHelper.getData(id).getString(2), dbHelper.getData(id).getString(3),
                        dbHelper.getData(id).getString(4),
                        dbHelper.getData(id).getString(5));

                startActivityForResult(intent, 2);

            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
        Cursor cursor = dbHelper.getAllData();
        myCursorAdapter.swapCursor(cursor);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                DailyMeals meals= (DailyMeals) data.getSerializableExtra("meals");
                String id = meals.getId();
                String day = meals.getDay();
                String meal = meals.getMeal();
                String food = meals.getFood();
                String drink = meals.getDrink();
                String snacks = meals.getSnacks();
                dbHelper.insertData(id, day, meal, food, drink, snacks);

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                DailyMeals meals= (DailyMeals) data.getSerializableExtra("meals");
                String id = meals.getId();
                String day = meals.getDay();
                String meal = meals.getMeal();
                String food = meals.getFood();
                String drink = meals.getDrink();
                String snacks = meals.getSnacks();
                dbHelper.updateData(id, day, meal, food, drink, snacks);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
