import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import question.controllers.QuestionController;

public class Main extends Application {

    @Override
    public void start(Stage mainStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/question/views/first.fxml"));
        Parent root = loader.load();
        QuestionController first = loader.getController();
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
