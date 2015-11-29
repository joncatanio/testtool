package question.models;

import question.models.QuestionBank;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestutility;
import format.ClassNameFormat;
import question.models.QuestionBank;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestutility.getFieldValue;

@RunWith(SpestRunner.class)
public class QuestionBankTest
{
    @Before
    public void setUp()
    {
        testObj = (question.models.QuestionBank)javaTestutility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = question.models.QuestionBank.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/kendall/Desktop/testtoolAttempt3");
    private File sourceFile = new File("/Users/kendall/Desktop/testtoolAttempt3/src/question/models/QuestionBank.java");
    private JavaTestutility javaTestutility = new JavaTestutility(rootDirectory, sourceFile, false);
    private question.models.QuestionBank testObj;
    @Test
    public void addQuestionTest_0() throws Exception
    {
        java.util.Collection<question.models.QuestionModel> questions = cloner.deepClone(getFieldValue(testObj, "questions", java.util.Collection.class));

        int testComboIndex;

        String methodId = "addQuestion_question.models.QuestionModel";
        List<question.models.QuestionModel> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "question", question.models.QuestionModel.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {question.models.QuestionModel.class};
        List<question.models.QuestionModel> quess_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean forall_21 = true;
        question.models.QuestionModel param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            for(question.models.QuestionModel ques : quess_0)
            {
                if(javaTestutility.getFieldValue(testObj, "questions", java.util.Collection.class).contains(ques))
                {
                    Assert.assertTrue(ques.equals(param_0) || questions.contains(ques));
                }
                if(!(ques.equals(param_0) || questions.contains(ques)))
                {
                    Assert.assertTrue(!(javaTestutility.getFieldValue(testObj, "questions", java.util.Collection.class).contains(ques)));
                }
            }
            Assert.assertTrue(forall_21);

            setUp();
        }
    }

    @Test
    public void deleteQuestionTest_1() throws Exception
    {
        java.util.Collection<question.models.QuestionModel> questions = cloner.deepClone(getFieldValue(testObj, "questions", java.util.Collection.class));

        int testComboIndex;

        String methodId = "deleteQuestion_question.models.QuestionModel";
        List<question.models.QuestionModel> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "question", question.models.QuestionModel.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {question.models.QuestionModel.class};
        List<question.models.QuestionModel> quess_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean forall_22 = true;
        question.models.QuestionModel param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            for(question.models.QuestionModel ques : quess_0)
            {
                forall_22 = forall_22 && (questions.contains(ques));
                if(javaTestutility.getFieldValue(testObj, "questions", java.util.Collection.class).contains(ques))
                {
                    Assert.assertTrue(!(ques.equals(param_0)));
                }
                if(!(!(ques.equals(param_0))))
                {
                    Assert.assertTrue(!(javaTestutility.getFieldValue(testObj, "questions", java.util.Collection.class).contains(ques)));
                }
            }
            Assert.assertTrue(forall_22);

            setUp();
        }
    }

    @Test
    public void QuestionModel,null>Test_2() throws Exception
    {
        int testComboIndex;

        String methodId = "java.util.Collection<question.models.QuestionModel,null>_int";
        List<java.lang.Integer> testPoints_0 = javaTestutility.getSamplePrimitives(testObj, methodId, "num", java.lang.Integer.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {int.class};
        List<question.models.QuestionModel> qms_1 = javaTestutility.getUniversalValues(testObj, methodId, 1);
        boolean forall_23 = true;
        int param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            if()
            {
                Assert.assertTrue(param_0 == 0);
            }
            if(!(param_0 == 0))
            {
            }
            for(question.models.QuestionModel qm : qms_1)
            {
                if(javaTestutility.getFieldValue(testObj, "questions", java.util.Collection.class).contains(qm))
                {
                    Assert.assertTrue(javaTestutility.getFieldValue(qm, "difficulty", int.class) == param_0);
                }
                if(!(javaTestutility.getFieldValue(qm, "difficulty", int.class) == param_0))
                {
                    Assert.assertTrue(!(javaTestutility.getFieldValue(testObj, "questions", java.util.Collection.class).contains(qm)));
                }
            }
            Assert.assertTrue(forall_23);

            setUp();
        }
    }

    @Test
    public void QuestionModel,null>Test_3() throws Exception
    {
        int testComboIndex;

        String methodId = "java.util.Collection<question.models.QuestionModel,null>_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "subject", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {java.lang.String.class};
        List<question.models.QuestionModel> qms_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean forall_24 = true;
        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            for(question.models.QuestionModel qm : qms_0)
            {
                if(javaTestutility.getFieldValue(testObj, "questions", java.util.Collection.class).contains(qm))
                {
                    Assert.assertTrue(param_0.equals(param_0));
                }
                if(!(param_0.equals(param_0)))
                {
                    Assert.assertTrue(!(javaTestutility.getFieldValue(testObj, "questions", java.util.Collection.class).contains(qm)));
                }
            }
            Assert.assertTrue(forall_24);

            setUp();
        }
    }

    @Test
    public void QuestionModel,null>Test_4() throws Exception
    {
        java.util.Collection<question.models.QuestionModel> questions = cloner.deepClone(getFieldValue(testObj, "questions", java.util.Collection.class));

        int testComboIndex;

        java.util.Collection ret;
        String methodId = "java.util.Collection<question.models.QuestionModel,null>_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "date", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {java.lang.String.class};
        List<question.models.QuestionModel> quess_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean exists_25 = false;
        List<question.models.QuestionModel> quess_1 = javaTestutility.getUniversalValues(testObj, methodId, 1);
        boolean exists_26 = false;
        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            for(question.models.QuestionModel ques : quess_0)
            {
            }
            for(question.models.QuestionModel ques : quess_1)
            {
            }
            Assert.assertTrue(exists_25 || !(exists_26));
            Assert.assertTrue(ret == null);

            setUp();
        }
    }

    @Test
    public void findByQuestionNameTest_5() throws Exception
    {
        java.util.Collection<question.models.QuestionModel> questions = cloner.deepClone(getFieldValue(testObj, "questions", java.util.Collection.class));

        int testComboIndex;

        java.util.Collection ret;
        String methodId = "findByQuestionName_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "name", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {java.lang.String.class};
        List<question.models.QuestionModel> quess_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean exists_27 = false;
        List<question.models.QuestionModel> quess_1 = javaTestutility.getUniversalValues(testObj, methodId, 1);
        boolean exists_28 = false;
        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            Object[] paramValues = {param_0};
            Class[] paramClasses = {java.lang.String.class};

            ret = javaTestutility.getMethodValue(testObj, "findByQuestionName", paramValues, paramClasses);
            for(question.models.QuestionModel ques : quess_0)
            {
            }
            for(question.models.QuestionModel ques : quess_1)
            {
            }
            Assert.assertTrue(exists_27 || !(exists_28));
            Assert.assertTrue(ret == null);

            setUp();
        }
    }
    /*End generated tests*/
}