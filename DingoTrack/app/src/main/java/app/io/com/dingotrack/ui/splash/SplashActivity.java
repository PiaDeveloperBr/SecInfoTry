package app.io.com.dingotrack.ui.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.ui.base.BaseActivity;
import app.io.com.dingotrack.ui.intro.IntroductionScreen;
import app.io.com.dingotrack.ui.login.LoginActivity;

@SuppressLint("NewApi")
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        activity = SplashActivity.this;

        bind();
        HideActionBar();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, IntroductionScreen.class),translateBundle);
                finish();
            }
        },3000);

    }
}
