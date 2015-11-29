package user.models;

import user.models.UserDBModel;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestutility;
import format.ClassNameFormat;
import user.models.UserDBModel;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestutility.getFieldValue;

@RunWith(SpestRunner.class)
public class UserDBModelTest
{
    @Before
    public void setUp()
    {
    }

    /*Start generated tests*/
    private Class clazz = user.models.UserDBModel.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/rgarmsen/coding/cpe307/gitwork/testtool");
    private File sourceFile = new File("/Users/rgarmsen/coding/cpe307/gitwork/testtool/src/user/models/UserDBModel.java");
    private JavaTestutility javaTestutility = new JavaTestutility(rootDirectory, sourceFile, false);
    private user.models.UserDBModel testObj;
    @Test
    public void addTest_0() throws Exception
    {
        java.util.Collection<user.models.UserModel> users = cloner.deepClone(getFieldValue(testObj, "users", java.util.Collection.class));

        int testComboIndex;

        String methodId = "add_user.models.UserModel";
        List<user.models.UserModel> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "um", user.models.UserModel.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {user.models.UserModel.class};
        List<user.models.UserModel> um_others_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean exists_33 = false;
        List<user.models.UserModel> um_others_1 = javaTestutility.getUniversalValues(testObj, methodId, 1);
        boolean forall_34 = true;
        user.models.UserModel param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            Object[] paramValues = {param_0};
            Class[] paramClasses = {user.models.UserModel.class};

            javaTestutility.getMethodValue(testObj, "add", paramValues, paramClasses);
            for(user.models.UserModel um_other : um_others_0)
            {
            }
            for(user.models.UserModel um_other : um_others_1)
            {
                forall_34 = forall_34 && ((null) || (users.contains(um_other)));
                if()
                {
                }
                if(!())
                {
                }
            }
            Assert.assertTrue(forall_34);

            setUp();
        }
    }

    @Test
    public void findByIdTest_1() throws Exception
    {
        java.util.Collection<user.models.UserModel> users = cloner.deepClone(getFieldValue(testObj, "users", java.util.Collection.class));

        int testComboIndex;

        user.models.UserModel ret;
        String methodId = "findById_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "id", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {java.lang.String.class};
        List<user.models.UserModel> um_founds_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean exists_35 = false;
        List<user.models.UserModel> um_founds_1 = javaTestutility.getUniversalValues(testObj, methodId, 1);
        boolean exists_36 = false;
        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            Object[] paramValues = {param_0};
            Class[] paramClasses = {java.lang.String.class};

            ret = javaTestutility.getMethodValue(testObj, "findById", paramValues, paramClasses);
            for(user.models.UserModel um_found : um_founds_0)
            {
            }
            for(user.models.UserModel um_found : um_founds_1)
            {
            }
            Assert.assertTrue(exists_35 || !(exists_36));
            Assert.assertTrue(ret == null);

            setUp();
        }
    }

    @Test
    public void findByUsernameTest_2() throws Exception
    {
        java.util.Collection<user.models.UserModel> users = cloner.deepClone(getFieldValue(testObj, "users", java.util.Collection.class));

        int testComboIndex;

        user.models.UserModel ret;
        String methodId = "findByUsername_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "username", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {java.lang.String.class};
        List<user.models.UserModel> um_founds_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean exists_37 = false;
        List<user.models.UserModel> um_founds_1 = javaTestutility.getUniversalValues(testObj, methodId, 1);
        boolean exists_38 = false;
        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            Object[] paramValues = {param_0};
            Class[] paramClasses = {java.lang.String.class};

            ret = javaTestutility.getMethodValue(testObj, "findByUsername", paramValues, paramClasses);
            for(user.models.UserModel um_found : um_founds_0)
            {
            }
            for(user.models.UserModel um_found : um_founds_1)
            {
            }
            Assert.assertTrue(exists_37 || !(exists_38));
            Assert.assertTrue(ret == null);

            setUp();
        }
    }
    /*End generated tests*/
}
