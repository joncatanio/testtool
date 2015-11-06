package classpack.controllers;

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

    // list of student submission objects goes here
    ArrayList<String> submissions = new ArrayList<String>();

    public void populateSubmissionsList() {

        ClassModel currClass = new ClassModel();
        submissions = currClass.getSubmissionsFromBin(777);

        for (int i = 0; i < submissions.size(); i++) {
            submissionsList.getItems().add(new CheckBox(submissions.get(i)));
        }

    }

    public void viewAssignedTest(ActionEvent actionEvent) throws IOException {

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../classpack/views/AssignedTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        AssignedTestViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void regradeSelectedSubmissions(ActionEvent actionEvent) {
    }
}
