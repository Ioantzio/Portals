package com.ian.portals.data;

import android.content.Context;

import com.ian.portals.conntrollers.MainController;
import com.ian.portals.miscellaneous.NonQuestionTiles;
import com.ian.portals.mock.MockQuestions;
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
    private NonQuestionTiles nonQuestionTiles;
    private boolean isOnFreeTile;
    private ArrayList<Integer> freeTiles;

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
        nonQuestionTiles = new NonQuestionTiles();
        freeTiles = nonQuestionTiles.getFreeTiles();
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