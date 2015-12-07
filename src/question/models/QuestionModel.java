package question.models;

import java.awt.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Created by kendall, Cameron Burwell (cburwell@calpoly.edu) on 11/3/15.
 */
public class QuestionModel{

    private String questionType;
    private String classNumber;
    private String subject;
    private String question;
    private String hint;
    private String questionName;
    private String answer;
    private String input;
    private String date;
    private String a;
    private String b;
    private String c;
    private String d;
    private String aAnswer;
    private String bAnswer;
    private String cAnswer;
    private String dAnswer;
    private boolean aCheck;
    private boolean bCheck;
    private boolean cCheck;
    private boolean dCheck;
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
        this.hint = "";
        this.answer = "";
        this.input = "";
        this.date = "";
        this.charLimit = 100;
        this.difficulty = 0;
        this.pointsPossible = 1;
        this.aCheck = false;
        this.bCheck = false;
        this.cCheck = false;
        this.dCheck = false;
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
    public void setAnswer(String name) {
        System.out.println("Answer: " + name);
        this.answer = name;
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
    public String getA() {
        return this.a;
    }

    /**
     * setA changes the question's a value which relates to multiple choice questions
     *
     **/
    public void setA(String name){
        System.out.println("A: " + name);
        this.a = name;
    }


    public String getB() {
        return this.b;
    }

    /**
     * setB changes the question's b value which relates to multiple choice questions
     *
     **/
    public void setB(String name){
        System.out.println("b: " + name);
        this.b = name;
    }
    public String getC() {
        return this.c;
    }

    /**
     * setC changes the question's c value which relates to multiple choice questions
     *
     **/
    public void setC(String name){
        System.out.println("c: " + name);
        this.c = name;
    }
    public String getD() {
        return this.d;
    }

    /**
     * setD changes the question's d value which relates to multiple choice questions
     *
     **/
    public void setD(String name){
        System.out.println("D: " + name);
        this.d = name;
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
    /**
     * getACheck changes the returns the aCheck boolean value
     * for multiple select
     *
     **/
    public boolean getACheck() {
        return this.aCheck;
    }

    /**
     * setACheck changes the boolean bCheck
     * to notify if A is an answer in MultipleSelect
     *
     **/
    public void setACheck(boolean name){
        System.out.println("A Check: " + name);
        this.aCheck = name;
    }

    /**
     * getBCheck changes the returns the bCheck boolean value
     * for multiple select
     *
     **/
    public boolean getBCheck() {
        return this.bCheck;
    }


    /**
     * setBCheck changes the boolean bCheck
     * to notify if b is an answer in MultipleSelect
     *
     **/
    public void setBCheck(boolean name){
        System.out.println("B Check: " + name);
        this.bCheck = name;
    }

    /**
     * getCCheck changes the returns the cCheck boolean value
     * for multiple select
     *
     **/
    public boolean getCCheck() {
        return this.cCheck;
    }


    /**
     * setCCheck changes the boolean cCheck
     * to notify if c is an answer in MultipleSelect
     *
     **/
    public void setCCheck(boolean name){
        System.out.println("C Check: " + name);
        this.cCheck = name;
    }

    /**
     * getDCheck changes the returns the DCheck boolean value
     * for multiple select
     *
     **/
    public boolean getDCheck() {
        return this.dCheck;
    }


    /**
     * setDCheck changes the boolean dCheck
     * to notify if d is an answer in MultipleSelect
     *
     **/
    public void setDCheck(boolean name){
        System.out.println("D Check: " + name);
        this.dCheck = name;
    }


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setBAnswer(String name){
        System.out.println("bAnswer: " + name);
        this.bAnswer = name;
    }
    public String getBAnswer() {
        return this.bAnswer;
    }

    public void setCAnswer(String name){
        System.out.println("CAnswer: " + name);
        this.cAnswer = name;
    }
    public String getCAnswer() {return this.cAnswer;}

    public void setDAnswer(String name){
        System.out.println("DAnswer: " + name);
        this.dAnswer = name;
    }
    public String getDAnswer() {return this.dAnswer;}

    public void setAAnswer(String name){
        System.out.println("aAnswer: " + name);
        this.aAnswer = name;
    }
    public String getAAnswer() {return this.aAnswer;}


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
                this.hint.equals(qm.hint) &&
                this.answer.equals(qm.answer) &&
                this.date.equals(qm.date) &&
                this.charLimit == qm.charLimit &&
                this.difficulty == qm.difficulty &&
                this.pointsPossible == qm.pointsPossible);
    }
}