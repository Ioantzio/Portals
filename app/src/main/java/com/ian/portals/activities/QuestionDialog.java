package com.ian.portals.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ian.portals.R;
import com.ian.portals.data.GlobalVariables;
import com.ian.portals.models.Question;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionDialog extends AppCompatActivity
{
    TextView mQuestion;
    Button mAnswer1, mAnswer2, mAnswer3, mAnswer4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_dialog);

        this.setFinishOnTouchOutside(false);
        initializeVariables();

        setupQuestion(GlobalVariables.getCurrentQuestion());
        setupAnswerTimeProgressBar();
    }

    @Override
    public void onBackPressed()
    {
        Toast.makeText(this, R.string.ERROR_backPressedOnQuestionDialog, Toast.LENGTH_SHORT).show();
    }

    private void initializeVariables()
    {
        mQuestion = (TextView) findViewById(R.id.question);
        mAnswer1 = (Button) findViewById(R.id.answer_1);
        mAnswer2 = (Button) findViewById(R.id.answer_2);
        mAnswer3 = (Button) findViewById(R.id.answer_3);
        mAnswer4 = (Button) findViewById(R.id.answer_4);
    }

    private void setupQuestion(Question question)
    {
        mQuestion.setText(question.getQuestion());

        ArrayList<String> answerShuffler = new ArrayList<>();

        answerShuffler.add(question.getAnswer1());
        answerShuffler.add(question.getAnswer2());
        answerShuffler.add(question.getAnswer3());
        answerShuffler.add(question.getAnswer4());
        Collections.shuffle(answerShuffler);

        mAnswer1.setText(answerShuffler.get(0));
        mAnswer2.setText(answerShuffler.get(1));
        mAnswer3.setText(answerShuffler.get(2));
        mAnswer4.setText(answerShuffler.get(3));
    }

    private void returnAnswer(String answer)
    {
        GlobalVariables.setAnswer(answer);
        setResult(RESULT_OK);
        finish();
    }

    public void setupAnswerTimeProgressBar()
    {
        /*final ProgressBar answerTimeTracker = (ProgressBar) findViewById(R.id.answer_time);
        answerTimeTracker.setProgress(0);

        CountDownTimer cdt = new CountDownTimer(GlobalVariables.getAnswerTime() * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                answerTimeTracker.setProgress((int) (GlobalVariables.getAnswerTime() * 1000 - millisUntilFinished));
            }

            public void onFinish() {
                finish();
            }
        };
        cdt.start();*/
    }

    public void firstAnswerOnClickEvent(View view)
    {
        returnAnswer(mAnswer1.getText().toString());
    }

    public void secondAnswerOnClickEvent(View view)
    {
        returnAnswer(mAnswer2.getText().toString());
    }

    public void thirdAnswerOnClickEvent(View view)
    {
        returnAnswer(mAnswer3.getText().toString());
    }

    public void fourthAnswerOnClickEvent(View view)
    {
        returnAnswer(mAnswer4.getText().toString());
    }
}