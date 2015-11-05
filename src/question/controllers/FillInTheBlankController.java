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



    public FillInTheBlankController(){
    }

    public void populateChoiceBoxes() {
        className.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        subject.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
    }

    public void AddQuestionToBank(ActionEvent actionEvent) throws IOException {
        QuestionModel questionModel = new QuestionModel();
        if(questionName.getText() != null){
            if(question.getText() != null){
                if(subject.getValue() != null){
                    if(className.getValue() != null){
                        if(answer.getText() != null){
                            if(points.getText() != null){
                            questionModel.setQuestionName(questionName.getText());
                            questionModel.setPointsPossible(Integer.parseInt(points.getText()));
                            questionModel.setClassNumber(className.getValue().toString());
                            questionModel.setSubject(subject.getValue().toString());
                            questionModel.setQuestion(question.getText());
                            questionModel.setAnswer(answer.getText());
                            if(hint.getText() != null){
                                questionModel.setHint(hint.getText());
                            }
                            if(image.getText() != null){
                                questionModel.setImageFile(image.getText());
                            }
                                FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/first.fxml"));
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