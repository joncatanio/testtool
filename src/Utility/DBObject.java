package Utility;

import question.models.QuestionModel;
import test.models.TestModel;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by cburwell on 11/27/15.
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
    private static DBObject instance = new DBObject();
    /** The filename for the serial file (database) */
    private static String filename = "db.ser";
    /** The database object that may be written to and read from a flat file */
    private static DBObject db = null;
    /** A collection of TestModels that make up the test bank */
    private ArrayList<TestModel> testBank;
    /** A collection of QuestionModels that make up the question bank */
    private ArrayList<QuestionModel> questionBank;

    /** DBObject constructor, private to avoid instantiation */
    protected DBObject() {}

    /**
     * Gets the instance of the singleton DBObject instance
     *
     * @return The singleton of DBObject
     */
    public static DBObject getInstance() { return instance; }

    /**
     * Getter for the current test bank
     *
     * @return The current test bank
     */
    public ArrayList<TestModel> getTestBank() { return this.testBank; }

    /**
     * Getter for the current question bank
     *
     * @return The current question bank
     */
    public ArrayList<QuestionModel> getQuestionBank() { return this.questionBank; }

    /**
     * Setter for the test bank
     *
     * @param tb The new test bank
     */
    public void setTestBank(ArrayList<TestModel> tb) { this.testBank = tb; }

    /**
     * Setter for the question bank
     *
     * @param qb The new question bank
     */
    public void setQuestionBank(ArrayList<QuestionModel> qb) { this.questionBank = qb; }

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
     * @param filename name of the database serial file
     * @return The DBObject stored in the serial file
     */
    public DBObject deserialize(String filename) {
        this.db = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename);
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
     *
     * @param db the DBObject to write to the file
     */
    public void serialize(DBObject db) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            fos = new FileOutputStream(this.filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(db);
            out.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}