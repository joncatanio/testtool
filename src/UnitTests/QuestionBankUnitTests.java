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


        }

        public void testQuestionBankGetByDifficulty() {
            
        }

        public void testQuestionBankGetByType() {

        }

        public void testQuestionBankGetByName() {

        }
}