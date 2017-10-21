package com.ian.portals.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.ian.portals.R;
import com.ian.portals.data.GlobalVariables;

public class Preferences extends AppCompatActivity
{
    ArrayAdapter<CharSequence> categoryAdapter;
    ArrayAdapter<CharSequence> gradeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        initializeVariables();
        updatePreferences();
    }

    private void initializeVariables()
    {
        //TODO: Preferences lost when changing language
        Spinner category = (Spinner) findViewById(R.id.category);
        categoryAdapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(categoryAdapter);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                GlobalVariables.setCategory(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        Spinner grade = (Spinner) findViewById(R.id.grade);
        gradeAdapter = ArrayAdapter.createFromResource(this, R.array.grades, android.R.layout.simple_spinner_item);
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grade.setAdapter(gradeAdapter);
        grade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                GlobalVariables.setGrade(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    private void updatePreferences()
    {
        Spinner category = (Spinner) findViewById(R.id.category);
        category.setSelection(GlobalVariables.getCategory());

        Spinner grade = (Spinner) findViewById(R.id.grade);
        grade.setSelection(GlobalVariables.getGrade());
    }

    public void backOnClickEvent(View view)
    {
        finish();
    }
}
