package com.miniproject.projectc2s;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class maps extends AppCompatActivity {

      Button btnMapGoogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnMapGoogle=(Button) findViewById(R.id.btnMap);



        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.map);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),
                                NavigationActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.law:

                        startActivity(new Intent(getApplicationContext(),
                                laws.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.map:

                        return true;


                    case R.id.video:
                        startActivity(new Intent(getApplicationContext(),
                                video.class));
                        overridePendingTransition(0,0);
                        return true;


                    case R.id.helpline:
                        startActivity(new Intent(getApplicationContext(),
                                helpline.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        btnMapGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMapGoogle.setVisibility(View.GONE);
                Intent intent=new Intent(getApplicationContext(),GoogleMapsActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.aboutUs){
            Intent intent=new Intent(getApplicationContext(),AboutUs.class);
            startActivity(intent);
        }
        else if(id==R.id.helplineList){
            Intent intent=new Intent(getApplicationContext(),HelplineList.class);
            startActivity(intent);
        }
        else if(id==R.id.signOut){
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(this,SendOtpActivity.class));
        }

        return true;
    }
}