/****
 *
 * The QuestionController Class is used to set up to populate QuestionBank table
 * from the questions held in the Database object. It also provides methods
 * that interact wtih the user such as when a user clickw on a question in the bank
 * a new new page is loaded. FUnctions include adding a question and changing the workflow.
 *
 *
 * Kendall Gassner (kendall.gassner@yahoo.com)
 *
 */

package question.controllers;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import utility.DBObject;
import classpack.controllers.ClassPackController;
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

    /**
     * testLabel for the test.
     *
     */
    public Label testLabel;

    /**
     * selectSection allows you to move from the question bank to
     * different packages.
     *
     */
    public ChoiceBox selectSection = new ChoiceBox();

    /**
     * selectQuestionType selects the type of question the user wishes to add.
     *
     */
    public ChoiceBox selectQuestionType = new ChoiceBox();

    /**
     * addQuestionButton allows user to add a question to the bank
     *
     */
    public Button addQuestionButton = new Button();

    /**
     * QuestionBank table.
     *
     */
    public TableView<QuestionModel> table;

    /**
     * title column in bank
     *
     */
    public TableColumn<QuestionModel, String> title;

    /**
     * className column in bank
     *
     */
    public TableColumn<QuestionModel, String> classType;

    /**
     * subject column in bank
     *
     */
    public TableColumn<QuestionModel, String> subject;

    /**
     * type of question column in bank
     *
     */
    public TableColumn<QuestionModel, String> type;

    /**
     * date column in bank
     *
     */
    public TableColumn<QuestionModel, String> date;

    /**
     * difficulty column in bank
     *
     */
    public TableColumn<QuestionModel, Integer> difficulty;

    /**
     * table content in the bank column in bank
     *
     */
    public ObservableList<QuestionModel> tableContent;

    /**
     * currStage holds the current view.
     *
     */
    protected Stage currStage;

    /**
     * populateInterface is used to set the ArrayLists for dropdown menus and it calls getQuestions
     * to get the Data bases stored questions
     *
     */
    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(0);
        selectQuestionType.setItems(FXCollections.observableArrayList("T/F", "Fill in the blank", "SA", "MC"));
        getQuestions();
    }

    /**
     * setUpTable sets the type and object each column will contain in the table
     * and it fills the Question bank table with questions from the data base. A Listener is added
     * to the table. If a question is clicked then the user will be prompted with an option
     * to delete the question.
     *
     */
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

    /**
    * SectionChange is a function that loads a new workflow based on the users action
    *
    */
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

    /**
     * selectQuestion prints a message if the question is selected.
     *
     */
    public void selectQuestion(ActionEvent actionEvent) {
        System.out.println("Selected");
    }

    /**
     * PickNewQuestion loads the a scene where the user will be able to pick the type
     * of question he or she will want to add to the questionBank
     *
     */
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

    /**
     * getQuestion returns an observable list of questions stored in
     * the DataBase.
     *
     */
    public void getQuestions(){
        tableContent = FXCollections.observableList(DBObject.getInstance().getQuestionBank());
    }

    /**
     * FilterByType is a function that filters the questionBank
     * based on the type of question the user requests to filter by
     *
     */
    public void FilterByType(ActionEvent actionEvent) throws IOException {
        filterBy("Type", ((Button)actionEvent.getSource()).getText());
    }

    /**
     * FilterByEasy is a function that filters the questionBank
     * if the user selects "easy" in the filtering side bar
     *
     */
    public void FilterByEasy(ActionEvent actionEvent) throws IOException {
        filterBy("difficulty", "1");
    }

    /**
     * FilterByMedium is a function that filters the questionBank
     * if the user selects "medium" in the filtering side bar
     *
     */
    public void FilterByMedium(ActionEvent actionEvent) throws IOException {
        filterBy("difficulty", "2");
    }

    /**
     * FilterByDifficult is a function that filters the questionBank
     * if the user selects "hard" in the filtering side bar
     *
     */
    public void FilterByDifficult(ActionEvent actionEvent) throws IOException {
        filterBy("difficulty", "3");
    }

    /**
     * FilterBy is a function that reloads the Question workflow
     * with an updated questionBank containing only the requested filtered
     * questions
     *
     */
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

    /**
     * getFiltered returns an ObservableList of the filtered questions
     *
     */
    public ObservableList<QuestionModel> getFiltered(String filter, String filterType){

       if(filter.equals("Type")){
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