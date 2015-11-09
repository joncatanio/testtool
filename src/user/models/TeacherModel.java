package user.models;

import java.util.Collection;
import classpack.models.*;

/**
 * The Teacher class inherits almost all of its data from the abstract User superclass
 * and is mainly used to differentiate itself from the lower privilege Student class.
 */
public abstract class TeacherModel extends UserModel {
    /**
     * The collection of classes that the teacher "owns".
     */
    private Collection<ClassModel> classes;

    /**
     * Constructs a teacher object using the constructor from the UserModel class.
     * @param newUsername Username given by the new teacher.
     * @param newPassword Password given by the new teacher.
     */
    public TeacherModel(String newUsername, String newPassword) {
        super(newUsername, newPassword);
    }

    /**
     * Adds a class to the teacher object.
     * @param newClass The class object to add.
     */
    public void addClass(ClassModel newClass) {
        classes.add(newClass);
        System.out.println("Added a new class to teacher");
    }

    /**
     * Removes a class from the teacher object
     * @param toRemove The class object to remove
     */
    public void removeClass(ClassModel toRemove) {
        classes.remove(toRemove);
        System.out.println("Removed a class from teacher");
    }
}
