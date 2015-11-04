package question.models;

import java.awt.*;

/**
 * Created by kendall on 11/3/15.
 */
public class QuestionModel{

    private String questionType;
    private String classNumber;
    private String subject;
    private String question;
    private String ImageFile;
    private String hint;
    private String questionName;
    private int charLimit;
    private int difficulty;
    private int pointsPossible;


    public QuestionModel() {
        this.questionType = null;
        this.questionName = null;
        this.classNumber = null;
        this.subject = null;
        this.question = null;
        this.ImageFile = null;
        this.hint = null;
        this.charLimit = 100;
        this.difficulty = 0;
        this.pointsPossible = 1;
    }

    public String getQuestionType() {
        return this.questionType;
    }
    public void setQuestionType(String name){
        System.out.println("QuestionType: " + name);
        this.questionType = name;
    }

    public String getQuestionName() {
        return this.questionName;
    }
    public void setQuestionName(String name){
        System.out.println("QuestionName: " + name);
        this.questionName = name;
    }

    public String getClassNumber() {
        return this.classNumber;
    }
    public void setClassNumber(String name){
        System.out.println("ClassNumber: " + name);
        this.classNumber = name;
    }


    public String getSubject() {
        return this.subject;
    }
    public void setSubject(String name){
        System.out.println("SubjectName: " + name);
        this.subject = name;
    }


    public String getQuestion() {
        return this.question;
    }
    public void setQuestion(String name){
        System.out.println("Question: " + name);
        this.question = name;
    }


    public String getImageFile() {
        return this.ImageFile;
    }
    public void setImageFile(String name){
        System.out.println("ImageFile: " + name);
        this.ImageFile = name;
    }

    public String getHint() {
        return this.hint;
    }
    public void setHint(String name){
        System.out.println("Hint: " + name);
        this.hint = name;
    }

    public int getCharLimit() {
        return this.charLimit;
    }
    public void setCharLimit(int name){
        System.out.println("CharLimit: " + name);
        this.charLimit = name;
    }

    public int getDifficulty() {
        return this.difficulty;
    }
    public void setDifficulty(int name){
        System.out.println("Difficulty: " + name);
        this.difficulty = name;
    }

    public int getPointsPossible() {
        return this.pointsPossible;
    }
    public void setPointsPossible(int name){
        System.out.println("PointsPossible: " + name);
        this.pointsPossible = name;
    }

}