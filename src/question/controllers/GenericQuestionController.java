package question.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import question.models.QuestionModel;
import test.controllers.GenerateTestController;
import test.controllers.TestController;

import java.io.IOException;

/**
 * Created by cburwell on 11/4/15.
 */
public class GenericQuestionController extends QuestionController {

    public Label questionType;
    public TextField name = new TextField();
    public ChoiceBox<String> subjects;
    public ChoiceBox<String> classes;
    public TextField charLimit;
    public ToggleGroup difficulty = new ToggleGroup();
    public RadioButton easy = new RadioButton(); // 0 for easy
    public RadioButton medium = new RadioButton(); // 1 for medium
    public RadioButton hard = new RadioButton(); // 2 for hard
    public TextField points;
    public TextField image;
    public Button browse = new Button();
    public TextField hint = new TextField();
    public TextArea questionText = new TextArea();
    public Button addQuestion = new Button();
    public Button clear = new Button();
    public Button cancel = new Button();

    private QuestionModel questionModel;
    private QuestionModel initialQuestionModel;

    public GenericQuestionController(QuestionModel questionModel) {
        this.initialQuestionModel = this.questionModel = questionModel;
        this.questionType = new Label(questionModel.getQuestionType());
        this.charLimit = new TextField(Integer.toString(questionModel.getCharLimit()));
        this.points = new TextField(Integer.toString(questionModel.getPointsPossible()));

        // Initialize choiceboxes
        subjects = new ChoiceBox<String>(FXCollections.observableArrayList("Select", "computers", "not-computers", "subjects"));
        classes = new ChoiceBox<String>(FXCollections.observableArrayList("Select", "101", "202", "303", "505"));
    }

    public void addQuestion() throws IOException {
        // This will take all the fields and instantiate and object and pass it along to be created.
        System.out.println("Add question!");

        // TODO: Add error handling
        questionModel.setQuestionName(name.getText());
        questionModel.setSubject(subjects.getValue());

        // TODO: Add event handler for selection of subject to allow selection of class

        questionModel.setClassNumber(classes.getValue());
        questionModel.setCharLimit(Integer.parseInt(charLimit.getText()));

        if (easy.isSelected()) {
            questionModel.setDifficulty(0);
        }
        else if (medium.isSelected()) {
            questionModel.setDifficulty(1);
        }
        else if (hard.isSelected()) {
            questionModel.setDifficulty(2);
        }

        questionModel.setPointsPossible(Integer.parseInt(points.getText()));

        // TODO: Add logic for selecting image

        questionModel.setHint(hint.getText());
        questionModel.setQuestion(questionText.getText());
    }

    public void clearForm() {
        questionModel = initialQuestionModel;
    }

    public void cancel() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../user/views/QuestionView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        QuestionController q = parentLoader.getController();
        q.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }
}
