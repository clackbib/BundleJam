package com.habibokanla.bundlejam.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.habibokanla.bundlejam.R;
import com.habibokanla.bundlejam.bundlejam.UnJam;
import com.habibokanla.bundlejam.main.fragment.base.BaseFragment;

/**
 *
 * Created by habibokanla on 14/09/2014.
 */
public class FragmentC extends BaseFragment {

    public static final String FRAG_C_KEY = "FragCKey";

    @UnJam(key = FRAG_C_KEY)
    private String value;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_c_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Fragment C");
        TextView textView = (TextView) view.findViewById(R.id.unjam_txt);
        textView.setText("The value Jammed was:" + value);
    }
}

