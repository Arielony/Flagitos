package cl.flagare.flagitos.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.flagare.flagitos.R;

/**
 * Created by arielsalas on 22-10-17.
 */

public class AboutUsFragment extends Fragment {

    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View root = inflater.inflate(R.layout.aboutusfragment_layout, container, false);

            return root;
    }
}
