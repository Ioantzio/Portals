package com.ian.portals.data;

/**
 * Created by Ian
 */

public enum Tile
{
    normal("normal"),
    free("free"),
    portal("portal");

    private final String tile;

    Tile(String lang)
    {
        this.tile = lang;
    }

    public String getTile()
    {
        return tile;
    }
}
