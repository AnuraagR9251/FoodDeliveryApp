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

public class Hotel3 extends AppCompatActivity {
    TextView selectedItemsText;
    String item;
    int price;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel3);

        selectedItemsText = findViewById(R.id.selected_items_text);
        DBHelper dbHelper = new DBHelper(this, "FoodOrder", null, 1);

        Button buttonAddSalmon = findViewById(R.id.button_add_salmon);
        Button buttonAddLobster = findViewById(R.id.button_add_lobster);
        Button buttonAddFishFry = findViewById(R.id.button_add_fishfry);
        Button buttonAddCrab = findViewById(R.id.button_add_crab);
        Button buttonAddPrawns = findViewById(R.id.button_add_prawns);
        Button bBack = findViewById(R.id.back);
        Button bNext = findViewById(R.id.next);

        buttonAddSalmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Grilled Salmon");
                item = "Grilled Salmon";
                price = 850;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddLobster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Lobster Thermidor");
                item = "Lobster Thermidor";
                price = 1500;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddFishFry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Fish Fry");
                item = "Fish Fry";
                price = 150;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddCrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Crab Masala");
                item = "Crab Masala";
                price = 400;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddPrawns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Prawns Fry");
                item = "Prawns Fry";
                price = 300;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotel3.this, MainActivity.class);
                startActivity(i);
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotel3.this, Cart.class);
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
