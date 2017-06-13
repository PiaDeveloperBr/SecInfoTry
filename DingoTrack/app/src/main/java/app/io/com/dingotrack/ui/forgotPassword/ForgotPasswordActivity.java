package app.io.com.dingotrack.ui.forgotPassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.ui.base.BaseActivity;

public class ForgotPasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        activity = ForgotPasswordActivity.this;
        bind();

        SetActionBarTitle(abstitle_forgotpassword);
    }
}
