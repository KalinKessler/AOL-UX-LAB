package com.example.raisoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class AllStationeryFragment extends Fragment {

    public AllStationeryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_stationery, container, false);

        ImageView image1 = view.findViewById(R.id.itemImage1);
        ImageView image2 = view.findViewById(R.id.itemImage2);
        ImageView image3 = view.findViewById(R.id.itemImage3);
        ImageView image4 = view.findViewById(R.id.itemImage4);
        ImageView image5 = view.findViewById(R.id.itemImage5);
        ImageView image6 = view.findViewById(R.id.itemImage6);
        ImageView image7 = view.findViewById(R.id.itemImage7);

        image1.setOnClickListener(v -> navigateToDetail(ItemDetailsActivityPensil.class));
        image2.setOnClickListener(v -> navigateToDetail(ItemDetailsActivityPenggaris.class));
        image3.setOnClickListener(v -> navigateToDetail(ItemDetailsActivityPulpen.class));
        image4.setOnClickListener(v -> navigateToDetail(ItemDetailsActivityStabilo.class));
        image5.setOnClickListener(v -> navigateToDetail(ItemDetailsActivityDiary.class));
        image6.setOnClickListener(v -> navigateToDetail(ItemDetailsActivityStaples.class));
        image7.setOnClickListener(v -> navigateToDetail(ItemDetailsActivityTepak.class));

        return view;
    }

    private void navigateToDetail(Class<?> detailActivity) {
        Intent intent = new Intent(getActivity(), detailActivity);
        startActivity(intent);
    }
}
