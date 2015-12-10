package classpack.models;

import java.util.*;

/****
 *
 * A ClassModel is an object representing a class that a teacher teaches, all of the
 * students in the class, all of the tests that have been assigned to the class, and
 * other data relevant to the class.
 *
 * created by Alex Greene & Andrew Gough
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

    /**
     * classId is used by our backend to differentiate between different classes.
     */
    private int classId;
    /**
     * classCode is used by students to enroll in a given class.
     */
    private String classCode;
    /**
     * className is set by the teacher upon class creation.
     */
    private String className;
    /**
     * schoolName is set by the teacher upon class creation to describe where the class is taught.
     */
    private String schoolName;
    /**
     * students is a collection of students enrolled in the class.
     */
    private ArrayList<StudentModel> students;
    /** Collection of TestBinModels, each representing a collection of test submissions for
     * a particular assigned test.
     */
    private HashMap<Integer, TestBinModel> bins = new HashMap<Integer, TestBinModel>();
    private GradeBook grades;

    /**
     *  Gets the unique class ID.
     * @return classId is used by our back end to differentiate between created classes.
     */
    public int getClassId() {
        return classId;
    }

    /**
     * Sets the class id.
     * @param classId is a unique integer.
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     * setClassCode sets the classes code so students can specify a class to join, these are unique codes.
     *
     *   post:
     *         exists(this.classCode.length() > 1);
     * @param classCode is a unique string passed out to students so they can join the class.
     */
    public void setClassCode(String classCode){
        this.classCode = classCode;
    }

    /**
     * getClassCode gets the class code.
     * @return is a string of the class's code.
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * Sets the class name
     * @param name is a string that the class will be referred to in UI.
     */
    public void setClassName(String name){ this.className = name;}

    /**
     * Gets the class name
     * @return is a string of the class's name.
     */
    public String getClassName(){
        return className;
    }

    /**
     * Sets the class's school name.
     * @param name is a string of the school in which the class is taught.
     *
     *    post:
            exists(this.getId() == id)
     */
    public void setSchoolName(String name){ this.schoolName = name;}

    /**
     * Gets the school name of the class.
     * @return is a string of the school name in which the class is taught.
     */
    public String getSchoolName(){
        return schoolName;
    }

    /**
     * THIS METHOD IS NO LONGER SUPPORTED, GRADING HAS BEEN REMOVED FROM CLASSMODEL.
     */
    public GradeBook initializeGradeBook(Collection<StudentModel> students){
        return null;
    }

    /**
     * publishTest is called to publish a given test to all the students in a class.
     * @param test is the chosen testModel from the testBank to distribute to students.
     *
     */
    public void publishTest(TestModel test){
        // TODO: Integrate with Reed's test taking abilities
        System.out.println("Published test: " + test.getName());
        test.setPublished(true);
    }

    /**
     * Constructor will set everything to null, values get filled in by CreateClassController.
     */
    public ClassModel() {
        className = null;
        classCode = null;
        classId = 0;
        schoolName = null;
        students = new ArrayList<StudentModel>();
    }

    /**
     * getTestBin would be used to pull an individual students test.
     * @param testBinId is used to isolate the specific testBinModel.
     * @return gives a specific testBinModel associated with the provided testBinId.
     */
    public TestBinModel getTestBin(int testBinId) {

        //return bins.get(testBinId);
        return new TestBinModel();
    }

    /**
     * getTestBins would be used to pull all the students tests for an individual class.
     * @return an arrayList of testBinModels for the entire class.
     */
    public ArrayList<TestBinModel> getTestBins() {

        return new ArrayList<TestBinModel>(bins.values());
    }
}