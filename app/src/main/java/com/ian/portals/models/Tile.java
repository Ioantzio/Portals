package com.ian.portals.models;

/**
 * Created by Ian.
 */

public class Tile
{
    private Question question;
    private int index;

    public Tile(Question question, int index)
    {
        setQuestion(question);
        setIndex(index);
    }

    public Question getQuestion()
    {
        return question;
    }

    public void setQuestion(Question question)
    {
        this.question = question;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}
