package com.weblink.zbcommunity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;

import com.weblink.zbcommunity.BaseActivity;
import com.weblink.zbcommunity.Constants;
import com.weblink.zbcommunity.MainActivity;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.utils.PrefUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by swq on 2016/11/7.
 */
public class SplashActivity extends BaseActivity {


    @BindView(R.id.ll_content)
    LinearLayout llContent;

    private Handler mhandler = new Handler();


    @Override
    public void setContent() {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
    }

    @Override
    public void initView() {


        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean isFirstStart = PrefUtils.getBoolean(Constants.IS_FIRST_START, true);
                if (isFirstStart) {

                    PrefUtils.putBoolean(Constants.IS_FIRST_START, false);

                    Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                    startActivity(intent);

                } else {

                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }


                finish();
            }
        }, 3000);


        AlphaAnimation animation = new AlphaAnimation(0, 1);
        animation.setFillAfter(true);
        animation.setDuration(2000);

        llContent.startAnimation(animation);

    }

    @Override
    public void initNet() {

    }


    /**
     * 重写返回键，防止闪屏时候按返回键退出应用
     *
     * @param keyCode
     * @param event
     * @return
     */

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
