package question.controllers;

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

/**
 * Created by kendall on 11/4/15.
 */


public class FillInTheBlankController extends QuestionController {
    public TextField questionName;
    public TextArea  question;
    public ChoiceBox subject;
    public ChoiceBox className;
    public TextField answer;
    public TextField points;
    public TextField image;
    public TextField hint;
    public RadioButton easy;
    public RadioButton medium;
    public RadioButton hard;
    public Button clear;

    public FillInTheBlankController(){
    }

    public void populateChoiceBoxes() {
        className.setItems(FXCollections.observableArrayList("Select", "Questions", "Tests", "Classes", "Settings"));
        subject.setItems(FXCollections.observableArrayList("Select", "Questions", "Tests", "Classes", "Settings"));
        subject.getSelectionModel().select(0);
        className.getSelectionModel().select(0);

    }

    public void AddQuestionToBank(ActionEvent actionEvent) throws IOException {
        QuestionModel questionModel = new QuestionModel();
        if(questionName.getText() != null){
            if(question.getText() != null){
                if(subject.getValue() != null){
                    if(className.getValue() != null){
                        if(answer.getText() != null){
                            if(points.getText() != null) {
                                if (easy.isSelected() || medium.isSelected() || hard.isSelected()) {
                                    questionModel.setQuestionName(questionName.getText());
                                    questionModel.setPointsPossible(Integer.parseInt(points.getText()));
                                    questionModel.setClassNumber(className.getValue().toString());
                                    questionModel.setSubject(subject.getValue().toString());
                                    questionModel.setQuestion(question.getText());
                                    questionModel.setAnswer(answer.getText());
                                    if (hint.getText() != null) {
                                        questionModel.setHint(hint.getText());
                                    }
                                    if (image.getText() != null) {
                                        questionModel.setImageFile(image.getText());
                                    }
                                    if(easy.isSelected()){
                                        questionModel.setDifficulty(1);
                                    }
                                    else if(medium.isSelected()){
                                        questionModel.setDifficulty(2);
                                    }
                                    else if(hard.isSelected()){
                                        questionModel.setDifficulty(3);
                                    }

                                    FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
                                    Parent nextSceneParent = parentLoader.load();
                                    Scene nextScene = new Scene(nextSceneParent);

                                    QuestionController test = parentLoader.getController();
                                    test.populateInterface(currStage);

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

    public void ClearAllThings(ActionEvent actionEvent) {
        questionName.clear();
        question.clear();
        subject.setValue(0);
        className.setValue(0);
        answer.clear();
        points.clear();
        image.clear();
        hint.clear();
        easy.setSelected(false);
        medium.setSelected(false);
        hard.setSelected(false);
    }

    public void Cancel(ActionEvent actionEvent) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        QuestionController test = parentLoader.getController();
        test.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }
}