package com.shrarn.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    AppCompatButton AddWordButton;
    AutoCompleteTextView actv_word;
    TextView tv_meaning;
    ArrayAdapter Ad;
    ArrayList<String> al=new ArrayList<String>();
    DbManager dm;
    SQLiteDatabase db;
    Cursor c;
    String query;


    AppCompatButton btn_youtube;
    AppCompatButton btn_instagram;
    AppCompatButton btn_facebook;
    AppCompatButton btn_Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddWordButton=findViewById(R.id.AddWordButton);
        actv_word=findViewById(R.id.actv_word);
        tv_meaning=findViewById(R.id.tv_meaning);
        AddWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,loginscreen.class);
                startActivity(intent);
            }
        });
        dm=new DbManager(this);
        db=dm.getWritableDatabase();
        query="select * from dict";
        c=db.rawQuery(query,null);
        boolean res=c.moveToFirst();
        while(res==true)
        {
            al.add(c.getString(0));
            res=c.moveToNext();
        }
        Ad=new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,al);
        actv_word.setAdapter(Ad);

        actv_word.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String word=Ad.getItem(i).toString();
                query="select meaning from dict where word='"+word+"'";
                c=db.rawQuery(query,null);
                if(c.moveToFirst())
                {
                    tv_meaning.setText(c.getString(0));
                }
            }
        });

        btn_Logo = findViewById(R.id.Logo);
        btn_youtube = findViewById(R.id.youtubeButton1);
        btn_facebook = findViewById(R.id.facebookButton1);
        btn_instagram = findViewById(R.id.instagramButton1);


        btn_Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("http://www.softproindia.in");
            }
        });
        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://m.facebook.com/Softprogroupofcompanies/?tsid=0.9207350635838187&source=result");
            }
        });

        btn_youtube.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://youtube.com/c/SoftproIndia");
            }
        }));

        btn_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://instagram.com/softproindia?igshid=YmMyMTA2M2Y=");
            }
        });
    }

    private void gotoURL(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


}