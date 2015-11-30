/****
 *
 * The DeleteQuestionController Class is used whena question in the question bank
 * is clicked on. This controller will take care of removing a question from the bank
 * on users request.
 *
 *
 * Kendall Gassner (kendall.gassner@yahoo.com)
 *
 */

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

    /*
     * populateInterface is used to set the ArrayLists for dropdown menus and it calls getQuestions
     * to get the Data bases stored questions
     *
     */
    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(0);
        selectQuestionType.setItems(FXCollections.observableArrayList("T/F", "Fill in the blank", "SA", "MC"));
    }


    public void selectQuestion(ActionEvent actionEvent) {
        System.out.println("Selected");
    }

    /*
     * DeleteQuestion is a function that is called when a user presses the deleteQuestion button
     * this function removes the question from the DataBase and removes the question from the table
     * in the questionBank.
     *
     */
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

    /*
     * GoBack is a function that allows a user to go back to the test bank without
     * deleting the question that is selected.
     *
     */
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
