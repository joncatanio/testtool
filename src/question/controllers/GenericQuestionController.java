package question.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import test.controllers.GenerateTestController;
import test.controllers.TestController;

import java.io.IOException;

/**
 * Created by cburwell on 11/4/15.
 */
public class GenericQuestionController extends QuestionController {

    public Label questionType;
    public TextField name;
    public ChoiceBox<String> subjects;
    public ChoiceBox<String> classes;
    public TextField charLimit;
    public ToggleGroup difficulty;
    public RadioButton easy; // 0 for easy
    public RadioButton medium; // 1 for medium
    public RadioButton hard; // 2 for hard
    public TextField points;
    public TextField image;
    public Button browse;
    public TextField hint;
    public TextArea questionText;
    public Button addQuestion;
    public Button clear;
    public Button cancel;

    public GenericQuestionController() {

    }

    public void addQuestion() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/GenericQuestionView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        GenericQuestionController gqc = parentLoader.getController();
        gqc.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
        System.out.println("Added a new free response / uml / coding / short answer / long answer question.");
    }

    public void clearForm() {

    }

    public void cancel() {

    }
}
