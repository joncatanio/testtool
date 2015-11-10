package classpack.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import question.controllers.QuestionController;
import test.controllers.TestController;
import user.controllers.UserController;

import java.io.IOException;
import java.util.*;
import classpack.models.*;
import javafx.event.ActionEvent;

/**
 * Created by andrewgough94 on 11/6/2015.
 */


public class JoinClassController extends ClassPackController {

    public Button ok;
    public Button cancel;
    public TextField classCode;


    public void ok(ActionEvent x) throws IOException{
        if(classCode.getText().length() < 1) {
            System.out.println("Enter a longer classCode");
        }
        else {
            System.out.println("Class joined with code: " + classCode.getText());
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/ClassView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            ClassViewController assigned = parentLoader.getController();
            assigned.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
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
