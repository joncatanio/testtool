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
    public Button joinClass = new Button();
    public Button createClass = new Button();
    public Button editClasses = new Button();

    public int highlightedClassId;


    public void joinClass(ActionEvent event) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/JoinClassView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        JoinClassController assigned = parentLoader.getController();
        assigned.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
        System.out.println("Joining class");
    }

    public void createClass(ActionEvent event) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/CreateClassView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        CreateClassViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
        System.out.println("Creating class");
    }

    public void editClasses(ActionEvent event) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/EditClassesView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        EditClassesViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
        System.out.println("Editing class");
    }

    public void addClass(ActionEvent actionEvent) {
        System.out.println("Add Class");
    }

    public void viewAssignedTests(ActionEvent actionEvent) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/AssignedTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        AssignedTestViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage, highlightedClassId);

        currStage.setScene(nextScene);
        currStage.show();
    }
}
