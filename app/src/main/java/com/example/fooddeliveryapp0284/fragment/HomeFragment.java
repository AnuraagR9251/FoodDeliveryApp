package com.example.fooddeliveryapp0284.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp0284.R;
import com.example.fooddeliveryapp0284.adapter.FoodAdapter;
import com.example.fooddeliveryapp0284.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private List<FoodItem> foodItemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // 1. Initialize RecyclerView
        recyclerView = view.findViewById(R.id.food_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 2. Prepare data with actual images
        prepareFoodData();

        // 3. Set up the adapter
        foodAdapter = new FoodAdapter(foodItemList);
        recyclerView.setAdapter(foodAdapter);

        return view;
    }

    private void prepareFoodData() {
        foodItemList = new ArrayList<>();

        // IMPORTANT: Replace these 'R.drawable' names with the actual names of your image files.
        // For example, if you have 'burger.png', use 'R.drawable.burger'.
        foodItemList.add(new FoodItem("Classic Burger", 9.99, R.drawable.burger)); // Example
        foodItemList.add(new FoodItem("Margherita Pizza", 12.50, R.drawable.pizza)); // Example
        foodItemList.add(new FoodItem("Caesar Salad", 7.25, R.drawable.salad));   // Example
        foodItemList.add(new FoodItem("Spaghetti Bolognese", 11.00, R.drawable.pasta)); // Example
        foodItemList.add(new FoodItem("Chocolate Brownie", 5.50, R.drawable.dessert)); // Example
        foodItemList.add(new FoodItem("Vegan Wrap", 8.75, R.drawable.wrap));     // Example
    }
}
