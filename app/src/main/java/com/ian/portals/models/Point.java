package com.ian.portals.models;

/**
 * Created by Ian.
 */

public class Point
{
    private int index;
    private int width;
    private int height;

    public Point()
    {
        this.index = 1;
        this.width = 0;
        this.height = 0;
    }

    public Point(int index, int width, int height)
    {
        this.index = index;
        this.width = width;
        this.height = height;
    }

    public Point(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void setDimensions(int width, int height)
    {
        setWidth(width);
        setHeight(height);
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
}
