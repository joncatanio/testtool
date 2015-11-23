package test.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import question.models.QuestionModel;
import test.models.GenerateTestRequestModel;
import test.models.TestHandlerModel;
import test.models.TestModel;

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
    public MenuButton classes;
    private ListView<String> selectedClasses;
    public MenuButton classSubjects;
    private ListView<String> selectedSubjects;


    public GenerateTestController() {

    }

    public void generate() {
        TestHandlerModel testHandler = TestHandlerModel.getInstance();
        GenerateTestRequestModel requestModel = new GenerateTestRequestModel();
        TestModel generatedTest = null;

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

        // Send selected choice drop downs to model.
        requestModel.setSelectedQuestionTypes(selectedQuestionTypes);
        requestModel.setSelectedClasses(selectedClasses);
        requestModel.setSelectedSubjects(selectedSubjects);

        testHandler.generate(requestModel);
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

        classes.getItems().remove(0);
        classes.getItems().remove(0);
        List<CheckMenuItem> classItems = Arrays.asList(
                new CheckMenuItem("CPE 101"),
                new CheckMenuItem("CPE 102"),
                new CheckMenuItem("CPE 103"),
                new CheckMenuItem("CSC 307"),
                new CheckMenuItem("CPE 349"),
                new CheckMenuItem("CPE 357"),
                new CheckMenuItem("CSC 445")
        );
        classes.getItems().addAll(classItems);

        // Subscribe to selected menu items.
        selectedClasses = new ListView<>();
        for (CheckMenuItem item : classItems) {
            item.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
                if (isSelected) {
                    selectedClasses.getItems().add(item.getText());
                } else {
                    selectedClasses.getItems().remove(item.getText());
                }
            });
        }

        classSubjects.getItems().remove(0);
        classSubjects.getItems().remove(0);
        List<CheckMenuItem> classSubjectItems = Arrays.asList(
                new CheckMenuItem("CPE 101 - Strings/Arrays"),
                new CheckMenuItem("CPE 101 - Pointers"),
                new CheckMenuItem("CPE 349 - Graphs"),
                new CheckMenuItem("CPE 357 - Advanced Pointers"),
                new CheckMenuItem("CPE 357 - LZW"),
                new CheckMenuItem("CPE 357 - IPC"),
                new CheckMenuItem("CSC 445 - Turing Machines"),
                new CheckMenuItem("CSC 445 - Undecidability")
        );
        classSubjects.getItems().addAll(classSubjectItems);

        // Subscribe to selected menu items.
        selectedSubjects = new ListView<>();
        for (CheckMenuItem item : classSubjectItems) {
            item.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
                if (isSelected) {
                    selectedSubjects.getItems().add(item.getText());
                } else {
                    selectedSubjects.getItems().remove(item.getText());
                }
            });
        }
    }
}
