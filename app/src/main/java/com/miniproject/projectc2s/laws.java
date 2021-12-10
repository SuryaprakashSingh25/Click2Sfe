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

public class laws extends AppCompatActivity implements View.OnClickListener {
    public CardView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      //  getSupportActionBar().hide();


       // recyclerView = findViewById(R.id.rv);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //adapter = new RecyclerAdapter(this,lawNames);
        //recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.law);

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
                        return true;

                    case R.id.map:
                        startActivity(new Intent(getApplicationContext(),
                                maps.class));
                        overridePendingTransition(0,0);
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
        card1=(CardView) findViewById(R.id.c1);
        card2=(CardView) findViewById(R.id.c2);
        card3=(CardView) findViewById(R.id.c3);
        card4=(CardView) findViewById(R.id.c4);
        card5=(CardView) findViewById(R.id.c5);
        card6=(CardView) findViewById(R.id.c6);
        card7=(CardView) findViewById(R.id.c7);
        card8=(CardView) findViewById(R.id.c8);
        card9=(CardView) findViewById(R.id.c9);
        card10=(CardView) findViewById(R.id.c10);
        card11=(CardView) findViewById(R.id.c11);
        card12=(CardView) findViewById(R.id.c12);


        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
        card9.setOnClickListener(this);
        card10.setOnClickListener(this);
        card11.setOnClickListener(this);
        card12.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()) {
            case R.id.c1:
                i = new Intent(this, Law1Activity.class);
                startActivity(i);
                break;
            case R.id.c2:
                i = new Intent(this, LawActivity2.class);
                startActivity(i);
                break;
            case R.id.c3:
                i = new Intent(this, Law3Activity.class);
                startActivity(i);
                break;
            case R.id.c4:
                i = new Intent(this, LawActivity4.class);
                startActivity(i);
                break;
            case R.id.c5:
                i = new Intent(this, Law5Activity.class);
                startActivity(i);
                break;
            case R.id.c6:
                i = new Intent(this, Law6Activity.class);
                startActivity(i);
                break;
            case R.id.c7:
                i = new Intent(this, Law7Activity.class);
                startActivity(i);
                break;
            case R.id.c8:
                i = new Intent(this, Law8Activity.class);
                startActivity(i);
                break;
            case R.id.c9:
                i = new Intent(this, Law9Activity.class);
                startActivity(i);
                break;
            case R.id.c10:
                i = new Intent(this, Law10Activity.class);
                startActivity(i);
                break;
            case R.id.c11:
                i = new Intent(this, Law11Activity.class);
                startActivity(i);
                break;
            case R.id.c12:
                i = new Intent(this, Law12Activity.class);
                startActivity(i);
                break;
        }
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