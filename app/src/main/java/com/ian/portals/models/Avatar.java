package com.ian.portals.models;

/**
 * Created by Ian.
 */

public class Avatar
{
    private Point location = new Point();
    private int position;


    public Avatar()
    {
        location.setDimentions(0, 0);
        position = 1;
    }

    public void move(int steps)
    {
        position += steps;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public Point getLocation()
    {
        return location;
    }

    public void setLocation(Point location)
    {
        this.location = location;
    }

    public void setLocation(int locationX, int locationY)
    {
        this.location.setWidth(locationX);
        this.location.setHeight(locationY);
    }
}
