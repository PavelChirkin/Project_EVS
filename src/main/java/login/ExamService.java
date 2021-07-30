package login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import files.AnswersToQuestions;
import files.ExamAttempt;
import files.ExamSet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ExamService {


    public String choseExam(Scanner sc) {
        System.out.println("*** Chose exam you want take ***");
        String examId = getExamId(sc);

        return  examId;
    }

    public String getExamId(Scanner sc) {
        //String examId = "124";
        //get exam Id from list
        System.out.println("*** To take Oop-basics exam, please press [124] ***");
        String examId = sc.nextLine();
        return  examId;
    }

    public void tryExam(String examId, String userName, String dir, ExamSet examSet) throws IOException {
        //check time run from last trying

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File(dir + "\\"+ "testrez.json");
        if(!file.exists())
        {
            file.createNewFile();
        }

        ExamAttempt examAttempt = new ExamAttempt(examId, userName, examSet);
        mapper.writeValue(file, examAttempt);
        System.out.println("file: " + "is written");
    }
    public ExamSet tryQuestions(Scanner sc) {
        ExamSet examSet = new ExamSet();
        String[] question = new String[4];
        System.out.println("*** Please answer the questions ***");
        System.out.println("1 Question  * How many legs elephant have ? *");
        System.out.println(" 1 - [a] , 2 - [b], 3 - [c], 4 - [d]");
        question[0] = (sc.nextLine());

        System.out.println("2 Question  * Does crocodiles can fly ? *");
        System.out.println(" Yes - [a] , No - [b], May be - [c]");
        question[1] = (sc.nextLine());

        System.out.println("3 Question  * How many jobs you can do at the same time ? *");
        System.out.println(" 1 - [a] , 2 - [b], 3 - [c], 4 and more - [d]");
        question[2] = (sc.nextLine());

        System.out.println("4 Question  * What the Java is ? *");
        System.out.println(" island - [a] , coffee - [b], language - [c]");
        question[3] = (sc.nextLine());
        examSet.setQuestion(question);
        examSet.setExamId("124");
        return examSet;
    }
    public void CheckExam(AnswersToQuestions answersToQuestions, ExamSet examSet, String dir) throws IOException {
        //check time run from last trying
        int count;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File(dir + "\\"+ "testrez.json");
        if(!file.exists())
        {
            file.createNewFile();
        }

        //answersToQuestions.;
        //mapper.writeValue(file, persons);

        System.out.println("file: " + "is written");
    }

}

