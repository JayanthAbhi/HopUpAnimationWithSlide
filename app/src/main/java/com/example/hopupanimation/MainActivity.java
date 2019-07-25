package com.example.hopupanimation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hopupanimation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    private static final String FRAGMENT_TAG = "Product_List_Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        displayProductListFragment();
    }

    private void displayProductListFragment() {
        getSupportFragmentManager().beginTransaction().
                replace(mBinding.container.getId(), new ProductListFragment(), FRAGMENT_TAG)
                .addToBackStack(FRAGMENT_TAG).
                commit();
    }
}
