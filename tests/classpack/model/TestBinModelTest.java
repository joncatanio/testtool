package classpack.models;

import classpack.models.TestBinModel;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import classpack.models.TestBinModel;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class TestBinModelTest
{
    @Before
    public void setUp()
    {
        testObj = (classpack.models.TestBinModel)javaTestUtility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = classpack.models.TestBinModel.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/JonCatanio/Programming Projects/TestTool");
    private File sourceFile = new File("/Users/JonCatanio/Programming Projects/TestTool/src/classpack/models/TestBinModel.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private classpack.models.TestBinModel testObj;
    @Test
    public void getIdTest_0() throws Exception
    {
        int id = getFieldValue(testObj, "id", java.lang.Integer.class);


        String methodId = "getId";

        testObj.getId();
        Assert.assertTrue(id > 0);
        setUp();
    }

    @Test
    public void addSubmissionTest_1() throws Exception
    {
        java.util.ArrayList<test.models.TestModel> submissions = cloner.deepClone(getFieldValue(testObj, "submissions", java.util.ArrayList.class));

        int testComboIndex;

        String methodId = "addSubmission_test.models.TestModel";
        List<test.models.TestModel> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "testToAdd", test.models.TestModel.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {test.models.TestModel.class};
        List<test.models.TestModel> ts_0 = javaTestUtility.getUniversalValues(testObj, methodId, 0);
        boolean forall_65 = true;
        List<test.models.TestModel> tests_1 = javaTestUtility.getUniversalValues(testObj, methodId, 1);
        boolean forall_66 = true;
        List<test.models.TestModel> test2s_1 = javaTestUtility.getUniversalValues(testObj, methodId, 1);
        boolean forall_67 = true;
        test.models.TestModel param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.addSubmission(param_0);
            for(test.models.TestModel t : ts_0)
            {
                forall_65 = forall_65 && (!(t.equals(testToAdd)));
                if(submissions.contains(t))
                {
                    Assert.assertTrue(javaTestUtility.getFieldValue(testObj, "submissions", java.util.ArrayList.class).contains(t));
                }
                else
                {
                    Assert.assertTrue(!(javaTestUtility.getFieldValue(testObj, "submissions", java.util.ArrayList.class).contains(t)));
                }
            }
            Assert.assertTrue(forall_65);
            for(test.models.TestModel test : tests_1)
            {
                forall_66 = forall_66 && (submissions.contains(test));
                for(test.models.TestModel test2 : test2s_1)
                {
                    forall_67 = forall_67 && (test.studentId() != test2.studentId());
                }
                Assert.assertTrue(forall_67);
            }
            Assert.assertTrue(forall_66);

            setUp();
        }
    }

    @Test
    public void getAverageTest_2() throws Exception
    {
        double average = getFieldValue(testObj, "average", java.lang.Double.class);


        String methodId = "getAverage";

        testObj.getAverage();
        Assert.assertTrue(average >= 0);
        Assert.assertTrue(average <= 100);
        setUp();
    }
    /*End generated tests*/
}