package classpack.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by andrewgough94 on 11/7/2015.
 */
public class CreateClassViewController extends ClassPackController {
    public Button ok;
    public Button cancel;
    public TextField classCode;
    public TextField className;
    public TextField school;


    public void ok(ActionEvent x) throws IOException {
        System.out.println("Created class: " + className.getText() + " at " + school.getText() + " with code " + classCode.getText());
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/ClassView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        ClassViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void cancel(ActionEvent x) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/ClassView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        ClassViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }
}
