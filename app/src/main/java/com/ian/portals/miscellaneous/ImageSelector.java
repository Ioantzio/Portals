package com.ian.portals.miscellaneous;

import java.util.HashMap;
import com.ian.portals.R.drawable;

/**
 * Created by Ian.
 */

public class ImageSelector
{
    private int widthTilesCount;
    private int heightTilesCount;
    private int screenWidth;
    private int screenHeight;

    private int playerImage;
    private int tileImage;

    private HashMap<Integer, Integer> diceImages;
    private HashMap<Integer, Integer> tileSizes;
    private HashMap<Integer, Integer> playerSizes;

    /**
     * @param widthTilesCount No.tiles to be drawn horizontally
     * @param heightTilesCount No.tiles to be drawn vertically
     * @param screenWidth Available screen width to draw all horizontal tiles
     * @param screenHeight Available screen height to draw all vertical tiles
     */
    public ImageSelector(int widthTilesCount, int heightTilesCount, int screenWidth, int screenHeight)
    {
        setWidthTilesCount(widthTilesCount);
        setHeightTilesCount(heightTilesCount);
        setScreenWidth(screenWidth);
        setScreenHeight(screenHeight);

        diceImages = new HashMap<>();
        diceImages = new HashMap<>();
        tileSizes = new HashMap<>();
        playerSizes = new HashMap<>();

        initializeDiceImages();
        initializeTileImages();
        initializePlayerImages();

        calculateSizes();
    }

    private int getWidthTilesCount()
    {
        return widthTilesCount;
    }

    private void setWidthTilesCount(int widthTilesCount)
    {
        this.widthTilesCount = widthTilesCount;
    }

    private int getHeightTilesCount()
    {
        return heightTilesCount;
    }

    private void setHeightTilesCount(int heightTilesCount)
    {
        this.heightTilesCount = heightTilesCount;
    }

    private int getScreenWidth()
    {
        return screenWidth;
    }

    private void setScreenWidth(int screenWidth)
    {
        this.screenWidth = screenWidth;
    }

    private int getScreenHeight()
    {
        return screenHeight;
    }

    private void setScreenHeight(int screenHeight)
    {
        this.screenHeight = screenHeight;
    }

    private void initializeDiceImages()
    {
        diceImages.put(1, drawable.dice_1);
        diceImages.put(2, drawable.dice_2);
        diceImages.put(3, drawable.dice_3);
        diceImages.put(4, drawable.dice_4);
        diceImages.put(5, drawable.dice_5);
        diceImages.put(6, drawable.dice_6);
    }

    public int getDiceImage(int diceRoll)
    {
        return diceImages.get(diceRoll);
    }

    private void initializeTileImages()
    {
        tileSizes.put(10, drawable.tile_xx_small);
        tileSizes.put(20, drawable.tile_x_small);
        tileSizes.put(30, drawable.tile_small);
        tileSizes.put(40, drawable.tile_medium_small);
        tileSizes.put(50, drawable.tile_medium);
        tileSizes.put(60, drawable.tile_medium_large);
        tileSizes.put(70, drawable.tile_large);
        tileSizes.put(80, drawable.tile_x_large);
        tileSizes.put(90, drawable.tile_xx_large);
    }

    public int getTileImage()
    {
        return tileImage;
    }

    private void setTileImage(int tileImage)
    {
        this.tileImage = tileImage;
    }

    private void initializePlayerImages()
    {
        playerSizes.put(10, drawable.player_xx_small_cyan);
        playerSizes.put(20, drawable.player_x_small_cyan);
        playerSizes.put(30, drawable.player_small_cyan);
        playerSizes.put(40, drawable.player_medium_small_cyan);
        playerSizes.put(50, drawable.player_medium_cyan);
        playerSizes.put(60, drawable.player_medium_large_cyan);
        playerSizes.put(70, drawable.player_large_cyan);
        playerSizes.put(80, drawable.player_x_large_cyan);
        playerSizes.put(90, drawable.player_xx_large_cyan);
    }

    public int getPlayerImage()
    {
        return playerImage;
    }

    private void setPlayerImage(int playerImage)
    {
        this.playerImage = playerImage;
    }

    @SuppressWarnings("RedundantCast")
    private void calculateSizes()
    {
        int width;
        int height;

        width = (int) (getScreenWidth() / getWidthTilesCount());
        height = (int) (getScreenHeight() / getHeightTilesCount());

        setTileImage(tileSizes.get(50));
        setPlayerImage(playerSizes.get(50));

        for(int i=1; i<=tileSizes.size(); i++)
        {
            if(width >= i*10 || height >= i*10)
            {
                setTileImage(tileSizes.get(i*10));
                setPlayerImage(playerSizes.get(i*10));
            }
        }
    }
}
