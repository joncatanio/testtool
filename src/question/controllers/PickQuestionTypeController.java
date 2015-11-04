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