package login;

import com.fasterxml.jackson.databind.ObjectMapper;
import files.AnswersToQuestions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TeacherMenu {

    public AnswersToQuestions addNewExam(Scanner sc) {
        AnswersToQuestions answersToQuestions = new AnswersToQuestions();
        System.out.println("*** Input examID you want to upload ***");
        answersToQuestions.setExamId(sc.nextLine());

        String[] quest_body = new String[4];
        String[] answers = new String[4];

        System.out.println("*** Set question 1 body ***");
        quest_body[0] = sc.nextLine();
        System.out.println("*** Set question 1 answer ***");
        answers[0] = sc.nextLine();

        System.out.println("*** Set question 2 body ***");
        quest_body[1] = sc.nextLine();
        System.out.println("*** Set question 2 answer ***");
        answers[1] = sc.nextLine();

        System.out.println("*** Set question 3 body ***");
        quest_body[2] = sc.nextLine();
        System.out.println("*** Set question 3 answer ***");
        answers[2] = sc.nextLine();

        System.out.println("*** Set question 4 body ***");
        quest_body[3] = sc.nextLine();
        System.out.println("*** Set question 4 answer ***");
        answers[3] = sc.nextLine();

        answersToQuestions.setQuest_body(quest_body);
        answersToQuestions.setAnswers(answers);

    return answersToQuestions;
    }
    public void writeExamFile(AnswersToQuestions answersToQuestions, String dir2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(dir2 + "\\"+"oop_basics_answer.json");
        mapper.writeValue(file, answersToQuestions);
        System.out.println("file: oop_basics_answer" + "is written");
    }

}
