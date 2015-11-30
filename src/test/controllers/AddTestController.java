package test.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import test.models.TestModel;

import java.io.IOException;

/**
 * Created by JonCatanio on 11/1/15.
 */
public class AddTestController extends TestController {

    public void createCustomTest() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/CustomEditTestView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        CustomEditTestController cetc = parentLoader.getController();

        /* Set the instance of the new test in the controller. */
        TestModel customTest = new TestModel("New Test");
        cetc.setTestInstance(customTest);

        /* Add the test to the ListView. */
        testBank.addTest(customTest);

        /* Populate the interface with the new test in the test bank sidebar. */
        cetc.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void generateRandomTest() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/GenerateTestView.fxml"));
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
