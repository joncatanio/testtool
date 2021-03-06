/****
 *
 * The MatchingController Class is used when a the user is creating a matching question.
 * This controller will add a matching question to the database and to the table.
 *
 *
 * Kendall Gassner (kendall.gassner@yahoo.com)
 *
 */
package question.controllers;

import utility.DBObject;
import classpack.controllers.ClassPackController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import question.models.QuestionModel;
import test.controllers.TestController;
import user.controllers.UserController;

import java.io.IOException;
import java.util.ArrayList;


public class MatchingController extends QuestionController {

    /**
     * questionName is a TextField for the title of the question.
     *
     **/
    public TextField questionName;

    /**
     * question is a TextArea for the question.
     *
     **/
    public TextArea  question;

    /**
     * subjects is a ChoiceBox for the subject.
     *
     **/
    public ChoiceBox subjects;

    /**
     * className is a ChoiceBox for the className.
     *
     **/
    public ChoiceBox className;

    /**
     * a is a TextField for the option a.
     *
     **/
    public TextField a;

    /**
     * b is a TextField for the option b.
     *
     **/
    public TextField b;

    /**
     *c is a TextField for the option c.
     *
     **/
    public TextField c;

    /**
     * d is a TextField for the option d.
     *
     **/
    public TextField d;

    /**
     * aAnswer is a TextField for the matching to a.
     *
     **/
    public TextField aAnswer;

    /**
     * bAnswer is a TextField for the matching to b.
     *
     **/
    public TextField bAnswer;

    /**
     * cAnswer is a TextField for the matching to c.
     *
     **/
    public TextField cAnswer;

    /**
     * dAnswer is a TextField for the matching to d.
     *
     **/
    public TextField dAnswer;

    /**
     * points is a textField for the amount of points
     * possible
     *
     **/
    public TextField points;

    /**
     * hint is a textField for the teachers hint
     *
     **/
    public TextField hint;

    /**
     * easy is a radioButton for the difficulty
     *
     **/
    public RadioButton easy;

    /**
     * medium is a radioButton for the difficulty
     *
     **/
    public RadioButton medium;

    /**
     * hard is a radioButton for the difficulty
     *
     **/
    public RadioButton hard;

    /**
     * clear is a Button to clear the fields
     *
     **/
    public Button clear;

    /**
     * check is a boolean to check if we are in edit
     * mode
     *
     **/
    public boolean check;

    /**
     * unEditedQuestion holds the oldQuestions information based
     * on if we were in edit  mode.
     *
     **/
    public QuestionModel unEditedQuestion;


    /**
     * MatchingController sets check to false.
     *
     */
    public MatchingController(){
        check = false;
    }

    /**
     * populateChoiceBoxes is used to set the ArrayLists for dropdown menus and it calls getQuestions
     * to get the Data bases stored questions
     *
     */
    public void populateChoiceBoxes() {
        subjects.setItems(FXCollections.observableArrayList("Select", "computers", "not-computers", "subjects"));
        className.setItems(FXCollections.observableArrayList("Select", "101", "202", "303", "505"));
        subjects.getSelectionModel().select(0);
        className.getSelectionModel().select(0);
        this.points.setPromptText(Integer.toString(100));

    }

    /**
     * AddQuestionToBank will add the fill in the blank question only if the user has
     * filled out the following fields: title, question, subject, class, answer
     * points possible, other options, and difficulty. Points possible must be an integer.
     *
     */
    public void AddQuestionToBank(ActionEvent actionEvent) throws IOException {
        QuestionModel questionModel = new QuestionModel();
        ArrayList<QuestionModel> questionBank  = DBObject.getInstance().getQuestionBank();
        if(questionName.getText() != null && subjects.getValue() != null){
            if(className.getValue() != null) {
                if (easy.isSelected() || medium.isSelected() || hard.isSelected()) {
                    questionModel.setQuestionName(questionName.getText());
                    questionModel.setPointsPossible(Integer.parseInt(points.getText()));
                    questionModel.setClassNumber(className.getValue().toString());
                    questionModel.setSubject(subjects.getValue().toString());
                    questionModel.setQuestion(question.getText());
                    questionModel.getQuestionHelper().setA(a.getText());
                    questionModel.getQuestionHelper().setB(b.getText());
                    questionModel.getQuestionHelper().setC(c.getText());
                    questionModel.getQuestionHelper().setD(d.getText());
                    questionModel.getQuestionHelper().setAAnswer(aAnswer.getText());
                    questionModel.getQuestionHelper().setBAnswer(bAnswer.getText());
                    questionModel.getQuestionHelper().setCAnswer(cAnswer.getText());
                    questionModel.getQuestionHelper().setDAnswer(dAnswer.getText());
                    questionModel.setHint(hint.getText());
                    if (easy.isSelected()) {
                        questionModel.setDifficulty(1);
                    } else if (medium.isSelected()) {
                        questionModel.setDifficulty(2);
                    } else if (hard.isSelected()) {
                        questionModel.setDifficulty(3);
                    }
                    SetUpNewView(questionBank, questionModel);
                }
            }
        }
    }

    /**
     * SetUpNewView loads the question bank view with the new Multiple Select question
     * added to the bank.
     *
     */
    public void SetUpNewView(ArrayList<QuestionModel> questionBank ,QuestionModel questionModel) throws IOException {
        questionModel.setQuestionType("Matching");
        questionBank.add(questionModel);
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
     * ClearAllThings clears all of the fields in the fill in the blank GUI.
     *
     */
    public void ClearAllThings(ActionEvent actionEvent) {
        questionName.clear();
        question.clear();
        subjects.setValue(0);
        className.setValue(0);
        a.clear();
        b.clear();
        c.clear();
        d.clear();
        aAnswer.clear();
        bAnswer.clear();
        cAnswer.clear();
        dAnswer.clear();
        points.clear();
        hint.clear();
        easy.setSelected(false);
        medium.setSelected(false);
        hard.setSelected(false);
    }

    /**
     * Cancel takes the user back to the question bank and does not add the question
     * to the database.
     *
     */
    public void Cancel(ActionEvent actionEvent) throws IOException {
        if(check){
            SetUpQuestion(unEditedQuestion);
            AddQuestionToBank(actionEvent);
        }
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
     * SetUpQuestion adds information about the question to each field
     * when the user has clicked edit question.
     *
     */
    public void SetUpQuestion(QuestionModel questionMod) {
        unEditedQuestion = questionMod;
        check = true;
        questionName.setText(questionMod.getQuestionName());
        question.setText(questionMod.getQuestion());
        subjects.setValue(questionMod.getSubject());
        className.setValue(questionMod.getClassNumber());
        a.setText(questionMod.getQuestionHelper().getA());
        b.setText(questionMod.getQuestionHelper().getB());
        c.setText(questionMod.getQuestionHelper().getC());
        d.setText(questionMod.getQuestionHelper().getD());
        aAnswer.setText(questionMod.getQuestionHelper().getAAnswer());
        bAnswer.setText(questionMod.getQuestionHelper().getBAnswer());
        cAnswer.setText(questionMod.getQuestionHelper().getCAnswer());
        dAnswer.setText(questionMod.getQuestionHelper().getDAnswer());
        points.setText(Integer.toString(questionMod.getPointsPossible()));
        hint.setText(questionMod.getHint());
        if(questionMod.getDifficulty() == 1)
            easy.setSelected(true);
        else if(questionMod.getDifficulty() == 2)
            medium.setSelected(true);
        else if(questionMod.getDifficulty() == 3)
            hard.setSelected(true);
    }

}