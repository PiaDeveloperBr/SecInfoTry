package app.io.com.dingotrack.ui.base;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import app.io.com.dingotrack.R;
import butterknife.ButterKnife;
import butterknife.Unbinder;


@SuppressLint("NewApi")
public abstract class BaseFragment extends Fragment {
    public Bundle translateBundle;
    private Unbinder mUnbinder;
    public View rootView;
    @Override
    public void onDestroyView() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        translateBundle = ActivityOptions.makeCustomAnimation(getActivity(), R.anim.slide_in_left, R.anim.slide_out_left).toBundle();

        if (mUnbinder == null) {
            throw new RuntimeException("Use this.bind(view) instead of ButterKnife.bind(fragment, view)");
        }
    }

    /**
     * Call after inflate view
     *
     */
    protected void bind() {
        mUnbinder = ButterKnife.bind(this, rootView);
    }

/*

    protected RxPermissions getRxPermissions() {
        final BaseActivity baseActivity = getBaseActivity();
        return baseActivity.getRxPermissions();
    }*/

}
