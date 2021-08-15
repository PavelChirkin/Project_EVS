package files;

import java.util.List;

public class ExamTest extends Exam {


    public String examId;
    public String examNames;
    public List<Question> questions;

    public ExamTest(String examId, ExamNames examNames, List<Question> questions) {
        this.examId = examId;
        this.examNames = ExamNames.valueOf(examNames.name()).toString();
        this.questions = questions;
    }
    public ExamTest() {
            }
    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }
/*
    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examNames.name();
    }   */

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public ExamNames getExamNames() {
        return ExamNames.OOP_PAGRINDAI;
    }

    @Override
    public void setExamNames(String examNames) {
        this.examNames = examNames.toString();
    }

    @Override
    public String toString() {
        return "ExamTest{" +
                "examId='" + examId + '\'' +
                ", examNames='" + examNames + '\'' +
                ", questions=" + questions +
                '}';
    }
}
