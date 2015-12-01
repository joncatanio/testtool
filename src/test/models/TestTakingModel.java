package test.models;

import question.models.QuestionModel;
import java.util.*;
//import utility.EQuestionTypes;

/****
 * Class TestTakingModel is a representation of a test being viewed/taken.
 * Also by extension used as a temporary holder for scores while a student completes a test.
 *
 * @author Reed Garmsen (rgarmsen@calpoly.edu)
 */
public class TestTakingModel {
    private TestModel curTest;
    private int curQuestionIdx;

    /**
     * If no name is given for a test, use dummy data (good for debugging).
     */
    public TestTakingModel() {
        this.curTest = new TestModel("CPE 103 - Final");
        this.curQuestionIdx = 0;
    }

    /**
     * Grabs the test from the test database using the name of the test given.
     * @param testName The name of the test to be used
     */
    public TestTakingModel(String testName) {
        //TODO: Hook up the constructor to the testdb (name TBD) and have it construct properly.
        //this.curTest = TestDBModel.getByName(testName);
        //this.curQuestionIdx = 0;
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
     * Get the test names for every test that has not been completed by the user.
     * @return An ArrayList of scheduled test names
     */
    public ArrayList<String> getScheduledTest() {
        ArrayList<String> scheduledTests = new ArrayList<>();
        scheduledTests.add("CPE 103 - Final");
        scheduledTests.add("CPE 357 - Midterm 1");
        scheduledTests.add("CPE 357 - Midterm 2");
        scheduledTests.add("CPE 357 - Final");

        System.out.println("List of scheduled tests: " + scheduledTests);

        return scheduledTests;
    }


    /**
     * Get the test names for every test that has been completed by the user.
     * @return An ArrayList of completed test names
     */
    public ArrayList<String> getCompletedTests() {
        ArrayList<String> completedTests = new ArrayList<>();
        completedTests.add("CPE 349 - Final");
        completedTests.add("CSC 101 - Midterm 1");
        completedTests.add("CSC 445 - Midterm");
        completedTests.add("CSC 101 - Midterm 2");

        System.out.println("List of completed tests: " + completedTests);

        return completedTests;
    }

    /**
     * Get the question names for the current test.
     * @return An ArrayList of strings of question names for the current test
     */
    public ArrayList<String> getQuestionNameList() {
        ArrayList<String> questionNames = new ArrayList<String>();
        questionNames.add("Question 1");
        questionNames.add("Question 2");
        questionNames.add("Question 3");

        System.out.println("Question list for test: " + questionNames.toString());

        return questionNames;
    }
}
