package files;

import java.time.LocalDateTime;
import java.util.Date;

public class ExamResult {


    private String examAttemptId;
    private String userName;
    private String examId;
    private String dateStamp;
    private int AssessmentOfKnowledge;


    public ExamResult(String examAttemptId, String userName, String examId, String dateStamp, int assessmentOfKnowledge) {
        this.examAttemptId = examAttemptId;
        this.userName = userName;
        this.examId = examId;
        this.dateStamp = dateStamp;
        AssessmentOfKnowledge = assessmentOfKnowledge;
    }

    public ExamResult() {
    }
    public String getExamAttemptId() {
        return examAttemptId;
    }

    public void setExamAttemptId(String examAttemptId) {
        this.examAttemptId = examAttemptId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    }

    public int getAssessmentOfKnowledge() {
        return AssessmentOfKnowledge;
    }

    public void setAssessmentOfKnowledge(int assessmentOfKnowledge) {
        AssessmentOfKnowledge = assessmentOfKnowledge;
    }
}
