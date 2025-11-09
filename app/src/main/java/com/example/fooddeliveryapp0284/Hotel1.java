package com.example.fooddeliveryapp0284;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Hotel1 extends AppCompatActivity {
    TextView t1;
    ListView l1;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.hotel1);

       Button b1 = findViewById(R.id.button_add_pizza);
       Button b2 = findViewById(R.id.button_add_burger);
       Button b3 = findViewById(R.id.button_add_spaghetti);
       Button b4 = findViewById(R.id.button_add_bruschetta);
       Button b5 = findViewById(R.id.button_add_ravioli);
       Button b6 = findViewById(R.id.button_add_lasagna);
       Button b7 = findViewById(R.id.back);
       Button b8 = findViewById(R.id.button_add_ravioli);


        items = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        l1.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem("Pizza");
            }
        });
    }

    private void addItem(String item) {
        items.add(item);
        adapter.notifyDataSetChanged();
    }
}

