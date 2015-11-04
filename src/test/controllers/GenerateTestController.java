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
    public ToggleGroup difficulty;
    public RadioButton easy;
    public RadioButton medium;
    public RadioButton hard;

    public GenerateTestController() {
        // Initialize text fields.
        this.numQuestions = new TextField();
        this.name = new TextField();

        // Initialize and add radio buttons to toggle group.
        this.difficulty = new ToggleGroup();
        this.easy = new RadioButton();
        this.medium = new RadioButton();
        this.hard = new RadioButton();
        this.easy.setToggleGroup(this.difficulty);
        this.medium.setToggleGroup(this.difficulty);
        this.hard.setToggleGroup(this.difficulty);
    }

    public void generate() {
        GenerateTestRequestModel requestModel = new GenerateTestRequestModel();

        // This will take all the fields and instantiate and object and pass it along to be created.
        System.out.println("Generate!");

        requestModel.setName(name.getText());
        requestModel.setNumQuestions(numQuestions.getText());
    }
}
