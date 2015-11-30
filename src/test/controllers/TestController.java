package test.controllers;

import java.io.IOException;
import java.util.ArrayList;

import classpack.controllers.ClassPackController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import question.controllers.QuestionController;
import test.models.TestBankModel;
import test.models.TestModel;
import user.controllers.UserController;

public class TestController {
    public ListView testBankSidebar = new ListView();
    public TestBankModel testBank = TestBankModel.getInstance();

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
        /* Create a new cell factory to pull the name of the test for the ListView */
        testBankSidebar.setCellFactory(lv -> new ListCell<TestModel>() {
            @Override
            public void updateItem(TestModel item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    String text = item.getName();
                    setText(text);
                }
            }
        });
        testBankSidebar.setItems(FXCollections.observableArrayList(testBank.getAllTests()));
    }

    /**
     * On edit start event handler for the list view.
     */
    public void editTest() throws IOException {
        TestModel editingTest = testBank.getTest(testBankSidebar.getEditingIndex());
        System.out.println("Editing test: " + editingTest.toString());

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/CustomEditTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        CustomEditTestController cetc = parentLoader.getController();
        cetc.populateInterface(currStage);
        cetc.setTestInstance(editingTest);

        currStage.setScene(nextScene);
        currStage.show();
    }
}