package com.example.ExploreX;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.ExploreX.Fragments.HomeFragment;
import com.example.ExploreX.Fragments.NotificationFragment;
import com.example.ExploreX.Fragments.ProfileFragment;
import com.example.ExploreX.Fragments.SearchFragment;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.ExploreX.Fragments.HomeFragment;
import com.example.ExploreX.Fragments.NotificationFragment;
import com.example.ExploreX.Fragments.ProfileFragment;
import com.example.ExploreX.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private int selectedtab = 1;

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new HomeFragment());

        final LinearLayout homeLayout = findViewById(R.id.homeLayout);
        final LinearLayout documentLayout = findViewById(R.id.documentLayout);
        final LinearLayout profileLayout = findViewById(R.id.profileLayout);
        final LinearLayout notifLayout = findViewById(R.id.notifLayout);
        final LinearLayout searchLayout = findViewById(R.id.searchLayout);

        final LinearLayout homeNavbar = findViewById(R.id.homeNavbar);
        final LinearLayout documentNavbar = findViewById(R.id.documentNavbar);
        final LinearLayout profileNavbar = findViewById(R.id.profileNavbar);
        final LinearLayout notifNavbar = findViewById(R.id.notifNavbar);
        final LinearLayout searchNavbar = findViewById(R.id.searchNavbar);

        final ImageView homeImage = findViewById(R.id.homeImage);
        final ImageView documentImage = findViewById(R.id.documentImage);
        final ImageView profileImage = findViewById(R.id.profileImage);
        final ImageView notifImage = findViewById(R.id.notifImage);
        final ImageView searchImage = findViewById(R.id.searchImage);

        final TextView homeText = findViewById(R.id.homeText);
        final TextView documentText = findViewById(R.id.documentText);
        final TextView profileText = findViewById(R.id.profileText);
        final TextView notifText = findViewById(R.id.notifText);
        final TextView searchText = findViewById(R.id.searchText);


        linearLayout = findViewById(R.id.navbarLayout);

        homeLayout.setOnClickListener(v -> {
            if (selectedtab != 1) {

                documentNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                profileNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                searchNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                notifNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                homeNavbar.setBackgroundResource(R.color.colorBrown);

                replaceFragment(new HomeFragment());

                selectedtab = 1;
            }
        });
        searchLayout.setOnClickListener(v -> {
            if (selectedtab != 2) {

                documentNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                profileNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                homeNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                notifNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                searchNavbar.setBackgroundResource(R.color.colorBrown);

                replaceFragment(new SearchFragment());

                selectedtab = 2;
            }
        });
        documentLayout.setOnClickListener(v -> {
            if (selectedtab != 3) {

                homeNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                profileNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                searchNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                notifNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                documentNavbar.setBackgroundResource(R.color.colorBrown);

                startActivity(new Intent(MainActivity.this , PostActivity.class));

                selectedtab = 3;
            }
        });
        notifLayout.setOnClickListener(v -> {
            if (selectedtab != 4) {

                documentNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                profileNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                searchNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                homeNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                notifNavbar.setBackgroundResource(R.color.colorBrown);

                replaceFragment(new NotificationFragment());

                selectedtab = 4;
            }
        });
        profileLayout.setOnClickListener(v -> {
            if (selectedtab != 5) {

                documentNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                homeNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                searchNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                notifNavbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                profileNavbar.setBackgroundResource(R.color.colorBrown);

                replaceFragment(new ProfileFragment());

                selectedtab = 5;
            }
        });

        Bundle intent = getIntent().getExtras();

    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

}



