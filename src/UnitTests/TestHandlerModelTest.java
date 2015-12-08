package UnitTests;

import test.models.*;
import question.models.*;

public class TestHandlerModelTest {

    public void testGradeMethod() {

        TestHandlerModel inst = TestHandlerModel.getInstance();
        QuestionModel q1 = new QuestionModel();
        q1.setQuestionType("Multiple Choice");

        QuestionModel q2 = new QuestionModel();
        q2.setQuestionType("Multiple Select");

        QuestionModel q3 = new QuestionModel();
        q3.setQuestionType("Fill in the Blank");

        QuestionModel q4 = new QuestionModel();
        q4.setQuestionType("Short Answer");

        TestModel sample = new TestModel("sampletest");

        sample.addQuestion(q1);
        sample.addQuestion(q2);
        sample.addQuestion(q3);

        inst.grade(sample);

        if ( sample.getTaken() ) {
            System.out.println("FAILURE, NOT MARKED AS TAKEN");
        }

        sample.addQuestion(q4);

        inst.grade(sample);

        if ( sample.getTaken() ) {
            System.out.println("FAILURE, NOT MARKED AS TAKEN");
        }

    }

}