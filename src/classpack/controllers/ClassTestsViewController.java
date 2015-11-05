package classpack.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;


public class ClassTestsViewController extends ClassPackController{

    public Button backButton = new Button();
    public Label currentClassLabel = new Label("current class");

    public void addClass(ActionEvent actionEvent) {
        System.out.println("Add Class");
    }

    public void goBackToClasses(ActionEvent actionEvent) throws IOException {

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../classpack/views/ClassView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        ClassViewController classes = parentLoader.getController();
        classes.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

}
