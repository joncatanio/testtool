package classpack.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import question.controllers.QuestionController;
import test.controllers.TestController;
import user.controllers.UserController;

import java.io.IOException;

public class ClassViewController extends ClassPackController{

    public void addClass(ActionEvent actionEvent) {
        System.out.println("Add Class");
    }
}
