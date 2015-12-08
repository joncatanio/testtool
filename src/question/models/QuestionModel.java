package question.models;

import java.awt.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/****
 *
 * The QuestionModel Class is used to store all of the questions information.
 *
 * Created by Kendall Gassner (kgassner@calpoly.edu), Cameron Burwell (cburwell@calpoly.edu) on 11/6/15.
 */
public class QuestionModel{

    /**
     * questionType holds the type of question.
     *
     **/
    protected String questionType;

    /**
     * classNumber holds the class id.
     *
     **/
    protected String classNumber;

    /**
     * subject holds the subject the question comes from.
     *
     **/
    protected String subject;

    /**
     * question holds the actual question.
     *
     **/
    protected String question;

    /**
     * hint holds a hint the teacher could give a student about
     * the question.
     *
     **/
    protected String hint;

    /**
     * questionName holds the title of the question.
     *
     **/
    protected String questionName;

    /**
     * answer holds the answer to the question.
     *
     **/
    protected String answer;

    /**
     * input holds the response to the student puts
     * for an answer.
     *
     **/
    protected String input;

    /**
     * date holds the date the question was created.
     *
     **/
    protected String date;

    /**
     * a holds multiple choice option a.
     *
     **/
    protected String a;

    /**
     * b holds multiple choice option a.
     *
     **/
    protected String b;

    /**
     * c holds multiple choice option a.
     *
     **/
    protected String c;

    /**
     * d holds multiple choice option a.
     *
     **/
    protected String d;

    /**
     * aAnswer holds the matching to a.
     *
     **/
    protected String aAnswer;

    /**
     * bAnswer holds the matching to b.
     *
     **/
    protected String bAnswer;

    /**
     * cAnswer holds the matching to c.
     *
     **/
    protected String cAnswer;

    /**
     * dAnswer holds the matching to d.
     *
     **/
    protected String dAnswer;

    /**
     * selectQuestion is used to get more variables needed
     * only for multiple selects
     *
     **/
    protected MultipleSelectQuestion selectQuestion;

    /**
     * charLimit hold the value of the limit
     * the student can type per question.
     *
     **/
    protected int charLimit;

    /**
     * difficulty hold the level of difficulty
     * for the question.
     *
     **/
    protected int difficulty;

    /**
     * pointsPossible holds the value of
     * the points given to the question.
     *
     **/
    protected int pointsPossible;

    /**
     * id holds a unique number to each question.
     *
     **/
    protected int id;

    /**
     * QuestionModel() initializes the question model so that
     * all strings are empty.
     *
     **/
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
        this.selectQuestion = new MultipleSelectQuestion();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        this.date = dateFormat.format(date);
    }

    /**
     * QuestionModel(String questionTy,String questionNa, String classNum, String sub, String ques,
     * String image, String  hin, String ans, int charlim, int diff, int pp, int newId) initializes
     * the question model so that all strings are filled with specified information.
     *
     **/
    public QuestionModel(String questionTy,String questionNa, String classNum, String sub, String ques,
                         String image, String  hin, String ans, int charlim, int diff, int pp, int newId) {
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


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }


    /**
     * setBAnswer is used in matching to set what
     * B should be matched too
     *
     **/
    public void setBAnswer(String name){
        System.out.println("bAnswer: " + name);
        this.bAnswer = name;
    }

    /**
     * getBAnswer returns the matching of B
     *
     **/
    public String getBAnswer() {
        return this.bAnswer;
    }


    /**
     * setCAnswer is used in matching to set what
     * C should be matched too
     *
     **/
    public void setCAnswer(String name){
        System.out.println("CAnswer: " + name);
        this.cAnswer = name;
    }

    /**
     * getCAnswer returns the matching of C
     *
     **/
    public String getCAnswer() {return this.cAnswer;}

    /**
     * setDAnswer is used in matching to set what
     * D should be matched too
     *
     **/
    public void setDAnswer(String name){
        System.out.println("DAnswer: " + name);
        this.dAnswer = name;
    }
    /**
     * getDAnswer returns the matching of d
     *
     **/
    public String getDAnswer() {return this.dAnswer;}

    /**
     * setAAnswer is used in matching to set what
     * a should be matched too
     *
     **/
    public void setAAnswer(String name){
        System.out.println("aAnswer: " + name);
        this.aAnswer = name;
    }

    /**
     * getAAnswer returns the matching of A
     *
     **/
    public String getAAnswer() {return this.aAnswer;}


    /**
     * getId return the id of the question
     *
     **/
    public int getId() {
        return this.id;
    }

    /**
     * getDate returns the date of when the question
     * was created
     *
     **/
    public String getDate() {
        return this.date;
    }

    /**
     * toString creates a string with all of the questions
     * variables
     *
     **/
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

    /**
     * equals checks if the qm questionModel
     * equals the questionModel
     *
     **/
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

    /**
     * getSelectQuestion returns an MultipleSelectQuestions
     * class which contains all the extra information only
     * multiple select needs
     *
     **/
    public MultipleSelectQuestion getSelectQuestion() {
        return selectQuestion;
    }

}