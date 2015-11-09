package login.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by JonCatanio on 11/5/15.
 */
public class LoginScreenController extends MainController {
    public TextField username;
    public PasswordField password;

    public LoginScreenController() {}

    public void submit() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/login/views/SplashPageView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        SplashPageController spc = parentLoader.getController();
        spc.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
        System.out.println("Username: " + username.getText() + " Password: " + password.getText());
    }
}
