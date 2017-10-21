package com.ian.portals.mock;

import com.ian.portals.models.Question;

import java.util.ArrayList;

/**
 * Created by Ian.
 */

public class MockQuestions
{
    public MockQuestions()
    {
    }

    public ArrayList<Question> getQuestions()
    {
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("5x8", "10", "30", "40", "48", 3));
        questions.add(new Question("4^3", "16", "24", "32", "64", 4));
        questions.add(new Question("1024/128", "6", "8", "12", "16", 2));
        questions.add(new Question("895-396", "399", "449", "499", "549", 3));
        questions.add(new Question("13+19", "28", "31", "32", "34", 3));
        questions.add(new Question("17-38", "-16", "-21", "-24", "-26", 2));
        questions.add(new Question("10mod2", "3", "4", "5", "6", 3));
        questions.add(new Question("10div3", "0", "1", "2", "3", 2));
        questions.add(new Question("2^5", "16", "24", "32", "48", 3));
        questions.add(new Question("8x12", "88", "96", "98", "106", 2));
        questions.add(new Question("14+38", "52", "54", "56", "58", 1));
        questions.add(new Question("14x9", "116", "122", "126", "132", 3));
        questions.add(new Question("144/12", "6", "8", "10", "12", 4));
        questions.add(new Question("39mod14", "2", "4", "6", "8", 1));
        questions.add(new Question("40div14", "6", "9", "11", "12", 4));
        questions.add(new Question("15x15", "75", "95", "105", "125", 4));
        questions.add(new Question("500/25", "20", "25", "30", "40", 1));
        questions.add(new Question("256/4", "32", "64", "86", "124", 2));
        questions.add(new Question("29x2", "48", "52", "56", "58", 4));
        questions.add(new Question("96/4", "24", "26", "30", "34", 1));
        questions.add(new Question("49+85", "114", "124", "134", "144", 3));
        questions.add(new Question("76-28", "42", "48", "56", "58", 2));
        questions.add(new Question("27x9", "243", "256", "262", "269", 1));
        questions.add(new Question("256x100", "25.600", "256.000", "2.560.000", "25.600.000", 1));
        questions.add(new Question("1000/100", "1", "10", "11", "100", 2));
        questions.add(new Question("9-7+16", "14", "18", "20", "22", 2));
        questions.add(new Question("4+8+16", "28", "32", "34", "40", 1));
        questions.add(new Question("1256-46-210", "900", "1.000", "1.010", "1.100", 2));
        questions.add(new Question("81/3", "18", "27", "36", "54", 2));
        questions.add(new Question("4680-3591", "989", "1.039", "1.089", "1.139", 3));
        questions.add(new Question("15x8", "90", "105", "120", "135", 3));
        questions.add(new Question("88+88", "146", "156", "166", "176", 4));
        questions.add(new Question("44+122", "146", "166", "186", "196", 2));
        questions.add(new Question("99+99+99", "198", "297", "299", "397", 2));
        questions.add(new Question("49+99-118", "25", "29", "30", "34", 3));
        questions.add(new Question("24-14x2+14", "10", "14", "18", "26", 1));
        questions.add(new Question("1+4+1+4-2", "5", "8", "9", "11", 2));
        questions.add(new Question("32+56", "78", "86", "88", "98", 3));
        questions.add(new Question("52-48", "2", "4", "5", "6", 2));
        questions.add(new Question("100mod4", "15", "18", "22", "25", 4));
        questions.add(new Question("10^3", "100", "1.000", "10.000", "100.000", 2));
        questions.add(new Question("11x7", "66", "67", "76", "77", 4));
        questions.add(new Question("40div24", "1", "2", "24", "26", 4));
        questions.add(new Question("95+295", "390", "395", "405", "490", 1));
        questions.add(new Question("43-42+43", "1", "4", "44", "144", 1));
        questions.add(new Question("1024+1024", "2028", "2048", "2052", "2058", 2));
        questions.add(new Question("1920-1080", "640", "740", "790", "840", 4));
        questions.add(new Question("48/6", "6", "7", "8", "9", 3));

        return questions;
    }

    public Question getFinalQuestion()
    {
        return new Question("499-399+299-199+99", "0", "99", "299", "499", 3);
    }
}
