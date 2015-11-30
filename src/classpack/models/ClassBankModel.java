package classpack.models;

import java.util.*;

/**
 * Created by alexg on 11/29/15.
 */
public class ClassBankModel {

    public ArrayList<ClassModel> classes = new ArrayList<ClassModel>();

    private ClassBankModel(){ }

    private static ClassBankModel ourInstance = new ClassBankModel();

    public static ClassBankModel getInstance(){
        return ourInstance;
    }

    public ClassModel getClassById(int id) {
        for( int i = 0; i < classes.size(); i++ ) {
            if( classes.get(i).getClassId() == id) {
                return classes.get(i);
            }
        }

        //TODO: should throw an exception instead
        return new ClassModel();
    }
}
