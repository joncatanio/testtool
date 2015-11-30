package test.models;

import question.models.QuestionModel;

import java.util.ArrayList;

/**
 * A singleton model that manages the Test Bank.
 *
 * Created by JonCatanio on 11/29/15.
 */
public class TestBankModel {
    /**
     * The singleton TestBankModel object. Not lazily instantiated so the
     * object will be instantiated on start up. Memory isn't an issue on this guy.
     */
    private static TestBankModel singleton = new TestBankModel();

    /**
     * The ArrayList of tests.
     */
    private ArrayList<TestModel> tests;

    /**
     * TestBankModel constructor, private to avoid instantiation.
     */
    private TestBankModel() {
        // TODO: Pull data from database on startup.
        tests = new ArrayList<TestModel>();
        TestModel mockTest1 = new TestModel("CPE 349 - Final");
        QuestionModel mockQuestion1 = new QuestionModel();

        mockQuestion1.setQuestionName("Mock Question 1");
        mockTest1.addQuestion(mockQuestion1);

        tests.add(mockTest1);
        tests.add(new TestModel("CPE 349 - Midterm 1"));
    }

    /**
     * Gets the instance of the singleton object.
     *
     * @return the singleton of TestBankModel
     */
    public static TestBankModel getInstance() {
        return singleton;
    }

    /**
     * Gets all of the tests in the test bank.
     *
     * @return All of the tests in the test bank.
     */
    public ArrayList<TestModel> getAllTests() {
        return tests;
    }

    public TestModel getTest(int index) {
        return tests.get(index);
    }

    /**
     * Adds a test to the test bank.
     *
     * @param test The given test to be added.
     */
    public void addTest(TestModel test) {
        tests.add(test);
        // TODO: Update database here.
    }

    /**
     * Removes a given test from the test bank.
     *
     * @param id The test index to be removed.
     */
    public void removeTest(int id) {
        tests.remove(id);
        // TODO: Update database here.
    }
}
