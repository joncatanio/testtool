package test.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import question.models.QuestionModel;
import test.models.TestModel;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by JonCatanio on 11/29/15.
 */
public class CustomEditTestController extends TestController {
    public TestModel testInstance;
    public int testIndex;

    public ListView questionList = new ListView();

    public TextField testNameField = new TextField();
    public Label totalPoints = new Label();

    public QuestionModel selectedQuestion = null;

    public CustomEditTestController() {

    }

    public CustomEditTestController(TestModel testInstance, QuestionModel selectedQuestion) {
        this.testInstance = testInstance;
        this.selectedQuestion = selectedQuestion;
    }

    public void addQuestion() {
        // TODO: Let the user pick a question from the question bank.
        System.out.println("Add question is deprecated, couldn't get to it.");
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

    /**
     * When a user selects a question on the test, it will redirect them to a page allowing them
     * to remove the question or edit the question.
     *
     * @throws IOException
     */
    public void editQuestion() throws IOException {
        selectedQuestion = testInstance.getQuestion(questionList.getEditingIndex());

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/EditRemoveQuestionFromTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        CustomEditTestController cetc = parentLoader.getController();
        cetc.testInstance = testInstance;
        cetc.selectedQuestion = selectedQuestion;
        cetc.testIndex = questionList.getEditingIndex();
        cetc.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    /**
     * Applies to the EditRemoveQuestionFromTest workflow. Redirects user to the
     * edit question page.
     */
    public void editActualQuestion() {
        // TODO: Pass off to Kendall's edit question.
        System.out.println("Edit actual question");
    }

    /**
     * Applies to the EditRemoveQuestionFromTest workflow. Removes the question from
     * the test.
     */
    public void removeQuestion() {
        testInstance.removeQuestion(selectedQuestion);
    }
}
