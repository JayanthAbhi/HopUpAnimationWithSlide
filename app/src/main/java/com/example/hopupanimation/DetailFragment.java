package com.example.hopupanimation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hopupanimation.databinding.FragmentPricingDetailBinding;

public class DetailFragment extends DialogFragment {

    private FragmentPricingDetailBinding mFragmentPricingDetailBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentPricingDetailBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_pricing_detail, container, false);
        View view = mFragmentPricingDetailBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentPricingDetailBinding.btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
}
