package classpack.models;

import java.util.*;

/****
 *
 * A ClassModel is an object representing a class that a teacher teaches, all of the
 * students in the class, all of the tests that have been assigned to the class, and
 * other data relevant to the class.
 *
 ****/

import test.models.TestModel;
import user.models.StudentModel;

import java.util.*;

/**
 * The Class is an object which holds all the information needed to model
 * a class.
 */
public class ClassModel {
    private String classCode;
    private String className;
    private String schoolName;
    private Collection<StudentModel> students;
    /** Collection of TestBinModels, each representing a collection of test submissions for
     * a particular assigned test.
     */
    private HashMap<Integer, TestBinModel> bins = new HashMap<Integer, TestBinModel>();
    private GradeBook grades;

    /**
     *   setClassCode sets the classes code so students can specify a class to join, these are unique codes.
     *   pre:
     *    //  The given class code is not used by another class.
     *      !students.contains(code);
     *   post:
     *     //The given class code has length greater than 1.
     *         code.length() > 1;
     **/
    public void setClassCode(String code){}

    /**
     * Gets the class code
     */
    public String getClassCode(){
        return null;
    }

    /**
     * Sets the class name
     */
    public void setClassName(String name){}

    /**
     * Gets the class name
     */
    public String getClassName(){
        return null;
    }

    /**
     * Sets the school name
     */
    public void setSchoolName(String name){}

    /**
     * Gets the school name
     */
    public String getSchoolName(){
        return null;
    }

    /**
     * Given the students in the class, this method initializes the GradeBook
     */
    public GradeBook initializeGradeBook(Collection<StudentModel> students){
        return null;
    }

    /**
     * Given a test, this method publishes a test to students
     */
    public void publishTest(TestModel test){}

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