package test.models;

/**
 * The TestHandlerModel handles generating, grading, and creating tests.
 * It is the engine that handles and generic Test tasks that doesn't belong
 * to a specific model.
 *
 * Created by JonCatanio on 11/5/15.
 */
public class TestHandlerModel {
    /**
     * Regrades the given test.
     *
     * @param id unique id of a given test.
     */
    public void regrade(int id) {
        System.out.println("Test " + id + " has been regraded.");
    }
}
