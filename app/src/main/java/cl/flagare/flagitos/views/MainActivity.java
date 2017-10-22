package cl.flagare.flagitos.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import cl.flagare.flagitos.R;
import cl.flagare.flagitos.utils.viewAdapters.StatusBar;

/**
 * Created by arielsalas on 20-10-17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    // UI Components
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private DrawerLayout drawer;

    // Views
    private NavigationView navigationView;

    // Actions
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set Layout
        setContentView(R.layout.activity_main);

        // StatusBar Changes Color
        StatusBar.CambiarStatusBar(this, R.color.color_BLACK);

        // UI Components
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);


        // Toolbar Config
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // Listeners Settings
        fab.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);


        // Toggle Congfigs
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }


    /* INTERFACES METHODS */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /* MENU METHODS */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Fragments needed
        Fragment container = getSupportFragmentManager().findFragmentById(R.id.mainactivity_fragment);
        Fragment newFragment = null;

        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_profile:

                if(!(container instanceof ProfileFragment)) {
                    newFragment = new ProfileFragment();
                }

                break;
            case R.id.nav_aboutUs:

                if(!(container instanceof AboutUsFragment)) {
                    newFragment = new AboutUsFragment();
                }

                break;
            default:
        }

        if (newFragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.remove(getSupportFragmentManager().getFragments().get(0)); // Remove Old Fragment
            ft.replace(R.id.mainactivity_fragment, newFragment);
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /* ONCLICKS  */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fab:
                Snackbar.make(view, "Aqui deberia suceder algo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            default:

        }

    }
}
