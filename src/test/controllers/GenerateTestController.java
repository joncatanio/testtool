package test.controllers;

import javafx.scene.control.*;
import test.models.GenerateTestRequestModel;

/**
 * Created by JonCatanio on 11/1/15.
 */
public class GenerateTestController extends TestController {
    public TextField numQuestions = new TextField();
    public TextField name = new TextField();
    public RadioButton difficulty[] = new RadioButton[3];

    public void generate() {
        GenerateTestRequestModel requestModel = new GenerateTestRequestModel();

        // This will take all the fields and instantiate and object and pass it along to be created.
        System.out.println("Generate!");

        requestModel.setName(name.getText());
        requestModel.setNumQuestions(numQuestions.getText());
    }

    public void easyDifficulty() {
        if (difficulty[1].isSelected()) {
            difficulty[1].setSelected(false);
        }
        if (difficulty[2].isSelected()) {
            difficulty[2].setSelected(false);
        }
    }

    public void mediumDifficulty() {

    }

}
