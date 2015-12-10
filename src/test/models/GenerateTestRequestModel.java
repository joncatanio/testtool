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
    public final int MAX_QUESTION_NUMBER = 500;

    /**
     * Requested name of the test.
     */
    private static String name;

    /**
     * Requested number of questions for the test.
     */
    private static int numQuestions;

    /**
     * The desired difficulty of the test.
     */
    private static int difficulty;

    /**
     * The collection of desired question types to be included on the test.
     */
    private static ArrayList<EQuestionTypes> selectedQuestionTypes;

    /**
     * The collection of classes to pull questions from to be included on the test.
     */
    private static ArrayList<Integer> selectedClasses;

    /**
     * The collection of class subjects to pull questions from to be included on the test.
     */
    private static ArrayList<Integer> selectedSubjects;

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

            if (num > 0 && num <= MAX_QUESTION_NUMBER) {
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
        for(String type : selectedQuestionTypes.getItems()) {
            switch(type) {
                case "Fill in the Blank":
                    if (!this.selectedQuestionTypes.contains(EQuestionTypes.FILL_IN_THE_BLANK)) {
                        this.selectedQuestionTypes.add(EQuestionTypes.FILL_IN_THE_BLANK);
                    }
                    break;
                case "Multiple Choice":
                    if (!this.selectedQuestionTypes.contains(EQuestionTypes.MULTIPLE_CHOICE)) {
                        this.selectedQuestionTypes.add(EQuestionTypes.MULTIPLE_CHOICE);
                    }
                    break;
                case "Multiple Select":
                    if (!this.selectedQuestionTypes.contains(EQuestionTypes.MULTIPLE_SELECT)) {
                        this.selectedQuestionTypes.add(EQuestionTypes.MULTIPLE_SELECT);
                    }
                    break;
                case "Free Response":
                    if (!this.selectedQuestionTypes.contains(EQuestionTypes.FREE_RESPONSE)) {
                        this.selectedQuestionTypes.add(EQuestionTypes.FREE_RESPONSE);
                    }
                    break;
                case "Short Answer":
                    if (!this.selectedQuestionTypes.contains(EQuestionTypes.SHORT_ANSWER)) {
                        this.selectedQuestionTypes.add(EQuestionTypes.SHORT_ANSWER);
                    }
                    break;
                case "Coding":
                    if (!this.selectedQuestionTypes.contains(EQuestionTypes.CODING)) {
                        this.selectedQuestionTypes.add(EQuestionTypes.CODING);
                    }
                    break;
                case "UML":
                    if (!this.selectedQuestionTypes.contains(EQuestionTypes.UML)) {
                        this.selectedQuestionTypes.add(EQuestionTypes.UML);
                    }
                    break;
                case "Matching":
                    if (!this.selectedQuestionTypes.contains(EQuestionTypes.MATCHING)) {
                        this.selectedQuestionTypes.add(EQuestionTypes.MATCHING);
                    }
                    break;
                default:
                    System.out.println("Not a valid type.");
                    break;
            }
        }
    }

    /**
     * DEPRECATED
     * Get the desired classes to pull questions from for the test.
     *
     * @return the desired classes to pull questions from for the test.
     */
    public ArrayList<Integer> getSelectedClasses() { return this.selectedClasses; }

    /**
     * DEPRECATED
     * Set the desired classes to pull questions from for the test.
     *
     * @param selectedClasses requested classes to pull questions from for the test.
     */
    public void setSelectedClasses(ListView<String> selectedClasses) {
        selectedClasses.getItems().forEach(System.out::println);
    }

    /**
     * DEPRECATED
     * Get the desired class subjects to pull questions from for the test.
     *
     * @return the desired class subjects to pull questions from for the test.
     */
    public ArrayList<Integer> getSelectedSubjects() { return this.selectedSubjects; }

    /**
     * DEPRECATED
     * Set the desired class subjects to pull questions from for the test.
     *
     * @param selectedSubjects the requested class subjects to pull questions from for the test.
     */
    public void setSelectedSubjects(ListView<String> selectedSubjects) {
        selectedSubjects.getItems().forEach(System.out::println);
    }
}
