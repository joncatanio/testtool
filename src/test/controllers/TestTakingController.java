package test.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.*;

import question.models.QuestionModel;
import test.models.*;

public class TestTakingController {
    /* Non-specific */
    public ListView scheduledTests = new ListView();
    public ListView completedTests = new ListView();
    public ChoiceBox selectSection = new ChoiceBox();
    protected Stage currStage;

    /* Test Info */
    public TestTakingModel curTest = new TestTakingModel();
    public Label testName = new Label();
    public Label timeLabel = new Label();
    public Label pointsLabel = new Label();
    public Label dueDateLabel = new Label();
    public Label testDescriptionLabel = new Label();
    public Label testNotesLabel = new Label();
    public Button takeTestBtn = new Button();

    /* Test Taking */
    public ListView currentQuestionList = new ListView();
    public Label currentQuestionName = new Label();
    public Label currentQuestionInfo = new Label();

    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Take Test"));

        getScheduledTests();
        getCompletedTests();

        if (curTest != null) {
            updateTestInfo();
            currentQuestionName.setText("Question " + curTest.getQuestionNum());
            currentQuestionInfo.setText("Submit the test for full credit!");
            getQuestionList();
        }
    }

    public void sectionChange(ActionEvent actionEvent) throws IOException {
        if (selectSection.getValue() == "Take Test") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestTakingView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestTakingController ttc = parentLoader.getController();
            ttc.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();

            System.out.println("Switched to viewing the take test tab");
        }
    }

    public void selectTestToView() throws IOException {
        if (scheduledTests.getEditingIndex() >= 0) {
            TestModel test = TestBankModel.getInstance().getTest(scheduledTests.getEditingIndex());
            System.out.println("Selected test: " + test.getName());

            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestInfo.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestTakingController testView = parentLoader.getController();

            curTest = new TestTakingModel(test, scheduledTests.getEditingIndex());
            updateTestInfo();
            testView.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();

            System.out.println("Switched to viewing a test");
        }
    }

    public void selectCompletedTestToView() throws IOException {
        if (completedTests.getEditingIndex() >= 0) {
            TestModel test = TestBankModel.getInstance().getTest(completedTests.getEditingIndex());
            System.out.println("Selected test: " + test.getName());

            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestInfo.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestTakingController testView = parentLoader.getController();

            curTest = new TestTakingModel(test, completedTests.getEditingIndex());
            updateTestInfo();
            testView.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();

            System.out.println("Switched to viewing a test");
        }
    }

    public void takeTest() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestQuestion.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestTakingController testView = parentLoader.getController();

        currentQuestionName.setText("Question " + curTest.getQuestionNum());
        currentQuestionInfo.setText("Submit the test for full credit!");
        getQuestionList();
        testView.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to test taking question view");
    }

    public void nextQuestion() throws IOException {
        curTest.getNextQuestion();
    }

    public void prevQuestion() throws IOException {
        curTest.getPrevQuestion();
    }

    public void showHint() throws IOException {
        curTest.getQuestionHint();
    }

    public void submitTest() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestCompleteInfo.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestTakingController testView = parentLoader.getController();
        updateTestInfo();
        testView.populateInterface(currStage);

        curTest = new TestTakingModel(curTest.getTest(), curTest.getTestIndex());

        currStage.setScene(nextScene);
        currStage.show();

        curTest.getTest().setTaken(true);
        TestHandlerModel.getInstance().grade(curTest.getTest());

        System.out.println("Submitted test!");
    }

    /* Hardcoded info here was never provided by TestModel class so was unable to implement properly */
    public void updateTestInfo() {
        testName.setText(curTest.getTestName());
        timeLabel.setText("Time Limit: 60 Minutes");
        pointsLabel.setText("Total Points: " + curTest.getTest().getTotalPoints());
        dueDateLabel.setText("Due: 10/3");
        testDescriptionLabel.setText("Description: A cumulative test of your knowledge");
        testNotesLabel.setText("Teacher notes: Good luck!!");

        currentQuestionName.setText("Question " + curTest.getQuestionNum());
        currentQuestionInfo.setText("Submit the test for full credit!");
    }

    public void getScheduledTests() {
        ArrayList<TestModel> testsScheduled = new ArrayList<>();

        /* Create a new cell factory to pull the name of the question for the ListView */
        scheduledTests.setCellFactory(lv -> new ListCell<TestModel>() {
            @Override
            public void updateItem(TestModel item, boolean empty) {
                if (!item.getTaken()) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        String text = item.getName();
                        setText(text);
                    }
                }
            }
        });

        ArrayList<TestModel> tests = TestBankModel.getInstance().getAllTests();

        for (int i = 0; i < tests.size(); i++) {
            if (!tests.get(i).getTaken()) {
                testsScheduled.add(tests.get(i));
            }
        }

        scheduledTests.setItems(FXCollections.observableArrayList(testsScheduled));
    }

    public void getCompletedTests() {
        ArrayList<TestModel> testsCompleted = new ArrayList<>();

        /* Create a new cell factory to pull the name of the question for the ListView */
        scheduledTests.setCellFactory(lv -> new ListCell<TestModel>() {
            @Override
            public void updateItem(TestModel item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    String text = item.getName();
                    setText(text);
                }
            }
        });

        ArrayList<TestModel> tests = TestBankModel.getInstance().getAllTests();

        for (int i = 0; i < tests.size(); i++) {
            if (tests.get(i).getTaken()) {
                testsCompleted.add(tests.get(i));
            }
        }

        completedTests.setItems(FXCollections.observableArrayList(testsCompleted));
    }

    public void getQuestionList() {
        ArrayList<QuestionModel> questions = new ArrayList<>();

        /* Create a new cell factory to pull the name of the question for the ListView */
        currentQuestionList.setCellFactory(lv -> new ListCell<QuestionModel>() {
            @Override
            public void updateItem(QuestionModel item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    String text = item.getQuestionName();
                    setText(text);
                }
            }
        });

        curTest.setQuestions(questions);

        currentQuestionList.setItems(FXCollections.observableArrayList(questions));
    }
}
