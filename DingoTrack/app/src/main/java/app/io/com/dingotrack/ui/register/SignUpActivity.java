package app.io.com.dingotrack.ui.register;

import android.os.Bundle;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.ui.base.BaseActivity;

public class SignUpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bind();
        SetActionBarTitle(abstitle_signup);

    }

}
