package test.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by JonCatanio on 11/27/15.
 */
public class TestTakingController {
    public ChoiceBox selectSection = new ChoiceBox();
    protected Stage currStage;

    public void populateInterface(Stage stage) {
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Take Test"));
    }

    public void sectionChange(ActionEvent actionEvent) throws IOException {
        if (selectSection.getValue() == "Take Test") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestTakingView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestTakingController ttc = parentLoader.getController();
            ttc.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
    }
}
