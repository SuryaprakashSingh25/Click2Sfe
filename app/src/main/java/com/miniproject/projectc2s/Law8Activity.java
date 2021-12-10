package com.miniproject.projectc2s;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class Law8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law8);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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