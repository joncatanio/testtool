public class TestBinModelTest extends TestBinModel {

    public void testAddSubmissionMethod() {

        TestModel sample = new TestModel();
        sample.setId(1234);

        TestModel sample2 = new TestModel();
        sample.setId(4321);

        TestModel sample3 = new TestModel();
        sample.setId(7777);

        TestModel sample4 = new TestModel();
        sample.setId(7777);

        addSubmission(sample);

        ArrayList<Integer> seen = new ArrayList<Integer>();
        for(TestModel submission: submissions) {
            if( seen.contains(submission.getId()) ) {
                System.out.println("FAILURE, DUPLICATE TESTS!");
            } else {
                seen.add( submission.getId() );
            }
        }

        addSubmission(sample2);

        seen.clear();
        for(TestModel submission: submissions) {
            if( seen.contains(submission.getId()) ) {
                System.out.println("FAILURE, DUPLICATE TESTS!");
            } else {
                seen.add( submission.getId() );
            }
        }

        addSubmission(sample3);

        seen.clear();
        for(TestModel submission: submissions) {
            if( seen.contains(submission.getId()) ) {
                System.out.println("FAILURE, DUPLICATE TESTS!");
            } else {
                seen.add( submission.getId() );
            }
        }

        addSubmission(sample4);

        seen.clear();
        for(TestModel submission: submissions) {
            if( seen.contains(submission.getId()) ) {
                System.out.println("FAILURE, DUPLICATE TESTS!");
            } else {
                seen.add( submission.getId() );
            }
        }

    }
}