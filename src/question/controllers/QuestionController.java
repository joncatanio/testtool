package question.controllers;

import java.io.IOException;
import java.util.ResourceBundle;

import classpack.controllers.ClassPackController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import question.models.QuestionModel;
import test.controllers.TestController;
import user.controllers.UserController;

public class QuestionController {

    public Label testLabel;
    public ChoiceBox selectSection = new ChoiceBox();
    public ChoiceBox selectQuestionType = new ChoiceBox();
    public Button addQuestionButton = new Button();
    public TableView<QuestionModel> table;
    public TableColumn<QuestionModel, String> title;
    public TableColumn<QuestionModel, String> classType;
    public TableColumn<QuestionModel, String> subject;
    public TableColumn<QuestionModel, String> type;
    public TableColumn<QuestionModel, String> date;
    public TableColumn<QuestionModel, Integer> difficulty;

    protected Stage currStage;

    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(0);
        selectQuestionType.setItems(FXCollections.observableArrayList("T/F", "Fill in the blank", "SA", "MC"));
    }


    public void  setUpTable(){
        title.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("questionName"));
        classType.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("classNumber"));
        subject.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("subject"));
        type.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("questionType"));
        date.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("date"));
        difficulty.setCellValueFactory(new PropertyValueFactory<QuestionModel, Integer>("difficulty"));

        table.setItems(getQuestions());
    }

    public void sectionChange(ActionEvent actionEvent) throws IOException{
        if (selectSection.getValue() == "Tests") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/AddTestView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestController test = parentLoader.getController();
            test.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
        else if (selectSection.getValue() == "Classes") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/ClassView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            ClassPackController cp = parentLoader.getController();
            cp.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
        else if (selectSection.getValue() == "Settings") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/user/views/SettingsView.fxml"));
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


    public void PickNewQuestion() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/PickQuestionType.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        PickQuestionTypeController test = parentLoader.getController();
        test.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
        System.out.println("Select a Question type.");
    }

    public ObservableList<QuestionModel> getQuestions(){
        ObservableList<QuestionModel> questionBank = FXCollections.observableArrayList();
        questionBank.add(new QuestionModel("FillInTheBlank", "52", "334", "CSC", "DOES this work?", "", "", "no", -1, 2, 100, 1));
        questionBank.add(new QuestionModel("MultipleChoice", "2", "34", "MATH", "DOES this work?", "", "", "yes", 5, 2, 600, 2));
        questionBank.add(new QuestionModel("FillInTheBlank", "1", "222", "CSC", "DOES this work?", "", "", "no", -1, 2, 50, 3));
        questionBank.add(new QuestionModel("ShortAnswer", "44", "229", "CSC", "DOES this work?", "", "", "no", -1, 6, 200, 4));
        questionBank.add(new QuestionModel("FreeResponse", "22", "111", "CPE", "DOES this work?", "", "", "no", -1, 5, 300, 5));
        return questionBank;
    }




}