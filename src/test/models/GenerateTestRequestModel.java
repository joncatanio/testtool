package test.models;

import utility.EQuestionTypes;
import javafx.scene.control.ListView;

import java.util.ArrayList;

/**
 * GenerateTestRequestModel is a request object that holds parameters
 * that the TestHandlerModel will use to generate a random test.
 * Created by JonCatanio on 11/2/15.
 */
public class GenerateTestRequestModel {
    /**
     * Currently, the max number of questions allowed to be generated.
     */
    private final int MAX_QUESTION_NUMBER = 500;

    /**
     * Requested name of the test.
     */
    private String name;

    /**
     * Requested number of questions for the test.
     */
    private int numQuestions;

    /**
     * The desired difficulty of the test.
     */
    private int difficulty;

    /**
     * The collection of desired question types to be included on the test.
     */
    private ArrayList<EQuestionTypes> selectedQuestionTypes;

    /**
     * The collection of classes to pull questions from to be included on the test.
     */
    private ArrayList<Integer> selectedClasses;

    /**
     * The collection of class subjects to pull questions from to be included on the test.
     */
    private ArrayList<Integer> selectedSubjects;

    /**
     * Constructor for the request model.
     */
    public GenerateTestRequestModel() {
        this.numQuestions = 0;
        this.difficulty = 0;
    }


    /**
     * Gets the number of questions desired for the generated test.
     *
     * @return the number of questions requested.
     */
    public int getNumQuestions() {
        return this.numQuestions;
    }

    /**
     * Set the desired number of questions for the test.
     *
     * @param number the requested number of questions
     */
    public void setNumQuestions(String number) {
        try {
            int num = Integer.parseInt(number);

            if (num > 0 && num < MAX_QUESTION_NUMBER) {
                System.out.println("Number of Questions: " + num);
                this.numQuestions = num;
            }
        }
        catch(NumberFormatException nfe) {
            System.out.println("Not a valid number.");
        }
    }

    /**
     * Get the desired name for the test.
     *
     * @return the name of the test.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the desired name of the test.
     *
     * @param name the requested name of the test.
     *
     *
     <pre>
     pre:
     post:
        exists (String s ; name.equals(s))
     */
    public void setName(String name){
        System.out.println("Name: " + name);
        this.name = name;
    }

    /**
     * Gets the desired difficulty of the test.
     *
     * @return the desired difficulty of the test
     */
    public int getDifficulty() { return this.difficulty; }

    /**
     * Set the desired difficulty of the test.
     *
     * @param val the requested difficulty of the test.
     */
    public void setDifficulty(int val) {
        if (val >= 0 && val <= 2) {
            System.out.println("Difficulty Value: " + val);
            this.difficulty = val;
        }
    }

    /**
     * Get the desired question types for the test.
     *
     * @return the selectedQuestionTypes
     *
     */
    public ArrayList<EQuestionTypes> getSelectedQuestionTypes() { return this.selectedQuestionTypes; }

    /**
     * Set the desired question types for the test.
     *
     * @param selectedQuestionTypes the requested question types for the test.
     *
     */
    public void setSelectedQuestionTypes(ListView<String> selectedQuestionTypes) {
        selectedQuestionTypes.getItems().forEach(System.out::println);
    }

    /**
     * Get the desired classes to pull questions from for the test.
     *
     * @return the desired classes to pull questions from for the test.
     */
    public ArrayList<Integer> getSelectedClasses() { return this.selectedClasses; }

    /**
     * Set the desired classes to pull questions from for the test.
     *
     * @param selectedClasses requested classes to pull questions from for the test.
     */
    public void setSelectedClasses(ListView<String> selectedClasses) {
        selectedClasses.getItems().forEach(System.out::println);
    }

    /**
     * Get the desired class subjects to pull questions from for the test.
     *
     * @return the desired class subjects to pull questions from for the test.
     */
    public ArrayList<Integer> getSelectedSubjects() { return this.selectedSubjects; }

    /**
     * Set the desired class subjects to pull questions from for the test.
     *
     * @param selectedSubjects the requested class subjects to pull questions from for the test.
     */
    public void setSelectedSubjects(ListView<String> selectedSubjects) {
        selectedSubjects.getItems().forEach(System.out::println);
    }
}
