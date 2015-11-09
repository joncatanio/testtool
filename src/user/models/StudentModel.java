package user.models;

import java.util.*;
import classpack.models.*;
 
/**
 * The Student class extends the base User class and
 * features limited privileges compared to the Teacher
 * class as well as different GUI functionality.
 */
public abstract class StudentModel extends UserModel {
    /**
     * A collection of classes that the student is
     * enrolled in.
     */
    private Collection<ClassModel> classes;

    /**
     * Constructs a student object using the constructor from the UserModel class.
     * @param newUsername Username given by the new student.
     * @param newPassword Password given by the new student.
     */
    public StudentModel(String newUsername, String newPassword) {
        super(newUsername, newPassword);
    }

    /**
     * Adds a class to the student object.
     * @param newClass The class object to add.
     */
    public void addClass(ClassModel newClass) {
        classes.add(newClass);
        System.out.println("Added a new class to student");
    }

    /**
     * Removes a class from the student object
     * @param toRemove The class object to remove
     */
    public void removeClass(ClassModel toRemove) {
        classes.remove(toRemove);
        System.out.println("Removed a class from student");
    }
}
