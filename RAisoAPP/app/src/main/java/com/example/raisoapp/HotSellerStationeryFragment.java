package com.example.raisoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class HotSellerStationeryFragment extends Fragment {

    private ImageView carouselImage;
    private int currentImageIndex = 0;
    private Handler handler = new Handler();
    private Runnable runnable;

    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};

    public HotSellerStationeryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hot_seller_stationery, container, false);

        carouselImage = view.findViewById(R.id.carouselImage);
        ImageView prevImage = view.findViewById(R.id.prevImage);
        ImageView nextImage = view.findViewById(R.id.nextImage);


        carouselImage.setImageResource(images[currentImageIndex]);

        prevImage.setOnClickListener(v -> prevImage());
        nextImage.setOnClickListener(v -> nextImage());


        runnable = new Runnable() {
            @Override
            public void run() {
                nextImage();
                handler.postDelayed(runnable, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);


        carouselImage.setOnClickListener(v -> navigateToDetail(currentImageIndex));


        view.findViewById(R.id.itemImage1).setOnClickListener(v -> navigateToDetail(ItemDetailsActivityPensil.class));
        view.findViewById(R.id.itemImage2).setOnClickListener(v -> navigateToDetail(ItemDetailsActivityPenggaris.class));
        view.findViewById(R.id.itemImage3).setOnClickListener(v -> navigateToDetail(ItemDetailsActivityPulpen.class));
        view.findViewById(R.id.itemImage4).setOnClickListener(v -> navigateToDetail(ItemDetailsActivityStabilo.class));
        view.findViewById(R.id.itemImage5).setOnClickListener(v -> navigateToDetail(ItemDetailsActivityDiary.class));

        return view;
    }

    private void prevImage() {
        Animation slideOutRight = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right);
        Animation slideInLeft = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_left);

        carouselImage.startAnimation(slideOutRight);
        currentImageIndex = (currentImageIndex - 1 + images.length) % images.length;
        carouselImage.setImageResource(images[currentImageIndex]);
        carouselImage.startAnimation(slideInLeft);
    }

    private void nextImage() {
        Animation slideOutLeft = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_left);
        Animation slideInRight = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right);

        carouselImage.startAnimation(slideOutLeft);
        currentImageIndex = (currentImageIndex + 1) % images.length;
        carouselImage.setImageResource(images[currentImageIndex]);
        carouselImage.startAnimation(slideInRight);
    }

    private void navigateToDetail(int index) {
        Class<?> detailActivity;
        switch (index) {
            case 0:
                detailActivity = ItemDetailsActivityPensil.class;
                break;
            case 1:
                detailActivity = ItemDetailsActivityPenggaris.class;
                break;
            case 2:
                detailActivity = ItemDetailsActivityPulpen.class;
                break;
            case 3:
                detailActivity = ItemDetailsActivityStabilo.class;
                break;
            case 4:
                detailActivity = ItemDetailsActivityDiary.class;
                break;
            case 5:
                detailActivity = ItemDetailsActivityStaples.class;
                break;
            case 6:
                detailActivity = ItemDetailsActivityTepak.class;
                break;
            default:
                throw new IllegalArgumentException("Invalid index");
        }

        Intent intent = new Intent(getActivity(), detailActivity);
        startActivity(intent);
    }

    private void navigateToDetail(Class<?> detailActivity) {
        Intent intent = new Intent(getActivity(), detailActivity);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
