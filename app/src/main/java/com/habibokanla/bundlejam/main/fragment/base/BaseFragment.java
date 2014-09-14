package com.habibokanla.bundlejam.main.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.habibokanla.bundlejam.bundlejam.processor.JamProcessor;
import com.habibokanla.bundlejam.main.BundleJamActivity;

/**
 *
 * Created by habibokanla on 11/09/2014.
 */
public class BaseFragment extends Fragment {

    public void gotTo(Fragment fragment, String tag, boolean addToBackStack) {
        ((BundleJamActivity) (getActivity())).addFragment(fragment, tag, addToBackStack);

    }

    @Override
    public void onPause() {
        super.onPause();
        JamProcessor.jamVariables(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        JamProcessor.unjamVariables(this);
    }
}
