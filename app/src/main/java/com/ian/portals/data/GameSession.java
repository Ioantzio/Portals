package com.ian.portals.data;

import android.content.Context;

import com.ian.portals.conntrollers.MainController;
import com.ian.portals.models.Avatar;
import com.ian.portals.models.Question;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ian.
 */

@SuppressWarnings("FieldCanBeLocal")
public class GameSession
{
    //Variables: Questions
    private ReadQuestionsFromFile readQuestionsFromFile;
    private ArrayList<Question> questions;

    //Variables: Tiles
    private boolean isOnFreeTile;
    private boolean isOnPortalTile;

    //Variables: Player
    private Avatar avatar;

    //Variables: Game
    private int diceRoll;
    private boolean playerTurn = true;

    public GameSession(MainController mainController)
    {
        initializeVariables(mainController.getContext());
    }

    private void initializeVariables(Context context)
    {
        readQuestionsFromFile = new ReadQuestionsFromFile(context);
        questions = readQuestionsFromFile.getQuestions();

        avatar = new Avatar();
        diceRoll = 1;
        isOnFreeTile = false;

        randomizeQuestionOrder();
    }

    //Methods: Questions
    public ArrayList<Question> getQuestions()
    {
        return questions;
    }

    public Question getFinalQuestion()
    {
        return readQuestionsFromFile.getFinalQuestion();
    }

    private void randomizeQuestionOrder()
    {
        Collections.shuffle(questions);
    }

    //Methods: Tiles
    public boolean isOnFreeTile()
    {
        return isOnFreeTile;
    }

    public void setOnFreeTile(boolean onFreeTile)
    {
        isOnFreeTile = onFreeTile;
    }

    public boolean isOnPortalTile(){return isOnPortalTile;}

    public void setOnPortalTile(boolean onPortalTile){isOnPortalTile = onPortalTile;}

    //Methods: Player
    public Avatar getAvatar()
    {
        return avatar;
    }

    public void setAvatar(Avatar avatar)
    {
        this.avatar = avatar;
    }

    //Methods: Game
    public int getDiceRoll()
    {
        return diceRoll;
    }

    public void setDiceRoll(int diceRoll)
    {
        this.diceRoll = diceRoll;
    }

    public boolean isPlayerTurn()
    {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn)
    {
        this.playerTurn = playerTurn;
    }
}