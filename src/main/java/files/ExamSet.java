package files;

public class ExamSet {

    private String examId;
    private String[] question;

    public ExamSet(String examId, String[] question) {
        this.examId = examId;
        this.question = question;
    }

    public ExamSet() {
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }
    public String[] getQuestion() {
        return question;
    }
    public void setQuestion(String[] question) {
        this.question = question;
    }
}

