package com.example.hopupanimation;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

import com.example.hopupanimation.databinding.FragmentProductListBinding;

public class ProductListFragment extends Fragment {

    FragmentProductListBinding mFragmentProductListBinding;
    private static final String DETAIL_FRAGMENT = "detail_fragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentProductListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_product_list, container, false);
        View view = mFragmentProductListBinding.getRoot();
        mFragmentProductListBinding.fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetailFragment();
            }
        });
        setAnimationToTextView();
        return view;
    }

    private void setAnimationToTextView() {
        final Handler animationHandler = new Handler();
        animationHandler.post(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void run() {
                ViewPropertyAnimator viewPropertyAnimator =
                        mFragmentProductListBinding.fl.animate().translationYBy(-40f).setDuration(200);
                viewPropertyAnimator.withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        mFragmentProductListBinding.fl.animate().translationYBy(40f).setDuration(200);
                    }
                });
                animationHandler.postDelayed(this, 1000);
            }
        });
    }

    private void launchDetailFragment() {
        DetailFragment dialogFragment = new DetailFragment();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_up, R.anim.slide_down, R.anim.pop_slide_down, R.anim.pop_slide_up);
        ft.add(R.id.container, dialogFragment, DETAIL_FRAGMENT);
        ft.addToBackStack(DETAIL_FRAGMENT);
        ft.commit();
    }

}
