package classpack.models;

import classpack.models.ClassModel;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import classpack.models.ClassModel;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class ClassModelTest
{
    @Before
    public void setUp()
    {
        testObj = (classpack.models.ClassModel)javaTestUtility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = classpack.models.ClassModel.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/JonCatanio/Programming Projects/TestTool");
    private File sourceFile = new File("/Users/JonCatanio/Programming Projects/TestTool/src/classpack/models/ClassModel.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private classpack.models.ClassModel testObj;
    @Test
    public void setClassCodeTest_0() throws Exception
    {
        int testComboIndex;

        String methodId = "setClassCode_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "code", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setClassCode(param_0);
            Assert.assertTrue(param_0.length() > 1);
            setUp();
        }
    }
    /*End generated tests*/
}