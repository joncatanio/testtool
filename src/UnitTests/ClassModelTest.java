package UnitTests;

import classpack.models.ClassModel;
import test.models.TestModel;

/**
 * Created by andrewgough94 on 12/9/2015.
 */
public class ClassModelTest extends ClassModel{
    public void testPublishTest() {
        System.out.println("Testing ClassModel.setPublishTest...");
        ClassModel testClass = new ClassModel();

        TestModel test = new TestModel();
        test.setName("sampleTest");
        testClass.publishTest(test);
        assert test.getPublished() == true;

        System.out.println("TestModel.publishTest successful.");

    }
    public void testSetClassId() {
        System.out.println("Testing ClassModel.setClassId...");
        ClassModel testClass = new ClassModel();

        int classId = 5;
        testClass.setClassId(classId);
        assert testClass.getClassId() == classId;

        System.out.println("TestModel.setClassId successful.");
    }

    public void testSetClassCode() {
        System.out.println("Testing ClassModel.setClassCode...");
        ClassModel testClass = new ClassModel();

        String classCode = "sampleClassCode";
        testClass.setClassCode(classCode);
        assert testClass.getClassCode().equals(classCode);

        System.out.println("TestModel.setClassCode successful.");
    }

    public void testSetSchoolName() {
        System.out.println("testing ClassModel.setClassCode...");
        ClassModel testClass = new ClassModel();

        String schoolName = "sampleSchool";
        testClass.setSchoolName(schoolName);
        assert testClass.getClassCode().equals(schoolName);

        System.out.println("TestModel.setSchoolName successful.");
    }
}
