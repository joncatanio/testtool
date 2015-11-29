package classpack.controllers;

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


public class AssignedTestViewController extends ClassTestsViewController{


    public ListView testList;

    public void populateInterface(Stage stage, int classId) {
        super.populateInterface(stage);
        populateTestList(classId);
    }

    public void viewSubmissions(ActionEvent actionEvent) throws IOException{
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/SubmissionsView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        SubmissionsViewController submissions = parentLoader.getController();
        submissions.populateInterface(currStage, 23423);
        currStage.setScene(nextScene);
        currStage.show();
    }

    public void populateTestList(int classId) {
        //class db . getClass( classId ) . getTests();
        testList.setItems(FXCollections.observableArrayList("test A", "test B", "test C", "test D"));
    }
}
