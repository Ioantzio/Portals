package com.ian.portals.data;

/**
 * Created by Ian
 */

public enum LanguagePrefix
{
    english("-en"),
    greek("-el");

    private final String languagePrefix;

    LanguagePrefix(String lang)
    {
        this.languagePrefix = lang;
    }

    public String getLanguagePrefix()
    {
        return languagePrefix;
    }
}
