package com.miniproject.projectc2s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class NavigationActivity extends AppCompatActivity {
    EditText no, msg;
    Button send_btn,send_loc;
    ImageButton add_btn;

    private static final int PICK_CONTACT=885;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        no = (EditText) findViewById(R.id.number_txtbx);
        msg = (EditText) findViewById(R.id.message_txtbx);

        add_btn = (ImageButton) findViewById(R.id.btn_addcntct);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(i,101);
            }
        });

        send_btn = (Button) findViewById(R.id.btn_send);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try
                {
                    SmsManager sms_mnger = SmsManager.getDefault();
                    sms_mnger.sendTextMessage(no.getText().toString(), null, msg.getText().toString(), null, null );

                    Toast.makeText(NavigationActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    Toast.makeText(NavigationActivity.this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        send_loc = (Button) findViewById(R.id.loc);
        send_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String nos = no.getText().toString();
//                Intent mIntent = new Intent(NavigationActivity.this, GoogleMapsActivity.class);
//                mIntent.putExtra("number", nos);
                Intent i = new Intent(NavigationActivity.this, GoogleMapsActivity.class);
                i.putExtra("number", nos);
                startActivity(i);

            }
        });

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        return true;

                    case R.id.law:
                        startActivity(new Intent(getApplicationContext(),
                                laws.class));
                        overridePendingTransition(0,0);
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101 && resultCode == Activity.RESULT_OK){
            Uri uri =  data.getData();
            String cols[] = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
            Cursor rs = getContentResolver().query(uri,cols,null,null,null);
            if(rs.moveToFirst()){
                no.setText(rs.getString(0));
//                edName.setText(rs.getString(1));
            }
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