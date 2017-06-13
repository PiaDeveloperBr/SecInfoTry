package app.io.com.dingotrack.ui.intro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.ui.base.BaseActivity;
import app.io.com.dingotrack.ui.login.LoginActivity;
import app.io.com.dingotrack.ui.register.SignUpActivity;
import butterknife.OnClick;

@SuppressLint("NewApi")
public class IntroductionScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        activity = IntroductionScreen.this;
        bind();
        HideActionBar();
    }

    @OnClick(R.id.btn_login)
    void Login(){
        startActivity(new Intent(activity, LoginActivity.class),translateBundle);
    }

    @OnClick(R.id.btn_register)
    void Register(){
        startActivity(new Intent(activity, SignUpActivity.class),translateBundle);
    }
}
