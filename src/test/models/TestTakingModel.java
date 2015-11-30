package test.models;

import question.models.QuestionModel;
import java.util.*;
//import utility.EQuestionTypes;

/**
 * Created by rgarmsen on 11/29/15.
 */
public class TestTakingModel {
    private TestModel curTest;

    /**
     * If no name is given for a test, use dummy data (good for debugging).
     */
    public TestTakingModel() {
        this.curTest = new TestModel("CPE 103 - Final");
    }

    /**
     * Grabs the test from the test database using the name of the test given.
     * @param testName The name of the test to be used
     */
    public TestTakingModel(String testName) {
        //this.curTest = TestDBModel.getByName(testName);
    }

    public String getTestName() {
        return curTest.getName();
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

        return questionNames;
    }
}
