package com.habibokanla.bundlejam.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.habibokanla.bundlejam.R;
import com.habibokanla.bundlejam.bundlejam.Jam;
import com.habibokanla.bundlejam.main.fragment.base.BaseFragment;

/**
 *
 * Created by habibokanla on 11/09/2014.
 */
public class FragmentA extends BaseFragment {

    @Jam(key = FragmentC.FRAG_C_KEY)
    public String name;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_a_layout, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Fragment A");
        Button button = (Button) getView().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = ((EditText) getView().findViewById(R.id.jam_et)).getText().toString();
                gotTo(new FragmentB(), "B", true);
            }
        });
    }

}
