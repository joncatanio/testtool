import test.models.TestHandlerModel;

public class TestHandlerModelTest extends TestHandlerModel {

    public void testGradeMethod() {

        QuestionModel q1 = new QuestionModel();
        q1.setQuestionType("Multiple Choice");

        QuestionModel q2 = new QuestionModel();
        q2.setQuestionType("Multiple Select");

        QuestionModel q3 = new QuestionModel();
        q3.setQuestionType("Fill in the Blank");

        QuestionModel q4 = new QuestionModel();
        q4.setQuestionType("Short Answer");

        TestModel sample = new TestModel();

        sample.addQuestion(q1);
        sample.addQuestion(q2);
        sample.addQuestion(q3);

        grade(sample);

        if ( sample.getTaken() ) {
            System.out.println("FAILURE, NOT MARKED AS TAKEN");
        }

        sample.addQuestion(q4);

        grade(sample);

        if ( sample.getTaken() ) {
            System.out.println("FAILURE, NOT MARKED AS TAKEN");
        }

    }

}