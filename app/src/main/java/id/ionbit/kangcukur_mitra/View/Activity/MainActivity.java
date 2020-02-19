package id.ionbit.kangcukur_mitra.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import id.ionbit.kangcukur_mitra.Helper.BottomNavigationViewHelper;
import id.ionbit.kangcukur_mitra.R;
import id.ionbit.kangcukur_mitra.View.Fragment.HomeFragment;
import id.ionbit.kangcukur_mitra.View.Fragment.InboxFragment;
import id.ionbit.kangcukur_mitra.View.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.inbox:
                        fragment = new InboxFragment();
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_container, fragment);
                transaction.commit();
                return true;
            }
        });
    }

    private boolean loadFragment(HomeFragment homeFragment) {
        if (homeFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, homeFragment)
                    .commit();
            return true;
        }
        return false;
    }

    protected void onResume() {
        super.onResume();
    }
}
