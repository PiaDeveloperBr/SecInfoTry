package app.io.com.dingotrack.ui.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import app.io.com.dingotrack.ui.main.MainActivity;
import app.io.com.dingotrack.R;
import app.io.com.dingotrack.ui.base.BaseActivity;
import app.io.com.dingotrack.ui.forgotPassword.ForgotPasswordActivity;
import app.io.com.dingotrack.ui.register.SignUpActivity;
import butterknife.BindView;
import butterknife.OnClick;

@SuppressLint("NewApi")
public class LoginActivity extends BaseActivity {

    @BindView(R.id.emailEditText)
    EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activity = LoginActivity.this;
        bind();
        SetActionBarTitle(abstitle_login);
    }

    @OnClick(R.id.createButton)
    void Register(){
        startActivity(new Intent(activity, SignUpActivity.class), translateBundle);
    }

    @OnClick(R.id.rlForgetPassword)
    void ForgotPassword() {
        startActivity(new Intent(activity, ForgotPasswordActivity.class), translateBundle);
    }
    @OnClick(R.id.loginButton)
    void Login() {
        startActivity(new Intent(activity, MainActivity.class), translateBundle);
        finish();
    }

}
