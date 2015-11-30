package classpack.models;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;
import test.models.*;
import java.util.*;

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

    private String name;

    /** Average score of graded test submissions */
    private double average;

    /** Average elapased time for student to take the exam */
    private double averageTimeInMinutes;

    /** Collection of submitted test objects */
    private ArrayList<TestModel> submissions;

    public TestBinModel() {
        id = 123467;
        average = 87.5;
        averageTimeInMinutes = 43.17;
        name = "sample test";
        submissions = new ArrayList<TestModel>();
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * Return the TestBinModel's id
     *
     <pre>
     pre:
     post:
     //
     // the returned id describes a test that is in the testbin
     //
     id > 0
     *
     */
    public int getId() {
        return id;
    }

    /**
     * Regrade a defined set of submitted tests.
     */
    public void regradeSubmission(int toRegrade) {

        TestHandlerModel grader = TestHandlerModel.getInstance();
        grader.regrade(toRegrade);

    }

    /**
     * Return the collection of submitted tests.
     */
    public ArrayList<TestModel> getSubmissions() {

        return submissions;
    }

    /**
     * Adds a completed test to the bin of test submissions
     *
     <pre>
     pre:
     post:
     forall (TestModel t ; !t.equals(testToAdd) ;
        if (submissions.contains(t))
            ( submissions'.contains(t))
        else
            (!submissions'.contains(t)))
     &&

     forall (TestModel test ; submissions.contains(test) ;
        forall (TestModel test2 ; submissions.contains(test) ;
            test.studentId() != test2.studentId()));
     *
     */
    public void addSubmission(TestModel testToAdd) {}

    /**
     * Return the average score on the assigned exam
     *
     pre: //none;

     post:
     //
     // the returned value is between 0 and 100, inclusive
     //
        (average >= 0 && average <=100);
     *
     */
    public double getAverage() {
        return average;
    }

    /**
     * Return the average elapsed time in minutes, for a student to take the exam
     */
    public double getAverageTimeInMinutes() {
        return averageTimeInMinutes;
    }
}
