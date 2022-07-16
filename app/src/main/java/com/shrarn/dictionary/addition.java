package com.shrarn.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addition extends AppCompatActivity {

    EditText et_word, et_meaning;

    AppCompatButton btn_youtube3;
    AppCompatButton btn_facebook3;
    AppCompatButton btn_instagram3;
    AppCompatButton btn_logo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition);
        et_word=findViewById(R.id.et_Word);
        et_meaning=findViewById(R.id.et_meaning);

        btn_logo3 = findViewById(R.id.Logo3);
        btn_youtube3 = findViewById(R.id.youtubeButton3);
        btn_facebook3 = findViewById(R.id.facebookButton3);
        btn_instagram3 = findViewById(R.id.instagramButton3);

        btn_facebook3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://m.facebook.com/Softprogroupofcompanies/?tsid=0.9207350635838187&source=result");
            }
        });

        btn_youtube3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://youtube.com/c/SoftproIndia");
            }
        }));

        btn_instagram3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://instagram.com/softproindia?igshid=YmMyMTA2M2Y=");
            }
        });

        btn_logo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("http://www.softproindia.in");
            }
        });
    }
    public void add(View view)
    {
        if(et_word.getText().toString().isEmpty())
        {
            et_word.setError("Empty");
            et_word.requestFocus();
        }
        else
        {
            if(et_meaning.getText().toString().isEmpty())
            {
                et_meaning.setError("Empty");
                et_meaning.requestFocus();
            }
            else
            {
                DbManager dm=new DbManager(this);
                String word=et_word.getText().toString();
                String meaning=et_meaning.getText().toString();
                String query="insert into dict values('"+word+"','"+meaning+"')";
                SQLiteDatabase db=dm.getWritableDatabase();
                db.execSQL(query);
                Toast.makeText(this, "Word and meaning are added", Toast.LENGTH_SHORT).show();
                et_word.setText("");
                et_meaning.setText("");
            }
        }



    }

    private void gotoURL(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}