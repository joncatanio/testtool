package UnitTests;

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
    }
}