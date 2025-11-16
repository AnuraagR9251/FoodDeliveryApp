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

public class Hotel2 extends AppCompatActivity {
    TextView selectedItemsText;
    String item;
    int price;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel2);

        selectedItemsText = findViewById(R.id.selected_items_text);
        DBHelper dbHelper = new DBHelper(this, "FoodOrder", null, 1);

        Button buttonAddDosa = findViewById(R.id.button_add_dosa);
        Button buttonAddIdli = findViewById(R.id.button_add_idli);
        Button buttonAddVada = findViewById(R.id.button_add_vada);
        Button buttonAddUttapam = findViewById(R.id.button_add_uttapam);
        Button buttonAddPongal = findViewById(R.id.button_add_pongal);
        Button buttonAddUpma = findViewById(R.id.button_add_upma);
        Button bBack = findViewById(R.id.back);
        Button bNext = findViewById(R.id.next);

        buttonAddDosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Masala Dosa");
                item = "Masala Dosa";
                price = 180;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddIdli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Idli Sambar");
                item = "Idli Sambar";
                price = 120;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddVada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Medu Vada");
                item = "Medu Vada";
                price = 90;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddUttapam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Paddu");
                item = "Paddu";
                price = 200;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddPongal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("BisibeleBath");
                item = "BisibeleBath";
                price = 250;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddUpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Onion Upma");
                item = "Onion Upma";
                price = 200;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotel2.this, MainActivity.class);
                startActivity(i);
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotel2.this, Cart.class);
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
