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
    // General tab
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

    // Customization tab
    public ChoiceBox color_options = new ChoiceBox();

    //Security tab
    public TextField current_password;
    public TextField new_password;
    public TextField confirm_password;

    public CheckBox ferpa_setting;

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

    /**
     * Switches the active tab to the General tab in the Settings section.
     * @throws IOException
     */
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

    /**
     * Switches the active tab to the Customization tab in the Settings section.
     * @throws IOException
     */
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

    /**
     * Switches the active tab to the Security tab in the Settings section.
     * @throws IOException
     */
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

    /**
     * Called by the view when a user hits the "Submit" button within the customization tab of the settings section.
     */
    public void updateCustomizationSettings() {
        UserModel tempUser = new UserModel("reed_test", "temp_pass");

        System.out.println("Updating customization user settings...");

        UserSettingsModel currentSettings = tempUser.getUserSettings();

        currentSettings.setThemeColor(color_options.toString());

        tempUser.getUserSettings();

        System.out.println("...done updating!");
    }

    /**
     * Called by the view when a user hits the "Submit" button within the security tab of the settings section.
     */
    public void updateSecuritySettings() {
        UserModel tempUser = new UserModel("reed_test", "temp_pass");

        System.out.println("Updating security user settings...");

        UserSettingsModel currentSettings = tempUser.getUserSettings();

        String currentPassword = current_password.getText();
        String newPassword = new_password.getText();
        String confirmPassword = confirm_password.getText();

        if (newPassword.equals(confirmPassword)) {
            System.out.println("New Password and Confirm Password fields match! Attempting password change...");
            tempUser.setPassword(currentPassword, newPassword);
        } else {
            System.out.println("New Password and Confirm Password fields do not match.");
        }

        if (ferpa_setting.isSelected()) {
            currentSettings.setFerpaStatus(true);
        } else {
            currentSettings.setFerpaStatus(false);
        }

        tempUser.getUserSettings();

        System.out.println("...done updating!");
    }
}
