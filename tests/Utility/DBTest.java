import question.models.QuestionBank;

public class DBTest
{
    private QuestionBank qb = QuestionBank.getInstance();

    public void main() {

    }

    public void addQuestions() {
        qb.add("FillInTheBlank", "52", "334", "CSC", "DOES this work?", "", "", "no", -1, 2, 100, 1);
        qb.add("FillInTheBlank", "55", "552", "CSC", "DOES THIS work?", "", "", "yes", -1, 3, 100, 1);
        qb.add("FillInTheBlank", "12", "656", "CSC", "DOES this WORK?", "", "", "no", -1, 4, 100, 1);
        qb.add("FillInTheBlank", "42", "121", "CSC", "does this work?", "", "", "yes", -1, 5, 100, 1);
        qb.add("FillInTheBlank", "33", "989", "CSC", "DOES this WORK?", "", "", "no", -1, 6, 100, 1);
    }

    public void deleteQuestions() {

    }

    public void readQuestions() {

    }
}