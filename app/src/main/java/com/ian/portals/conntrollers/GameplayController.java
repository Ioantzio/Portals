package com.ian.portals.conntrollers;

import com.ian.portals.data.GameSession;
import com.ian.portals.data.GlobalVariables;
import com.ian.portals.miscellaneous.RandomNumberGenerator;

/**
 * Created by Ian.
 */

public class GameplayController
{
    private GameSession gameSession;
    private DataController dataController;
    private boolean isFinalQuestion;

    public GameplayController(MainController mainController)
    {
        gameSession = mainController.getGameSession();
        dataController = mainController.getDataController();
    }

    public void play()
    {
        int diceRoll;

        diceRoll = rollDice();
        gameSession.setDiceRoll(diceRoll);

        if(gameSession.getFreeTiles().contains(gameSession.getAvatar().getPosition() + diceRoll))
        {
            gameSession.setOnFreeTile(true);
            gameSession.getAvatar().move(diceRoll);
        }
        else
        {
            setQuestion(diceRoll);
        }
    }

    private int rollDice()
    {
        int diceRoll;

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        diceRoll = randomNumberGenerator.generateNumber(dataController.getDiceLowLimit(), dataController.getDiceHighLimit(), true);

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
        int result;

        if(GlobalVariables.getAnswer().equals(GlobalVariables.getCurrentQuestion().getCorrectAnswer()))
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
