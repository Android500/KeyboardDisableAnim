package com.czt.saisam.unittest;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.czt.saisam.unittest.android.SystemBarTintManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setStatusBarTint(android.R.color.transparent);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout root = (RelativeLayout)findViewById(R.id.root2);

//        Animation animation2 = new TranslateAnimation(0, 20, 0, 0);
//        animation2.setDuration(2000);
//        animation2.setRepeatCount(10);
//        animation2.setRepeatMode(Animation.RESTART);
//        button.startAnimation(animation2);
        final View view = findViewById(R.id.anima_icon);
        AndroidBug5497Workaround.assistActivity(this, new AndroidBug5497Workaround.OnStateListener() {
            @Override
            public void onDetectScale(int slop) {
                view.setVisibility(View.GONE);
                Log.e("MainActivity", "onDetectScale-----> y: " + view.getY() + " slop: " + slop);
            }

            @Override
            public void onDetectExpland(final int slop) {
                findViewById(R.id.anima_icon).setVisibility(View.VISIBLE);
                //Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.small_to_big);
                //findViewById(R.id.anima_icon).startAnimation(animation);
                Log.e("MainActivity", "onDetectExpland----->");

            }

            @Override
            public void onDetectExplanding(float percent) {
                Log.e("MainActivity", "onDetectExpland-----> percent: " + percent);
                findViewById(R.id.anima_icon).setScaleX(percent);
                findViewById(R.id.anima_icon).setScaleY(percent);
            }
        });
    }

    public void setStatusBarTint(int res) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR);
            int color = getResources().getColor(res);
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (true) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(res);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}