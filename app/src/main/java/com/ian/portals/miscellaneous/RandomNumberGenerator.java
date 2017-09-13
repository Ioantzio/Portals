package com.ian.portals.miscellaneous;

import java.util.Random;

/**
 * Created by Ian.
 */

public class RandomNumberGenerator
{
    public int generateNumber(int lowLimit, int highLimit)
    {
        if(lowLimit == highLimit)
        {
            return lowLimit;
        }
        else if(lowLimit > highLimit)
        {
            return -1;
        }
        else
        {
            Random rand = new Random();
            return rand.nextInt((highLimit - lowLimit) + 1) + lowLimit;
        }
    }
}
