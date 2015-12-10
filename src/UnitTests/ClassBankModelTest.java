package UnitTests;

import test.models.*;
import question.models.*;
import classpack.models.*;
import java.util.*;

public class ClassBankModelTest  {

    public void testGetClassByIdMethod() {

        ClassBankModel inst = ClassBankModel.getInstance();

        ClassModel sample = new ClassModel();
        sample.setClassId(1234);

        ClassModel sample2 = new ClassModel();
        sample.setClassId(4321);

        ClassModel sample3 = new ClassModel();
        sample.setClassId(3333);

        ClassModel sample4 = new ClassModel();
        sample.setClassId(7777);

        ClassModel temp;

        inst.addClass(sample);
        inst.addClass(sample2);
        inst.addClass(sample3);
        inst.addClass(sample4);

        try {
            temp = inst.getClassById(1234);
            temp = inst.getClassById(4567);
        }
        catch (NoSuchElementException nsee) {

        }

        System.out.println("ALEX: testGetClassByIdMethod Finished");
    }
}