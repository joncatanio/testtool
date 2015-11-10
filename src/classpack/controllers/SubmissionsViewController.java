package classpack.controllers;

//import com.sun.tools.javac.comp.Check;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.*;
import classpack.models.*;

public class SubmissionsViewController extends ClassTestsViewController{

    public Label classAverageLabel;

    public ListView submissionsList;
    public Button regradeButton;

    private ClassModel currClass;
    private int testBinId;
    private int classId;

    // list of student submission objects goes here
    ArrayList<String> submissions = new ArrayList<String>();

    public void populateSubmissionsList(int classId, int testBinId) {

        this.testBinId = testBinId;
        this.classId = classId;

        currClass = new ClassModel(); // = ClassDB.getClassById( classId );
        submissions = currClass.getTestBin(testBinId).getSubmissions();

        classAverageLabel.setText(Double.toString( currClass.getTestBin(testBinId).getAverage() ));

        for (int i = 0; i < submissions.size(); i++) {
            submissionsList.getItems().add(new CheckBox(submissions.get(i)));
        }

    }

    public void viewAssignedTest(ActionEvent actionEvent) throws IOException {

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/AssignedTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        AssignedTestViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void regradeSelectedSubmissions(ActionEvent actionEvent) {

        ArrayList<Integer> ids = new ArrayList<Integer>();

        for ( int i = 0; i < submissionsList.getItems().size(); i++ ) {
            CheckBox temp = (CheckBox) submissionsList.getItems().get(i);
            if ( temp.isSelected()) {
                //System.out.println(temp.getText() + " regraded");
                ids.add(123);
            }
        }

        currClass.getTestBin(testBinId).regradeForSubmissions(ids);

    }
}
