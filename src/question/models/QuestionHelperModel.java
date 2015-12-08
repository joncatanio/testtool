package question.models;

/**
 * QuestionHelperModel holds extra content needed for special question
 * types.
 *
 * Created by Kendall Gassner (kendall.gassner@yahoo.com) on 12/7/15.
 */
public class QuestionHelperModel {

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

    public QuestionHelperModel(){}


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
     * getA returns the value of a
     *
     **/
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


    /**
     * getB returns the value of b
     *
     **/
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

    /**
     * getC returns the value of C
     *
     **/
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

    /**
     * getD returns the value of d
     *
     **/
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
     * getInput returns the student input
     *
     **/
    public String getInput() {
        return input;
    }


    /**
     * setInput put the students answer into input
     *
     **/
    public void setInput(String input) {
        this.input = input;
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
}
