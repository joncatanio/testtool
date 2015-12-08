package classpack.models;

import java.util.*;

/**
 * Created by alexg on 11/29/15.
 * Updated / Documented by agough on 11/30/15.
 *
 * ClassBankModel is a singleton object that holds all of the classes
 */

public class ClassBankModel {

    /**
     * classes is an arrayList of class models holding all the classes, essentially our 'bank'.
     */
    public ArrayList<ClassModel> classes = new ArrayList<ClassModel>();

    private ClassBankModel(){ }

    private static ClassBankModel ourInstance = new ClassBankModel();

    public static ClassBankModel getInstance(){
        return ourInstance;
    }

    /**
     * getClassById is used to pull a class from the bank using a specific id.
     * @param id is a unique int associated with a class.
     * @return is the class associated with the given id.
     *
     *
     pre:
        exists(ClassModel c; classes.contains(c); c.getId() == id)
     post:

     */
    public ClassModel getClassById(int id) {
        for( int i = 0; i < classes.size(); i++ ) {
            if( classes.get(i).getClassId() == id) {
                return classes.get(i);
            }
        }

        return new ClassModel();
    }

    /**
     * getAllClasses is used to return all classes in the bank.
     * @return is an arrayList of class models.
     */
    public ArrayList<ClassModel> getAllClasses() {
        return classes;
    }

    /**
     * removeClass is used to remove a class from the bank.
     * @param id is a unique integer associated with a class in the test bank.
     *
     pre:
        exists(ClassModel c; classes.contains(c); c.getId() == id)
     post:
     */
    public void removeClass(int id) {
        for( int i = 0; i < classes.size(); i++ ) {
            if( classes.get(i).getClassId() == id) {
                classes.remove(i);
            }
        }
        updateClassBankDB();
    }

    /**
     * addClass is used to add a class to the class bank.
     * @param classToAdd
     */
    public void addClass(ClassModel classToAdd) {
        classes.add(classToAdd);
        updateClassBankDB();
    }

    /**
     * updateClassBankDB is used to update the database with any new classes added to the bank.
     */
    public void updateClassBankDB() {
        //update DB here
    }
}
