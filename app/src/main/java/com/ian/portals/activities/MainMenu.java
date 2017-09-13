package com.ian.portals.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ian.portals.R;

public class MainMenu extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void playOnClickEvent(View view)
    {
        startActivity(new Intent(MainMenu.this, Game.class));
    }

    public void settingsOnClickEvent(View view)
    {
        startActivity(new Intent(MainMenu.this, Settings.class));
    }

    public void connectOnClickEvent(View view)
    {
        //TODO: login & register activities
        Toast.makeText(this, "Login & register not implemented yet.", Toast.LENGTH_SHORT).show();
    }

    public void exitOnClickEvent(View view)
    {
        finish();
    }
}
