package UnitTests;

import test.models.GenerateTestRequestModel;

/**
 * Created by JonCatanio on 12/9/15.
 */
public class GenerateTestRequestModelTest extends GenerateTestRequestModel {
    public void setNumQuestionsTest() {
        System.out.println("Testing GenerateTestRequestModel.setNumQuestions...");
        GenerateTestRequestModel testModel = new GenerateTestRequestModel();
        String number;

        /* Out of lower bound */
        number = "-12";
        testModel.setNumQuestions(number);
        assert testModel.getNumQuestions() == 0;

        /* Out of upper bound */
        number = Integer.toString(MAX_QUESTION_NUMBER + 1);
        testModel.setNumQuestions(number);
        assert testModel.getNumQuestions() == 0;

        /* Valid number */
        number = "100";
        testModel.setNumQuestions(number);
        assert testModel.getNumQuestions() == 100;
        System.out.println("GenerateTestRequestModel.setNumQuestions success.");
    }
}
