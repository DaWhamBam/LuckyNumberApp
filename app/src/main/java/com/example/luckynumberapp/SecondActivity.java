package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeText, luckyNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeText = findViewById(R.id.tv_text);
        luckyNumberTxt = findViewById(R.id.tv_text2);
        share_btn = findViewById(R.id.btn_share);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        int random_num = generateRandomNumber();
        luckyNumberTxt.setText("" +random_num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, random_num);
            }
        });

    }

    public int generateRandomNumber() {
        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated = random.nextInt(upper_limit);

        return randomNumberGenerated;
    }

    public  void shareData(String username, int randomNum) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, username + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is: "+randomNum);

        startActivity(Intent.createChooser(i, "Choose a Platform"));
    }


}