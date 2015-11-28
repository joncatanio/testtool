package test.controllers;

import java.io.IOException;

import classpack.controllers.ClassPackController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import question.controllers.QuestionController;
import user.controllers.UserController;

public class TestController {
    public ListView testBank = new ListView();
    public ChoiceBox selectSection = new ChoiceBox();
    protected Stage currStage;

    public void populateInterface(Stage stage){
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(1);

        getTestBank();
    }

    public void sectionChange(ActionEvent actionEvent) throws IOException{
        if (selectSection.getValue() == "Questions") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            QuestionController first = parentLoader.getController();
            first.populateInterface(currStage);
            first.setUpTable();

            currStage.setScene(nextScene);
            currStage.show();
        }
        else if (selectSection.getValue() == "Classes") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/ClassView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            ClassPackController classPack = parentLoader.getController();
            classPack.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
        else if (selectSection.getValue() == "Settings") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/user/views/SettingsView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            UserController user = parentLoader.getController();
            user.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
    }

    public void addNewTest() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/AddTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestController test = parentLoader.getController();
        test.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void getTestBank() {
        testBank.setItems(FXCollections.observableArrayList("CPE 349 - Final", "CSC 101 - Midterm 1", "CSC 445 - Midterm",
                "CSC 101 - Midterm 2", "CSC 101 - Final", "CPE 102 - Midterm 1", "CPE 102 - Midterm 2", "CPE 102 - Final",
                "CPE 103 - Midterm 1", "CPE 103 - Midterm 2", "CPE 103 - Final", "CPE 357 - Midterm 1", "CPE 357 - Midterm 2",
                "CPE 357 - Midterm 3", "CPE 357 - Midterm 4", "CPE 357 - Midterm 5", "CPE 357 - Final", "CPE 123 - Midterm",
                "CPE 123 - Final"));
        // Go through Cameron's DB to pull all tests instead of make a TestBank class.
        // TODO: Cameron's DB will give me an ArrayList, I'll have to convert it to an observableArrayList.
        // To do that simply pass the ArrayList into observableArrayList.
    }
}