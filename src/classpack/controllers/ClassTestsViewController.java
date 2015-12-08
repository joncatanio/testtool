package classpack.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;

/**
 * Created by alexg
 *
 * ClassTestsViewController handles the view for looking at all submitted tests for a given assigned test
 */
public class ClassTestsViewController extends ClassPackController{

    /**
     * button to traverse backwards
     */
    public Button backButton = new Button();

    /**
     * label to display the current class
     */
    public Label currentClassLabel = new Label("current class");

    /**
     * add a new class
     */
    public void addClass(ActionEvent actionEvent) {
        System.out.println("Add Class");
    }

    /**
     * traverse back to list of classes
     */
    public void goBackToClasses(ActionEvent actionEvent) throws IOException {

        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/classpack/views/ClassView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        ClassViewController classes = parentLoader.getController();
        classes.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

}
