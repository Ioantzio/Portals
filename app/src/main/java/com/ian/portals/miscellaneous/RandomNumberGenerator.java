package com.ian.portals.miscellaneous;

import java.util.Random;

/**
 * Created by Ian.
 */

public class RandomNumberGenerator
{
    public int generateNumber(int lowLimit, int highLimit, boolean useSeed)
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
            Random rand;
            if(useSeed)
            {
                rand = new Random(System.currentTimeMillis());
            }
            else
            {
                rand = new Random();
            }
            return rand.nextInt((highLimit - lowLimit) + 1) + lowLimit;
        }
    }
}
