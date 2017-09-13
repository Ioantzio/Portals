package com.ian.portals.data;

/**
 * Created by Ian.
 */

public enum Language
{
    english("english"),
    greek("greek");

    private final String language;

    Language(String lang)
    {
        this.language = lang;
    }

    public String getLanguage()
    {
        return language;
    }
}
