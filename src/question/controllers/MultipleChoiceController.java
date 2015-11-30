/****
 *
 * The MultipleChoiceController Class is used when a the user is creating a multiple choice question.
 * This controller will add a multiple choice question to the database and to the table.
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


public class MultipleChoiceController extends QuestionController {
    public TextField questionName;
    public TextArea  question;
    public ChoiceBox subjects;
    public ChoiceBox className;
    public TextField answer;
    public TextField b;
    public TextField c;
    public TextField d;
    public TextField points;
    public TextField image;
    public TextField hint;
    public RadioButton easy;
    public RadioButton medium;
    public RadioButton hard;
    public Button clear;

    public MultipleChoiceController(){
    }

    /*
     * populateChoiceBoxes is used to set the ArrayLists for dropdown menus and it calls getQuestions
     * to get the Data bases stored questions
     *
     */
    public void populateChoiceBoxes() {
        className.setItems(FXCollections.observableArrayList("Select", "Questions", "Tests", "Classes", "Settings"));
        subjects.setItems(FXCollections.observableArrayList("Select", "Questions", "Tests", "Classes", "Settings"));
        subjects.getSelectionModel().select(0);
        className.getSelectionModel().select(0);

    }

    /*
     * AddQuestionToBank will add the fill in the blank question only if the user has
     * filled out the following fields: title, question, subject, class, answer
     * points possible, other options, and difficulty. Points possible must be an integer.
     *
     */
    public void AddQuestionToBank(ActionEvent actionEvent) throws IOException {
        QuestionModel questionModel = new QuestionModel();
        ArrayList<QuestionModel> questionBank  = DBObject.getInstance().getQuestionBank();
        if(questionName.getText() != null){
            if(question.getText() != null){
                if(subjects.getValue() != null){
                    if(className.getValue() != null){
                        if(answer.getText() != null){
                            if(points.getText() != null) {
                                if(b.getText() != null) {
                                    if (c.getText() != null) {
                                        if (d.getText() != null) {
                                            if (easy.isSelected() || medium.isSelected() || hard.isSelected()) {
                                                questionModel.setQuestionName(questionName.getText());
                                                questionModel.setPointsPossible(Integer.parseInt(points.getText()));
                                                questionModel.setClassNumber(className.getValue().toString());
                                                questionModel.setSubject(subjects.getValue().toString());
                                                questionModel.setQuestion(question.getText());
                                                questionModel.setAnswer(answer.getText());
                                                questionModel.setB(b.getText());
                                                questionModel.setC(c.getText());
                                                questionModel.setD(d.getText());

                                                if (hint.getText() != null) {
                                                    questionModel.setHint(hint.getText());
                                                }
                                                if (image.getText() != null) {
                                                    questionModel.setImageFile(image.getText());
                                                }
                                                if (easy.isSelected()) {
                                                    questionModel.setDifficulty(1);
                                                } else if (medium.isSelected()) {
                                                    questionModel.setDifficulty(2);
                                                } else if (hard.isSelected()) {
                                                    questionModel.setDifficulty(3);
                                                }
                                                questionModel.setQuestionType("Multiple Choice");
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
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

    }


    /*
     * ClearAllThings clears all of the fields in the fill in the blank GUI.
     *
     */
    public void ClearAllThings(ActionEvent actionEvent) {
        questionName.clear();
        question.clear();
        subjects.setValue(0);
        className.setValue(0);
        answer.clear();
        b.clear();
        c.clear();
        d.clear();
        points.clear();
        image.clear();
        hint.clear();
        easy.setSelected(false);
        medium.setSelected(false);
        hard.setSelected(false);
    }

    /*
     * Cancel takes the user back to the question bank and does not add the question
     * to the database.
     *
     */
    public void Cancel(ActionEvent actionEvent) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        QuestionController test = parentLoader.getController();
        test.populateInterface(currStage);
        test.setUpTable();

        currStage.setScene(nextScene);
        currStage.show();
    }
}