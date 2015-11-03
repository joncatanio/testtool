package user.controllers;

import java.io.IOException;

import classpack.controllers.ClassPackController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import question.controllers.QuestionController;
import test.controllers.TestController;

public class UserController {
    public ChoiceBox selectSection = new ChoiceBox();
    protected Stage currStage;

    public void populateInterface(Stage stage){
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(3);
    }

    public void sectionChange(ActionEvent actionEvent) throws IOException{
        if (selectSection.getValue() == "Questions") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../question/views/first.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            QuestionController first = parentLoader.getController();
            first.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
        else if (selectSection.getValue() == "Tests") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../test/views/AddTestView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestController test = parentLoader.getController();
            test.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
        else if (selectSection.getValue() == "Classes") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../classpack/views/ClassView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            ClassPackController cp = parentLoader.getController();
            cp.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
    }
}
