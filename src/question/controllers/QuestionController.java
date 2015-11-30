package question.controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import utility.DBObject;
import classpack.controllers.ClassPackController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    public ObservableList<QuestionModel> tableContent;

    protected Stage currStage;

    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(0);
        selectQuestionType.setItems(FXCollections.observableArrayList("T/F", "Fill in the blank", "SA", "MC"));
        getQuestions();
    }


    public void setUpTable(){
        title.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("questionName"));
        classType.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("classNumber"));
        subject.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("subject"));
        type.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("questionType"));
        date.setCellValueFactory(new PropertyValueFactory<QuestionModel, String>("date"));
        difficulty.setCellValueFactory(new PropertyValueFactory<QuestionModel, Integer>("difficulty"));

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // just in case you didnt already set the selection model to multiple selection.
        table.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>()
        {
            @Override
            public void onChanged(Change<? extends Integer> change){
                Scene nextScene;
                FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/DeleteQuestion.fxml"));
                Parent nextSceneParent = null;
                try {
                    nextSceneParent = parentLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                nextScene = new Scene(nextSceneParent);

                DeleteQuestionController test = parentLoader.getController();
                test.deleteQuestion = table.getSelectionModel().getSelectedItem();
                test.populateInterface(currStage);
                currStage.setScene(nextScene);
                currStage.show();
            }

        });
        table.setItems(tableContent);
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

    public void getQuestions(){
        tableContent = FXCollections.observableList(DBObject.getInstance().getQuestionBank());
    }


    public void FilterByFIllIn(ActionEvent actionEvent) throws IOException {
        filterBy("Type", "Fill in The Blank");
    }

    public void FilterByShortAnswer(ActionEvent actionEvent) throws IOException {
        filterBy("Type", "Short Answer");
    }

    public void FilterByFreeResponse(ActionEvent actionEvent) throws IOException {
        filterBy("Type", "Free Response");
    }

    public void FilterByUML(ActionEvent actionEvent) throws IOException {
        filterBy("Type", "UML");
    }

    public void FilterByMultipleChoice(ActionEvent actionEvent) throws IOException {
        filterBy("Type", "Multiple Choice");
    }

    public void FilterByMultipleSelect(ActionEvent actionEvent) throws IOException {
        filterBy("Type", "Multiple Select");
    }

    public void FilterByMatching(ActionEvent actionEvent) throws IOException {
        filterBy("Type", "Matching");
    }

    public void FilterByCoding(ActionEvent actionEvent) throws IOException {
        filterBy("Type", "Coding");
    }

    public void FilterByEasy(ActionEvent actionEvent) throws IOException {
        filterBy("difficulty", "1");
    }
    public void FilterByMedium(ActionEvent actionEvent) throws IOException {
        filterBy("difficulty", "2");
    }
    public void FilterByDifficult(ActionEvent actionEvent) throws IOException {
        filterBy("difficulty", "3");
    }

    public void filterBy(String filter, String filterType) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        QuestionController first = parentLoader.getController();

        first.populateInterface(currStage);
        first.tableContent = getFiltered(filter, filterType);
        first.setUpTable();


        currStage.setScene(nextScene);
        currStage.show();
    }

    public ObservableList<QuestionModel> getFiltered(String filter, String filterType){

       if(filter.equals("Type")){
           System.out.println(DBObject.getInstance().QuestionsByType(filterType));
           return FXCollections.observableList(DBObject.getInstance().QuestionsByType(filterType));

       }
       else if(filter.equals("difficulty")){
           return FXCollections.observableList(DBObject.getInstance().QuestionsByDifficulty(Integer.parseInt(filterType)));
       }
       else{
           return FXCollections.observableList(DBObject.getInstance().getQuestionBank());
       }
    }




}