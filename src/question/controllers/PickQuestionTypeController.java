/****
 *
 * The PickQuestionTypeController Class is used when a user wishes to add a question.
 * This class is used to decide which question type the user will be adding.
 *
 *
 * Kendall Gassner (kendall.gassner@yahoo.com)
 *
 */

package question.controllers;
import utility.DBObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import question.models.QuestionModel;

import java.io.IOException;
import java.util.ArrayList;


public class PickQuestionTypeController extends QuestionController {

    /**
     * EnterQuestionTypeSelection is the enter
     * button at the bottom of the screen
     *
     */
    public Button EnterQuestionTypeSelection = new Button();

    /**
     * FillInTheBlankButton is the radio button to select
     * fill in the blank.
     *
     */
    public RadioButton FillInTheBlankButton = new RadioButton();

    /**
     * MultipleChoiceButton is the radio button to select
     * Multiple Choice.
     *
     */
    public RadioButton MultipleChoiceButton = new RadioButton();

    /**
     * MultipleSelectButton is the radio button to select
     * multiple select.
     *
     */
    public RadioButton MultipleSelectButton  = new RadioButton();

    /**
     * FreeResponseButton is the radio button to select
     * Free Response.
     *
     */
    public RadioButton FreeResponseButton  = new RadioButton();

    /**
     * ShortAnswerButton is the radio button to select
     * Short answer.
     *
     */
    public RadioButton ShortAnswerButton  = new RadioButton();

    /**
     * CodingButton is the radio button to select
     * Coding.
     */
    public RadioButton CodingButton  = new RadioButton();

    /**
     * UMLButton is the radio button to select
     * UML.
     *
     */
    public RadioButton UMLButton = new RadioButton();

    /**
     * MatchingButton is the radio button to select
     * Matching.
     *
     */
    public RadioButton MatchingButton = new RadioButton();


    /**
     * QuestionTypeChosen is called when a user selects a question type and presses
     * enter.
     *
     */
    public void  QuestionTypeChosen() throws IOException {
        QuestionModel questionModel = new QuestionModel();
        SetQuestionType();
    }

    /**
     * SetQuestionType loads an editQuestion scene based on
     * what type of question the user has selected/
     *
     */
    public void SetQuestionType() throws IOException {
        Scene nextScene;
        if(FillInTheBlankButton.isSelected()){
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/FillInTheBlankQuestion.fxml"));
            Parent nextSceneParent = parentLoader.load();
            nextScene = new Scene(nextSceneParent);

            FillInTheBlankController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(MultipleChoiceButton.isSelected()){
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/MultipleChoice.fxml"));
            Parent nextSceneParent = parentLoader.load();
             nextScene = new Scene(nextSceneParent);

            MultipleChoiceController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(MultipleSelectButton.isSelected()){
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/MultipleSelect.fxml"));
            Parent nextSceneParent = parentLoader.load();
            nextScene = new Scene(nextSceneParent);

            MultipleSelectController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else if(MatchingButton.isSelected()){
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/Matching.fxml"));
            Parent nextSceneParent = parentLoader.load();
             nextScene = new Scene(nextSceneParent);

            MatchingController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.populateChoiceBoxes();
        }
        else {
            genericGenerator();
            return;
        }
        currStage.setScene(nextScene);
        currStage.show();
    }

    /**
     * genericGenerator loads an generic question view model
     * and creates a new question
     *
     */
    public void genericGenerator() throws IOException {
        Scene nextScene;
        QuestionModel questionModel = new QuestionModel();
        if(CodingButton.isSelected()){
            questionModel.setQuestionType("Coding");
        }
        else if(FreeResponseButton.isSelected()){
            questionModel.setQuestionType("Free Response");
        }
        else if(ShortAnswerButton.isSelected()){
            questionModel.setQuestionType("ShortAnswer");
        }
        else if(UMLButton.isSelected()){
            questionModel.setQuestionType("UML");
        }
        else{
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
            Parent nextSceneParent = parentLoader.load();
            nextScene = new Scene(nextSceneParent);

            QuestionController test = parentLoader.getController();
            test.populateInterface(currStage);
            test.setUpTable();
            currStage.setScene(nextScene);
            currStage.show();
            return;
        }
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/GenericQuestionView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        nextScene = new Scene(nextSceneParent);

        GenericQuestionController test = parentLoader.getController();
        test.populateInterface(currStage);
        test.initializeQuestionModel(questionModel);
        currStage.setScene(nextScene);
        currStage.show();

    }
}