package app.io.com.dingotrack.libs.slidingMenu.util;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import app.io.com.dingotrack.libs.slidingMenu.SlidingRootNavLayout;


/**
 * Created by yarolegovich on 26.03.2017.
 */

public class HiddenMenuClickConsumer extends View {

    private SlidingRootNavLayout menuHost;

    public HiddenMenuClickConsumer(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return menuHost.isMenuHidden();
    }

    public void setMenuHost(SlidingRootNavLayout layout) {
        this.menuHost = layout;
    }
}
