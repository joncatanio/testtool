package login.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by JonCatanio on 11/22/15.
 */
public class SignUpController extends MainController {
    public TextField username;
    public PasswordField password;
    public PasswordField confirmPassword;

    public void submit() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/login/views/SplashPageView.fxml"));
        System.out.println("/login/views/SplashPageView.fxml");
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        SplashPageController spc = parentLoader.getController();
        spc.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
        System.out.println("Username: " + username.getText() + " Password: " + password.getText() + " Confirm: " + confirmPassword.getText());
    }

    public void signIn() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/login/views/LoginScreenView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        LoginScreenController lsc = parentLoader.getController();
        lsc.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }
}
