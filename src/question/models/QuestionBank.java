package question.models;

/**
 * Created by kendall on 11/8/15.
 */
abstract class QuestionBank {
    Collection <Question> questions;
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
    abstract void AddQuestion(Question question);

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
    abstract void DeleteQuestion(Question question);
    /**
     *   QuestionByDifficulty returns a list of questions that
     *   have the difficulty specified in the parameters
     **/
    abstract Collection<Question> QuestionsByDifficulty(int num);

    /**
     *   QuestionByClass returns a list of questions that are from
     *   the specified class.
     **/
    abstract Collection<Question> QuestionsByClass(String subject);

    /**
     *   QuestionByDateAdded returns a list of questions that were added
     *   on the specified date.
     **/
    abstract Collection<Question> QuestionsByDateAdded(String date);

    /**
     *   QuestionByNumberOfUses returns a list of questions that have
     *   the same number of uses as specified.
     **/
    abstract Collection<Question> QuestionsByNumberOfUses(int num);

}
