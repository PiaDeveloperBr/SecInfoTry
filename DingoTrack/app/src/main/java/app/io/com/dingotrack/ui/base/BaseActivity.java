package app.io.com.dingotrack.ui.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.tbruyelle.rxpermissions.RxPermissions;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.utils.ViewUtil;
import butterknife.BindString;
import butterknife.ButterKnife;

@SuppressLint("NewApi")
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ProgressDialog mProgressDialog;
    protected RxPermissions mRxPermissions;
    public Activity activity;
    public Bundle translateBundle;

    @BindString(R.string.abstitle_login) public String abstitle_login;
    @BindString(R.string.abstitle_signup) public String abstitle_signup;
    @BindString(R.string.abstitle_forgotpassword) public String abstitle_forgotpassword;
    @BindString(R.string.abstitle_profile) public String abstitle_profile;
    @BindString(R.string.abstitle_create_shipments) public String abstitle_create_shipments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseActivity.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        translateBundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.slide_in_left, R.anim.slide_out_left).toBundle();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void showLoadingDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.show();
            return;
        }

        mProgressDialog = new ProgressDialog(this, R.style.ProgressDialogTheme);
        mProgressDialog.setMessage(getString(R.string.please_wait));
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    /**
     * Used to hide a progress dialog
     */
    public void hideLoadingDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    public RxPermissions getRxPermissions() {
        if (mRxPermissions == null) {
            mRxPermissions = new RxPermissions(this);
        }
        return mRxPermissions;
    }

 /*   @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }*/

    /**
     * Call instead of ButterKnife.bind(activity)
     */
    protected void bind() {
        ButterKnife.bind(this);
    }

    /**
     * Call this to show toast of error message.
     *
     * @param error String value contains error message
     */
    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    /**
     * call this to show progress dialog
     */
    @Override
    public void showProgress() {
        showLoadingDialog();
    }

    /**
     * call this to hide progress dialog
     */
    @Override
    public void hideProgress() {
        hideLoadingDialog();
    }

    /** call this to hide keyboard*/
    @Override
    public void hideKeyboard() {
        ViewUtil.hideKeyboard(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        try{
            InputMethodManager im=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (NullPointerException e){
        }

        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    public void SetCenterActionBar(String mTitle){
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_action_bar));
        TextView absTitleTextView = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.absTitleTextView);
        absTitleTextView.setText(mTitle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void SetActionBarTitle(String mTitle){
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_action_bar));
        getSupportActionBar().setTitle(mTitle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void HideActionBar(){
        getSupportActionBar().hide();
    }

    public void ShowActionBar(){
        getSupportActionBar().show();
    }
}
