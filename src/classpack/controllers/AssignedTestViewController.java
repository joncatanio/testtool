package classpack.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;



public class AssignedTestViewController extends ClassTestsViewController{


    public void viewSubmissions(ActionEvent actionEvent) throws IOException{
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/SubmissionsView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        SubmissionsViewController submissions = parentLoader.getController();
        submissions.populateInterface(currStage);
        submissions.populateSubmissionsList(1, 12345);
        currStage.setScene(nextScene);
        currStage.show();
    }

}
