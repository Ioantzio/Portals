package com.ian.portals.miscellaneous;

import java.util.HashMap;
import com.ian.portals.R.drawable;

/**
 * Created by Ian.
 */

public class ImageSizeCalculator
{
    private int widthTilesCount;
    private int heightTilesCount;
    private int screenWidth;
    private int screenHeight;

    private int playerImage;
    private int tileImage;

    /**
     * @param widthTilesCount No.tiles to be drawn horizontally
     * @param heightTilesCount No.tiles to be drawn vertically
     * @param screenWidth Available screen width to draw all horizontal tiles
     * @param screenHeight Available screen height to draw all vertical tiles
     */
    public ImageSizeCalculator(int widthTilesCount, int heightTilesCount, int screenWidth, int screenHeight)
    {
        setWidthTilesCount(widthTilesCount);
        setHeightTilesCount(heightTilesCount);
        setScreenWidth(screenWidth);
        setScreenHeight(screenHeight);

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

    public int getPlayerImage()
    {
        return playerImage;
    }

    private void setPlayerImage(int playerImage)
    {
        this.playerImage = playerImage;
    }

    public int getTileImage()
    {
        return tileImage;
    }

    private void setTileImage(int tileImage)
    {
        this.tileImage = tileImage;
    }

    private HashMap<Integer, Integer> getTileSizes()
    {
        HashMap<Integer, Integer> tileSizes = new HashMap<>();
        tileSizes.put(10, drawable.tile_xx_small);
        tileSizes.put(20, drawable.tile_x_small);
        tileSizes.put(30, drawable.tile_small);
        tileSizes.put(40, drawable.tile_medium_small);
        tileSizes.put(50, drawable.tile_medium);
        tileSizes.put(60, drawable.tile_medium_large);
        tileSizes.put(70, drawable.tile_large);
        tileSizes.put(80, drawable.tile_x_large);
        tileSizes.put(90, drawable.tile_xx_large);

        return tileSizes;
    }

    private HashMap<Integer, Integer> getPlayerSizes()
    {
        HashMap<Integer, Integer> playerSizes = new HashMap<>();
        playerSizes.put(10, drawable.player_xx_small);
        playerSizes.put(20, drawable.player_x_small);
        playerSizes.put(30, drawable.player_small);
        playerSizes.put(40, drawable.player_medium_small);
        playerSizes.put(50, drawable.player_medium);
        playerSizes.put(60, drawable.player_medium_large);
        playerSizes.put(70, drawable.player_large);
        playerSizes.put(80, drawable.player_x_large);
        playerSizes.put(90, drawable.player_xx_large);

        return playerSizes;
    }

    @SuppressWarnings("RedundantCast")
    private void calculateSizes()
    {
        int width;
        int height;
        HashMap<Integer, Integer> tileSizes = getTileSizes();
        HashMap<Integer, Integer> playerSizes = getPlayerSizes();

        width = (int) (getScreenWidth() / getWidthTilesCount());
        height = (int) (getScreenHeight() / getHeightTilesCount());

        for(int i=1; i<=tileSizes.size(); i++)
        {
            if(width >= i*10 || height >= i*10)
            {
                setTileImage(tileSizes.get(i*10));
                setPlayerImage(playerSizes.get(i*10));
            }
        }
        setTileImage(tileSizes.get(50));
        setPlayerImage(playerSizes.get(50));
    }
}
