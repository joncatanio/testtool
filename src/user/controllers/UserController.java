package user.controllers;

import java.io.IOException;

import classpack.controllers.ClassPackController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import question.controllers.QuestionController;
import test.controllers.TestController;
import javafx.scene.control.*;

import user.models.*;

public class UserController {
    public TextField name;
    public TextField email;

    public ToggleGroup email_settings;
    public RadioButton default_email;
    public RadioButton all_email;
    public RadioButton no_email;

    public ToggleGroup timer_settings;
    public RadioButton default_timer;
    public RadioButton all_timer;
    public RadioButton no_timer;

    public ChoiceBox selectSection = new ChoiceBox();
    protected Stage currStage;

    public void populateInterface(Stage stage){
        currStage = stage;
        selectSection.setItems(FXCollections.observableArrayList("Questions", "Tests", "Classes", "Settings"));
        selectSection.getSelectionModel().select(3);
        System.out.println("Opened Settings");
    }

    public void sectionChange(ActionEvent actionEvent) throws IOException{
        if (selectSection.getValue() == "Questions") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../question/views/first.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            QuestionController first = parentLoader.getController();
            first.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
        else if (selectSection.getValue() == "Tests") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../test/views/AddTestView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            TestController test = parentLoader.getController();
            test.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
        else if (selectSection.getValue() == "Classes") {
            FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../../classpack/views/ClassView.fxml"));
            Parent nextSceneParent = parentLoader.load();
            Scene nextScene = new Scene(nextSceneParent);

            ClassPackController cp = parentLoader.getController();
            cp.populateInterface(currStage);

            currStage.setScene(nextScene);
            currStage.show();
        }
    }

    public void switchGeneral() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/SettingsView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        UserController user = parentLoader.getController();
        user.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to the general settings tab");
    }

    public void switchCustomization() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/CustomizationView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        UserController user = parentLoader.getController();
        user.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to the customization settings tab");
    }

    public void switchSecurity() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("../views/SecurityView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        UserController user = parentLoader.getController();
        user.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();

        System.out.println("Switched to the security settings tab");
    }

    /**
     * Called by the view when a user hits the "Submit" button within the general tab of the settings section.
     */
    public void updateGeneralSettings() {
        UserModel tempUser = new UserModel("reed_test", "temp_pass");

        System.out.println("Updating general user settings...");

        UserSettingsModel currentSettings = tempUser.getUserSettings();

        currentSettings.setName(name.getText());
        currentSettings.setEmail(email.getText());

        if (default_email.isSelected()) {
            currentSettings.setEmailSetting(0);
        }
        else if (all_email.isSelected()) {
            currentSettings.setEmailSetting(1);
        }
        else if (no_email.isSelected()) {
            currentSettings.setEmailSetting(2);
        }

        if (default_timer.isSelected()) {
            currentSettings.setTimerSetting(0);
        }
        else if (all_timer.isSelected()) {
            currentSettings.setTimerSetting(1);
        }
        else if (no_timer.isSelected()) {
            currentSettings.setTimerSetting(2);
        }

        tempUser.getUserSettings();

        System.out.println("...done updating!");
    }
}
