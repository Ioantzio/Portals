package com.ian.portals.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ian.portals.R;

public class Preferences extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        updatePreferences();
    }

    private void updatePreferences()
    {

    }

    public void backOnClickEvent(View view)
    {
        finish();
    }
}
