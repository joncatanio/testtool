package classpack.models;

/**
 * Created by andrewgough94 on 11/9/2015.
 */

import test.*;
import test.models.TestModel;
import user.*;
import user.models.StudentModel;

import java.util.*;

/**
 * The GradeBook class is an element of the ClassInfo class. This GradeBook serves
 * as a record to store tests published and individual student performance
 * on each test.
 */
public abstract class GradeBook {
    /**
     * This will be a hashmap of students to tests in implementation
     */
    Collection<StudentModel> tests;

    /**
     *   setClassCode will add a new test to the hash map.
     *   pre:
     *    //  The test bank does not currently contain an equivalent test.
     *      !data.contains(test);
     *   post:
     *     // The test bank contains an object equivalent to test.
     *         data.contains(test) == true;
     **/
    abstract void AddTest(TestModel test);

    /**
     * This method will return a given test for a given student
     */

    /**
     *   getTest method will return a given test for a given student
     *   pre:
     *    //  The collection of tests contains both an object with a student with name equivalent to name, and a test object equivalent to test.
     *      data.contains(name) && data.contains(test);
     **/
    abstract TestModel getTest(StudentModel name, TestModel test);
}
