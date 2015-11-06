package classpack.models;

import java.util.*;

public class ClassModel {

    HashMap<Integer, TestBinModel> bins = new HashMap<Integer, TestBinModel>();

    public ClassModel() {

    }

    public TestBinModel getTestBin(int testBinId) {

        //return bins.get(testBinId);
        return new TestBinModel();
    }

}
