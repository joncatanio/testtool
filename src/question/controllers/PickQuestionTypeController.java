package question.controllers;
import classpack.controllers.ClassPackController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import question.models.QuestionModel;
import test.controllers.TestController;
import user.controllers.UserController;

import java.io.IOException;


public class PickQuestionTypeController {

    public ChoiceBox selectSection = new ChoiceBox();
    public ChoiceBox selectQuestionType = new ChoiceBox();
    public Button EnterQuestionTypeSelection = new Button();
    public RadioButton FillInTheBlankButton = new RadioButton();
    public RadioButton MultipleChoiceButton = new RadioButton();
    public RadioButton MultipleSelectButton  = new RadioButton();
    public RadioButton FreeResponseButton  = new RadioButton();
    public RadioButton ShortAnswerButton  = new RadioButton();
    public RadioButton CodingButton  = new RadioButton();
    public RadioButton UMLButton = new RadioButton();
    public RadioButton MatchingButton = new RadioButton();

    private QuestionModel questionModel = new QuestionModel();

    protected Stage currStage;

    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(0);

        selectQuestionType.setItems(FXCollections.observableArrayList("T/F", "Fill in the blank", "SA", "MC"));
    }

    public void sectionChange(ActionEvent actionEvent) throws IOException {
        if (selectSection.getValue() == "Tests") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../test/views/AddTestView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestController test = parentLoader.getController();
            test.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        } else if (selectSection.getValue() == "Classes") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../classpack/views/ClassView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            ClassPackController cp = parentLoader.getController();
            cp.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        } else if (selectSection.getValue() == "Settings") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../user/views/SettingsView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            UserController user = parentLoader.getController();
            user.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
    }

    public void selectQuestion(ActionEvent actionEvent) {
        System.out.println("Selected");
    }

    public void  QuestionTypeChosen() throws IOException {
        SetQuestionType();

        if (questionModel.getQuestionType() == "FreeResponse" ||
                questionModel.getQuestionType() == "ShortAnswer" ||
                questionModel.getQuestionType() == "LongAnswer" ||
                questionModel.getQuestionType() == "Coding" ||
                questionModel.getQuestionType() == "UML") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/GenericQuestionView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            QuestionController gqc = parentLoader.getController();
            gqc.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
            System.out.println("Question type " + questionModel.getQuestionType() + " was selected.");
        }
        else {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/first.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            QuestionController test = parentLoader.getController();
            test.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
            System.out.println("Question type was selected.");
        }
    }
    public void SetQuestionType() {
        if(FillInTheBlankButton.isSelected()){
            questionModel.setQuestionType("FillInTheBlank");
        }
        else if(MultipleChoiceButton.isSelected()){
            questionModel.setQuestionType("MultipleChoice");
        }
        else if(MultipleSelectButton.isSelected()){
            questionModel.setQuestionType("MultipleSlect");
        }
        else if(FreeResponseButton.isSelected()){
            questionModel.setQuestionType("FreeResponse");
        }
        else if(ShortAnswerButton.isSelected()){
            questionModel.setQuestionType("ShortAnswer");
        }
        else if(CodingButton.isSelected()){
            questionModel.setQuestionType("Coding");
        }
        else if(UMLButton.isSelected()){
            questionModel.setQuestionType("UML");
        }
        else if(MatchingButton.isSelected()){
            questionModel.setQuestionType("Matching");
        }
    }


}