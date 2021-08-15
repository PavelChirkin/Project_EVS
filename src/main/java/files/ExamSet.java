package files;

import java.util.List;

public class ExamSet {

    private String examId;
    private List<String> question;
    private int counter;

    public ExamSet() {
    }

    public ExamSet(String examId, List<String> question, int counter) {
        this.examId = examId;
        this.question = question;
        this.counter = counter;
    }
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }
    public List<String> getQuestion() {
        return question;
    }
    public void setQuestion(List<String> question) {
        this.question = question;
    }
}

