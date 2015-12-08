package UnitTests;

public class RunUnitTests {

    public static void main(String[] args) {
        //call your unit tests here
        DBObjectUnitTests kendallsTests = new DBObjectUnitTests();
        kendallsTests.testDBObjectQuestionsByDifficulty();
        kendallsTests.testDBObjectQuestionsByType();
        System.out.println("TESTS RAN");
        QuestionBankUnitTests kendallTest2 = new QuestionBankUnitTests();

        kendallTest2.testQuestionBankgetQuestion();


        /*
         * Alex Unit Tests
         */

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("ALEX TESTS BEGIN");

        TestBinModelTest t1 = new TestBinModelTest();
        t1.testAddSubmissionMethod();

        ClassBankModelTest t2 = new ClassBankModelTest();
        t2.testGetClassByIdMethod();

        TestHandlerModelTest t3 = new TestHandlerModelTest();
        t3.testGradeMethod();

        System.out.println("ALEX TESTS END");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        /* * * * * * * * * * * * */


    }
}