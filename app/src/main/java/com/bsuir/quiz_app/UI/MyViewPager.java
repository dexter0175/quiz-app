package com.bsuir.quiz_app.UI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;

import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Field;

public class MyViewPager extends ViewPager {

    public MyViewPager(Context context) {
        super(context);
        init();
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        Class<?> viewpager = ViewPager.class;

        try {
        Field scroller = viewpager.getDeclaredField("mScroller");
        scroller.setAccessible(true);

            scroller.set(this, new MyScroller(getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setPageTransformer(true, new VerticalPageTransformer());
        setOverScrollMode(OVER_SCROLL_NEVER);

    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//
//        return false;
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        return false;
//    }

    private class VerticalPageTransformer implements ViewPager.PageTransformer {
        static final float MIN_SCALE=0.65f;
        @Override
        public void transformPage(View view, float position) {
            position= (float)Math.pow(position,2);
            if (position < -1) {
                view.setAlpha(0);
            } else if (position <= 0) { // [-1,1]
                view.setAlpha(1);

                view.setTranslationX(view.getWidth() * -position); // stop
                float yPosition = position * view.getHeight();
                view.setTranslationY(yPosition);
                view.setScaleX(1);
                view.setScaleY(1);
            } else if(position <= 1 ) {
                view.setAlpha(1-position);
                view.setTranslationX(view.getWidth() * -position);
                view.setTranslationY(0);
                float scaleFactor = MIN_SCALE + (1-MIN_SCALE)*(1-Math.abs(position));

                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
            } else{
                view.setAlpha(0);
            }
        }
    }

    public class MyScroller extends Scroller {
        public MyScroller(Context context) {
            super(context, new LinearInterpolator()); // my LinearInterpolator
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, 500);
        }
    }



}