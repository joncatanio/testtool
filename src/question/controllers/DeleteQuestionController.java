package question.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import utility.DBObject;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import question.models.QuestionModel;


public class DeleteQuestionController {

    public ChoiceBox selectSection = new ChoiceBox();
    public ChoiceBox selectQuestionType = new ChoiceBox();
    public QuestionModel deleteQuestion;
    protected Stage currStage;

    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(0);
        selectQuestionType.setItems(FXCollections.observableArrayList("T/F", "Fill in the blank", "SA", "MC"));
    }


    public void selectQuestion(ActionEvent actionEvent) {
        System.out.println("Selected");
    }


    public void DeleteQuestion(ActionEvent actionEvent) throws IOException {
        Scene nextScene;
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
        Parent nextSceneParent = null;
        nextSceneParent = parentLoader.load();

        nextScene = new Scene(nextSceneParent);

        QuestionController test = parentLoader.getController();
        test.tableContent = FXCollections.observableList(DBObject.getInstance().getQuestionBank());
        ArrayList<QuestionModel> db = DBObject.getInstance().getQuestionBank();
        db.remove(deleteQuestion);
        test.tableContent.remove(deleteQuestion);
        DBObject.getInstance().setQuestionBank(db);
        test.populateInterface(currStage);

        test.setUpTable();
        currStage.setScene(nextScene);
        currStage.show();

    }

    public void GoBack(ActionEvent actionEvent) throws IOException {
        Scene nextScene;
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
        Parent nextSceneParent = null;
        nextSceneParent = parentLoader.load();

        nextScene = new Scene(nextSceneParent);

        QuestionController test = parentLoader.getController();
        test.populateInterface(currStage);
        test.setUpTable();
        currStage.setScene(nextScene);
        currStage.show();
    }

}
