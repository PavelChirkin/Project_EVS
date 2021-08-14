package files;

import java.util.List;

public class ExamTest extends Exam {


    public String examId;
    public ExamNames examNames;
    public List<Question> questions;

    public ExamTest(String examId, ExamNames examNames, List<Question> questions) {
        this.examId = examId;
        this.examNames = examNames;
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

    public ExamNames getExamNames() {
        return examNames;
    }

    public void setExamNames(ExamNames examNames) {
        this.examNames = examNames;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
