package com.ian.portals.conntrollers;

import android.content.Context;

import com.ian.portals.data.GameSession;
import com.ian.portals.data.GlobalVariables;
import com.ian.portals.miscellaneous.RandomNumberGenerator;

/**
 * Created by Ian.
 */

public class GameplayController
{
    private Context gameContext;
    private GameSession gameSession;
    private DataController dataController;
    private int result;
    private boolean isFinalQuestion;

    public GameplayController(MainController mainController)
    {
        gameContext = mainController.getContext();
        gameSession = mainController.getGameSession();
        dataController = mainController.getDataController();
    }

    public void play()
    {
        int diceRoll;

        diceRoll = rollDice();
        gameSession.setDiceRoll(diceRoll);
        setQuestion(diceRoll);
    }

    private int rollDice()
    {
        int diceRoll;

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        diceRoll = randomNumberGenerator.generateNumber(dataController.getDiceLowLimit(), dataController.getDiceHighLimit());

        return diceRoll;
    }

    private void setQuestion(int steps)
    {
        isFinalQuestion = (gameSession.getAvatar().getPosition()) >= (dataController.getWidthTilesCount() * dataController.getHeightTilesCount()) - 6;

        if(isFinalQuestion)
        {
            GlobalVariables.setCurrentQuestion(gameSession.getFinalQuestion());
        }
        else
        {
            GlobalVariables.setCurrentQuestion(gameSession.getQuestions().get(gameSession.getAvatar().getPosition() + steps));
        }
    }

    public int checkAnswer()
    {
        if(GlobalVariables.getAnswer() == GlobalVariables.getCurrentQuestion().getCorrectAnswer())
        {
            gameSession.getAvatar().move(gameSession.getDiceRoll());
            if(isFinalQuestion)
            {
                result = 0;
            }
            else
            {
                result = 1;
            }
        }
        else
        {
            result = -1;
        }

        return result;
    }
}
