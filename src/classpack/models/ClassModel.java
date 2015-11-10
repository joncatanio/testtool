package classpack.models;

import java.util.*;

/****
 *
 * A ClassModel is an object representing a class that a teacher teaches, all of the
 * students in the class, all of the tests that have been assigned to the class, and
 * other data relevant to the class.
 *
 ****/
public class ClassModel {

    /** Collection of TestBinModels, each representing a collection of test submittions for
     * a particular assigned test.
     */
    HashMap<Integer, TestBinModel> bins = new HashMap<Integer, TestBinModel>();

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
