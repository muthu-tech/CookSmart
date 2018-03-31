package com.smartcook.smartcook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.smartcook.smartcook.Camera.OcrCaptureActivity;
import com.smartcook.smartcook.DBManager.ModelQueryManager;
import com.smartcook.smartcook.Models.Items;
import com.smartcook.smartcook.Pages.OrderFragment;
import com.smartcook.smartcook.Pages.PictureFragment;
import com.smartcook.smartcook.Pages.ScanFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Initial Demo models

        Items itm1 = new Items("12/2/1988", "crabmeat,parsley,bread");
        itm1.setRecipeName("Crab Cake");
        itm1.setReceipeSuggestion("crabmeat,parsley,bread");
        itm1.setDirections("Mix saltine crackers, mayonnaise, Dijon mustard, seafood seasoning, Worcestershire sauce, egg, salt, and cayenne pepper in a large bowl. \n"
                +"Stir in crabmeat until mixture is combined but still chunky. Cover and refrigerate for 1 hour. \n"
                +"Sprinkle breadcrumbs on a plate. \n"
                +"Shape chilled crab mixture into 4 small thick patties; coat completely with bread crumbs.");



        Items itm2 = new Items("12/2/1989", "beef,onions,garlic");
        itm2.setRecipeName("Lasagna Cupcakes");
        itm2.setReceipeSuggestion("beef,onions,garlic");
        itm2.setDirections("Preheat oven to 375 degrees F (190 degrees C). Prepare muffin cups with cooking spray. \n"
                +"Heat a large skillet over medium-high heat. Cook and stir beef in the hot skillet until browned and crumbly, 5 to 7 minutes; season with salt and pepper. Drain and discard grease from the beef. \n"
                +"Cut wonton wrappers into 2 1/4-inch circles with a biscuit cutter. Press one wonton into the bottom of each muffin cup. Sprinkle even amounts of Parmesan cheese, mozzarella cheese, and ricotta cheese into each muffin cup; top each portion with even amounts of ground beef and pasta sauce. \n"
                +"Divide 1/2 cup Parmesan cheese, 1/2 cup mozzarella cheese, half the ricotta cheese, 1/2 the ground beef mixture, and 1/2 cup pasta sauce, between the muffin cups and layer, respectively, atop the wonton wrapper; repeat layering with remaining wonton wrappers, 1/2 cup Parmesan cheese, 1/2 cup mozzarella cheese, remaining ricotta cheese, remaining ground beef, and remaining pasta sauce. Top the 'cupcakes' with remaining Parmesan cheese and mozzarella cheese.\n"
                +"Bake in preheated oven until edges of 'cupcakes' are browned, 18 to 20 minutes; let cook in tins for 5 minutes before running a knife around the edges of the cupcakes to loosen the edges to remove. Garnish with fresh basil to serve");



        Items itm3 = new Items("12/2/1988", "tomato,mushrrom,onions");
        itm3.setRecipeName("Veggie Pizza");
        itm3.setReceipeSuggestion("tomato,mushrrom,onions");
        itm3.setDirections("Preheat oven to 350 degrees F (175 degrees C). Spray a jellyroll pan with non-stick cooking spray. \n"
                +"Pat crescent roll dough into a jellyroll pan. Let stand 5 minutes. Pierce with fork. \n"
                +"Bake for 10 minutes, let cool \n"
                +"In a medium-sized mixing bowl, combine sour cream, cream cheese, dill weed, garlic salt and ranch dip mix. Spread this mixture on top of the cooled cr");


        ModelQueryManager.get(getApplicationContext()).createItem(itm1);
        ModelQueryManager.get(getApplicationContext()).createItem(itm2);
        ModelQueryManager.get(getApplicationContext()).createItem(itm3);

        ////////

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        PictureFragment frag = new PictureFragment();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.home_Frag, frag)
                .commit();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_scan) {
            Intent intent = new Intent(this, OcrCaptureActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_recipes) {
            OrderFragment frag = new OrderFragment();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.home_Frag, frag)
                    .commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
