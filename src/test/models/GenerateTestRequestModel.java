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
}
