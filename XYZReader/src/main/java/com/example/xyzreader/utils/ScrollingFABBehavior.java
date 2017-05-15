package com.example.xyzreader.utils;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Oleg Leskin on 15.05.2017.
 */

public class ScrollingFABBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    private static final String TAG = "ScrollingFABBehavior";

    public ScrollingFABBehavior(Context context, AttributeSet attrs) {
        super();
        // Log.e(TAG, "ScrollAwareFABBehavior");
    }


    public boolean onStartNestedScroll(CoordinatorLayout parent, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {

        return true;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        if (dependency instanceof RecyclerView)
            return true;

        return false;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout,
            FloatingActionButton child, View target, int dxConsumed,
            int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

     /*   super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed,
                dxUnconsumed, dyUnconsumed);*/

        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            //   Log.e(TAG, "child.hide()");
            child.hide(new FloatingActionButton.OnVisibilityChangedListener() {
                @Override
                public void onHidden(FloatingActionButton fab) {
                    super.onShown(fab);
                    fab.setVisibility(View.INVISIBLE);
                }
            });
        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            //  Log.e(TAG, "child.show()");
            child.show();
        }
    }
}
