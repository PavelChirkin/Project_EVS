package files;

public class AnswersToQuestions {

    private String examId;

    private String[] answers;

    public AnswersToQuestions(String examId,String answ_1, String answ_2, String answ_3, String answ_4) {
        this.examId = examId;
        this.answers = answers;
    }

    public AnswersToQuestions() {
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }
    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

}
