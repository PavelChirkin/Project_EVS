package files;

public class ExamSet {
    private String question_1;
    private String question_2;
    private String question_3;
    private String question_4;

    public ExamSet() {
    }

    public ExamSet(String question_1, String question_2, String question_3, String question_4) {
        this.question_1 = question_1;
        this.question_2 = question_2;
        this.question_3 = question_3;
        this.question_4 = question_4;
    }

    public String getQuestion_1() {
        return question_1;
    }

    public void setQuestion_1(String question_1) {
        this.question_1 = question_1;
    }

    public String getQuestion_2() {
        return question_2;
    }

    public void setQuestion_2(String question_2) {
        this.question_2 = question_2;
    }

    public String getQuestion_3() {
        return question_3;
    }

    public void setQuestion_3(String question_3) {
        this.question_3 = question_3;
    }

    public String getQuestion_4() {
        return question_4;
    }

    public void setQuestion_4(String question_4) {
        this.question_4 = question_4;
    }

    @Override
    public String toString() {
        return "ExamSet{" +
                "question_1='" + question_1 + '\'' +
                ", question_2='" + question_2 + '\'' +
                ", question_3='" + question_3 + '\'' +
                ", question_4='" + question_4 + '\'' +
                '}';
    }

}
