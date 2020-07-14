package com.example.mp2weatherfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavController navController;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigation();
    }

    public void setupNavigation(){
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerLayout=findViewById(R.id.drawer1);
        navigationView=findViewById(R.id.navigationView);
        navController= Navigation.findNavController(this,R.id.nav_host);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setCheckable(true);
        drawerLayout.closeDrawers();
        int id=menuItem.getItemId();
        Bundle b=new Bundle();
        switch (id){
            case R.id.montreal:
                b.putString("Label","montreal");
                navController= Navigation.findNavController(this,R.id.nav_host);
                Toast.makeText(this, "Montreal's weather is showing!"+b.getString("Country"), Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.firstFragment,b);
                break;
            case R.id.london:
                b.putString("Label","london");
                navController= Navigation.findNavController(this,R.id.nav_host);
                Toast.makeText(this, "london's weather is showing!"+b.getString("Country"), Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.firstFragment,b);
                break;
            case R.id.hyderabad:
                b.putString("Label","hyderabad");
                navController= Navigation.findNavController(this,R.id.nav_host);
                navController.navigate(R.id.firstFragment,b);
                break;
            case R.id.newYork:
                b.putString("Label","newYork");
                navController= Navigation.findNavController(this,R.id.nav_host);
                Toast.makeText(this, "NY's weather is showing!"+b.getString("Country"), Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.firstFragment,b);
                break;
            case R.id.chicago:
                b.putString("Label","chicago");
                navController= Navigation.findNavController(this,R.id.nav_host);
                navController.navigate(R.id.firstFragment,b);
                break;
            case R.id.delhi:
                b.putString("Label","delhi");
                navController= Navigation.findNavController(this,R.id.nav_host);
                navController.navigate(R.id.firstFragment,b);
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.nav_host),drawerLayout);
    }

}