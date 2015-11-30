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

public class TestTakingController {
    /* Non-specific */
    public ListView scheduledTests = new ListView();
    public ListView completedTests = new ListView();
    public ChoiceBox selectSection = new ChoiceBox();
    protected Stage currStage;

    /* Test Info */
    public Label classNameLabel = new Label();
    public Label testName = new Label();
    public Label timeLabel = new Label();
    public Label pointsLabel = new Label();
    public Label dueDateLabel = new Label();
    public Label testDescriptionLabel = new Label();
    public Label testNotesLabel = new Label();


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

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to test taking question view");
    }

    public void getScheduledTests() {
        scheduledTests.setItems(FXCollections.observableArrayList("CPE 103 - Final", "CPE 357 - Midterm 1", "CPE 357 - Midterm 2",
                "CPE 357 - Midterm 3", "CPE 357 - Midterm 4", "CPE 357 - Midterm 5", "CPE 357 - Final", "CPE 123 - Midterm",
                "CPE 123 - Final"));
        // Go through Cameron's DB to pull all tests that have yet to be taken instead of making a TestBank class.
        // TODO: Cameron's DB will give me an ArrayList, I'll have to convert it to an observableArrayList.
        // To do that simply pass the ArrayList into observableArrayList.
    }

    public void getCompletedTests() {
        completedTests.setItems(FXCollections.observableArrayList("CPE 349 - Final", "CSC 101 - Midterm 1", "CSC 445 - Midterm",
                "CSC 101 - Midterm 2", "CSC 101 - Final", "CPE 102 - Midterm 1", "CPE 102 - Midterm 2", "CPE 102 - Final",
                "CPE 103 - Midterm 1", "CPE 103 - Midterm 2"));
        // Go through Cameron's DB to pull all tests that have been taken instead of making a TestBank class.
        // TODO: Cameron's DB will give me an ArrayList, I'll have to convert it to an observableArrayList.
        // To do that simply pass the ArrayList into observableArrayList.
    }
}
