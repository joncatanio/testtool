package question.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import question.models.QuestionBank;
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

    private QuestionModel questionModel = new QuestionModel();
    private QuestionModel initialQuestionModel = new QuestionModel();

    public GenericQuestionController() {
    }

    public void initializeQuestionModel(QuestionModel qm) {
        this.questionType = new Label(qm.getQuestionType());

        // Initialize choiceboxes
        this.subjects.setItems(FXCollections.observableArrayList("Select", "computers", "not-computers", "subjects"));
        this.subjects.getSelectionModel().select(0);
        this.classes.setItems(FXCollections.observableArrayList("Select", "101", "202", "303", "505"));
        this.classes.getSelectionModel().select(0);

        this.charLimit.setPromptText(Integer.toString(qm.getCharLimit()));
        this.points.setPromptText(Integer.toString(qm.getPointsPossible()));

        System.out.println(this.charLimit.getText() + " : " + this.points.getText());

        updateFields(this.initialQuestionModel);
        updateFields(this.questionModel);
    }

    public void addQuestion() throws IOException {
        // This will take all the fields and instantiate and object and pass it along to be created.
        System.out.println("\nAdding question!");

        // Make sure the question is up-to-date
        updateFields(this.questionModel);
        // Ship it off to QuestionBank
        QuestionBank.getInstance().addQuestion(this.questionModel);

        // return to Add Question scene
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/PickQuestionType.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        QuestionController q = parentLoader.getController();
        q.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void clearForm() throws IOException {
        // Set all the fields to their inputs
        updateFields(this.questionModel);

        if ((this.initialQuestionModel == null && this.questionModel == null) ||
                this.initialQuestionModel.equals(this.questionModel)) {
            System.out.println("\nThey're the same, silly");
            return;
        }

        System.out.println("\nClearing form!");

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/GenericQuestionView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        GenericQuestionController q = parentLoader.getController();
        q.populateInterface(this.currStage);
        initializeQuestionModel(this.initialQuestionModel);

        this.currStage.setScene(nextScene);
        this.currStage.show();
    }

    public void cancel() throws IOException {
        System.out.println("\nGetting out of here!");

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        QuestionController q = parentLoader.getController();
        q.populateInterface(currStage);
        q.setUpTable();
        currStage.setScene(nextScene);
        currStage.show();
    }

    public void updateFieldHandler() {
        updateFields(this.questionModel);
    }

    private void updateFields(QuestionModel qm) {
        qm.setQuestionType(questionType.getText() == null ? "None" : questionType.getText());
        qm.setQuestionName(questionName.getText() == null ? "" : questionName.getText());
        qm.setSubject(subjects.getValue() == null ? "None" : subjects.getValue());
        qm.setClassNumber(classes.getValue() == null ? "0" : classes.getValue());

        if (easy.isSelected()) {
            qm.setDifficulty(0);
        }
        else if (medium.isSelected()) {
            qm.setDifficulty(1);
        }
        else if (hard.isSelected()) {
            qm.setDifficulty(2);
        }
        else {
            qm.setDifficulty(0);
        }

        // TODO: CharLimit and PointsPossible not working properly
        qm.setCharLimit(charLimit.getText() == null || charLimit.getText().equals("") ? 0 : Integer.parseInt(charLimit.getText()));
        qm.setPointsPossible(points.getText().equals("") ? 0 : Integer.parseInt(points.getText()));

        // TODO: Add logic for selecting image

        qm.setHint(hint.getText() == null ? "" : hint.getText());
        qm.setQuestion(questionText.getText() == null ? "" : questionText.getText());
    }
}
