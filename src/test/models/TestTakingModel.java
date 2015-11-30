package test.models;

import question.models.QuestionModel;
import java.util.*;
//import utility.EQuestionTypes;

/**
 * Created by rgarmsen on 11/29/15.
 */
public class TestTakingModel {
    TestModel currentTest;

    public TestTakingModel() {
        this.currentTest = new TestModel();
    }

    public TestTakingModel(String testName) {
        //this.currentTest = TestDBModel.getByName(testName);
    }

    public ArrayList<QuestionModel> getQuestions() {

        return null;
    }
}
