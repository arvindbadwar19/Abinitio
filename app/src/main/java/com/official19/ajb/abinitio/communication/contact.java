package com.official19.ajb.abinitio.communication;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.SimpleAdapter;
import com.official19.ajb.abinitio.event;

public class contact extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    int[] images={R.drawable.arvind,R.drawable.imran316,R.drawable.laraib1,R.drawable.dheeraj,R.drawable.dhanaji123, R.drawable.devesh1};
    String[] title={"Arvind","Imran","Laraib","Dheeraj","Dhanshree","Devesh"};
    String[] description={"Contact:9370088262","Contact:9730844820","Contact:7889592130","Contact:9284705198","Contact:9702905883","Contact:9850316611"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Developers!");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        setListView();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        MainActivity.navigation(this ,id);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setListView()
    {
        listView=(ListView)findViewById(R.id.lvFaculty);
        FacultyAdapter facultyAdapter = new FacultyAdapter(contact.this, title,description,images);
        listView.setAdapter(facultyAdapter);
    }
}
