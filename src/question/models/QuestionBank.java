package question.models;

import java.util.*;

/**
 * Created by kendall on 11/8/15.
 */
abstract class QuestionBank {
    Collection <QuestionModel> questions;
    QuestionBank instance = null;
    int numberOfQuestions;
    /**
     *   GetInstace checks to see if there is an instance
     *   of QuestionBank return it if there is and creates
     *   a new one if there is not.
     **/
    abstract QuestionBank GetInstance();

    /**
     *   AddQuestion adds a question to the "questions"
     *   collection in the question bank
     *   post:
     *    //A Question is in the output QuestionBank if and only if it is the new
     *    // Question to be added or it is in the input QuestionBank.
     *    forall (Question ques ;
     *        data'.contains(ques) iff
     *           ques.equals(question) || data.contains(ques));
     * */
    abstract void AddQuestion(QuestionModel question);

    /**
     *   DeleteQuestion removes a question from the "questions"
     *   collection in the question bank.
     *   pre:
     *    //  The given Question is in the given QuestionBank.
     *      data.containsgquestion);
     *   post:
     *     //A question is in the output QuestionBank if and only if it is not the
     *     // existing question to be deleted and it is in the input db.
     *         forall (Question ques ;
     *          data'.contains(ques) iff
     *         !ques.equals(question) && data.contains(ques));
     *
     **/
    abstract void DeleteQuestion(QuestionModel question);

    /**
     *   QuestionByDifficulty returns a list of questions that
     *   have the difficulty specified in the parameters
     *   pre:
     *    //  The integer passed in is a valid value (easy - 0, medium - 1, hard - 2)
     *      data.contains(num) iff:
     *          num == 0 || num == 1 || num == 2;
     *   post:
     *    //  A Collection of all the QuestionModels that correspond to the input
     *    //  difficulty is returned.
     *      forall (QuestionModel qm;
     *          data'.contains(qm) iff
     *              qm.difficulty == num;
     **/
    abstract Collection<QuestionModel> QuestionsByDifficulty(int num);

    /**
     *   QuestionByClass returns a list of questions that are from
     *   the specified class.
     *   post:
     *    //  A Collection of all the QuestionModels that correspond to the input
     *    //  subject is returned.
     *      forall (QuestionModel qm;
     *          data'.contains(qm) iff
     *              qm.subject.equals(subject);
     **/
    abstract Collection<QuestionModel> QuestionsByClass(String subject);

    /**
     *   QuestionByDateAdded returns a list of questions that were added
     *   on the specified date.
     *   pre:
     *    //  The String passed in is a valid date
     *      data.contains(subject) iff:
     *          subject.day > 0 && subject.day <= 31 &&
     *          subject.month > 0 && subject.month <= 12
     *   post:
     *    //  A Collection of all the QuestionModels that correspond to the input
     *    //  date is returned.
     *      forall (QuestionModel qm;
     *          data'.contains(qm) iff
     *              qm.date.equals(date);
     **/
    abstract Collection<QuestionModel> QuestionsByDateAdded(String date);

    /**
     *   QuestionByNumberOfUses returns a list of questions that have
     *   the same number of uses as specified.
     **/
    abstract Collection<QuestionModel> QuestionsByNumberOfUses(int num);

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
     exists (Question ques ; data.contains(ques) ;
     ques.name.equals(name) && ques.equals(return))
     ||
     !exists (Question ques ; data.contains(ques) ;
     ques.name.equals(name)) && return == null;

     *
     */
    abstract QuestionModel findByQuestionName(String name);

}
