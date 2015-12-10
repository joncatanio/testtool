package classpack.models;

/**
 * Created by agough on 11/9/2015.
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
     *
     *   post:
     *     // The test bank contains an object equivalent to test.
     *      exists(GradeBook book; book.tests.contains(test) == true);
     **/
    abstract void AddTest(TestModel test);

    /**
     * This method will return a given test for a given student
     */

    /**
     *   getTest method will return a given test for a given student
     *   pre:
     *    //  The collection of tests contains both an object with a student with name equivalent to name, and a test object equivalent to test.
     *      tests.contains(name) && tests.contains(test);
     *      pre:
                exists(GradeBook b; b.tests.contain(test); c.getName() == name)
     **/
    abstract TestModel getTest(StudentModel name, TestModel test);
}
