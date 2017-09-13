package com.ian.portals.miscellaneous;

import com.ian.portals.data.Language;

/**
 * Created by Ian.
 */

public class GlobalVariables
{
    private static boolean musicActivated = true;
    private static boolean soundsActivated = true;
    private static Language language = Language.english;

    public static boolean isMusicActivated()
    {
        return musicActivated;
    }

    public static void setMusicActivated(boolean musicActivated)
    {
        GlobalVariables.musicActivated = musicActivated;
    }

    public static boolean isSoundsActivated()
    {
        return soundsActivated;
    }

    public static void setSoundsActivated(boolean soundsActivated)
    {
        GlobalVariables.soundsActivated = soundsActivated;
    }

    public static Language getLanguage()
    {
        return language;
    }

    public static void setLanguage(Language language)
    {
        GlobalVariables.language = language;
    }
}