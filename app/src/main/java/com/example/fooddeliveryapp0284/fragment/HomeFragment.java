package com.example.fooddeliveryapp0284.fragment;

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
import com.example.fooddeliveryapp0284.adapter.HotelAdapter;
import com.example.fooddeliveryapp0284.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView hotelRecyclerView;
    private HotelAdapter hotelAdapter;
    private List<Hotel> hotelList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // This inflates the fragment_home.xml layout you already have.
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        hotelRecyclerView = view.findViewById(R.id.menu_recycler_view);
        hotelRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // This method creates the specific list of 4 restaurants.
        prepareHotelData();

        hotelAdapter = new HotelAdapter(hotelList);
        hotelRecyclerView.setAdapter(hotelAdapter);

        return view;
    }

    /**
     * Prepares the list of 4 specific hotels as requested.
     */
    private void prepareHotelData() {
        hotelList = new ArrayList<>();

        // Make sure you have images named 'fast_food', 'south_indian', etc., in your drawable folder.
        hotelList.add(new Hotel("Quick Bites", "Fast Food", R.drawable.fast_food));
        hotelList.add(new Hotel("Dakshin Flavors", "South Indian", R.drawable.south_indian));
        hotelList.add(new Hotel("The Salty Catch", "Sea Food", R.drawable.sea_food));
        hotelList.add(new Hotel("Chaat Street", "Chats & Snacks", R.drawable.chats));
    }
}
