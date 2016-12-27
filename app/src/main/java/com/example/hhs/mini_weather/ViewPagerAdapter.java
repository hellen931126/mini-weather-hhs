package com.example.hhs.mini_weather;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hhs on 2016/12/27.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> views;
    private Context context;

    public ViewPagerAdapter(List<View> views, Context context){
        this.views=views;
        this.context=context;
    }

    @Override
    public int getCount() {
        Log.d("ViewPagerAdapter","getCount");
        return views.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        Log.d("ViewPagerAdapter","instantiateItem");
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.d("ViewPagerAdapter","destroyItem");
        container.removeView(views.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        Log.d("ViewPagerAdapter","isViewFromObject");
        return (view == object);
    }
}
