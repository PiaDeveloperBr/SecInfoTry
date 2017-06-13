package app.io.com.dingotrack.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.inputmethod.InputMethodManager;

public final class ViewUtil {

    /**
     * method with specified px. px is pixel value. Returns value
     * in dp after converting from pixel to dp.
     *
     * @param px pixel value to be converted.
     * @return value in dp
     */
    public static float pxToDp(float px) {
        final float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }

    /**
     * method with specified dp. Returns value in px after
     * converting from dp to pixel.
     *
     * @param dp dp value to be converted in pixel
     * @return value in pixel
     */
    public static int dpToPx(int dp) {
        final float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    /**
     * Call this method to hide keyboard from screen.
     * @param activity
     */
    public static void hideKeyboard(Activity activity) {
        final InputMethodManager imm =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    /**
     * Returns the height of the status bar. It can be used to set
     * top padding for the layouts.
     * @param context
     * @return Height in integer value
     */
    public static int getStatusBarHeight(Context context) {
        int height = 0;
        if (context == null) {
            return height;
        }
        final Resources resources = context.getResources();
        final int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            height = resources.getDimensionPixelSize(resId);
        }
        return height;
    }

}
