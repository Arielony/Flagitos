package cl.flagare.flagitos.views;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import cl.flagare.flagitos.R;
import cl.flagare.flagitos.utils.viewAdapters.ProfilePagerAdapter;
import cl.flagare.flagitos.utils.viewAdapters.StatusBar;

/**
 * Created by arielsalas on 22-10-17.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener, TabLayout.OnTabSelectedListener, MediaPlayer.OnCompletionListener {

    // Management Components
    private TabLayout tabLayout;
    private ViewPager viewPager;

    // Tools
    private MediaPlayer mPlayer;

    // Adapters
    private ProfilePagerAdapter adapter;

    // UI Components
    private ImageView imgProfile;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Getting view for work it
        View root = inflater.inflate(R.layout.profilefragment_layout, container, false);

        // UI Components
        imgProfile = root.findViewById(R.id.profileactivity_imgProfile);
        tabLayout = root.findViewById(R.id.profileactivity_tab_tablayout);
        viewPager = root.findViewById(R.id.profilactivity_pag_viewpager);

        // THIS Configs
        configTabs();

        // Listeners Settings
        imgProfile.setOnClickListener(this);

        return root;
    }

    /* Configures tabs for this Fragment */
    private void configTabs() {

        // Adapter for VP
        adapter = new ProfilePagerAdapter(getContext(), getChildFragmentManager());
        viewPager.setAdapter(adapter);

        // Merge VP & TABS
        tabLayout.setupWithViewPager(viewPager);

        // Configure TABS
        tabLayout.getTabAt(0).setText("FLAGITOS");
        tabLayout.getTabAt(1).setText("COMPROMISOS");

    }


    /* OnClick VIEWS */
    @Override
    public void onClick(View view) {

        // Get ID for Views
        switch (view.getId()) {

            case R.id.profileactivity_imgProfile:

                imgProfile.setBackgroundColor(getResources().getColor(R.color.color_WHITE));
                Glide.with(this)
                        .load(getString(R.string.URL_MARCIANITO))
                        .into(imgProfile);

                if(mPlayer == null) {

                    mPlayer = MediaPlayer.create(getContext(), R.raw.nunca_me_faltes);
                    mPlayer.start();
                } else {

                    if(mPlayer.isPlaying()) {
                        mPlayer.pause();
                    } else {
                        mPlayer.start();
                    }
                }
                break;
            default:
                // Do Something

        }
    }




    /* TABS METHODS */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    /* LIFECYCLE FRAGMENT */
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if(mPlayer != null) {
            mPlayer.stop();
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        if(mPlayer != null) {
            mPlayer.start();
        }
    }

    @Override
    public void onPause() {
        if(mPlayer != null) {
            mPlayer.pause();
        }
        super.onPause();
    }

    @Override
    public void onStop() {
        if(mPlayer != null) {
            mPlayer.stop();
        }
        super.onStop();
    }

    @Override
    public void onDetach() {
        if(mPlayer != null) {
            mPlayer.stop();
        }
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        if(mPlayer != null) {
            mPlayer.stop();
        }
        super.onDestroy();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        if(mediaPlayer != null) {
            mediaPlayer.start();
        }
    }
}
