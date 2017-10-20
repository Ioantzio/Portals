package com.ian.portals.data;

import com.ian.portals.miscellaneous.NonQuestionTiles;
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

    //Variables: Tiles
    private NonQuestionTiles nonQuestionTiles;
    private boolean isOnFreeTile;
    private ArrayList<Integer> freeTiles;

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
        nonQuestionTiles = new NonQuestionTiles();
        freeTiles = nonQuestionTiles.getFreeTiles();
        avatar = new Avatar();
        diceRoll = 1;
        isOnFreeTile = false;
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

    //Methods: Tiles
    public ArrayList<Integer> getFreeTiles()
    {
        return freeTiles;
    }

    public boolean isOnFreeTile()
    {
        return isOnFreeTile;
    }

    public void setOnFreeTile(boolean onFreeTile)
    {
        isOnFreeTile = onFreeTile;
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

    //Methods: Dice
    public int getDiceRoll()
    {
        return diceRoll;
    }

    public void setDiceRoll(int diceRoll)
    {
        this.diceRoll = diceRoll;
    }
}