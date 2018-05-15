package com.greenhilles.com.app001;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by toshiyukiyoshizawa on 2018/05/15.
 */

public class ReservationFragment extends Fragment {
    public static ReservationFragment newInstance() {

        return new ReservationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reservation, container, false);
    }
}
