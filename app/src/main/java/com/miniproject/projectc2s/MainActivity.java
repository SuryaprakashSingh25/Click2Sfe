package com.miniproject.projectc2s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,email,password,conformPassword;
    Button signup,signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText) findViewById(R.id.username);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        conformPassword=(EditText) findViewById(R.id.conformPassword);
        signup=(Button) findViewById(R.id.btnSignup);
        signin=(Button) findViewById(R.id.btnSignin);

        DB =new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                String conPass = conformPassword.getText().toString();
                if (user.trim().length() < 5 ) {
                    Toast.makeText(MainActivity.this, "Username must be atleast 5 characters long", Toast.LENGTH_SHORT).show();
                }
                else if(!mail.contains("@gmail.com") && mail.length()<12){
                    Toast.makeText(MainActivity.this, "Mail must contain atleast 12 characters including @gmail.com at the end", Toast.LENGTH_SHORT).show();
                }
                else if(pass.length()<8){
                    Toast.makeText(MainActivity.this, "Password must be atleast 8 characters long", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (user.equals("") || mail.equals("") || pass.equals("") || conPass.equals(""))
                        Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    else {
                        if (pass.equals(conPass)) {
                            Boolean checkuser = DB.checkusername(user);
                            if (checkuser == false) {
                                Boolean insert = DB.insertData(user, mail, pass);
                                if (insert == true) {
                                    Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Password not matching!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}