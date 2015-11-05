package question.controllers;
import classpack.controllers.ClassPackController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import question.models.QuestionModel;
import test.controllers.TestController;
import user.controllers.UserController;

import java.io.IOException;


public class PickQuestionTypeController extends QuestionController {
    public Button EnterQuestionTypeSelection = new Button();
    public RadioButton FillInTheBlankButton = new RadioButton();
    public RadioButton MultipleChoiceButton = new RadioButton();
    public RadioButton MultipleSelectButton  = new RadioButton();
    public RadioButton FreeResponseButton  = new RadioButton();
    public RadioButton ShortAnswerButton  = new RadioButton();
    public RadioButton CodingButton  = new RadioButton();
    public RadioButton UMLButton = new RadioButton();
    public RadioButton MatchingButton = new RadioButton();

    public void  QuestionTypeChosen() throws IOException {
        QuestionModel questionModel = new QuestionModel();
        SetQuestionType();
    }

    public void SetQuestionType() throws IOException {
        Scene nextScene;
        QuestionModel questionModel = new QuestionModel();
        if(FillInTheBlankButton.isSelected()){
            questionModel.setQuestionType("FillInTheBlank");
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/FillInTheBlankQuestion.fxml"));
            Parent nextSceneParent = parentLoader.load();
            nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(MultipleChoiceButton.isSelected()){
            questionModel.setQuestionType("MultipleChoice");
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/AddMultipleChoiceView.fxml"));
            Parent nextSceneParent = parentLoader.load();
             nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(MultipleSelectButton.isSelected()){
            questionModel.setQuestionType("MultipleSlect");
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/AddMultipleSelectView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(FreeResponseButton.isSelected()){
            questionModel.setQuestionType("FreeResponse");
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/GenericQuestionView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(ShortAnswerButton.isSelected()){
            questionModel.setQuestionType("ShortAnswer");
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/GenericQuestionView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(CodingButton.isSelected()){
            questionModel.setQuestionType("Coding");
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/GenericQuestionView.fxml"));
            Parent nextSceneParent = parentLoader.load();
             nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(UMLButton.isSelected()){
            questionModel.setQuestionType("UML");
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/GenericQuestionView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(MatchingButton.isSelected()){
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/AddMatchingView.fxml"));
            Parent nextSceneParent = parentLoader.load();
             nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
            questionModel.setQuestionType("Matching");
        }
        else {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/first.fxml"));
            Parent nextSceneParent = parentLoader.load();
            nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        currStage.setScene(nextScene);
        currStage.show();
        System.out.println("Question type was selected.");
    }


}