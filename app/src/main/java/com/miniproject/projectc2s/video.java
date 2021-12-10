package com.miniproject.projectc2s;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class video extends AppCompatActivity {
 @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_video);
     Toolbar toolbar=findViewById(R.id.toolbar);
     setSupportActionBar(toolbar);
     BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

     bottomNavigationView.setSelectedItemId(R.id.video);

     bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
             switch (menuItem.getItemId()) {
                 case R.id.home:
                     startActivity(new Intent(getApplicationContext(),
                             NavigationActivity.class));
                     overridePendingTransition(0, 0);
                     return true;

                 case R.id.law:

                     startActivity(new Intent(getApplicationContext(),
                             laws.class));
                     overridePendingTransition(0, 0);
                     return true;

                 case R.id.map:
                     startActivity(new Intent(getApplicationContext(),
                             maps.class));
                     overridePendingTransition(0, 0);

                     return true;


                 case R.id.video:

                     return true;


                 case R.id.helpline:
                     startActivity(new Intent(getApplicationContext(),
                             helpline.class));
                     overridePendingTransition(0, 0);
                     return true;

             }
             return false;
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