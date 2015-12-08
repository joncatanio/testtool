package test.models;

import question.models.QuestionModel;

import java.util.*;

/**
 * The TestHandlerModel handles generating, grading, and creating tests.
 * It is the engine that handles and generic Test tasks that doesn't belong
 * to a specific model.
 *
 * NOTE: This is a Singleton object and should not be instantiated twice.
 *
 * Created by JonCatanio on 11/5/15.
 * grade function by Alex Greene
 */
public class TestHandlerModel {
    /**
     * The singleton TestHandlerModel object. Not lazily instantiated so the
     * object will be instantiated on start up. Memory isn't an issue on this guy.
     */
    private static TestHandlerModel singleton = new TestHandlerModel();

    /**
     * TestHandlerModel constructor, private to avoid instantiation.
     */
    private TestHandlerModel() {}

    /**
     * Gets the instance of the singleton object.
     *
     * @return the singleton of TestHandlerModel
     */
    public static TestHandlerModel getInstance() {
        return singleton;
    }

    /**
     * Grades the given test.
     *
     * @param toGrade test to grade.
     */
    public void grade(TestModel toGrade) {
        int points = 0;
        for(QuestionModel question : toGrade.getQuestions()) {
            //grade each question

            switch(question.getQuestionType()) {
                case "Fill in the Blank":
                    if (question.getQuestionHelper().getAnswer().equals( question.getQuestionHelper().getInput() )) {
                        points += question.getPointsPossible();
                    }
                    break;
                case "Multiple Choice":
                    if (question.getQuestionHelper().getAnswer().equals( question.getQuestionHelper().getInput() )) {
                        points += question.getPointsPossible();
                    }
                    break;
                case "Multiple Select":
                    if (question.getSelectQuestion().getACheck() == question.getSelectQuestion().isaChecked() &&
                            question.getSelectQuestion().getBCheck() == question.getSelectQuestion().isbChecked() &&
                            question.getSelectQuestion().getCCheck() == question.getSelectQuestion().iscChecked() &&
                            question.getSelectQuestion().getDCheck() == question.getSelectQuestion().isdChecked()) {
                        points += question.getPointsPossible();
                    }
                    break;
            }
        }

        toGrade.setTotalPoints(points);

        System.out.println("Test " + toGrade.getId() + " has been graded.");
    }

    /**
     * Regrades the given test.
     *
     * @param id unique id of a given test.
     */
    public void regrade(int id) {
        System.out.println("Test " + id + " has been regraded.");
    }

    /**
     * Generates a random TestModel from a given GenerateTestRequestModel.
     */
    public TestModel generate(GenerateTestRequestModel request) {
        TestModel rtn = new TestModel(request.getName());

        rtn.setDifficulty(request.getDifficulty());
        rtn.setId(1);
        // TODO: Set the proper id and actual difficulty from pulled questions. This is gonna be a big method.

        return rtn;
    }
}
