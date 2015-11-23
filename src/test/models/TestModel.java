package test.models;

import question.models.QuestionModel;
import utility.EQuestionTypes;

import java.util.ArrayList;

/**
 * The TestModel is an instance of a test.
 *
 * Created by JonCatanio on 11/9/15.
 */
public class TestModel {
    /**
     * The name of the test.
     */
    private String name;

    /**
     * The total points of the test.
     */
    private int totalPoints;

    /**
     * The number of questions on the test.
     */
    private int numQuestions;

    /**
     * The number of fill in the blank questions.
     */
    private int numFillBlank;

    /**
     * The number of multiple choice questions.
     */
    private int numMultipleChoice;

    /**
     * The number of multiple select questions.
     */
    private int numMultipleSelect;

    /**
     * The number of free response questions.
     */
    private int numFreeResponse;

    /**
     * The number of short answer questions.
     */
    private int numShortAnswer;

    /**
     * The number of coding questions.
     */
    private int numCoding;

    /**
     * The number of UML questions.
     */
    private int numUML;

    /**
     * The number of matching questions.
     */
    private int numMatching;

    /**
     * The difficulty of the test, 0 - easy, 1 - medium, 2 - hard.
     */
    private int difficulty;

    /**
     * The collection of questions included on the test.
     */
    private ArrayList<QuestionModel> questions;

    /**
     * Gets the name of the test.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the test.
     */
    public void setName(String name) {
        //TODO: Validate string.
        this.name = name;
    }

    /**
     * Gets the total points of the test.
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Sets the total points of the test.
     */
    public void setTotalPoints(int totalPoints) {
        //TODO: Add validation
        this.totalPoints = totalPoints;
    }

    /**
     * Get the number of questions included on the test.
     */
    public int getNumQuestions() {
        return numQuestions;
    }

    /**
     * Get the number of a specified type of question from the test.
     */
    public int getSpecificQuestionTypeNum(EQuestionTypes type) {
        //TODO: Search through question list and count all questions with the specified 'type'
        return 5;
    }

    /**
     * Get the average difficulty of the test.
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Set the difficulty of the test.
     */
    public void setDifficulty(int difficulty) {
        if (difficulty >= 0 && difficulty <= 2) {
            this.difficulty = difficulty;
        }
    }

    /**
     * Gets each question included on the test.
     */
    public ArrayList<QuestionModel> getQuestions() {
        return questions;
    }

    /**
     * Adds a single question to the test.
     */
    public void addQuestion(QuestionModel question) {}

    /**
     * Removes the specified question from the test if it is included in the test.
     */
    public void removeQuestion(QuestionModel question) {}
}
