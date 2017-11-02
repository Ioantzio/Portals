package com.ian.portals.data;

import android.content.Context;

import com.ian.portals.miscellaneous.RandomNumberGenerator;
import com.ian.portals.models.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Ian
 */

public class ReadQuestionsFromFile
{
    private Context context;
    private ArrayList<Question> questions;

    public ReadQuestionsFromFile(Context context)
    {
        this.context = context;
    }

    public String getJsonFromAsset(String filename)
    {
        byte[] buffer;
        String json;

        try
        {
            InputStream inputStream = context.getAssets().open(filename + "-" + GlobalVariables.getLanguagePrefix() + ".json");
            buffer = new byte[inputStream.available()];

            //noinspection ResultOfMethodCallIgnored
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, "UTF-8");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }

        return json;
    }

    public ArrayList<Question> getQuestions()
    {
        JSONObject temp;
        try
        {
            JSONObject jsonObject = new JSONObject(getJsonFromAsset("Questions"));
            JSONArray jsonArray = jsonObject.getJSONArray("questions");
            questions = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++)
            {
                temp = jsonArray.getJSONObject(i);
                questions.add(new Question(temp.getString("question"), temp.getString("answer1"), temp.getString("answer2"), temp.getString("answer3"), temp.getString("answer4"), temp.getString("correctAnswer")));
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        return questions;
    }

    public Question getFinalQuestion()
    {
        JSONObject temp;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        try
        {
            JSONObject jsonObject = new JSONObject(getJsonFromAsset("Questions_final"));
            JSONArray jsonArray = jsonObject.getJSONArray("questions");
            questions = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++)
            {
                temp = jsonArray.getJSONObject(i);
                questions.add(new Question(temp.getString("question"), temp.getString("answer1"), temp.getString("answer2"), temp.getString("answer3"), temp.getString("answer4"), temp.getString("correctAnswer")));
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        return questions.get(randomNumberGenerator.generateNumber(0, questions.size()-1, true));
    }
}
