package utilities;

import question.models.QuestionBank;
import java.util.*;

public class DBObjectUnitTests extends DBObject {

    public void testDBObjectQuestionsByDifficulty(){
        ArrayList<QuestionModel> questions = new ArrayList<QuestionModel>();
        questions.add(new QuestionModel("FillInTheBlank", "52", "334", "CSC", "DOES this work?", "", "", "no", -1, 2, 100, 1));
        questions.add(new QuestionModel("FillInTheBlank", "55", "552", "CSC", "DOES THIS work?", "", "", "yes", -1, 3, 100, 1));
        questions.add(new QuestionModel("FillInTheBlank", "12", "656", "CSC", "DOES this WORK?", "", "", "no", -1, 2, 100, 1));
        questions.add(new QuestionModel("FillInTheBlank", "42", "121", "CSC", "does this work?", "", "", "yes", -1, 3, 100, 1));
        questions.add(new QuestionModel("FillInTheBlank", "33", "989", "CSC", "DOES this WORK?", "", "", "no", -1, 1, 100, 1));
        setQuestionBank(questions);


        ArrayList<QuestionModel> test1 = QuestionsByDifficulty(3);
        ArrayList<QuestionModel> test2 = QuestionsByDifficulty(2);
        ArrayList<QuestionModel> test3 = QuestionsByDifficulty(1);
        ArrayList<QuestionModel> test4 = QuestionsByDifficulty(0);
        ArrayList<QuestionModel> test5 = QuestionsByDifficulty(5);

        for (QuestionModel qm : test1) {
            if(qm.getDifficulty() != 3){
                System.out.println("FAILURE, QuestionsByDifficulty(3) contains  different difficulties");
            }
        }
        if(test1.size() != 2) {
            System.out.println("FAILURE, QuestionsByDifficulty(3) does not output all of the questions with difficulty " +
                    "of three");

        }

        for (QuestionModel qm2 : test2) {
            if(qm2.getDifficulty() != 2){
                System.out.println("FAILURE, QuestionsByDifficulty(2) contains different difficulties");
            }
        }
        if(test2.size() != 2) {
            System.out.println("FAILURE, QuestionsByDifficulty(2) does not output all of the questions with difficulty " +
                    "of two");

        }

        for (QuestionModel qm3 : test3) {
            if(qm3.getDifficulty() != 1){
                System.out.println("FAILURE, QuestionsByDifficulty(1) contains different difficulties");
            }
        }
        if(test3.size() != 1) {
            System.out.println("FAILURE, QuestionsByDifficulty(1) does not output all of the questions with difficulty " +
                    "of one");

        }

        if(test4.size() > 0) {
            System.out.println("FAILURE, QuestionsByDifficulty(0) outputs questions")

        }

        if(test5.size() > 0) {
            System.out.println("FAILURE, QuestionsByDifficulty(5) outputs questions")

        }

        }

    public void testDBObjectQuestionsByType(){
        ArrayList<QuestionModel> questions = new ArrayList<QuestionModel>();
        questions.add(new QuestionModel("Fill in The Blank", "52", "334", "CSC", "DOES this work?", "", "", "no", -1, 2, 100, 1));
        questions.add(new QuestionModel("Matching", "55", "552", "CSC", "DOES THIS work?", "", "", "yes", -1, 3, 100, 1));
        questions.add(new QuestionModel("Fill in The Blank", "12", "656", "CSC", "DOES this WORK?", "", "", "no", -1, 2, 100, 1));
        questions.add(new QuestionModel("Multiple Select", "42", "121", "CSC", "does this work?", "", "", "yes", -1, 3, 100, 1));
        questions.add(new QuestionModel("Multiple Choice", "33", "989", "CSC", "DOES this WORK?", "", "", "no", -1, 1, 100, 1));
        questions.add(new QuestionModel("Short Answer", "55", "552", "CSC", "DOES THIS work?", "", "", "yes", -1, 3, 100, 1));
        questions.add(new QuestionModel("Free Response", "12", "656", "CSC", "DOES this WORK?", "", "", "no", -1, 2, 100, 1));
        questions.add(new QuestionModel("Coding", "42", "121", "CSC", "does this work?", "", "", "yes", -1, 3, 100, 1));
        questions.add(new QuestionModel("UML", "33", "989", "CSC", "DOES this WORK?", "", "", "no", -1, 1, 100, 1));
        setQuestionBank(questions);

        ArrayList<QuestionModel> test1 = QuestionsByType("Fill in The Blank");
        ArrayList<QuestionModel> test2 = QuestionsByType("Matching");
        ArrayList<QuestionModel> test3 = QuestionsByType("Multiple Select");
        ArrayList<QuestionModel> test4 = QuestionsByType("Multiple Choice");
        ArrayList<QuestionModel> test5 = QuestionsByType("Free Response");
        ArrayList<QuestionModel> test6 = QuestionsByType("Short Answer");
        ArrayList<QuestionModel> test7 = QuestionsByType("Coding");
        ArrayList<QuestionModel> test8 = QuestionsByType("UML");
        ArrayList<QuestionModel> test8 = QuestionsByType("Short");

        for (QuestionModel qm : test1) {
            if(qm.getType() != "FIll in The Blank"){
                System.out.println("FAILURE, not all questions are Fill in The Blank");
            }
        }

        for (QuestionModel qm2 : test2) {
            if(qm2.getType() != "Matching"){
                System.out.println("FAILURE, not all questions are Matching");
            }
        }

        for (QuestionModel qm3 : test3) {
            if(qm3.getType() != "Multiple Select"){
                System.out.println("FAILURE, not all questions are Multiple Select");
            }
        }

        for (QuestionModel qm4 : test4) {
            if(qm4.getType() != "Multiple Choice"){
                System.out.println("FAILURE, not all questions are Multiple Choice");
            }
        }

        for (QuestionModel qm5 : test5) {
            if(qm5.getType() != "Free Response"){
                System.out.println("FAILURE, not all questions are Free response");
            }
        }

        for (QuestionModel qm6 : test6) {
            if(qm6.getType() != "Short Answer"){
                System.out.println("FAILURE, not all questions are Short Answer");
            }
        }

        for (QuestionModel qm7 : test7) {
            if(qm7.getType() != "Coding"){
                System.out.println("FAILURE, not all questions are coding");
            }
        }

        for (QuestionModel qm8 : test8) {
            if(qm8.getType() != "UML"){
                System.out.println("FAILURE, not all questions are UML");
            }
        }

            if(test9.szie() > 0){
                System.out.println("FAILURE, gives back to many questions");
            }
        }





    }



}