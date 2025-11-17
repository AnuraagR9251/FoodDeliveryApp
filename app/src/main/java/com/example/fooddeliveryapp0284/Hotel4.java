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

public class Hotel4 extends AppCompatActivity {
    TextView selectedItemsText;
    String item;
    int price;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel4);

        selectedItemsText = findViewById(R.id.selected_items_text);
        DBHelper dbHelper = new DBHelper(this, "FoodOrder", null, 1);

        Button buttonAddSevPuri = findViewById(R.id.button_add_sevpuri);
        Button buttonAddSamosa = findViewById(R.id.button_add_samosa);
        Button buttonAddKachori = findViewById(R.id.button_add_kachori);
        Button buttonAddMasalaPuri = findViewById(R.id.button_add_masalapuri);
        Button buttonAddPaniPuri = findViewById(R.id.button_add_panipuri);
        Button buttonAddBhelPuri = findViewById(R.id.button_add_bhelpuri);
        Button bBack = findViewById(R.id.back);
        Button bNext = findViewById(R.id.next);

        buttonAddSevPuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Sev Puri");
                item = "Sev Puri";
                price = 40;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddSamosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Punjabi Samosa (2 Pcs)");
                item = "Punjabi Samosa (2 Pcs)";
                price = 80;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddKachori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Kachori");
                item = "Kachori";
                price = 50;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddMasalaPuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Masala Puri");
                item = "Masala Puri";
                price = 50;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddPaniPuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Pani Puri");
                item = "Pani Puri";
                price = 30;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        buttonAddBhelPuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemsText.setText("Bhel Puri");
                item = "Bhel Puri";
                price = 40;
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO FoodOrder VALUES (?, ?)", new Object[]{item, price});
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotel4.this, MainActivity.class);
                startActivity(i);
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotel4.this, Cart.class);
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
