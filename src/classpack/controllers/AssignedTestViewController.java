package classpack.controllers;

import classpack.models.ClassBankModel;
import classpack.models.ClassModel;
import classpack.models.TestBinModel;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alexg
 *
 * AssignedTestViewController handles the view for looking at a given assigned test
 */
public class AssignedTestViewController extends ClassTestsViewController{

    /**
     * label to display class average score
     */
    public ListView testList;

    /**
     * label to display class average score
     */
    public Label currentTestLabel;

    /**
     * holds data on the current class
     */

    private ClassModel currClass;

    /**
     * label to display class average score
     */
    private TestBinModel currTest;

    /**
     * id of the current test/testbin
     */
    private int testBinId;

    /**
     * sets up the interface with necessary UI elements and appropriate data
     */
    public void populateInterface(Stage stage, int classId, int testBinId) {
        super.populateInterface(stage);

        currClass = ClassBankModel.getInstance().getClassById(classId);
        currTest = currClass.getTestBin(testBinId);

        currentTestLabel.setText(currTest.getName());

        //populate the tests sidebar
        ArrayList<TestBinModel> sidebarTests = ClassBankModel.getInstance().getClassById(classId).getTestBins();
        ArrayList<String> testNames = new ArrayList<String>();
        for( TestBinModel testBin: sidebarTests) {
            testNames.add(testBin.getName());
        }

        testList.setItems(FXCollections.observableArrayList(testNames));
        currentClassLabel.setText(currClass.getClassName());
    }

    /**
     * transfers view to view a list of test submissions for currently viewed assigned test
     */
    public void viewSubmissions(ActionEvent actionEvent) throws IOException{
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/SubmissionsView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        SubmissionsViewController submissions = parentLoader.getController();
        submissions.populateInterface(currStage, 23423, 23423);
        currStage.setScene(nextScene);
        currStage.show();
    }


}
