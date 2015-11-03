package test.controllers;

import javafx.scene.control.*;
import test.models.GenerateTestRequestModel;

/**
 * Created by JonCatanio on 11/1/15.
 */
public class GenerateTestController extends TestController {
    public TextField numQuestions = new TextField();
    public TextField name = new TextField();
    private GenerateTestRequestModel requestModel = new GenerateTestRequestModel();

    public void generate() {
        // This will take all the fields and instantiate and object and pass it along to be created.
        System.out.println("Generate!");
        System.out.println("Number of Questions: " + requestModel.getNumQuestions());
    }

    public void addNumQuestions() {
        String inputQuestionNumber = numQuestions.getCharacters().toString();

        if (!inputQuestionNumber.equals("")) {
            System.out.println("In addNumQuestions sequence: " + inputQuestionNumber);
            try {
                requestModel.setNumQuestions(Integer.parseInt(inputQuestionNumber));
            }
            catch (NumberFormatException nfe) {
                requestModel.setNumQuestions(0);
            }
        }
    }

    public void getName() {
        String tempName = name.getText();

        requestModel.setName(tempName);
        System.out.println("Name of test: " + tempName);
    }
}
