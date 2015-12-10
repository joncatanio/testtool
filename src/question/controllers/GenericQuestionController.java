package question.controllers;

import utility.DBObject;
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
import java.util.ArrayList;

/**
 * Created by Cameron Burwell (cburwell@calpoly.edu) on 11/4/15.
 */
public class GenericQuestionController extends QuestionController {

    /**
     * All public variables refer to their corresponding UI element fields
     */
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
    public Button browse = new Button();
    public TextField hint = new TextField();
    public TextArea questionText = new TextArea();
    public Button addQuestion = new Button();
    public Button clear = new Button();
    public Button cancel = new Button();
    public boolean check;

    /**
     * The current version of the QuestionModel passed in to the controller
     */
    private QuestionModel questionModel = new QuestionModel();
    /**
     * The original version of the QuestionModel that was passed in to the controller
     */
    private QuestionModel initialQuestionModel = new QuestionModel();
    /**
     * Get the current QuestionBank
     */
    private QuestionBank questionBank = QuestionBank.getInstance();

    public GenericQuestionController() {
        check = false;
    }

    /**
     * Prepopulate the view with relevant informaiton
     *
     * @param qm QuestionModel that represents the current question being added
     */
    public void initializeQuestionModel(QuestionModel qm) {
        this.questionType = new Label(qm.getQuestionType());

        // Initialize choiceboxes
        this.subjects.setItems(FXCollections.observableArrayList("Select", "computers", "not-computers", "subjects"));
        this.subjects.getSelectionModel().select(0);
        this.classes.setItems(FXCollections.observableArrayList("Select", "101", "202", "303", "505"));
        this.classes.getSelectionModel().select(0);

        this.charLimit.setPromptText(Integer.toString(qm.getCharLimit()));
        this.points.setPromptText(Integer.toString(qm.getPointsPossible()));

        updateFields(this.initialQuestionModel);
        updateFields(this.questionModel);
    }

    /**
     * Update the current QuestionModel and save it to the database, then return to the QuestionBank screen
     *
     * @throws IOException
     */
    public void addQuestion() throws IOException {
        // This will take all the fields and instantiate and object and pass it along to be created.
        ArrayList<QuestionModel> questionBank  = DBObject.getInstance().getQuestionBank();

        // Make sure the question is up-to-date
        updateFields(this.questionModel);
        questionBank.add(questionModel);

        // Ship it off to QuestionBank
        DBObject.getInstance().setQuestionBank(questionBank);

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        QuestionController test = parentLoader.getController();
        test.populateInterface(currStage);
        test.setUpTable();

        currStage.setScene(nextScene);
        currStage.show();
    }

    /**
     * Clears all fields of the form if the user presses the Clear button
     *
     * @throws IOException
     */
    public void clearForm() throws IOException {
        // Set all the fields to their inputs
        updateFields(this.questionModel);

        if ((this.initialQuestionModel == null && this.questionModel == null) ||
                this.initialQuestionModel.equals(this.questionModel)) {
            return;
        }

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/GenericQuestionView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        GenericQuestionController q = parentLoader.getController();
        q.populateInterface(this.currStage);
        initializeQuestionModel(this.initialQuestionModel);

        this.currStage.setScene(nextScene);
        this.currStage.show();
    }

    /**
     * Returns the user to the QuestionBank if they hit the Cancel button
     *
     * @throws IOException
     */
    public void cancel() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        QuestionController q = parentLoader.getController();
        q.populateInterface(currStage);
        q.setUpTable();
        currStage.setScene(nextScene);
        currStage.show();
    }

    /**
     * OnActionEvent that updates the QuestionModel fields as the user enters information in the GUI
     */
    public void updateFieldHandler() {
        updateFields(this.questionModel);
    }

    /**
     * Updates the QuestionModel to the most current GUI information
     *
     * @param qm QuestionModel that represents the current question
     */
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

        qm.setCharLimit(charLimit.getText() == null || charLimit.getText().equals("") ? 0 : Integer.parseInt(charLimit.getText()));
        qm.setPointsPossible(points.getText().equals("") ? 0 : Integer.parseInt(points.getText()));

        qm.setHint(hint.getText() == null ? "" : hint.getText());
        qm.setQuestion(questionText.getText() == null ? "" : questionText.getText());
    }

    /**
     * SetUpQuestion adds information about the question to each field
     * when the user has clicked edit question.
     *
     * @param questionMod QuestionModel representing the question
     */
    public void SetUpQuestion(QuestionModel questionMod) {
        check = true;
        questionName.setText(questionMod.getQuestionName());
        questionText.setText(questionMod.getQuestion());
        subjects.setValue(questionMod.getSubject());
        classes.setValue(questionMod.getClassNumber());
        points.setText(Integer.toString(questionMod.getPointsPossible()));
        hint.setText(questionMod.getHint());
        charLimit.setText(Integer.toString(questionMod.getCharLimit()));
        if(questionMod.getDifficulty() == 1)
            easy.setSelected(true);
        else if(questionMod.getDifficulty() == 2)
            medium.setSelected(true);
        else if(questionMod.getDifficulty() == 3)
            hard.setSelected(true);
    }
}
