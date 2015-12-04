package test.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

import test.models.*;

public class TestTakingController {
    /* Non-specific */
    public ListView scheduledTests = new ListView();
    public ListView completedTests = new ListView();
    public ChoiceBox selectSection = new ChoiceBox();
    protected Stage currStage;

    /* Test Info */
    public TestTakingModel curTest = new TestTakingModel();
    public Label testName = new Label();
    public Label timeLabel = new Label();
    public Label pointsLabel = new Label();
    public Label dueDateLabel = new Label();
    public Label testDescriptionLabel = new Label();
    public Label testNotesLabel = new Label();

    /* Test Taking */
    public ListView currentQuestionList = new ListView();
    public Label currentQuestionName = new Label();
    public Label currentQuestionInfo = new Label();

    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Take Test"));

        getScheduledTests();
        getCompletedTests();

        currentQuestionName.setText("Question " + curTest.getQuestionNum());
        currentQuestionInfo.setText("Submit the test for full credit!");
        getQuestionList();
    }

    public void sectionChange(ActionEvent actionEvent) throws IOException {
        if (selectSection.getValue() == "Take Test") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestTakingView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestTakingController ttc = parentLoader.getController();
            ttc.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();

            System.out.println("Switched to viewing the take test tab");
        }
    }

    public void selectTestToView() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestInfo.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestTakingController testView = parentLoader.getController();

        curTest = new TestTakingModel();
        updateTestInfo();
        testView.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to viewing a test");
    }

    public void selectCompletedTestToView() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestCompleteInfo.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestTakingController testView = parentLoader.getController();

        curTest = new TestTakingModel();
        updateTestInfo();
        testView.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to viewing a test");
    }

    public void takeTest() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestQuestion.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestTakingController testView = parentLoader.getController();

        currentQuestionName.setText("Question " + curTest.getQuestionNum());
        currentQuestionInfo.setText("Submit the test for full credit!");
        getQuestionList();
        testView.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();


        System.out.println("Switched to test taking question view");
    }

    public void nextQuestion() throws IOException {
        System.out.println("Switch to next question in test");
    }

    public void prevQuestion() throws IOException {
        System.out.println("Switch to previous question in test");
    }

    public void showHint() throws IOException {
        System.out.println("Display current question hint pop-up");
    }

    public void submitTest() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestCompleteInfo.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestTakingController testView = parentLoader.getController();
        updateTestInfo();
        testView.populateInterface(currStage);

        curTest = new TestTakingModel();

        currStage.setScene(nextScene);
        currStage.show();

        TestHandlerModel.getInstance().grade(curTest.getTest());
        System.out.println("Submitted test!");
    }

    public void updateTestInfo() {
        testName.setText(curTest.getTestName());
        timeLabel.setText("Time Limit: 60 Minutes");
        pointsLabel.setText("Total Points: " + curTest.getTest().getTotalPoints());
        dueDateLabel.setText("Due: 10/3");
        testDescriptionLabel.setText("Description: A cumulative test of your knowledge");
        testNotesLabel.setText("Teacher notes: Good luck!!");

        currentQuestionName.setText("Question " + curTest.getQuestionNum());
        currentQuestionInfo.setText("Submit the test for full credit!");
    }

    public void getScheduledTests() {
        // Will eventually be pulled from test db
        scheduledTests.setItems(FXCollections.observableArrayList(curTest.getScheduledTest()));
    }

    public void getCompletedTests() {
        // Will eventually be pulled from test db
        completedTests.setItems(FXCollections.observableArrayList(curTest.getCompletedTests()));
    }

    public void getQuestionList() {
        currentQuestionList.setItems(FXCollections.observableArrayList(curTest.getQuestionNameList()));
    }
}
