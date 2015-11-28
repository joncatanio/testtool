package question.models;

import javafx.collections.ObservableList;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * Created by kendall on 11/8/15.
 */
public class QuestionBank {
    public Collection <QuestionModel> questions;
    private static QuestionBank instance = null;
    private int numberOfQuestions;

    /**
     *   GetInstace checks to see if there is an instance
     *   of QuestionBank return it if there is and creates
     *   a new one if there is not.
     **/
    public static QuestionBank getInstance(){
        if (instance == null)
            instance = new QuestionBank();
        return instance;
    }

    /**
     *   AddQuestion adds a question to the "questions"
     *   collection in the question bank
     *
       pre:
       post:
     //A Question is in the output QuestionBank if and only if it is the new
     // Question to be added or it is in the input QuestionBank.
        forall (QuestionModel ques ;
            questions'.contains(ques) iff
                (ques.equals(question) || questions.contains(ques)));
     *
     **/
    public void addQuestion(String questionType,String questionName, String classNumber, String subject, String newQuestion, String image, String  hint, String answer, int charlimit, int difficulty, int pointsPossible){
        QuestionModel question = new QuestionModel(questionType, questionName, classNumber, subject, newQuestion, image, hint, answer, charlimit, difficulty, pointsPossible, numberOfQuestions);
        questions.add(question);
        numberOfQuestions++;
    }

    /**
     *   DeleteQuestion removes a question from the "questions"
     *   collection in the question bank.
        pre:
     *    //  The given Question is in the given QuestionBank.
           questions.contains(question);
       post:
          //A question is in the output QuestionBank if and only if it is not the
          // existing question to be deleted and it is in the input db.
              forall (QuestionModel ques ;
                questions'.contains(ques) iff
                !ques.equals(question) && questions.contains(ques));
     *
     **/
    public void deleteQuestion(QuestionModel question){
    }

    /**
     *   QuestionByDifficulty returns a list of questions that
     *   have the difficulty specified in the parameters
        pre:
         //  The integer passed in is a valid value (easy - 0, medium - 1, hard - 2)
           questions.contains(num) iff
               num == 0 || num == 1 || num == 2;
        post:
         //  A Collection of all the QuestionModels that correspond to the input
         //  difficulty is returned.
          forall (QuestionModel qm;
               questions'.contains(qm) iff
                   qm.difficulty == num);
     *
     **/
    public Collection<QuestionModel> QuestionsByDifficulty(int num){
        return new ArrayList<QuestionModel>();
    }

    /**
     *   QuestionByType returns a list of questions that are from
     *   the specified type.
        post:
         //  A Collection of all the QuestionModels that correspond to the input
         //  type is returned.
           forall (QuestionModel qm;
              questions'.contains(qm) iff
                   qm.type.equals(type));
     *
     **/
    public Collection<QuestionModel> QuestionsByType(String type){
        return new ArrayList<QuestionModel>();
    }

    /**
     *   QuestionByDateAdded returns a list of questions that were added
     *   on the specified date.

     post:
        //  A Collection of all the QuestionModels that correspond to the input
        //  date is returned.
            exists (QuestionModel ques ; questions.contains(ques);
            ques.getDate().equals(date) && ques.equals(return))
            ||
            !exists (QuestionModel ques ; questions.contains(ques) ;
            ques.getDate().equals(date)) && return == null;
     *
     **/
    public Collection<QuestionModel> QuestionsByDateAdded(String date){
        return new ArrayList<QuestionModel>();
    }
    /**
     *   QuestionByNumberOfUses returns a list of questions that have
     *   the same number of uses as specified.
     **/
    public Collection<QuestionModel> QuestionsByNumberOfUses(int num){
        return new ArrayList<QuestionModel>();
    }

    public class SE1 extends Exception {}
    public class SE2 extends Exception {}

    /**
     * Find a question by unique question name;
     *                                                                     <pre>
     post:
     //
     // If there is a question with the given questionName in the QuestionBank, then the
     // output question is equal to that question, otherwise the output question
     // is null.
     //
     exists (QuestionModel ques ; questions.contains(ques);
     ques.getName().equals(name) && ques.equals(return))
     ||
     !exists (QuestionModel ques ; questions.contains(ques) ;
     ques.getName().equals(name)) && return == null;

     *
     */
    public Collection<QuestionModel> findByQuestionName(String name){
        return new ArrayList<QuestionModel>();
    }

    public QuestionModel getQuestion(int id){

        for (QuestionModel question : questions) {
            if(question.getId() == id)
                return question;
        }
        return null;

    }
}
