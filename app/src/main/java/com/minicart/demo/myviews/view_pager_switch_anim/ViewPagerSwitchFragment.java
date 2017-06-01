package com.minicart.demo.myviews.view_pager_switch_anim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.minicart.demo.myviews.R;

import java.util.ArrayList;

public class ViewPagerSwitchFragment extends Fragment {

    private ViewPager viewPager;
    private int[] mImageIDs = new int[]{R.drawable.d0, R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4};
    private ArrayList<View> mImages = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager_switch_anim, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager = (ViewPager) getView().findViewById(R.id.viewPager);
        viewPager.setPageTransformer(true,new ZoomOutPageTransformer());
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(mImageIDs[position]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                mImages.add(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImages.get(position));
            }

            @Override
            public int getCount() {
                return mImageIDs.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
    }

}
