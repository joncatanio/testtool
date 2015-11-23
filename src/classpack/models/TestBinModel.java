package classpack.models;

import java.util.ArrayList;
import java.util.Arrays;
import test.models.*;

/****
 *
 * A TestBinModel is a container for a collection of individual test submissions
 * pertaining to a certain assigned test. The id represents the id of the
 * corresponding assigned test. The average is the average score of the graded
 * submitted tests. The averageTimeInMinutes is the average elapsed time for
 * a student to take the assigned test from start to finish.
 *
 ****/

public class TestBinModel {

    /** Id of corresponding test */
    private int id;

    /** Average score of graded test submissions */
    private double average;

    /** Average elapased time for student to take the exam */
    private double averageTimeInMinutes;

    /** Collection of submitted test objects */
    //private ArrayList<TestModel> submissions;

    public TestBinModel() {
        id = 123467;
        average = 87.5;
        averageTimeInMinutes = 43.17;
    }

    /**
     * Return the TestBinModel's id
     *
     post:
     //
     // the returned id describes a test that is in the testbin
     //
     exists(TestModel test; test.id == id`)
     *
     */
    public int getId() {
        return id;
    }

    /**
     * Regrade a defined set of submitted tests.
     */
    public void regradeForSubmissions(ArrayList<Integer> ids) {

        TestHandlerModel grader = TestHandlerModel.getInstance();
        for(int i = 0; i < ids.size(); i++) {
            grader.regrade(ids.get(i));
        }
    }

    /**
     * Return the collection of submitted test.
     */
    public ArrayList<String> getSubmissions() {

        return new ArrayList<String>(Arrays.asList("spongebob", "darth vader", "lord voldemort", "mike wazowski"));
    }

    /**
     * Adds a completed test to the bin of test submissions
     *
     pre:
     //
     // All tests in the bin are completed versions of the test
     // with the id that matches the bins' id.

     forall (TestModel test ; submissions.contains(test) ;
        test.id == tb.id);

     post:
     //
     // No two test submissions were submitted by the same student
     //
     forall (TestModel test ; submissions.contains(test) ;
        forall (TestModel test2 ; submissions.contains(test) ;
            test.studentId() != test2.studentId()));
     *
     */
    //public addSubmission(TestModel testToAdd) {}

    /**
     * Return the average score on the assigned exam
     *
     post:
     //
     // the returned value is between 0 and 100, inclusive
     //
        val` >= 0 && val` <=100
     *
     */
    public double getAverage() {
        return average;
    }

    /**
     * Return the average elapsed time in minutes, for a student to take the exam
     */
    private double getAverageTimeInMinutes() {
        return averageTimeInMinutes;
    }
}
