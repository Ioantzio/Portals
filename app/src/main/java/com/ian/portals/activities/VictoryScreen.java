package com.ian.portals.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ian.portals.R;
import com.ian.portals.data.GlobalVariables;

public class VictoryScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory_screen);

        updateStatistics();
    }

    private void updateStatistics()
    {
        TextView numberOfQuestions = (TextView) findViewById(R.id.number_of_questions);
        numberOfQuestions.setText(String.valueOf(GlobalVariables.getNumberOfQuestions()));

        TextView numberOfCorrectAnswers = (TextView) findViewById(R.id.number_of_correct_answers);
        numberOfCorrectAnswers.setText(String.valueOf(GlobalVariables.getNumberOfCorrectAnswers()));

        TextView numberOfPortalsUsed = (TextView) findViewById(R.id.number_of_portals_used);
        numberOfPortalsUsed.setText(String.valueOf(GlobalVariables.getNumberOfPortalsUsed()));

        TextView numberOfFreeTilesStepped = (TextView) findViewById(R.id.number_of_free_tiles_stepped);
        numberOfFreeTilesStepped.setText(String.valueOf(GlobalVariables.getNumberOfFreeTilesStepped()));
    }

    public void returnOnClickEvent(View view)
    {
        finish();
    }
}
