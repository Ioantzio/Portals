package com.ian.portals.conntrollers;

/**
 * Created by Ian.
 */

public class DataController
{

    //Variables: Dice
    private static final int diceLowLimit = 1;
    private static final int diceHighLimit = 6;
    private static final int diceImageWidth = 150;
    private static final int diceImageHeight = 150;

    //Variables: Tiles
    private static final int widthTilesCount = 6;
    private static final int heightTilesCount = 8;

    //Methods: Dice
    public int getDiceLowLimit()
    {
        return diceLowLimit;
    }

    public int getDiceHighLimit()
    {
        return diceHighLimit;
    }

    public int getDiceImageWidth()
    {
        return diceImageWidth;
    }

    public int getDiceImageHeight()
    {
        return diceImageHeight;
    }

    //Methods: Tiles
    public int getWidthTilesCount()
    {
        return widthTilesCount;
    }

    public int getHeightTilesCount()
    {
        return heightTilesCount;
    }
}