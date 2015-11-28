package login.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import test.controllers.TestTakingController;

import java.io.IOException;

/**
 * Created by JonCatanio on 11/5/15.
 */
public class LoginScreenController extends MainController {
    public static final int TEACHER = 0;
    public static final int STUDENT = 1;

    public TextField username;
    public PasswordField password;

    public LoginScreenController() {}

    public void submit() throws IOException {
        int workflow = validate(username.getText(), password.getText());

        if (workflow == TEACHER) {
            teacherWorkflow();
        }
        else if (workflow == STUDENT) {
            studentWorkflow();
        }
        else {
            System.out.println("Yo, you ain't allowed.");
        }
    }

    public void signUp() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/login/views/SignUpView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        SignUpController suc = parentLoader.getController();
        suc.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void teacherWorkflow() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/login/views/SplashPageView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        SplashPageController spc = parentLoader.getController();
        spc.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public void studentWorkflow() throws IOException {
        FXMLLoader parentLoader = new FXMLLoader(getClass().getResource("/test/views/TestTakingView.fxml"));
        Parent nextSceneParent = parentLoader.load();
        Scene nextScene = new Scene(nextSceneParent);

        TestTakingController ttc = parentLoader.getController();
        ttc.populateInterface(currStage);

        currStage.setScene(nextScene);
        currStage.show();
    }

    public int validate(String username, String password) {
        if (username.trim().equals("teacher") && password.equals("password")) {
            return TEACHER;
        }
        else if (username.trim().equals("student") && password.equals("password")) {
            return STUDENT;
        }

        return -1;
    }
}
