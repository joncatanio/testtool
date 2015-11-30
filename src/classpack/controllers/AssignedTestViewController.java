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


public class AssignedTestViewController extends ClassTestsViewController{


    public ListView testList;
    public Label currentTestLabel;

    //data for interface ///////////
    private ClassModel currClass;
    private TestBinModel currTest;
    private int testBinId;

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
