package user.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by rgarmsen on 11/4/15.
 */
public class CustomizationController {
    protected Stage currStage;

    public void populateInterface(Stage stage){
        currStage = stage;
    }

    public void switchToCustomization(ActionEvent actionEvent) throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("./CustomizationView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        CustomizationController first = parentLoader.getController();
        first.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }
}
