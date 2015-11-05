package test.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import question.models.QuestionModel;
import test.models.GenerateTestRequestModel;

import java.util.Arrays;
import java.util.List;

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
    public MenuButton questionTypes;
    private ListView<String> selectedQuestionTypes;

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

        // Loop through each item and print it.
        selectedQuestionTypes.getItems().forEach(System.out::println);
    }

    public void populateSelectBoxes() {
        // For some reason removeAll needs some bullshit.
        questionTypes.getItems().remove(0);
        questionTypes.getItems().remove(0);
        List<CheckMenuItem> questionTypeItems = Arrays.asList(
                new CheckMenuItem("Fill in the Blank"),
                new CheckMenuItem("Multiple Choice"),
                new CheckMenuItem("Multiple Select"),
                new CheckMenuItem("Free Response"),
                new CheckMenuItem("Short Answer"),
                new CheckMenuItem("Coding"),
                new CheckMenuItem("UML"),
                new CheckMenuItem("Matching")
        );
        questionTypes.getItems().addAll(questionTypeItems);

        // Subscribe to selected menu items.
        selectedQuestionTypes = new ListView<>();
        for (CheckMenuItem item : questionTypeItems) {
            item.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
                if (isSelected) {
                    selectedQuestionTypes.getItems().add(item.getText());
                } else {
                    selectedQuestionTypes.getItems().remove(item.getText());
                }
            });
        }
    }
}
