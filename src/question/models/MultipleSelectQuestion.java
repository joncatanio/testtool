package question.models;

import question.controllers.MultipleSelectController;

/****
 *
 * The MultipleSelectQuestions class is used to contain
 * variables and functions needed only for MultipleSelectQuestions
 *
 * Kendall Gassner (kendall.gassner@yahoo.com) on 12/7/15.
 *
 */
public class MultipleSelectQuestion {

    /**
     * aCheck is checked if the a should be checked
     * in the answer.
     *
     **/
    protected boolean aCheck;

    /**
     * bCheck is checked if the b should be checked
     * in the answer.
     *
     **/
    protected boolean bCheck;

    /**
     * cCheck is checked if the c should be checked
     * in the answer.
     *
     **/
    protected boolean cCheck;

    /**
     * dCheck is checked if the d should be checked
     * in the answer.
     *
     **/
    protected boolean dCheck;

    /**
     * aChecked is checked if the student selects
     * a on the test.
     *
     **/
    protected boolean aChecked;

    /**
     * bChecked is checked if the student selects
     * b on the test.
     *
     **/
    protected boolean bChecked;

    /**
     *cChecked is checked if the student selects
     * c on the test.
     **/
    protected boolean cChecked;

    /**
     * dChecked is checked if the student selects
     * d on the test.
     *
     **/
    protected boolean dChecked;

    /**
     * MultipleSelectQuestion() initializes every variable
     * to false.
     *
     **/
    public MultipleSelectQuestion(){
        this.aCheck = false;
        this.bCheck = false;
        this.cCheck = false;
        this.dCheck = false;
        this.aChecked = false;
        this.bChecked = false;
        this.cChecked = false;
        this.dChecked = false;
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


    /**
     * isaChecked returns true or false based on
     * what the student has entered
     *
     **/
    public boolean isaChecked() {
        return aChecked;
    }

    /**
     * setbChecked holds true or false depending
     * on what the student answers
     *
     **/
    public void setaChecked(boolean aChecked) {
        this.aChecked = aChecked;
    }

    /**
     * isbChecked returns true or false based on
     * what the student has entered
     *
     **/
    public boolean isbChecked() {
        return bChecked;
    }

    /**
     * setbChecked holds true or false depending
     * on what the student answerst
     *
     **/
    public void setbChecked(boolean bChecked) {
        this.bChecked = bChecked;
    }

    /**
     * iscChecked returns true or false based on
     * what the student has entered
     *
     **/
    public boolean iscChecked() {
        return cChecked;
    }

    /**
     * setCChecked holds true or false depending
     * on what the student answers
     *
     **/
    public void setcChecked(boolean cChecked) {
        this.cChecked = cChecked;
    }

    /**
     * isdChecked returns true or false based on
     * what the student has entered
     *
     **/
    public boolean isdChecked() {
        return dChecked;
    }

    /**
     * setDChecked holds true or false depending
     * on what the student answers
     *
     *
     **/
    public void setdChecked(boolean dChecked) {
        this.dChecked = dChecked;
    }
}
