package utility;

import question.models.QuestionModel;
import test.models.TestModel;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Cameron Burwell (cburwell@calpoly.edu) on 11/27/15, Kendall Gassner (kendall.gassner@yahoo.com)
 *
 * Class representing a database object that can be written and retrieved from a
 * flat db.ser file. This behavior allows us to mock a database without bringing
 * in the complexity of an actual database framework.
 */
public class DBObject implements Serializable {

    /**
     * The singleton DBObject object. Not lazily instantiated so the
     * object will be instantiated on start up. Memory isn't an issue on this guy.
     */
    protected static DBObject instance = new DBObject();
    /** The filename for the serial file (database) */
    protected static String filename = "src/utility/db.ser";
    /** The database object that may be written to and read from a flat file */
    protected static DBObject db = null;
    /** A collection of TestModels that make up the test bank */
    protected ArrayList<TestModel> testBank;
    /** A collection of QuestionModels that make up the question bank */
    protected ArrayList<QuestionModel> questionBank = new ArrayList<QuestionModel>();

    /** DBObject constructor, private to avoid instantiation */
    protected DBObject() {}

    /**
     * Gets the instance of the singleton DBObject instance
     *
     * @return The singleton of DBObject
     */
    public static DBObject getInstance() { return instance; }

    /**
     * Getter for the current test bank. Reads from the serial file.
     *
     * @return The current test bank
     */
    public ArrayList<TestModel> getTestBank() {
        this.db = deserialize();
        return this.testBank;
    }

    /**
     * Getter for the current question bank. Reads from the serial file.
     *
     * @return The current question bank
     */
    public ArrayList<QuestionModel> getQuestionBank() {
        this.db = deserialize();
        return this.questionBank;
    }

    /**
     * Setter for the test bank. Writes to the serial file.
     *
     * @param tb The new test bank
     */
    public void setTestBank(ArrayList<TestModel> tb) {
        this.testBank = tb;
        serialize();
    }

    /**
     * Setter for the question bank. Writes to the serial file.
     *
     * @param qb The new question bank
     */
    public void setQuestionBank(ArrayList<QuestionModel> qb) {
        this.questionBank = qb;
        serialize();
    }

    /**
     * Getter for the current DBObject without reading again from the db.ser file.
     *
     * @return The current DBObject
     */
    public DBObject getDb() {
        return this.db;
    }

    /**
     * Reads the flat file db.ser that contains a DBObject representing the database
     * that contains the test and question banks.
     *
     * @return The DBObject stored in the serial file
     */
    private DBObject deserialize() {
        this.db = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(this.filename);
            in = new ObjectInputStream(fis);
            this.db = (DBObject)in.readObject();
            in.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        return this.db;
    }

    /**
     * Write the flat file db.ser that represents our database.
     */
    private void serialize() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream(this.filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(this.db);
            out.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * QuestionByType is used to filter through the database questions
     * and return the questions with the specified "type"

     pre:
        type.equals("Fill in The Blank") || type.equals("Multiple Choice") ||
         type.equals("Matching") || type.equals("Multiple Select") ||  type.equals("Short Answer")
         ||  type.equals("Free Response") ||  type.equals("Coding") ||
         type.equals("UML")
     post:
         forall (QuestionModel qm;
            questions'.contains(qm) iff
            qm.getQuestionType() == type);
     *
     **/
    public ArrayList<QuestionModel> QuestionsByType(String type) {
        ArrayList<QuestionModel> questions = new ArrayList<QuestionModel>();
        this.questionBank = getQuestionBank();

        for(QuestionModel question : this.questionBank){
            if(question.getQuestionType().equals(type)){
                questions.add(question);
            }
        }
        return questions;
    }

    /**
     * QuestionByDifficulty is used to filter through the database questions
     * and return the questions with the specified "Difficulty"
     *
     pre:
        difficulty > 0 && difficulty  < 4
     post:
       forall (QuestionModel qm;
         questions'.contains(qm) iff
         qm.getDifficulty() == difficulty);
     *
     **/
    public ArrayList<QuestionModel> QuestionsByDifficulty(int difficulty) {
        ArrayList<QuestionModel> questions = new ArrayList<QuestionModel>();
        this.questionBank = getQuestionBank();

        for(QuestionModel question : this.questionBank){
            if(question.getDifficulty() == difficulty){
                questions.add(question);
            }
        }
        return questions;
    }


}