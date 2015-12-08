package utility;

//import junit.framework.TestCase;
//import org.junit.Test;
import question.models.QuestionBank;
import question.models.QuestionModel;

import java.util.ArrayList;

/**
 * Created by Cameron Burwell (cburwell@calpoly.edu) on 11/27/15.
 */
public class DBObjectTest {
    private QuestionBank qb = QuestionBank.getInstance();
    private ArrayList<QuestionModel> questions = new ArrayList<QuestionModel>();

    public void testAll() {
        System.out.println("Filling list");
        fillQuestionList();
        System.out.println("Adding questions");
        addQuestions();
        printAll();
        System.out.println("Clearing list");
        questions.clear();
        printAll();
        System.out.println("Reading questions");
        readQuestions();
        printAll();
        System.out.println("Deleting questions");
        deleteQuestions();
        printAll();
        System.out.println("Reading again, should only be 3");
        readQuestions();
        printAll();
    }

    private void fillQuestionList() {
        questions.add(new QuestionModel("FillInTheBlank", "52", "334", "CSC", "DOES this work?", "", "", "no", -1, 2, 100, 1));
        questions.add(new QuestionModel("FillInTheBlank", "55", "552", "CSC", "DOES THIS work?", "", "", "yes", -1, 3, 100, 1));
        questions.add(new QuestionModel("FillInTheBlank", "12", "656", "CSC", "DOES this WORK?", "", "", "no", -1, 4, 100, 1));
        questions.add(new QuestionModel("FillInTheBlank", "42", "121", "CSC", "does this work?", "", "", "yes", -1, 5, 100, 1));
        questions.add(new QuestionModel("FillInTheBlank", "33", "989", "CSC", "DOES this WORK?", "", "", "no", -1, 6, 100, 1));
    }

    private void addQuestions() {
        for (QuestionModel qm : questions) {
            qb.addQuestion(qm);
        }
    }

    private void deleteQuestions() {
        qb.deleteQuestion(questions.get(0));
        qb.deleteQuestion(questions.get(0));
    }

    private void readQuestions() {
        qb.restoreBankFromFile();
        questions = qb.getQuestions();
    }

    private void printAll() {
        int i = 1;

        System.out.println("\n");
        for (QuestionModel qm : questions) {
            System.out.println(i++ + ": " + qm.toString());
        }
        System.out.println("\n");
    }

//    public void testGetInstance() throws Exception {
//
//    }
//
//    public void testGetTestBank() throws Exception {
//
//    }
//
//    public void testGetQuestionBank() throws Exception {
//
//    }
//
//    public void testSetTestBank() throws Exception {
//
//    }
//
//    public void testSetQuestionBank() throws Exception {
//
//    }
//
//    public void testGetDb() throws Exception {
//
//    }
}