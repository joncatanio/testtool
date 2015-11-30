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

    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Take Test"));

        getScheduledTests();
        getCompletedTests();
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
        testView.populateInterface(currStage);

        curTest = new TestTakingModel();
        updateTestInfo();

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to viewing a test");
    }

    public void selectCompletedTestToView() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestCompleteInfo.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestTakingController testView = parentLoader.getController();
        testView.populateInterface(currStage);

        curTest = new TestTakingModel();
        updateTestInfo();

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to viewing a test");
    }

    public void takeTest() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestQuestion.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestTakingController testView = parentLoader.getController();
        testView.populateInterface(currStage);
        getQuestionList();

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to test taking question view");
    }

    public void updateTestInfo() {
        testName.setText(curTest.getTestName());
        /*public Label timeLabel = new Label();
        public Label pointsLabel = new Label();
        public Label dueDateLabel = new Label();
        public Label testDescriptionLabel = new Label();
        public Label testNotesLabel = new Label();
        public ListView currentQuestionList = new ListView();*/
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
