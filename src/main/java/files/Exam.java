package files;

import java.util.List;

public abstract class Exam {
    public String examId = null;
    public ExamNames examNames;
    public List<Object> questions = null;

    public abstract ExamNames getExamNames();
    public abstract void setExamNames(String examNames);
}
