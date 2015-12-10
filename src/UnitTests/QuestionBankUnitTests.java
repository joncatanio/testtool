package UnitTests;

import question.models.QuestionBank;
import java.util.*;
import utility.DBObject;
import question.models.QuestionBank;
import question.models.QuestionHelperModel;
import question.models.QuestionModel;

import java.util.*;

public class QuestionBankUnitTests extends QuestionBank {


    public void testQuestionBankgetQuestion(){
        addQuestion(new QuestionModel("FillInTheBlank", "52", "334", "CSC", "DOES this work?", "", "", "no", -1, 2, 100, 1));
        addQuestion(new QuestionModel("FillInTheBlank", "55", "552", "CSC", "DOES THIS work?", "", "", "yes", -1, 3, 100, 3));
        addQuestion(new QuestionModel("FillInTheBlank", "12", "656", "CSC", "DOES this WORK?", "", "", "no", -1, 2, 100, 14));
        addQuestion(new QuestionModel("FillInTheBlank", "42", "121", "CSC", "does this work?", "", "", "yes", -1, 3, 100, 5));
        addQuestion(new QuestionModel("FillInTheBlank", "33", "989", "CSC", "DOES this WORK?", "", "", "no", -1, 1, 100, 6));

        QuestionModel qm = getQuestion(1);
        QuestionModel qm2 = getQuestion(3);
        QuestionModel qm3 = getQuestion(14);
        QuestionModel qm4 = getQuestion(5);
        QuestionModel qm5 = getQuestion(6);
        QuestionModel qm6 = getQuestion(10);

        if(!qm.getQuestionName().equals("52")){System.out.println("FAILURE, returns question with the wrong id");}
        if(!qm2.getQuestionName().equals("55")){System.out.println("FAILURE, returns question with the wrong id");}
        if(!qm3.getQuestionName().equals("12")){System.out.println("FAILURE, returns question with the wrong id");}
        if(!qm4.getQuestionName().equals("42")){System.out.println("FAILURE, returns question with the wrong id");}
        if(! qm5.getQuestionName().equals("33")){System.out.println("FAILURE, returns question with the wrong id");}

        if( qm6 != null){
            System.out.println("FAILURE, returns question with the wrong id");
        }

        System.out.println("KENDALL: testQuestionBankgetQuestion Finished");
    }

    /**
     * Cameron test 1 for getting questions by difficulty
     */
    public void testQuestionBankGetByDifficulty() {
        QuestionBank qb = QuestionBank.getInstance();
        ArrayList<QuestionModel> qms = new ArrayList<QuestionModel>();
        Boolean pass1 = false, pass2 = false, pass3 = false;

        QuestionModel qm1 = new QuestionModel("FillInTheBlank", "DifficultyQuestion1", "334", "CSC", "Test1", "", "", "no", -1, 1, 100, 1);
        QuestionModel qm2 = new QuestionModel("FillInTheBlank", "DifficultyQuestion2", "552", "CSC", "Test2", "", "", "yes", -1, 2, 100, 3);
        QuestionModel qm3 = new QuestionModel("FillInTheBlank", "DifficultyQuestion3", "656", "CSC", "DOES this WORK?", "", "", "no", -1, 3, 100, 14);

        qb.addQuestion(qm1);
        qb.addQuestion(qm2);
        qb.addQuestion(qm3);

        // Easy
        qms = qb.QuestionsByDifficulty(1);
        for (QuestionModel qm : qms) {
            if (qm.getQuestionName().equals("DifficultyQuestion1")) {
                pass1 = true;
                break;
            }
        }

        // Medium
        qms = qb.QuestionsByDifficulty(2);
        for (QuestionModel qm : qms) {
            if (qm.getQuestionName().equals("DifficultyQuestion2")) {
                pass2 = true;
                break;
            }
        }

        // Hard
        qms = qb.QuestionsByDifficulty(3);
        for (QuestionModel qm : qms) {
            if (qm.getQuestionName().equals("DifficultyQuestion3")) {
                pass3 = true;
                break;
            }
        }

        if (pass1 && pass2 && pass3)
            System.out.println("PASSED: testQuestionBankGetByDifficulty Finished");
        else
            System.out.println("FAILED to get question by difficulty");

        // Clean up after testing
        qb.deleteQuestion(qm1);
        qb.deleteQuestion(qm2);
        qb.deleteQuestion(qm3);
    }

    /**
     * Cameron test 2 for getting questions by type
     */
    public void testQuestionBankGetByType() {
        QuestionBank qb = QuestionBank.getInstance();
        ArrayList<QuestionModel> qms;
        Boolean pass1 = false, pass2 = false, pass3 = false;

        QuestionModel qm1 = new QuestionModel("FillInTheBlank", "TypeQuestion1", "334", "CSC", "Test1", "", "", "no", -1, 1, 100, 1);
        QuestionModel qm2 = new QuestionModel("MultipleChoice", "TypeQuestion2", "552", "CSC", "Test2", "", "", "yes", -1, 2, 100, 3);
        QuestionModel qm3 = new QuestionModel("MultipleSelect", "TypeQuestion3", "656", "CSC", "DOES this WORK?", "", "", "no", -1, 3, 100, 14);

        qb.addQuestion(qm1);
        qb.addQuestion(qm2);
        qb.addQuestion(qm3);

        qms = qb.QuestionsByType("FillInTheBlank");
        for (QuestionModel qm : qms) {
            if (qm.getQuestionName().equals("TypeQuestion1")) {
                pass1 = true;
                break;
            }
        }

        qms = qb.QuestionsByType("MultipleChoice");
        for (QuestionModel qm : qms) {
            if (qm.getQuestionName().equals("TypeQuestion2")) {
                pass2 = true;
                break;
            }
        }

        qms = qb.QuestionsByType("MultipleSelect");
        for (QuestionModel qm : qms) {
            if (qm.getQuestionName().equals("TypeQuestion3")) {
                pass3 = true;
                break;
            }
        }

        if (pass1 && pass2 && pass3)
            System.out.println("PASSED: testQuestionBankGetByType Finished");
        else
            System.out.println("FAILED to get question by type");

        // Clean up after testing
        qb.deleteQuestion(qm1);
        qb.deleteQuestion(qm2);
        qb.deleteQuestion(qm3);
    }

    /**
     * Cameron test 3 for getting questions by name
     */
    public void testQuestionBankGetByName() {
        QuestionBank qb = QuestionBank.getInstance();
        QuestionModel qm;
        Boolean pass1 = false, pass2 = false, pass3 = false;

        QuestionModel qm1 = new QuestionModel("FillInTheBlank", "NameQuestion1", "334", "CSC", "Test1", "", "", "no", -1, 1, 100, 1);
        QuestionModel qm2 = new QuestionModel("FillInTheBlank", "NameQuestion2", "552", "CSC", "Test2", "", "", "yes", -1, 2, 100, 3);
        QuestionModel qm3 = new QuestionModel("FillInTheBlank", "NameQuestion3", "656", "CSC", "DOES this WORK?", "", "", "no", -1, 3, 100, 14);

        qb.addQuestion(qm1);
        qb.addQuestion(qm2);
        qb.addQuestion(qm3);

        qm = qb.findByQuestionName("NameQuestion1");
        if (qm != null && qm.getQuestionName().equals("NameQuestion1"))
            pass1 = true;

        qm = qb.findByQuestionName("NameQuestion2");
        if (qm != null && qm.getQuestionName().equals("NameQuestion2"))
            pass2 = true;

        qm = qb.findByQuestionName("NameQuestion3");
        if (qm != null && qm.getQuestionName().equals("NameQuestion3"))
            pass3 = true;

        if (pass1 && pass2 && pass3)
            System.out.println("PASSED: testQuestionBankGetByName Finished");
        else
            System.out.println("FAILED to get question by name");

        // Clean up after testing
        qb.deleteQuestion(qm1);
        qb.deleteQuestion(qm2);
        qb.deleteQuestion(qm3);
    }
}