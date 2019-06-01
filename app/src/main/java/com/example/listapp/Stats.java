package com.example.listapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Stats extends AppCompatActivity {
    Intent intent = getIntent();
    Champion champion = (Champion) intent.getSerializableExtra(this.getResources().getString(R.string.champion));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champion_stats);
    }
    private void getIncomingIntent(){
        Context context = null;
        if (getIntent().hasExtra(context.getResources().getString(R.string.champion))){
                String nameChamp = getIntent().getStringExtra(context.getResources().getString(R.string.champion));
        setImage(nameChamp);
        }
    }
    private void setImage(String nameChamp){
        TextView name = findViewById(R.id.image_description);
        name.setText(nameChamp);
    }
}