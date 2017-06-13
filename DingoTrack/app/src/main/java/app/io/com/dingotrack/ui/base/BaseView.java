package app.io.com.dingotrack.ui.base;

import com.arellomobile.mvp.MvpView;

public interface BaseView extends MvpView {

    /**
     * call this to show toast
     */
    void showError(String error);

    /**
     * call this to show progress dialog
     */
    void showProgress();

    /**
     * call this to hide progress dialog
     */
    void hideProgress();

    /**
     * call this to hide keyboard
     */
    void hideKeyboard();
}
