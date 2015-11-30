package test.controllers;

import javafx.scene.control.Label;
import test.models.TestModel;

/**
 * Created by JonCatanio on 11/29/15.
 */
public class CustomEditTestController extends TestController {
    private TestModel testInstance;
    public Label testNameLabel = new Label();
    public Label totalPoints = new Label();

    public CustomEditTestController() {
    }

    public void addQuestion() {
        System.out.println("Add question");
    }

    public void setTestInstance(TestModel testInstance) {
        this.testInstance = testInstance;

        populateViewData();
    }

    private void populateViewData() {
        testNameLabel.setText(testInstance.getName());
        totalPoints.setText(Integer.toString(testInstance.getTotalPoints()));
    }
}
