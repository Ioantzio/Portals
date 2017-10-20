package com.ian.portals.miscellaneous;

import com.ian.portals.conntrollers.DataController;

import java.util.ArrayList;

/**
 * Created by Ian
 */

public class NonQuestionTiles
{
    private DataController dataController;

    public NonQuestionTiles()
    {
        dataController = new DataController();
    }

    public ArrayList<Integer> getFreeTiles()
    {

        ArrayList<Integer> freeTiles = new ArrayList<>();
        int rand;
        int freeTile;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        rand = randomNumberGenerator.generateNumber(1, dataController.getWidthTilesCount() - 1);
        freeTile = rand;
        freeTiles.add(freeTile);

        for(int count = 1; count < dataController.getHeightTilesCount(); count++)
        {
            rand = randomNumberGenerator.generateNumber(1, dataController.getWidthTilesCount());
            freeTile = count*dataController.getWidthTilesCount() + rand;
            freeTiles.add(freeTile);
        }

        return freeTiles;
    }
}
