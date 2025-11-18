package com.example.fooddeliveryapp0284;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Cart extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart);
        DBHelper dbHelper = new DBHelper(this, "FoodOrder", null, 1);
        TextView totalbill = findViewById(R.id.textView4);
        TextView order = findViewById(R.id.textView2);
        Button b = findViewById(R.id.button);
        RadioGroup rg = findViewById(R.id.radioGroup4);
        Intent i = getIntent();
        int total = i.getIntExtra("total", 0);
        String finalorder = i.getStringExtra("final");
        totalbill.setText("₹"+String.valueOf(total));
        order.setText(finalorder);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
                String payment = rb.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("DELETE FROM FoodOrder");
                Intent i = new Intent(Cart.this,Delivery.class);
                i.putExtra("payment",payment);
                i.putExtra("final",finalorder);
                startActivity(i);
            }
        });




    }
}
