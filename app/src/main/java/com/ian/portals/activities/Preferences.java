package com.ian.portals.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.ian.portals.R;
import com.ian.portals.data.GlobalVariables;

public class Preferences extends AppCompatActivity
{
    Spinner category;
    ArrayAdapter<CharSequence> categoryAdapter;
    Spinner grade;
    ArrayAdapter<CharSequence> gradeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        initializeVariables();
        updatePreferences();
        answerTimeOnSeekBarChangeEvent(findViewById(R.id.answer_time_tracker));
    }

    private void initializeVariables()
    {
        category = (Spinner) findViewById(R.id.category);
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

        grade = (Spinner) findViewById(R.id.grade);
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

        SeekBar answerTime = (SeekBar) findViewById(R.id.answer_time_tracker);
        TextView answerTimeCurrent = (TextView) findViewById(R.id.answer_time_current);
        answerTime.setProgress(GlobalVariables.getAnswerTimeForSeekbar());
        answerTimeCurrent.setText(String.valueOf(GlobalVariables.getAnswerTime()));
    }

    public void answerTimeOnSeekBarChangeEvent(View view)
    {
        SeekBar answerTime = (SeekBar) findViewById(R.id.answer_time_tracker);

        answerTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            TextView answerTimeCurrent = (TextView) findViewById(R.id.answer_time_current);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                GlobalVariables.setAnswerTimeFromSeekbar(progress);
                answerTimeCurrent.setText(String.valueOf(GlobalVariables.getAnswerTime()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    public void backOnClickEvent(View view)
    {
        finish();
    }
}
