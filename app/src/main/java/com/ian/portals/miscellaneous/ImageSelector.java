package com.ian.portals.miscellaneous;

import java.util.HashMap;
import com.ian.portals.R.drawable;

/**
 * Created by Ian.
 */

public class ImageSelector
{
    private HashMap<Integer, Integer> diceImages;

    public ImageSelector()
    {
        diceImages = new HashMap<>();

        initializeDiceImages();
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
}
