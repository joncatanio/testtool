package UnitTests;

import test.models.TestModel;

/**
 * Created by JonCatanio on 12/9/15.
 */
public class TestModelTest extends TestModel {
    public TestModelTest () {}

    public void setDifficultyTest() {
        System.out.println("Testing TestModel.setDifficultyTest...");
        TestModel testModel = new TestModel();
        int number;

        /* Out of lower bound */
        number = -1;
        testModel.setDifficulty(number);
        assert testModel.getDifficulty() == 0;

        /* Out of upper bound */
        number = 12;
        testModel.setDifficulty(number);
        assert testModel.getDifficulty() == 0;

        /* Valid number */
        number = 1;
        testModel.setDifficulty(number);
        assert testModel.getDifficulty() == 1;
        System.out.println("TestModel.setDifficultyTest successful.");
    }

    public void setTotalPointsTest() {
        System.out.println("Testing TestModel.setTotalPoints...");
        TestModel testModel = new TestModel();
        int points;

        /* True True */
        points = 100;
        testModel.setTotalPoints(points);
        assert testModel.getTotalPoints() == points;

        /* True False */
        points = 20000;
        testModel.setTotalPoints(points);
        assert testModel.getTotalPoints() == 100;

        /* False True */
        points = -1;
        testModel.setTotalPoints(points);
        assert testModel.getTotalPoints() == 100;

        /* False False */
        /* not possible */
        System.out.println("TestModel.setTotalPoints successful.");
    }
}
