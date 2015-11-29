package test.models;

import test.models.TestModel;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestutility;
import format.ClassNameFormat;
import test.models.TestModel;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestutility.getFieldValue;

@RunWith(SpestRunner.class)
public class TestModelTest
{
    @Before
    public void setUp()
    {
        testObj = (test.models.TestModel)javaTestutility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = test.models.TestModel.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/JonCatanio/Programming Projects/TestTool");
    private File sourceFile = new File("/Users/JonCatanio/Programming Projects/TestTool/src/test/models/TestModel.java");
    private JavaTestutility javaTestutility = new JavaTestutility(rootDirectory, sourceFile, false);
    private test.models.TestModel testObj;
    @Test
    public void addQuestionTest_0() throws Exception
    {
        java.util.ArrayList<question.models.QuestionModel> questions = cloner.deepClone(getFieldValue(testObj, "questions", java.util.ArrayList.class));

        int testComboIndex;

        String methodId = "addQuestion_question.models.QuestionModel";
        List<question.models.QuestionModel> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "question", question.models.QuestionModel.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {question.models.QuestionModel.class};
        List<question.models.QuestionModel> qs_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean forall_58 = true;
        question.models.QuestionModel param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.addQuestion(param_0);
            for(question.models.QuestionModel q : qs_0)
            {
                forall_58 = forall_58 && (!(q.equals(question)));
                if(questions.contains(q))
                {
                    Assert.assertTrue(javaTestutility.getFieldValue(testObj, "questions", java.util.ArrayList.class).contains(q));
                }
                else
                {
                    Assert.assertTrue(!(javaTestutility.getFieldValue(testObj, "questions", java.util.ArrayList.class).contains(q)));
                }
            }
            Assert.assertTrue(forall_58);

            setUp();
        }
    }

    @Test
    public void removeQuestionTest_1() throws Exception
    {
        java.util.ArrayList<question.models.QuestionModel> questions = cloner.deepClone(getFieldValue(testObj, "questions", java.util.ArrayList.class));

        int testComboIndex;

        String methodId = "removeQuestion_question.models.QuestionModel";
        List<question.models.QuestionModel> testPoints_0 = javaTestutility.getSampleObjects(testObj, methodId, "question", question.models.QuestionModel.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {question.models.QuestionModel.class};
        List<question.models.QuestionModel> qs_0 = javaTestutility.getUniversalValues(testObj, methodId, 0);
        boolean forall_59 = true;
        question.models.QuestionModel param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.removeQuestion(param_0);
            for(question.models.QuestionModel q : qs_0)
            {
                forall_59 = forall_59 && (!(q.equals(question)));
                if(questions.contains(q))
                {
                    Assert.assertTrue(!(javaTestutility.getFieldValue(testObj, "questions", java.util.ArrayList.class).contains(q)));
                }
                else
                {
                    Assert.assertTrue(!(javaTestutility.getFieldValue(testObj, "questions", java.util.ArrayList.class).contains(q)));
                }
            }
            Assert.assertTrue(forall_59);

            setUp();
        }
    }
    /*End generated tests*/
}