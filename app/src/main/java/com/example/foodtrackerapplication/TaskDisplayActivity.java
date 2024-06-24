package com.example.foodtrackerapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDisplayActivity extends AppCompatActivity {

    EditText editTextDay, editTextMeal, editTextFood, editTextDrink, editTextSnacks;

    Button buttonSaveData, buttonHomePageMain;

    String id, day, meal, food, drink, snacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);


        editTextDay = findViewById(R.id.editTextDay);
        editTextMeal = findViewById(R.id.editTextMeal);
        editTextFood = findViewById(R.id.editTextFood);
        editTextDrink = findViewById(R.id.editTextDrink);
        editTextSnacks = findViewById(R.id.editTextSnacks);
        buttonSaveData = findViewById(R.id.buttonSaveData);
        buttonHomePageMain = findViewById(R.id.buttonHomePageMain);

       buttonSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), DataActivity.class);
                startActivity(intent);

            }
        });


        buttonHomePageMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);

            }
        });



        Intent intent = getIntent();
        DailyMeals meals= (DailyMeals) intent.getSerializableExtra("meals");
        id = meals.getId();
        day = meals.getDay();
        editTextDay.setText(day);
        meal = meals.getMeal();
        editTextMeal.setText(meal);
        food = meals.getFood();
        editTextFood.setText(food);
        drink = meals.getDrink();
        editTextDrink.setText(drink);
        snacks = meals.getSnacks();
        editTextSnacks.setText(snacks);
        buttonSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DailyMeals meals=new DailyMeals(id, editTextDay.getText().toString(),
                        editTextMeal.getText().toString(),editTextFood.getText().toString(),
                        editTextDrink.getText().toString(), editTextSnacks.getText().toString());
                Intent returnIntent = new Intent();
                returnIntent.putExtra("meals",meals);

                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }}
