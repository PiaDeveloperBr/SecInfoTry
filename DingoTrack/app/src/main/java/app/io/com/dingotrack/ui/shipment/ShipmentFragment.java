package app.io.com.dingotrack.ui.shipment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.ui.base.BaseFragment;
import butterknife.OnClick;


/**
 * Created by yarolegovich on 25.03.2017.
 */

public class ShipmentFragment extends BaseFragment {


    View rootView;
    public static ShipmentFragment createFor(String text) {
        ShipmentFragment fragment = new ShipmentFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shipment, container, false);


        return  rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    }

    @OnClick(R.id.fab)
    void CreateShipment(){
        startActivity(new Intent(getActivity(), CreateShipmentActivity.class),translateBundle);
    }
}
