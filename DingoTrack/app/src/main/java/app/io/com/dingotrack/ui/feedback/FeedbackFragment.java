package app.io.com.dingotrack.ui.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.io.com.dingotrack.R;
import app.io.com.dingotrack.ui.base.BaseFragment;
import app.io.com.dingotrack.ui.shipment.CreateShipmentActivity;
import butterknife.OnClick;


/**
 * Created by yarolegovich on 25.03.2017.
 */

public class FeedbackFragment extends BaseFragment {


    View rootView;
    public static FeedbackFragment createFor(String text) {
        FeedbackFragment fragment = new FeedbackFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_feedback, container, false);


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
