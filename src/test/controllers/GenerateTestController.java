package test.controllers;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import question.models.QuestionModel;
import test.models.GenerateTestRequestModel;

/**
 * Created by JonCatanio on 11/1/15.
 */
public class GenerateTestController extends TestController {
    public TextField numQuestions;
    public TextField name;

    // Difficulty fields
    public ToggleGroup difficulty;
    public RadioButton easy; // 0 for easy
    public RadioButton medium; // 1 for medium
    public RadioButton hard; // 2 for hard

    // ChoiceBoxes
    public ComboBox<String> questionTypes;

    public GenerateTestController() {

    }

    public void generate() {
        GenerateTestRequestModel requestModel = new GenerateTestRequestModel();

        // This will take all the fields and instantiate and object and pass it along to be created.
        System.out.println("Generate!");

        requestModel.setName(name.getText());
        requestModel.setNumQuestions(numQuestions.getText());

        if (easy.isSelected()) {
            requestModel.setDifficulty(0);
        }
        else if (medium.isSelected()) {
            requestModel.setDifficulty(1);
        }
        else if (hard.isSelected()) {
            requestModel.setDifficulty(2);
        }
    }

    public void populateChoiceBoxes() {
        questionTypes.setItems(FXCollections.observableArrayList("Select", "Free Response", "Multiple Choice",
                "Multiple Select", "Free Response", "Short Answer", "Coding", "UML", "Matching"));
        questionTypes.getSelectionModel().select(0);
    }
}
