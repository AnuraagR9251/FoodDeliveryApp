package com.example.fooddeliveryapp0284;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Delivery extends AppCompatActivity {
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_delivery);
        DBHelper dbHelper = new DBHelper(this, "FoodOrder", null, 1);
        Button b = findViewById(R.id.button3);
        Button d = findViewById(R.id.button2);
        TextView t1 = findViewById(R.id.textView11);
        TextView t2 = findViewById(R.id.textView12);
        Intent i = getIntent();
        String payment = i.getStringExtra("payment");
        String food = i.getStringExtra("final");
        t1.setText("Payment Method:\t"+payment);
        t2.setText("Food Item\n"+food);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("DELETE FROM FoodOrder");
                Intent i = new Intent(Delivery.this,MainActivity.class);
                startActivity(i);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+91 98765 43210"));
                startActivity(i);
            }
        });



    }
}
