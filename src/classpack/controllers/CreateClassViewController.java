package classpack.controllers;

import classpack.models.ClassBankModel;
import classpack.models.ClassModel;
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
public class CreateClassViewController extends ClassViewController {
    public Button ok;
    public Button cancel;
    public TextField classCode;
    public TextField className;
    public TextField school;



    public void ok(ActionEvent x) throws IOException {
        ClassModel newClass;
        System.out.println("Created class: " + className.getText() + " at " + school.getText() + " with code " + classCode.getText());
        newClass = new ClassModel();
        newClass.setClassId(123);
        newClass.setClassCode(classCode.getText());
        newClass.setClassName(className.getText());
        classBank.addClass(newClass);

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
