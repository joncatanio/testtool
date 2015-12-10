package UnitTests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.controllers.LoginScreenController;
import question.models.QuestionModel;

public class RunUnitTests {

    public static void main(String[] args) {
        //call your unit tests here

        /*
         * Kendall Unit Tests
         */
        DBObjectUnitTests kendallsTests = new DBObjectUnitTests();
        kendallsTests.testDBObjectQuestionsByDifficulty();
        kendallsTests.testDBObjectQuestionsByType();
        QuestionBankUnitTests kendallTest2 = new QuestionBankUnitTests();

        kendallTest2.testQuestionBankgetQuestion();

        /* * * * * * * * * * * * */


        /*
         * Alex Unit Tests
         */

        TestBinModelTest t1 = new TestBinModelTest();
        t1.testAddSubmissionMethod();

        ClassBankModelTest t2 = new ClassBankModelTest();
        t2.testGetClassByIdMethod();

        TestHandlerModelTest t3 = new TestHandlerModelTest();
        t3.testGradeMethod();

        /* * * * * * * * * * * * */

        /*
         * Jon Unit Tests
         */
        System.out.println("\n\nJon's tests...\n\n");
        GenerateTestRequestModelTest gtq = new GenerateTestRequestModelTest();
        gtq.setNumQuestionsTest();

        TestModelTest tmt = new TestModelTest();
        tmt.setDifficultyTest();
        tmt.setTotalPointsTest();
        System.out.println("\n\nEnd Jon's tests.");
        /* * * * * * * * * * * * */

        /*
         * Cameron Unit Tests
         */

        System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("CAMERON TESTS BEGIN");

        QuestionBankUnitTests qbut = new QuestionBankUnitTests();
        qbut.testQuestionBankGetByDifficulty();
        qbut.testQuestionBankGetByType();
        qbut.testQuestionBankGetByName();

        System.out.println("CAMERON TESTS END");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");

        /* * * * * * * * * * * * */

        /*
         * Reed Unit Tests
         */
        System.out.println("\n\nReed's tests...\n\n");
        TestTakingModelTest ttmt = new TestTakingModelTest();

        /* Run tests */
        ttmt.setQuestionsTest();
        ttmt.getNextQuestionTest();
        ttmt.getPrevQuestionTest();

        System.out.println("\n\nEnd Reed's tests.");
        /* * * * * * * * * * * * */

    }
}