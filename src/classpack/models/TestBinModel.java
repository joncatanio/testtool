package classpack.models;

import java.util.ArrayList;
import java.util.Arrays;

public class TestBinModel {

    private int id;
    private double average;
    private double averageTimeInMinutes;
    //private ArrayList<TestModel> submissions;

    public TestBinModel() {
        id = 123467;
        average = 87.5;
        averageTimeInMinutes = 43.17;
    }

    public int getId() {
        return id;
    }

    public void regradeForSubmissions(int[] ids) {

        for(int i = 0; i < ids.length; i++) {
            //regrade(ids[i]);
        }
    }

    public ArrayList<String> getSubmissions() {

        return new ArrayList<String>(Arrays.asList("spongebob", "darth vader", "lord voldemort", "mike wazowski"));
    }

    public double getAverage() {
        return average;
    }

    private double getAverageTimeInMinutes() {
        return averageTimeInMinutes;
    }
}
