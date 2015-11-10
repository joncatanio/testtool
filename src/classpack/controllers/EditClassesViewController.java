package classpack.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Created by andrewgough94 on 11/7/2015.
 */
public class EditClassesViewController extends ClassPackController {
    public Button edit;
    public Button cancel;
    public Button delete;

    public void onCancel(ActionEvent x) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/ClassView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        ClassViewController assigned = parentLoader.getController();
        assigned.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void onEdit(ActionEvent x) throws IOException {
        System.out.println("Editing specified class");
    }

    public void onDelete(ActionEvent x) throws IOException {
        System.out.println("Deleting specified class");
    }
}
