package files;

public class ExamAttempt {
    private String examId;
    private String userName;
    private ExamSet examset;

    public ExamAttempt(String examId, String userName, ExamSet examset) {
        this.examId = examId;
        this.userName = userName;
        this.examset = examset;
    }

    public ExamAttempt() {
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ExamSet getExamset() {
        return examset;
    }

    public void setExamset(ExamSet examset) {
        this.examset = examset;
    }


}
