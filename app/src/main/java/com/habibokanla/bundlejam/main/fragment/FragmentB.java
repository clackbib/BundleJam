package com.habibokanla.bundlejam.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.habibokanla.bundlejam.R;
import com.habibokanla.bundlejam.main.fragment.base.BaseFragment;

/**
 *
 * Created by habibokanla on 11/09/2014.
 */
public class FragmentB extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_b_layout, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Fragment B");
        Button button = (Button) getView().findViewById(R.id.next_button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotTo(new FragmentC(), "C", true);
                }
            });
        }
    }
}
