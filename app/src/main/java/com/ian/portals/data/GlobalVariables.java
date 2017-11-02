package com.ian.portals.data;

import com.ian.portals.models.Question;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ian.
 */

public class GlobalVariables
{
    //Variables: Settings
    private static boolean musicActivated = true;
    private static boolean soundsActivated = true;
    private static Language language = Language.english;
    private static String languagePrefix = "-en";

    //Variables: Preferences
    private static int category = 0;
    private static int grade = 0;
    private static int gameType = 0;
    private static int answerTime = 15;

    //Variables: Questions
    private static Question currentQuestion;
    private static String answer;

    //Variables: Tiles
    private static HashMap<Integer, Tile> tileTypes = new HashMap<>();
    private static ArrayList<Integer> portalTilesList = new ArrayList<>();

    //Variables: Statistics
    private static int numberOfQuestions = 0;
    private static int numberOfCorrectAnswers = 0;
    private static int numberOfPortalsUsed = 0;
    private static int numberOfFreeTilesStepped;

    //Methods: Settings
    public static boolean isMusicActivated()
    {
        return musicActivated;
    }

    public static void setMusicActivated(boolean musicActivated) {GlobalVariables.musicActivated = musicActivated;}

    public static boolean isSoundsActivated()
    {
        return soundsActivated;
    }

    public static void setSoundsActivated(boolean soundsActivated) {GlobalVariables.soundsActivated = soundsActivated;}

    public static String getLanguagePrefix()
    {
        return languagePrefix;
    }

    public static void setLanguagePrefix(String languagePrefix) {GlobalVariables.languagePrefix = languagePrefix;}

    public static Language getLanguage()
    {
        return language;
    }

    public static void setLanguage(Language language)
    {
        GlobalVariables.language = language;
    }

    //Methods: Preferences
    public static int getCategory()
    {
        return category;
    }

    public static void setCategory(int category)
    {
        GlobalVariables.category = category;
    }

    public static int getGrade()
    {
        return grade;
    }

    public static void setGrade(int grade)
    {
        GlobalVariables.grade = grade;
    }

    /**
     * @return Returns the type of game selected
     * 0 = single player
     * 1 = multiplayer vs computer
     */
    public static int getGameType()
    {
        return gameType;
    }

    public static void setGameType(int gameType)
    {
        GlobalVariables.gameType = gameType;
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

    public static void setAnswerTimeFromSeekbar(int answerTime) {GlobalVariables.answerTime = answerTime + 5;}

    //Methods: Questions
    public static Question getCurrentQuestion()
    {
        return currentQuestion;
    }

    public static void setCurrentQuestion(Question currentQuestion) {GlobalVariables.currentQuestion = currentQuestion;}

    public static String getAnswer()
    {
        return answer;
    }

    public static void setAnswer(String answer)
    {
        GlobalVariables.answer = answer;
    }

    public static HashMap<Integer, Tile> getTileTypes()
    {
        return tileTypes;
    }

    public static void setTileTypes(HashMap<Integer, Tile> tileTypes) {GlobalVariables.tileTypes = tileTypes;}

    public static ArrayList<Integer> getPortalTilesList()
    {
        return portalTilesList;
    }

    public static void setPortalTilesList(ArrayList<Integer> portalTilesList) {GlobalVariables.portalTilesList = portalTilesList;}

    //Methods: Statistics
    public static int getNumberOfQuestions(){return numberOfQuestions;}

    public static void setNumberOfQuestions(int numberOfQuestions) {GlobalVariables.numberOfQuestions = numberOfQuestions;}

    public static int getNumberOfCorrectAnswers() {return numberOfCorrectAnswers;}

    public static void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {GlobalVariables.numberOfCorrectAnswers = numberOfCorrectAnswers;}

    public static int getNumberOfPortalsUsed() {return numberOfPortalsUsed;}

    public static void setNumberOfPortalsUsed(int numberOfPortalsUsed) {GlobalVariables.numberOfPortalsUsed = numberOfPortalsUsed;}

    public static int getNumberOfFreeTilesStepped() {return numberOfFreeTilesStepped;}

    public static void setNumberOfFreeTilesStepped(int numberOfFreeTilesStepped) {GlobalVariables.numberOfFreeTilesStepped = numberOfFreeTilesStepped;}
}