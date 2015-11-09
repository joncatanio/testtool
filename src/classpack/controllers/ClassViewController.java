package classpack.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import question.controllers.QuestionController;
import test.controllers.TestController;
import user.controllers.UserController;

import java.io.IOException;

public class ClassViewController extends ClassPackController{


    public Button viewAssignedTestsButton = new Button();

    public void addClass(ActionEvent actionEvent) {
        System.out.println("Add Class");
    }

    public void viewAssignedTests(ActionEvent actionEvent) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/AssignedTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        AssignedTestViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }
}
