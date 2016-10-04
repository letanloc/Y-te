package com.android.dev.y_te.moduler.sliderMenu;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.dev.y_te.R;
import com.android.dev.y_te.base.BaseActivity;
import com.android.dev.y_te.moduler.hospital.HospitalFragment;

public class MainActivity extends BaseActivity {
    DrawerLayout drawerLayout;// left menu
    Toolbar toolbar;// actionbar
    ActionBar actionBar;//
    NavigationView navigationView;

    @Override
    public int getLayoutResoudId() {
        return R.layout.navigation;
    }

    @Override
    public void init() {
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);
    }

    @Override
    public void actionbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void Content() {

//        View v = navigationView.getHeaderView(0);
//        ImageView img =(ImageView)v.findViewById(R.id.Logo);

//        Picasso.with(this).load(R.drawable.loc).placeholder(R.drawable.loc).transform(new CircleTransform()).into(img);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }
        setupNavigationDrawerContent(navigationView);
        setFragment(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /// thuw hien click
    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                HospitalFragment hospitalFragment =new HospitalFragment();
                fragmentTransaction.replace(R.id.fragment,hospitalFragment);
                fragmentTransaction.commit();
                    break;
//            case 0:
//

//                InboxFragment inboxFragment = new InboxFragment();
//                fragmentTransaction.replace(R.id.fragment, inboxFragment);
//                fragmentTransaction.commit();
//                break;
//            case 1:
//                fragmentManager = getSupportFragmentManager();
//                fragmentTransaction = fragmentManager.beginTransaction();
//                StarredFragment starredFragment = new StarredFragment();
//                fragmentTransaction.replace(R.id.fragment, starredFragment);
//                fragmentTransaction.commit();
//                break;
        }
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_inbox:
                                menuItem.setChecked(true);
                                setFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
//                            case R.id.item_navigation_drawer_starred:
//                                menuItem.setChecked(true);
//                                setFragment(1);
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
//                            case R.id.item_navigation_drawer_sent_mail:
//                                menuItem.setChecked(true);
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
//                            case R.id.item_navigation_drawer_drafts:
//                                menuItem.setChecked(true);
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
//                            case R.id.item_navigation_drawer_settings:
//                                menuItem.setChecked(true);
//                                Toast.makeText(MainActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
//                                startActivity(intent);
//                                return true;
//                            case R.id.item_navigation_drawer_help_and_feedback:
//                                menuItem.setChecked(true);
//                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                                drawerLayout.closeDrawer(GravityCompat.START);
//                                return true;
                        }
                        return true;
                    }
                });
    }
}
