package test.controllers;

import javafx.scene.control.*;
import test.models.GenerateTestRequestModel;

/**
 * Created by JonCatanio on 11/1/15.
 */
public class GenerateTestController extends TestController {
    public TextField numQuestions;
    public TextField name;

    // Difficulty fields
    public RadioButton easy; // 0 for easy
    public RadioButton medium; // 1 for medium
    public RadioButton hard; // 2 for hard

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

    // Could not figure out ToggleGroup, so I manually did it.
    public void easyDifficulty() {
        System.out.println("In easy");
        if (medium.isSelected()) {
            medium.setSelected(false);
        }
        if (hard.isSelected()) {
            hard.setSelected(false);
        }
    }

    public void mediumDifficulty() {
        System.out.println("In medium");
        if (easy.isSelected()) {
            easy.setSelected(false);
        }
        if (hard.isSelected()) {
            hard.setSelected(false);
        }
    }

    public void hardDifficulty() {
        System.out.println("In hard");
        if (easy.isSelected()) {
            easy.setSelected(false);
        }
        if (medium.isSelected()) {
            medium.setSelected(false);
        }
    }
}
