package com.czt.saisam.unittest;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;


/**
 * Created by huangxin on 2017/3/20.
 */
public class AndroidBug5497Workaround {
    // For more information, see https://code.google.com/p/android/issues/detail?id=5497
    // To use this class, simply invoke assistActivity() on an Activity that already has its content view set.


    public static interface OnStateListener {
        void onDetectScale(int slop);

        void onDetectExpland(int slop);

        void onDetectExplanding(float percent);
    }

    private OnStateListener onStateListener;

    public void setOnStateListener(OnStateListener onStateListener) {
        this.onStateListener = onStateListener;
    }

    public static void assistActivity(Activity activity, OnStateListener onStateListener) {
        new AndroidBug5497Workaround(activity).setOnStateListener(onStateListener);
    }

    private View mChildOfContent;
    private int usableHeightPrevious;
    private FrameLayout.LayoutParams frameLayoutParams;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    private AndroidBug5497Workaround(Activity activity) {
        FrameLayout content = (FrameLayout) activity.findViewById(R.id.root);
        mChildOfContent = content.getChildAt(0);

        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                possiblyResizeChildOfContent();
            }
        };

        mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        frameLayoutParams = (FrameLayout.LayoutParams) mChildOfContent.getLayoutParams();
    }

    private void possiblyResizeChildOfContent() {
        int usableHeightNow = computeUsableHeight();

        if (usableHeightNow != usableHeightPrevious) {

            int slop = Math.abs(usableHeightPrevious - usableHeightNow);
            if (usableHeightPrevious > usableHeightNow) {

                if (onStateListener != null)
                    onStateListener.onDetectScale(slop);
            } else {
                if (onStateListener != null)
                    onStateListener.onDetectExpland(slop);
            }


            int usableHeightSansKeyboard = mChildOfContent.getRootView().getHeight();
            int heightDifference = usableHeightSansKeyboard - usableHeightNow;
            if (heightDifference > (usableHeightSansKeyboard / 4)) {
                // keyboard probably just became visible
                frameLayoutParams.height = usableHeightSansKeyboard - heightDifference;

                usableHeightPrevious = usableHeightNow;
                mChildOfContent.requestLayout();


            } else {
                // keyboard probably just became hidden
                //frameLayoutParams.height = usableHeightSansKeyboard;
                if (usableHeightPrevious != 0)
                    animToNewSize(usableHeightPrevious, usableHeightNow);
                usableHeightPrevious = usableHeightNow;
            }


        }
    }


    private void animToNewSize(final int from, final int to) {
        mChildOfContent.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        Log.e("animToNewSize", "from: " + from + " to: " + to);
        final ValueAnimator animator = ValueAnimator.ofInt(from, to);
        animator.setDuration(500);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int integer = (int) animator.getAnimatedValue();
                Log.e("animToNewSize", "integer: " + integer );
                if (onStateListener != null)
                    onStateListener.onDetectExplanding((float) (integer - from) / (float)(to - from));
                // keyboard probably just became hidden
                frameLayoutParams.height = integer;
                mChildOfContent.requestLayout();
                if(to == integer)
                    mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

            }

        });
        animator.start();
    }


    private int computeUsableHeight() {
        Rect r = new Rect();
        mChildOfContent.getWindowVisibleDisplayFrame(r);
        return (r.bottom);// 全屏模式下： return r.bottom
    }
}
