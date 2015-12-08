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


    }
}