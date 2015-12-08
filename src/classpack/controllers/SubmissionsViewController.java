package classpack.controllers;

//import com.sun.tools.javac.comp.Check;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.*;
import classpack.models.*;
import javafx.stage.Stage;
import javafx.util.*;

import test.models.TestModel;


/**
 * Created by alexg
 *
 * SubmissionsViewController handles the view for looking at all submitted tests for a given assigned test
 */
public class SubmissionsViewController extends ClassTestsViewController{

    /**
     * label to display class average score
     */
    public Label classAverageLabel;

    /**
     * label to display average elapsed time to take the test
     */
    public Label classAverageTimeLabel;

    /**
     * label to display current class name
     */
    public Label currentClassLabel;

    /**
     * label to display current test label
     */
    public Label currentTestLabel;

    /**
     * button to call for a regrade of currently selected test submissions
     */
    public Button regradeButton;

    /**
     * list of tests assigned to current class
     */
    public ListView testList;

    /**
     * list of submitted tests for current assigned test
     */
    public TableView submissionsList;

    /**
     * column to display regrade checkbox
     */
    public TableColumn checkboxCol;

    /**
     * column to display name
     */
    public TableColumn nameCol;

    /**
     * column to display score
     */
    public TableColumn scoreCol;

    /**
     * column to display elapsed time
     */
    public TableColumn timeCol;

    /**
     *  column to display button to view individual submitted test
     */
    public TableColumn viewCol;

    /**
     *  holds data for current class
     */
    private ClassModel currClass;

    /**
     * holds data for current assigned test
     */
    private TestBinModel currTest;

    /**
     *  id of the current test/testbin
     */
    private int testBinId;

    /**
     * submissions holds all of the submissions currently being viewed in the testList
     */
    ArrayList<TestModel> submissions = new ArrayList<TestModel>();

    /**
     * sets up the interface with necessary UI elements and appropriate data
     */
    public void populateInterface(Stage stage, int classId, int testBinId) {
        super.populateInterface(stage);

        currClass = ClassBankModel.getInstance().getClassById(classId);
        currTest = currClass.getTestBin(testBinId);

        currentTestLabel.setText(currTest.getName());

        /*
         * populate the submissions list
         */
        submissions = currTest.getSubmissions();

        /*
         * more info here:
         * http://stackoverflow.com/questions/20879242/get-checkbox-value-in-a-table-in-javafx
         */
        checkboxCol.setCellValueFactory(new PropertyValueFactory<TestModel, Boolean>("checked"));

        checkboxCol.setCellFactory(new Callback<TableColumn<TestModel, Boolean>, TableCell<TestModel, Boolean>>() {

            public TableCell<TestModel, Boolean> call(TableColumn<TestModel, Boolean> p) {
                return new CheckBoxTableCell<TestModel, Boolean>();
            }
        });


        nameCol.setCellValueFactory(
                new PropertyValueFactory<TestModel, String>("name"));
        scoreCol.setCellValueFactory(
                new PropertyValueFactory<TestModel, String>("score"));
        timeCol.setCellValueFactory(
                new PropertyValueFactory<TestModel, String>("time"));

        for (int i = 0; i < submissions.size(); i++) {
            submissionsList.getItems().add(submissions.get(i));
            // new CheckBox(submissions.get(i).getName())
        }

        /*
         * show the statistics
         */
        classAverageLabel.setText(Double.toString( currClass.getTestBin(testBinId).getAverage() ));
        classAverageTimeLabel.setText(Double.toString( currClass.getTestBin(testBinId).getAverageTimeInMinutes() ));

        /*
         * populate the tests sidebar
         */
        ArrayList<TestBinModel> sidebarTests = ClassBankModel.getInstance().getClassById(classId).getTestBins();
        ArrayList<String> testNames = new ArrayList<String>();
        for( TestBinModel testBin: sidebarTests) {
            testNames.add(testBin.getName());
        }

        testList.setItems(FXCollections.observableArrayList(testNames));
        currentClassLabel.setText(currClass.getClassName());

    }

    /**
     * transfers view to view a a specific assigned test
     */
    public void viewAssignedTest(ActionEvent actionEvent) throws IOException {

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/AssignedTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        AssignedTestViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage, 1231, 1231);

        currStage.setScene(nextScene);
        currStage.show();
    }

    /**
     * calls a regrade for the submissions that have been check
     */
    public void regradeSelectedSubmissions(ActionEvent actionEvent) {

        for ( int i = 0; i < submissionsList.getItems().size(); i++ ) {
            CheckBox temp = (CheckBox) submissionsList.getItems().get(i);
            if ( temp.isSelected()) {
                currClass.getTestBin(testBinId).regradeSubmission(submissions.get(i).getId());
            }
        }
    }

}
