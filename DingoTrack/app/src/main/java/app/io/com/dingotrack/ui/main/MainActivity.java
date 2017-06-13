package app.io.com.dingotrack.ui.main;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Arrays;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.libs.glideTransformer.CircleTransform;
import app.io.com.dingotrack.libs.slidingMenu.SlidingRootNav;
import app.io.com.dingotrack.libs.slidingMenu.SlidingRootNavBuilder;
import app.io.com.dingotrack.libs.slidingMenu.menu.DrawerAdapter;
import app.io.com.dingotrack.libs.slidingMenu.menu.DrawerItem;
import app.io.com.dingotrack.libs.slidingMenu.menu.SimpleItem;
import app.io.com.dingotrack.ui.CenteredTextFragment;
import app.io.com.dingotrack.ui.home.HomeFragment;
import app.io.com.dingotrack.ui.profile.ProfileActivity;
import app.io.com.dingotrack.ui.shipment.ShipmentFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("NewApi")
public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {

    private static final int POS_HOME = 0;
    private static final int POS_SHIPMENTS = 1;
    private static final int POS_SETTINGS = 2;
    private static final int POS_FEEDBACK = 3;
    private static final int POS_LOGOUT = 4;

    public Bundle translateBundle;
    private String[] screenTitles;
    private Drawable[] screenIcons;
    SlidingRootNav slidingRootNavBuilder;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.toolbarTitleTextView)
    TextView toolbarTitleTextView;
    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        translateBundle = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.slide_in_left, R.anim.slide_out_left).toBundle();

        slidingRootNavBuilder = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        loadSlidingOption();


    }

    private void loadSlidingOption() {

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_HOME).setChecked(true),
                createItemFor(POS_SHIPMENTS),
                createItemFor(POS_SETTINGS),
                createItemFor(POS_FEEDBACK),
                createItemFor(POS_LOGOUT)));
        adapter.setListener(this);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
        adapter.setSelected(POS_HOME);

        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        // Loading profile image
        Glide.with(this).load("https://img07.rl0.ru/e2fece908ff8406706beb14caaa171b7/c500x359/www.gettyimages.com/gi-resources/images/Embed/new/embed2.jpg")
                .crossFade()
                .bitmapTransform(new CircleTransform(MainActivity.this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.defaultpic)
                .into(imgProfile);

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class),translateBundle);

            }
        });

    }

    @Override
    public void onItemSelected(int position) {
        getSupportActionBar().setTitle("");
        toolbarTitleTextView.setText(screenTitles[position]);

        Fragment selectedScreen;
        switch (position){
            case POS_HOME:
                selectedScreen = HomeFragment.createFor(screenTitles[position]);
                slidingRootNavBuilder.closeMenu();

                showFragment(selectedScreen);
                break;

            case POS_SHIPMENTS:
                selectedScreen = ShipmentFragment.createFor(screenTitles[position]);
                slidingRootNavBuilder.closeMenu();

                showFragment(selectedScreen);
                break;

            case POS_SETTINGS:
                selectedScreen = CenteredTextFragment.createFor(screenTitles[position]);
                slidingRootNavBuilder.closeMenu();

                showFragment(selectedScreen);
                break;

            case POS_FEEDBACK:
                selectedScreen = CenteredTextFragment.createFor(screenTitles[position]);
                slidingRootNavBuilder.closeMenu();

                showFragment(selectedScreen);
                break;

            case POS_LOGOUT:

                slidingRootNavBuilder.closeMenu();
                finish();
                break;
        }

    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.appAlphaBlack))
                .withTextTint(color(R.color.appBlack))
                .withSelectedIconTint(color(R.color.appWhite))
                .withSelectedTextTint(color(R.color.appWhite));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

}
