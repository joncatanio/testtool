import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.controllers.LoginScreenController;

public class Main extends Application {

    @Override
    public void start(Stage mainStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/views/LoginScreenView.fxml"));
        Parent root = loader.load();
        LoginScreenController first = loader.getController();
        first.populateInterface(mainStage);
        mainStage.setTitle("Test Tool");
        mainStage.setMinWidth(900);
        mainStage.setMinHeight(500);
        mainStage.setScene(new Scene(root, 900, 500));
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
