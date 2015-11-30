package test.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import question.models.QuestionModel;
import test.models.TestModel;

/**
 * Created by JonCatanio on 11/29/15.
 */
public class CustomEditTestController extends TestController {
    private TestModel testInstance;
    public TextField testNameField = new TextField();
    public Label totalPoints = new Label();

    public CustomEditTestController() {
    }

    public void addQuestion() {
        // TODO: Let the user pick a question from the question bank.
        testInstance.addQuestion(new QuestionModel());
    }

    public void setTestInstance(TestModel testInstance) {
        this.testInstance = testInstance;

        populateViewData();
    }

    private void populateViewData() {
        testNameField.setPromptText(testInstance.getName());
        totalPoints.setText(Integer.toString(testInstance.getTotalPoints()));
    }

    public void changeTestName() {
        testInstance.setName(testNameField.getText());

        /* Update the test bank with the new named test. */
        getTestBank();
    }
}
