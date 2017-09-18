package com.ian.portals.data;

import com.ian.portals.mock.MockQuestions;
import com.ian.portals.models.Avatar;
import com.ian.portals.models.Question;

import java.util.ArrayList;

/**
 * Created by Ian.
 */

public class GameSession
{
    //Variables: Questions
    private MockQuestions mockQuestions;

    //Variables: Player
    private Avatar avatar;

    //Variables: Dice
    private int diceRoll;

    public GameSession()
    {
        initializeVariables();
    }

    private void initializeVariables()
    {
        mockQuestions = new MockQuestions();
        avatar = new Avatar();
        diceRoll = 1;
    }

    //Methods: Questions
    public ArrayList<Question> getQuestions()
    {
        return mockQuestions.getQuestions();
    }

    public Question getFinalQuestion()
    {
        return mockQuestions.getFinalQuestion();
    }

    //Methods: Player
    public Avatar getAvatar()
    {
        return avatar;
    }

    public void setAvatar(Avatar avatar)
    {
        this.avatar = avatar;
    }

    public int getDiceRoll()
    {
        return diceRoll;
    }

    public void setDiceRoll(int diceRoll)
    {
        this.diceRoll = diceRoll;
    }
}