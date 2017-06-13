package app.io.com.dingotrack.ui.shipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.ui.base.BaseActivity;

public class CreateShipmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shipment);

        activity = CreateShipmentActivity.this;
        bind();
        SetCenterActionBar(abstitle_create_shipments);
    }
}
