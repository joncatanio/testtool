package classpack.controllers;

import java.io.IOException;

import classpack.models.ClassBankModel;
import classpack.models.ClassModel;
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
import test.controllers.TestController;
import test.models.TestModel;
import user.controllers.UserController;

public class ClassPackController {

    public ChoiceBox selectSection = new ChoiceBox();

    protected Stage currStage;

    public ListView classList = new ListView();

    public ClassBankModel classBank = ClassBankModel.getInstance();

    /**
     * populateInterface updates the UI of the testtool.
     * @param stage updates the current stage.
     */
    public void populateInterface(Stage stage){
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(2);

        getClassBank();
    }

    /**
     * getClassBank gets the list of classes from the ClassBankModel and updates the UI accordingly.
     */
    public void getClassBank() {
        /* Create a new cell factory to pull the name of the test for the ListView */
        classList.setCellFactory(lv -> new ListCell<ClassModel>() {
            @Override
            public void updateItem(ClassModel item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    String text = item.getClassName();
                    setText(text);
                }
            }
        });
        classList.setItems(FXCollections.observableArrayList(classBank.getAllClasses()));
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
        else if (selectSection.getValue() == "Tests") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/AddTestView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestController test = parentLoader.getController();
            test.populateInterface(currStage);

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
}
