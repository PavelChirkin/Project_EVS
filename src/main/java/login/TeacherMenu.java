package login;

import com.fasterxml.jackson.databind.ObjectMapper;
import files.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherMenu {

    public ExamTest addNewExam(Scanner sc) {
        ExamTest examTest = new ExamTest();
        System.out.println("*** Input examID you want to upload ***");
        examTest.setExamId(sc.nextLine());
        System.out.println("*** Input examName you want to upload ***");
        examTest.setExamNames(sc.nextLine());
        System.out.println("*** How many questions will be in the exam ***");
        int testSize =  Integer.parseInt(sc.nextLine());
        List<Question> questions = new ArrayList<>();

        for (int i=0; i < testSize; i++) {
            System.out.println("*** Set question " + (i+1) + " body ***");
            Question question = new Question();
            question.setQuestBody(sc.nextLine());
            System.out.println(question.getQuestBody());
            System.out.println("*** Set answer's to questions variants");
            for (AnswersId aId : AnswersId.values()) {
                System.out.println("*** Set answer's to questions variant: " + aId);
                question.setAnswerVariantsElement(aId, sc.nextLine());
            }
            System.out.println("*** Set correct answer's to questions variant");
            question.setGoodAnswer(sc.nextLine());
            System.out.println(question.toString());
            questions.add(question);
            examTest.setQuestions(questions);
        }
        return examTest;
    }
/*
    public AnswersToQuestions addNewExam(Scanner sc) {
        AnswersToQuestions answersToQuestions = new AnswersToQuestions();
        System.out.println("*** Input examID you want to upload ***");
        answersToQuestions.setExamId(sc.nextLine());
        System.out.println("*** Input examName you want to upload ***");
        answersToQuestions.setExamName(sc.nextLine());

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

 */
    public void writeExamFile(ExamTest examTest, String dir2) throws IOException {
        //System.out.println(examTest.toString());
        ObjectMapper mapper = new ObjectMapper();
        File file = FileUtils.createFileIfNotExist(dir2 + "\\"+"oop_basics_answer.json");
        mapper.writeValue(file, examTest);
        System.out.println("file: oop_basics_answer" + " is written");

        //Add new Exam to Exam List
        List<ExamTest> examTestList = new ArrayList<>();
        File fileExamList = FileUtils.createFileIfNotExist(dir2 + "\\"+"examList.json");
        examTestList.add(examTest);
        mapper.writeValue(fileExamList, examTestList);
        System.out.println("file: fileExamList" + "is written");
    }

}
