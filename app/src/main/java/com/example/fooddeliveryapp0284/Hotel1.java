package com.example.fooddeliveryapp0284;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class Hotel1 extends AppCompatActivity {
    TextView selectedItemsText;
    ArrayList<String> items;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel1); // Your XML filename (adjust if needed)

        selectedItemsText = findViewById(R.id.selected_items_text);
        items = new ArrayList<>();
        updateItemsDisplay();

        Button bPizza = findViewById(R.id.button_add_pizza);
        Button bBurger = findViewById(R.id.button_add_burger);
        Button bSpaghetti = findViewById(R.id.button_add_spaghetti);
        Button bBruschetta = findViewById(R.id.button_add_bruschetta);
        Button bRavioli = findViewById(R.id.button_add_ravioli);
        Button bLasagna = findViewById(R.id.button_add_lasagna);
        Button bBack = findViewById(R.id.back);
        Button bNext = findViewById(R.id.next);

        bPizza.setOnClickListener(v -> addItem("Margherita Pizza"));
        bBurger.setOnClickListener(v -> addItem("Classic Burger"));
        bSpaghetti.setOnClickListener(v -> addItem("Spaghetti Carbonara"));
        bBruschetta.setOnClickListener(v -> addItem("Bruschetta"));
        bRavioli.setOnClickListener(v -> addItem("Ravioli"));
        bLasagna.setOnClickListener(v -> addItem("Lasagna"));

        bBack.setOnClickListener(v -> finish());

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Hotel1.this, Cart.class);
                i.putStringArrayListExtra("selectedItems", items);
                startActivity(i);
            }
        });
    }
    private void addItem(String item) {
        items.add(item);
        updateItemsDisplay();
    }

    private void updateItemsDisplay() {
        String itemsString = String.join(", ", items);
        selectedItemsText.setText("Selected Items: " + itemsString);
    }
}
