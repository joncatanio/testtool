package test.models;

import test.models.GenerateTestRequestModel;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestutility;
import format.ClassNameFormat;
import test.models.GenerateTestRequestModel;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestutility.getFieldValue;

@RunWith(SpestRunner.class)
public class GenerateTestRequestModelTest
{
    @Before
    public void setUp()
    {
        testObj = (test.models.GenerateTestRequestModel)javaTestutility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = test.models.GenerateTestRequestModel.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/JonCatanio/Programming Projects/TestTool");
    private File sourceFile = new File("/Users/JonCatanio/Programming Projects/TestTool/src/test/models/GenerateTestRequestModel.java");
    private JavaTestutility javaTestutility = new JavaTestutility(rootDirectory, sourceFile, false);
    private test.models.GenerateTestRequestModel testObj;
    @Test
    public void setNameTest_0() throws Exception
    {
        java.lang.String name = getFieldValue(testObj, "name", java.lang.String.class);

        int testComboIndex;

        String methodId = "setName_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "name", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {java.lang.String.class};
        List<java.lang.String> ss_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean exists_56 = false;
        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setName(param_0);
            for(java.lang.String s : ss_0)
            {
                exists_56 = exists_56 || (name.equals(s));
            }
            Assert.assertTrue(exists_56);

            setUp();
        }
    }
    /*End generated tests*/
}
