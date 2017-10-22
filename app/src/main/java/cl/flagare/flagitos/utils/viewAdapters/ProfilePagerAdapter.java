package cl.flagare.flagitos.utils.viewAdapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cl.flagare.flagitos.views.ProfileCompromisosFragment;
import cl.flagare.flagitos.views.ProfileFlagitosFragment;
import cl.flagare.flagitos.views.ProfileFragment;

/**
 * Created by arielsalas on 22-10-17.
 */

public class ProfilePagerAdapter extends FragmentPagerAdapter {

    private Context context;


    public ProfilePagerAdapter(Context mContext, FragmentManager fm) {
        super(fm);
        context = mContext;
    }


    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;

        switch (position) {

            case 0:
                frag = new ProfileFlagitosFragment();
                break;
            case 1:
                frag = new ProfileCompromisosFragment();
                break;
            case 2:
                break;
            default:

        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
