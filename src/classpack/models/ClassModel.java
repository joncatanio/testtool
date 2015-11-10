package classpack.models;

import java.util.*;

/****
 *
 * A ClassModel is an object representing a class that a teacher teaches, all of the
 * students in the class, all of the tests that have been assigned to the class, and
 * other data relevant to the class.
 *
 ****/

import test.*;
import test.models.TestModel;
import user.*;
import user.models.StudentModel;

import java.util.*;

/**
 * The Class is an object which holds all the information needed to model
 * a class.
 */
public abstract class ClassModel {
    String classCode;
    String className;
    String schoolName;
    Collection<StudentModel> students;
    /** Collection of TestBinModels, each representing a collection of test submissions for
     * a particular assigned test.
     */
    HashMap<Integer, TestBinModel> bins = new HashMap<Integer, TestBinModel>();
    GradeBook grades;

    /**
     *   setClassCode sets the classes code so students can specify a class to join, these are unique codes.
     *   pre:
     *    //  The given class code is not used by another class.
     *      !data.contain(code);
     *   post:
     *     //The given class code has length greater than 1.
     *         code.length > 1;
     **/
    abstract void setClassCode(String code);

    /**
     * Gets the class code
     */
    abstract String getClassCode();

    /**
     * Sets the class name
     */
    abstract void setClassName(String name);

    /**
     * Gets the class name
     */
    abstract String getClassName();

    /**
     * Sets the school name
     */
    abstract void setSchoolName(String name);

    /**
     * Gets the school name
     */
    abstract String getSchoolName();

    /**
     * Given the students in the class, this method initializes the GradeBook
     */
    abstract GradeBook initializeGradeBook(Collection<StudentModel> students);

    /**
     * Given a test, this method publishes a test to students
     */
    abstract void publishTest(TestModel test);

    public ClassModel() {

    }

    /**
     * return the TestBinModel that matches a particular assigned test's id
     */
    public TestBinModel getTestBin(int testBinId) {

        //return bins.get(testBinId);
        return new TestBinModel();
    }
}