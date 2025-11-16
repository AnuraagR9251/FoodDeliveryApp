package com.example.fooddeliveryapp0284;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class Hotel1 extends AppCompatActivity {
    TextView selectedItemsText;
    String item;
    int price;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel1);

        selectedItemsText = findViewById(R.id.selected_items_text);
        DBHelper dbHelper = new DBHelper(this, "FoodOrder", null, 1);


        Button bPizza = findViewById(R.id.button_add_pizza);
        Button bBurger = findViewById(R.id.button_add_burger);
        Button bSpaghetti = findViewById(R.id.button_add_spaghetti);
        Button bBruschetta = findViewById(R.id.button_add_bruschetta);
        Button bRavioli = findViewById(R.id.button_add_ravioli);
        Button bLasagna = findViewById(R.id.button_add_lasagna);
        Button bBack = findViewById(R.id.back);
        Button bNext = findViewById(R.id.next);

        bPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Margarita Pizza");
                item = "Margarita Pizza";
                price = 450;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        bBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Burger");
                item = "Burger";
                price = 480;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});

            }
        });

        bSpaghetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Spaghetti Carbonara");
                item = "Spaghetti Carbonara";
                price = 550;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder  VALUES (?, ?)", new Object[]{item, price});

            }
        });

        bBruschetta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Bruschetta");
                item = "Bruschetta";
                price = 350;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});

            }
        });

        bRavioli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Ravioli");
                item = "Ravioli";
                price = 600;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});


            }
        });

        bLasagna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Ravioli");
                item = "Lasagna";
                price = 650;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});

            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotel1.this, MainActivity.class);
                startActivity(i);

            }
        });


        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotel1.this, Cart.class);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM FoodOrder", null);
                StringBuilder itemsWithPrice = new StringBuilder();
                int total = 0;
                while (cursor.moveToNext()) {
                    String item = cursor.getString(0);
                    int price = cursor.getInt(1);
                    total += price;
                    itemsWithPrice.append(item).append(" - ₹").append(price).append("\n");
                }
                cursor.close();
                i.putExtra("final", itemsWithPrice.toString());
                i.putExtra("total", total);
                startActivity(i);
            }
        });

    }
}

