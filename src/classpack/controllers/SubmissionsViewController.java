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

public class SubmissionsViewController extends ClassTestsViewController{

    //interface elements ///////////
    public Label classAverageLabel;
    public Label classAverageTimeLabel;
    public Label currentClassLabel;
    public Label currentTestLabel;

    public Button regradeButton;
    public ListView testList;

    public TableView submissionsList;
    public TableColumn checkboxCol;
    public TableColumn nameCol;
    public TableColumn scoreCol;
    public TableColumn timeCol;
    public TableColumn viewCol;

    //data for interface ///////////
    private ClassModel currClass;
    private TestBinModel currTest;
    private int testBinId;

    // list of student submission objects goes here
    ArrayList<TestModel> submissions = new ArrayList<TestModel>();

    public void populateInterface(Stage stage, int classId, int testBinId) {
        super.populateInterface(stage);

        currClass = ClassBankModel.getInstance().getClassById(classId);
        currTest = currClass.getTestBin(testBinId);

        currentTestLabel.setText(currTest.getName());

        //populate the submissions list
        submissions = currTest.getSubmissions();

        // more info here:
        // http://stackoverflow.com/questions/20879242/get-checkbox-value-in-a-table-in-javafx
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

        //show the statistics
        classAverageLabel.setText(Double.toString( currClass.getTestBin(testBinId).getAverage() ));
        classAverageTimeLabel.setText(Double.toString( currClass.getTestBin(testBinId).getAverageTimeInMinutes() ));

        //populate the tests sidebar
        ArrayList<TestModel> sidebarTests = ClassBank.getInstance().getClass(classId).getTests();
        ArrayList<String> testNames = new ArrayList<String>();
        for( TestModel test: sidebarTests) {
            testNames.add(test.getName());
        }

        testList.setItems(FXCollections.observableArrayList(testNames));
        currentClassLabel.setText(currClass.getClassName());

    }

    public void viewAssignedTest(ActionEvent actionEvent) throws IOException {

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/AssignedTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        AssignedTestViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage, 1231);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void regradeSelectedSubmissions(ActionEvent actionEvent) {

        for ( int i = 0; i < submissionsList.getItems().size(); i++ ) {
            CheckBox temp = (CheckBox) submissionsList.getItems().get(i);
            if ( temp.isSelected()) {
                currClass.getTestBin(testBinId).regradeSubmission(submissions.get(i).getId());
            }
        }
    }

}
