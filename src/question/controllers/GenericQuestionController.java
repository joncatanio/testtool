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
    public TextField questionName = new TextField();
    public ChoiceBox<String> subjects = new ChoiceBox<String>();
    public ChoiceBox<String> classes = new ChoiceBox<String>();
    public TextField charLimit = new TextField();
    public ToggleGroup difficulty = new ToggleGroup();
    public RadioButton easy = new RadioButton(); // 0 for easy
    public RadioButton medium = new RadioButton(); // 1 for medium
    public RadioButton hard = new RadioButton(); // 2 for hard
    public TextField points = new TextField();
    public TextField image;
    public Button browse = new Button();
    public TextField hint = new TextField();
    public TextArea questionText = new TextArea();
    public Button addQuestion = new Button();
    public Button clear = new Button();
    public Button cancel = new Button();

    private QuestionModel questionModel;
    private QuestionModel initialQuestionModel;

    public GenericQuestionController() {
    }

    // TODO: only free response opens to my view :(

    public void initiateQuestionModel(QuestionModel qm) {
        this.initialQuestionModel = this.questionModel = qm;

        this.questionType = new Label(questionModel.getQuestionType());

        this.charLimit = new TextField(Integer.toString(questionModel.getCharLimit()));
        this.points = new TextField(Integer.toString(questionModel.getPointsPossible()));

        // Initialize choiceboxes
        this.subjects.setItems(FXCollections.observableArrayList("Select", "computers", "not-computers", "subjects"));
        this.subjects.getSelectionModel().select(0);
        this.classes.setItems(FXCollections.observableArrayList("Select", "101", "202", "303", "505"));
        this.classes.getSelectionModel().select(0);

        this.charLimit.setText(Integer.toString(questionModel.getCharLimit()));
        this.points.setText(Integer.toString(questionModel.getPointsPossible()));
    }

    public void addQuestion() throws IOException {
        // This will take all the fields and instantiate and object and pass it along to be created.
        System.out.println("\nAdd question!");

        // TODO: Add error handling

        questionModel.setQuestionName(questionName.getText());
        questionModel.setSubject(subjects.getValue());
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

    // TODO: Doesn't actually clear woo
    public void clearForm() {
        questionModel = initialQuestionModel;
    }

    public void cancel() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/first.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        QuestionController q = parentLoader.getController();
        q.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }
}
