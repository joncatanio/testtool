/****
 *
 * The QuestionBank Class is used as our questionBank.
 * Here we store all of are questions. This file contains methods to filter
 * the question bank.
 *
 * Kendall Gassner (kendall.gassner@yahoo.com), Cameron Burwell (cburwell@calpoly.edu) on 12/4/15.
 *
 */
package question.models;

import utility.DBObject;
import javafx.collections.ObservableList;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;


public class QuestionBank {
    /**
     * questions contains the list of questions in the QuestionBank
     *
     **/
    protected ArrayList<QuestionModel> questions = new ArrayList<QuestionModel>();

    /**
     * dAnswer holds the matching to d.
     *
     **/
    protected static QuestionBank instance = new QuestionBank();

    /**
     * numberOfQuestions gives the amount of questions per bank.
     *
     **/
    protected int numberOfQuestions;

    /**
     * db holds our database object.
     *
     **/
    protected DBObject db = DBObject.getInstance();

    /**
     *   GetInstace checks to see if there is an instance
     *   of QuestionBank return it if there is and creates
     *   a new one if there is not.
     **/
    public static QuestionBank getInstance(){
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
    public void addQuestion(QuestionModel question) {
        questions.add(question);
        numberOfQuestions++;

        System.out.println("Adding question to QuestionBank!");
        System.out.println(question.toString());
        db.setQuestionBank(questions);
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
    public void deleteQuestion(QuestionModel question) {
        // delete question if it exists
        if (questions.contains(question))
            questions.remove(question);

        // update question bank
        db.setQuestionBank(questions);
    }

    public void restoreBankFromFile() {
        questions = DBObject.getInstance().getQuestionBank();
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

    /**
     *   getQuestion returns a question that has the same id
     *   as id.
     **/
    public QuestionModel getQuestion(int id){

        for (QuestionModel question : questions) {
            if(question.getId() == id)
                return question;
        }
        return null;

    }

    /**
     *   getQuestions returns a list of questions
     **/
    public ArrayList<QuestionModel> getQuestions(){
        return questions;
    }

}
