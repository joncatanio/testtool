package test.models;

import question.models.QuestionModel;
import java.util.*;

/****
 * Class TestTakingModel is a representation of a test being viewed/taken.
 * Also by extension used as a temporary holder for scores while a student completes a test.
 *
 * @author Reed Garmsen (rgarmsen@calpoly.edu)
 */
public class TestTakingModel {
    private TestModel curTest;
    private int curQuestionIdx;
    private int testIndex;

    /**
     * If no name is given for a test, use dummy data (good for debugging).
     */
    public TestTakingModel() {
        this.curTest = new TestModel("CPE 103 - Final");
        this.curQuestionIdx = 0;
        this.testIndex = 0;
    }

    /**
     * Grabs the test from the test database using the name of the test given.
     * @param test The test to be used
     * @param testIndex The index of the test in the test bank
     */
    public TestTakingModel(TestModel test, int testIndex) {
        this.curTest = test;
        this.curQuestionIdx = 0;
        this.testIndex = testIndex;
    }

    /**
     * Get the name of the currently viewed test.
     * @return String of the name of the currently viewed test
     */
    public String getTestName() {
        System.out.println("Current test name: " + curTest.getName());

        return curTest.getName();
    }

    /**
     * Gets the test currently in use by the test taking model.  Used for grading.
     * @return A reference to the test currently in use by the test taking model.
     */
    public TestModel getTest() {
        System.out.println("Returning test with name: " + curTest.getName());

        return curTest;
    }

    public int getTestIndex() {
        return testIndex;
    }

    /**
     * Gets the currently selected question number.
     * @return An integer representing the index + 1 of the current question in the test question array.
     */
    public int getQuestionNum() {
        return this.curQuestionIdx + 1;
    }

    /**
     * Sets the currently selected question for the test being taken.
     * @param newQuestionNum The question number to be viewed.
     */
    public void setQuestionNum(int newQuestionNum) {
        this.curQuestionIdx = newQuestionNum - 1;
    }

    /**
     * Get the question names for the current test.
     * @return An ArrayList of strings of question names for the current test
     */
    public ArrayList<QuestionModel> getQuestionList() {
        ArrayList<QuestionModel> questions = curTest.getQuestions();

        return questions;
    }

    /**
     * Called by the controller to set the ListView QuestionModels to the proper question.
     * @return An ArrayList of QuestionModels that needs it's question information set correctly
     *
      post:
        //
        // The passed in list must have it's questions updated to those within the current test
        //
        forall (QuestionModel um_other ;
        (listToSet'.contains(um_other)) iff
        questions.contains(um_other));
     */
    public void setQuestions(ArrayList<QuestionModel> listToSet) {
        ArrayList<QuestionModel> questions = curTest.getQuestions();

        for (int i = 0; i < questions.size(); i++) {
            listToSet.add(questions.get(i));
        }
    }

    /**
     * Gets the next Question information from the current test (the controller would handle displaying the information)
     * @return The QuestionModel of the next question in the list
        post:
            (curQuestionIdx' == curTest.getQuestions().size() - 1 iff curQuestionIdx >= curTest.getQuestions().size()) ||
            (curQuestionIdx' == curQuestionIdx + 1)
     */
    public QuestionModel getNextQuestion() {
        System.out.println("Switch to next question in test");

        curQuestionIdx++;

        if (curQuestionIdx >= curTest.getQuestions().size()) {
            System.out.println("No next question");

            curQuestionIdx = curTest.getQuestions().size() - 1;
            return null;
        }

        return curTest.getQuestion(curQuestionIdx);
    }

    /**
     * Gets the previous Question information from the current test (the controller would handle displaying the information)
     * @return The QuestionModel of the previous question in the list
        post:
            (curQuestionIdx' == 0 iff curQuestionIdx == 0) ||
            (curQuestionIdx' == curQuestionIdx - 1)
     */
    public QuestionModel getPrevQuestion() {

        curQuestionIdx--;

        if (curQuestionIdx < 0) {
            System.out.println("No previous question");

            curQuestionIdx = 0;
            return null;
        }

        System.out.println("Switch to previous question in test");

        return curTest.getQuestion(curQuestionIdx);
    }

    /**
     * Gets the hint for the current question (not implemented in questions at this time).
     * @return A string representing a hint for the question (or an empty string if one is not provided)
     */
    public String getQuestionHint() {
        System.out.println("Display current question hint pop-up");

        return "";
    }
}
