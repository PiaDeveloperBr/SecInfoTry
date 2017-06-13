package app.io.com.dingotrack.ui.profile;

import android.os.Bundle;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.ui.base.BaseActivity;

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bind();
        SetCenterActionBar(abstitle_profile);
    }
}
