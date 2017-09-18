package com.ian.portals.data;

import com.ian.portals.conntrollers.MainController;
import com.ian.portals.models.Question;

/**
 * Created by Ian.
 */

public class GlobalVariables
{
    //Variables: Settings
    private static boolean musicActivated = true;
    private static boolean soundsActivated = true;
    private static Language language = Language.english;
    private static int answerTime = 15;

    //Variables: Questions
    private static Question currentQuestion;
    private static int answer;

    //Methods: Settings
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

    public static int getAnswerTime()
    {
        return answerTime;
    }

    public static void setAnswerTime(int answerTime)
    {
        GlobalVariables.answerTime = answerTime;
    }

    public static int getAnswerTimeForSeekbar()
    {
        return (answerTime - 5);
    }

    public static void setAnswerTimeFromSeekbar(int answerTime)
    {
        GlobalVariables.answerTime = answerTime + 5;
    }

    //Methods: Questions
    public static Question getCurrentQuestion()
    {
        return currentQuestion;
    }

    public static void setCurrentQuestion(Question currentQuestion)
    {
        GlobalVariables.currentQuestion = currentQuestion;
    }

    public static int getAnswer()
    {
        return answer;
    }

    public static void setAnswer(int answer)
    {
        GlobalVariables.answer = answer;
    }
}