package com.ian.portals.miscellaneous;

import com.ian.portals.conntrollers.DataController;
import com.ian.portals.data.GlobalVariables;
import com.ian.portals.data.Tile;

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

    public void calculateFreeTiles()
    {
        int rand;
        int freeTile;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        rand = randomNumberGenerator.generateNumber(2, dataController.getWidthTilesCount() - 1, false);
        freeTile = rand;
        GlobalVariables.getTileTypes().put(freeTile, Tile.free);

        for(int count = 1; count < dataController.getHeightTilesCount() - 1; count++)
        {
            do
            {
                rand = randomNumberGenerator.generateNumber(1, dataController.getWidthTilesCount(), false);
                freeTile = count * dataController.getWidthTilesCount() + rand;
            }
            while(GlobalVariables.getTileTypes().get(freeTile) != Tile.normal);
            GlobalVariables.getTileTypes().put(freeTile, Tile.free);
        }
    }

    public void calculatePortalTiles()
    {
        ArrayList<Integer> portalTilesList = new ArrayList<>();
        int rand;
        int portalTile;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        rand = randomNumberGenerator.generateNumber(2, dataController.getWidthTilesCount() - 1, false);
        portalTile = rand;
        GlobalVariables.getTileTypes().put(portalTile, Tile.portal);

        for(int count = 1; count < dataController.getHeightTilesCount() - 1; count++)
        {
            do
            {
                rand = randomNumberGenerator.generateNumber(1, dataController.getWidthTilesCount(), false);
                portalTile = count * dataController.getWidthTilesCount() + rand;
            }
            while(GlobalVariables.getTileTypes().get(portalTile) != Tile.normal);
            GlobalVariables.getTileTypes().put(portalTile, Tile.portal);
            portalTilesList.add(portalTile);
        }
        GlobalVariables.setPortalTilesList(portalTilesList);
    }
}
