package UnitTests;

import question.models.QuestionModel;
import test.models.GenerateTestRequestModel;
import test.models.TestTakingModel;
import test.models.TestModel;

import java.util.ArrayList;

/**
 * Created by rgarmsen on 12/9/15.
 */
public class TestTakingModelTest extends TestTakingModel {
    public void setQuestionsTest() {
        System.out.println("Testing TestTakingModel.setQuestionsTest...");
        TestModel dummyTest = new TestModel("Dummy");

        QuestionModel q1 = new QuestionModel();
        QuestionModel q2 = new QuestionModel();
        QuestionModel q3 = new QuestionModel();
        dummyTest.addQuestion(q1);
        dummyTest.addQuestion(q2);
        dummyTest.addQuestion(q3);

        TestTakingModel testModel = new TestTakingModel(dummyTest, 0);

        ArrayList<QuestionModel> listToSet = new ArrayList<>();
        testModel.setQuestions(listToSet);

        /* Checking ArrayList equality */
        for (int i = 0; i < listToSet.size(); i++) {
            assert listToSet.get(i).equals(testModel.getQuestionList().get(i));
        }

        System.out.println("TestTakingModel.setQuestionsTest success.");
    }

    public void getNextTestQuestionTest() {
        System.out.println("Testing TestTakingModel.getNextQuestion...");
        TestModel dummyTest = new TestModel("Dummy");

        QuestionModel q1 = new QuestionModel();
        QuestionModel q2 = new QuestionModel();
        QuestionModel q3 = new QuestionModel();
        dummyTest.addQuestion(q1);
        dummyTest.addQuestion(q2);
        dummyTest.addQuestion(q3);

        TestTakingModel testModel = new TestTakingModel(dummyTest, 0);

        /* Checking normal iteration forwards... */
        assert testModel.getNextQuestion().equals(q2);
        assert testModel.getNextQuestion().equals(q3);

        /* Out of upper bound */
        assert testModel.getNextQuestion().equals(null);

        System.out.println("TestTakingModel.getNextQuestion success.");
    }

    public void getPrevTestQuestionTest() {
        System.out.println("Testing TestTakingModel.getPrevQuestion...");
        TestModel dummyTest = new TestModel("Dummy");

        QuestionModel q1 = new QuestionModel();
        QuestionModel q2 = new QuestionModel();
        QuestionModel q3 = new QuestionModel();
        dummyTest.addQuestion(q1);
        dummyTest.addQuestion(q2);
        dummyTest.addQuestion(q3);

        TestTakingModel testModel = new TestTakingModel(dummyTest, 0);

        /* Out of lower bound */
        assert testModel.getPrevQuestion().equals(null);

        testModel.getNextQuestion();
        testModel.getNextQuestion();

        /* Checking normal iteration backwards... */
        assert testModel.getPrevQuestion().equals(q3);
        assert testModel.getPrevQuestion().equals(q2);


        System.out.println("TestTakingModel.getPrevQuestion success.");
    }
}
