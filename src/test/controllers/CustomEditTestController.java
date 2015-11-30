package test.controllers;

import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import question.models.QuestionModel;
import test.models.TestModel;

import java.util.ArrayList;

/**
 * Created by JonCatanio on 11/29/15.
 */
public class CustomEditTestController extends TestController {
    private TestModel testInstance;
    public ListView questionList = new ListView();

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

        /* Create a new cell factory to pull the name of the question for the ListView */
        questionList.setCellFactory(lv -> new ListCell<QuestionModel>() {
            @Override
            public void updateItem(QuestionModel item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    String text = item.getQuestionName();
                    setText(text);
                }
            }
        });
        questionList.setItems(FXCollections.observableArrayList(testInstance.getQuestions()));
    }

    public void changeTestName() {
        testInstance.setName(testNameField.getText());

        /* Update the test bank with the new named test. */
        getTestBank();
    }

    public void editQuestion() {
        QuestionModel editingQuestion = testInstance.getQuestion(questionList.getEditingIndex());

        System.out.println("Editing question: " + editingQuestion.getQuestionName());
    }
}
