package question.models;

import java.awt.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private String answer;
    private String date;
    private int charLimit;
    private int difficulty;
    private int pointsPossible;
    private int id;




    public QuestionModel() {
        this.questionType = "";
        this.questionName = "";
        this.classNumber = "";
        this.subject = "";
        this.question = "";
        this.ImageFile = "";
        this.hint = "";
        this.answer = "";
        this.date = "";
        this.charLimit = 100;
        this.difficulty = 0;
        this.pointsPossible = 1;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        this.date = dateFormat.format(date);
    }

    public QuestionModel(String questionTy,String questionNa, String classNum, String sub, String ques, String image, String  hin, String ans, int charlim, int diff, int pp, int newId) {
        this.questionType = questionTy;
        this.questionName = questionNa;
        this.classNumber = classNum;
        this.subject = sub;
        this.question = ques;
        this.ImageFile = image;
        this.hint = hin;
        this.answer = ans;
        this.charLimit = charlim;
        this.difficulty = diff;
        this.pointsPossible = pp;
        this.id = newId;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        this.date = dateFormat.format(date);
    }
    /**
     * getQuestionType returns the type of question
     * ex. FillInTheBlank
     *
     **/
    public String getQuestionType() {
        return this.questionType;
    }

    /**
     * setQuestionType changes the question type
     *
     **/
    public void setQuestionType(String name){
        System.out.println("QuestionType: " + name);
        this.questionType = name;
    }

    /**
     * getQuestionName returns the Name of the question
     *
     **/
    public String getQuestionName() {
        return this.questionName;
    }

    /**
     * setQuestionName changes the question name
     *
     **/
    public void setQuestionName(String name){
        System.out.println("QuestionName: " + name);
        this.questionName = name;
    }

    /**
     * getClassNumber returns the class number of the question
     *
     **/
    public String getClassNumber() {
        return this.classNumber;
    }

    /**
     * setClassNumber changes the class number of the question
     *
     **/
    public void setClassNumber(String name){
        System.out.println("ClassNumber: " + name);
        this.classNumber = name;
    }

    /**
     * getSubject returns the question's subject
     * this is used for filtering
     *
     **/
    public String getSubject() {
        return this.subject;
    }

    /**
     * setSubject changes the question's subject
     *
     **/
    public void setSubject(String name){
        System.out.println("SubjectName: " + name);
        this.subject = name;
    }

    /**
     * getQuestion returns the question
     * intended for test generating
     *
     **/
    public String getQuestion() {
        return this.question;
    }

    /**
     * setQuestion changes the question
     *
     **/
    public void setQuestion(String name){
        System.out.println("Question: " + name);
        this.question = name;
    }

    /**
     * getAnswer returns the question's answer
     *
     **/
    public String getAnswer() {
        return this.answer;
    }

    /**
     * setAnswer changes the question's answer
     *
     **/
    public void setAnswer(String name){
        System.out.println("Answer: " + name);
        this.answer = name;
    }

    /**
     * getImageFile returns the questions Image file
     *
     **/
    public String getImageFile() {
        return this.ImageFile;
    }

    /**
     * setImageFile changes the questions Image file
     *
     **/
    public void setImageFile(String name){
        System.out.println("ImageFile: " + name);
        this.ImageFile = name;
    }

    /**
     * getHint returns the question's hint
     * if hint is null it will return "there is no hint available"
     *
     **/
    public String getHint() {
        return this.hint;
    }

    /**
     * setHint changes the question's hint
     *
     **/
    public void setHint(String name){
        System.out.println("Hint: " + name);
        this.hint = name;
    }

    /**
     * getCharLimit returns the question's char limit which
     * specifies how many characters a user can type as an answer
     *
     **/
    public int getCharLimit() {
        return this.charLimit;
    }

    /**
     * setCharLimit changes the question's char limit which
     * specifies how many characters a user can type as an answer
     *
     **/
    public void setCharLimit(int name){
        System.out.println("CharLimit: " + name);
        this.charLimit = name;
    }

    /**
     * getDifficulty returns the question's difficulty (int) based
     * on an easy = 1, medium = 2, hard = 3 scale
     *
     **/
    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * setDifficulty changes the question's difficulty based
     * on an easy = 1, medium = 2, hard = 3 scale
     *
     **/
    public void setDifficulty(int name){
        System.out.println("Difficulty: " + name);
        this.difficulty = name;
    }

    /**
     * getPointsPossible returns the number of points possible
     *
     **/
    public int getPointsPossible() {
        return this.pointsPossible;
    }

    /**
     * setPointsPossible changes the number of points possible
     * based on the users specifications
     *
     **/
    public void setPointsPossible(int name){
        System.out.println("PointsPossible: " + name);
        this.pointsPossible = name;
    }

    public int getId() {
        return this.id;
    }


    public String getDate() {
        return this.date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.questionType);
        sb.append("," + this.questionName);
        sb.append("," + this.classNumber);
        sb.append("," + this.subject);
        sb.append("," + this.question);
        sb.append("," + this.ImageFile);
        sb.append("," + this.hint);
        sb.append("," + this.answer);
        sb.append("," + this.date);
        sb.append("," + this.charLimit);
        sb.append("," + this.difficulty);
        sb.append("," + this.pointsPossible);

        return sb.toString();
    }

    public boolean equals(QuestionModel qm) {
        return (this.questionType.equals(qm.questionType) &&
                this.questionName.equals(qm.questionName) &&
                this.classNumber.equals(qm.classNumber) &&
                this.subject.equals(qm.subject) &&
                this.question.equals(qm.question) &&
                this.ImageFile.equals(qm.ImageFile) &&
                this.hint.equals(qm.hint) &&
                this.answer.equals(qm.answer) &&
                this.date.equals(qm.date) &&
                this.charLimit == qm.charLimit &&
                this.difficulty == qm.difficulty &&
                this.pointsPossible == qm.pointsPossible);
    }
}