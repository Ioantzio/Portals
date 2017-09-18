package com.ian.portals.models;

/**
 * Created by Ian.
 */

public class Avatar
{
    private Point location = new Point();
    private Point lastLocation = new Point();
    private int position;
    private int lastPosition;


    public Avatar()
    {
        location.setDimensions(0, 0);
        position = 1;
    }

    public void move(int steps)
    {
        setLastPosition(getPosition());
        setPosition(getPosition() + steps);
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

    public int getLastPosition()
    {
        return lastPosition;
    }

    public void setLastPosition(int lastPosition)
    {
        this.lastPosition = lastPosition;
    }

    public Point getLastLocation()
    {
        return lastLocation;
    }

    public void setLastLocation(Point lastLocation)
    {
        this.lastLocation = lastLocation;
    }
}
