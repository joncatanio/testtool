package test.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Created by JonCatanio on 11/1/15.
 */
public class AddTestController extends TestController {

    public void createCustomTest() {
        System.out.println("Create a custom test.");
    }

    public void generateRandomTest() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/GenerateTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        GenerateTestController gtc = parentLoader.getController();
        gtc.populateInterface(currStage);
        gtc.populateSelectBoxes();

        currStage.setScene(nextScene);
        currStage.show();
        System.out.println("Generate a random test.");
    }
}
