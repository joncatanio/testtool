package test.models;

/**
 * Created by JonCatanio on 11/2/15.
 */
public class GenerateTestRequestModel {
    private final int MAX_QUESTION_NUMBER = 500;
    private int numQuestions;
    private int difficulty;
    private String name;

    public GenerateTestRequestModel() {
        this.numQuestions = 0;
        this.difficulty = 0;
    }


    // finish getting all methods and instance vars
    public int getNumQuestions() {
        return this.numQuestions;
    }
    public void setNumQuestions(int num) {
        if (num > 0 && num < MAX_QUESTION_NUMBER) {
            System.out.println("In setNumQuestions num is: " + num + " which is valid.");
            this.numQuestions = num;
        }
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name){
        System.out.println("Woo in set name. Name is " + name);
        this.name = name;
    }
}
