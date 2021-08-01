package files;

public class AnswersToQuestions {

    private String examId;
    private String examName;
    private String[] answers;
    private String[] quest_body;    //with possible answer variants

    public AnswersToQuestions(String examId,String examName,String[] answers, String[] quest_body) {
        this.examId = examId;
        this.answers = answers;
        this.quest_body = quest_body;
    }

    public AnswersToQuestions() {
    }

    public String getExamId() {
        return examId;
    }
    public void setExamId(String examId) {
        this.examId = examId;
    }
    public String getExamName() {
        return examName;
    }
    public void setExamName(String examName) {
        this.examName = examName;
    }
    public String[] getAnswers() {
        return answers;
    }
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
    public String[] getQuest_body() {
        return quest_body;
    }
    public void setQuest_body(String[] quest_body) {
        this.quest_body = quest_body;
    }
}
