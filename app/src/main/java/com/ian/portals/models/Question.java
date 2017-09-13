package com.ian.portals.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ian.
 */

public class Question implements Parcelable
{
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correctAnswer;

    public Question(String question, String answer1, String answer2, String answer3, String answer4, int correctAnswer)
    {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getAnswer1()
    {
        return answer1;
    }

    public void setAnswer1(String answer1)
    {
        this.answer1 = answer1;
    }

    public String getAnswer2()
    {
        return answer2;
    }

    public void setAnswer2(String answer2)
    {
        this.answer2 = answer2;
    }

    public String getAnswer3()
    {
        return answer3;
    }

    public void setAnswer3(String answer3)
    {
        this.answer3 = answer3;
    }

    public String getAnswer4()
    {
        return answer4;
    }

    public void setAnswer4(String answer4)
    {
        this.answer4 = answer4;
    }

    public int getCorrectAnswer()
    {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }

    //Start parcel implementation
    public Question(Parcel in)
    {
        String[] data= new String[6];

        in.readStringArray(data);
        this.question = data[0];
        this.answer1 = data[1];
        this.answer2 = data[2];
        this.answer3 = data[3];
        this.answer4 = data[4];
        this.correctAnswer = Integer.parseInt(data[5]);
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeStringArray(new String[]{this.question, this.answer1, this.answer2, this.answer3, this.answer4, String.valueOf(this.correctAnswer)});
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>()
    {
        @Override
        public Question createFromParcel(Parcel source)
        {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size)
        {
            return new Question[size];
        }
    };
    //End parcel implementation
}
