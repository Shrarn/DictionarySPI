package com.shrarn.dictionary;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginscreen extends AppCompatActivity {

    EditText et_username;
    EditText et_password;

    AppCompatButton btn_youtube2;
    AppCompatButton btn_facebook2;
    AppCompatButton btn_instagram2;
    AppCompatButton btn_logo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);

        btn_youtube2 = findViewById(R.id.btn_yt2);
        btn_facebook2 = findViewById(R.id.btn_fb2);
        btn_instagram2 = findViewById(R.id.btn_insta2);
        btn_logo2 = findViewById(R.id.Logo2);

        btn_facebook2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://m.facebook.com/Softprogroupofcompanies/?tsid=0.9207350635838187&source=result");
            }
        });

        btn_youtube2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://youtube.com/c/SoftproIndia");
            }
        }));

        btn_instagram2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://instagram.com/softproindia?igshid=YmMyMTA2M2Y=");
            }
        });

        btn_logo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("http://www.softproindia.in");
            }
        });
    }


    public void login(View view){
        if(et_username.getText().toString().isEmpty())
        {
            et_username.setError("Empty");
            et_username.requestFocus();
        }
        else
        {
            if(et_password.getText().toString().isEmpty())
            {
                et_password.setError("Empty");
                et_password.requestFocus();
            }
            else
            {
                String username=et_username.getText().toString();
                String password=et_password.getText().toString();
                if(username.equals("admin") && password.equals("admin@123"))
                {
                    Intent I=new Intent(loginscreen.this,addition.class);
                    startActivity(I);
                    finish();
                }
                else
                {
                    Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
                    et_username.setText("");
                    et_password.setText("");
                }
            }
        }


    }

    private void gotoURL(String s) {
        Uri uri1 = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri1));
    }

}
