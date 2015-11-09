package test.models;

import utility.EQuestionTypes;
import javafx.scene.control.ListView;

import java.util.ArrayList;

/**
 * Created by JonCatanio on 11/2/15.
 */
public class GenerateTestRequestModel {
    private final int MAX_QUESTION_NUMBER = 500;

    private String name;
    private int numQuestions;
    private int difficulty;
    private ArrayList<EQuestionTypes> selectedQuestionTypes;
    private ArrayList<Integer> selectedClasses;
    private ArrayList<Integer> selectedSubjects;

    public GenerateTestRequestModel() {
        this.numQuestions = 0;
        this.difficulty = 0;
    }


    // finish getting all methods and instance vars
    public int getNumQuestions() {
        return this.numQuestions;
    }
    public void setNumQuestions(String number) {
        try {
            int num = Integer.parseInt(number);

            if (num > 0 && num < MAX_QUESTION_NUMBER) {
                System.out.println("Number of Questions: " + num);
                this.numQuestions = num;
            }
        }
        catch(NumberFormatException nfe) {
            System.out.println("Not a valid number.");
        }
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name){
        System.out.println("Name: " + name);
        this.name = name;
    }

    public int getDifficulty() { return this.difficulty; }
    public void setDifficulty(int val) {
        if (val >= 0 && val <= 2) {
            System.out.println("Difficulty Value: " + val);
            this.difficulty = val;
        }
    }

    public ArrayList<EQuestionTypes> getSelectedQuestionTypes() { return this.selectedQuestionTypes; }
    public void setSelectedQuestionTypes(ListView<String> selectedQuestionTypes) {
        selectedQuestionTypes.getItems().forEach(System.out::println);
    }

    public ArrayList<Integer> getSelectedClasses() { return this.selectedClasses; }
    public void setSelectedClasses(ListView<String> selectedClasses) {
        selectedClasses.getItems().forEach(System.out::println);
    }

    public ArrayList<Integer> getSelectedSubjects() { return this.selectedSubjects; }
    public void setSelectedSubjects(ListView<String> selectedSubjects) {
        selectedSubjects.getItems().forEach(System.out::println);
    }
}
