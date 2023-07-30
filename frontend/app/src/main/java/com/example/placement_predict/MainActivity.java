package com.example.placement_predict;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.placement_predict.AboutFragment;
import com.example.placement_predict.DetailsFragment;
import com.example.placement_predict.HomeFragment;
import com.example.placement_predict.R;
import com.example.placement_predict.TestsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        openFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        openFragment(new HomeFragment());
                        return true;
                    case R.id.tests:
                        openFragment(new TestsFragment());
                        return true;
                    case R.id.details:
                        openFragment(new DetailsFragment());
                        return true;
                    case R.id.about:
                        openFragment(new AboutFragment());
                        return true;
                }
                return false;
            }
        });
    }
    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentView, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}