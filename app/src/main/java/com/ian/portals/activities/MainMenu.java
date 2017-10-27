package com.ian.portals.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ian.portals.R;
import com.ian.portals.data.GlobalVariables;

public class MainMenu extends AppCompatActivity
{
    //Variables for method 'onBackPressed'
    private static final int waitTime = 2000;
    private long mBackPressed;
    private Toast mExitToast;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    @Override
    public void onBackPressed()
    {
        if(mBackPressed + waitTime > System.currentTimeMillis())
        {
            mExitToast.cancel();
            exitOnClickEvent(null);
        }
        else
        {
            mExitToast = Toast.makeText(getBaseContext(), R.string.TEXT_exit, Toast.LENGTH_SHORT);
            mExitToast.show();
        }
        mBackPressed = System.currentTimeMillis();
    }

    public void playOnClickEvent(View view)
    {
        GlobalVariables.setGameType(0);
        startActivity(new Intent(MainMenu.this, Game.class));
    }

    public void playVsComputerOnClickEvent(View view)
    {
        //TODO: play vs Computer activity
        GlobalVariables.setGameType(1);
//        startActivity(new Intent(MainMenu.this, Game.class));
        Toast.makeText(this, R.string.TODO_VsComputer, Toast.LENGTH_SHORT).show();
    }

    public void settingsOnClickEvent(View view)
    {
        startActivity(new Intent(MainMenu.this, Settings.class));
    }

    public void preferencesOnClickEvent(View view)
    {
        startActivity(new Intent(MainMenu.this, Preferences.class));
    }

    public void updateOnClickEvent(View view)
    {
        //TODO: update activity
        Toast.makeText(this, R.string.TODO_Update, Toast.LENGTH_SHORT).show();
    }

    public void connectOnClickEvent(View view)
    {
        //TODO: login & register activities
        Toast.makeText(this, R.string.TODO_Connect, Toast.LENGTH_SHORT).show();
    }

    public void exitOnClickEvent(View view)
    {
        finish();
    }
}
