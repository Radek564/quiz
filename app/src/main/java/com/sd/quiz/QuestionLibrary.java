package com.sd.quiz;

/**
 * Created by User on 30.12.2017.
 */

public class QuestionLibrary {

    public static String mQuestions [] = {
            "Pytanie 1",
            "Pytanie 2",
            "Pytanie 3",
            "Pytanie 4",
            "Pytanie 5",
            "Pytanie 6",
            "Pytanie 7"

    };

    private String mChoices [][] = {
            {"Opcja 1", "Opcja 2", "Opcja 3", "Opcja 4"},
            {"Opcja 1", "Opcja 2", "Opcja 3", "Opcja 4"},
            {"Opcja 1", "Opcja 2", "Opcja 3", "Opcja 4"},
            {"Opcja 1", "Opcja 2", "Opcja 3", "Opcja 4"},
            {"Opcja 1", "Opcja 2", "Opcja 3", "Opcja 4"},
            {"Opcja 1", "Opcja 2", "Opcja 3", "Opcja 4"},
            {"Opcja 1", "Opcja 2", "Opcja 3", "Opcja 4"}

    };

    private String mCorrectAnswers[] = {"Opcja 1", "Opcja 3", "Opcja 2", "Opcja 4", "Opcja 2", "Opcja 2", "Opcja 1" };

    public String getQuestion(int a) {
      String question = mQuestions[a];
      return question;

    };

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;

    };

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;

    };

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;

    };

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;

    };

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;

    };
}
