package login;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import files.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamService {

    List<ExamResult> examResultList = new ArrayList<>();
    LocalDateTime currentTime = LocalDateTime.now();

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

    public void tryExam(String examId, String userName, String dir1, String dir2, ExamSet examSet) throws IOException {
        //check time run from last trying
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(dir2 + "\\"+ "examrezults.json");
        examResultList = mapper.readValue(file, new TypeReference<>() {});
        if(!examResultList.isEmpty()) {
            for (ExamResult rez : examResultList) {
                if(rez.getDateStamp().plusDays(2).isBefore(currentTime)&&rez.getExamId().equals(examId)&&rez.getUserName().equals(userName)) {
                    System.out.println("You don't pass 2 days from last attempt. Try later");
                    return;
                }
            }
        }
        File file1 = FileUtils.createFileIfNotExist(dir1 + "\\"+ examId + userName + "exam.json");
        ExamAttempt examAttempt = new ExamAttempt(examId, userName, examSet);
        mapper.writeValue(file1, examAttempt);
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
    public void CheckExam(String userName, ExamSet examSet, String dir1,String dir2) throws IOException {
        //check time run from last trying
        int counter = 0;
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(dir2 + "\\"+"oop_basics_answer.json");
        AnswersToQuestions answersToQuestions = mapper.readValue(file, AnswersToQuestions.class);
        //System.out.println(answersToQuestions);
        for (int i=0; i<answersToQuestions.getAnswers().length; i++)
        {
            if(answersToQuestions.getAnswers()[i].equals(examSet.getQuestion()[i])){
                counter++;
            }
        }

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file1 = FileUtils.createFileIfNotExist(dir2 + "\\"+ "examrezults.json");
        int numb = examResultList.size() + 1;
        ExamResult examRezult = new ExamResult("" + numb, userName, examSet.getExamId(),currentTime,counter);

        examResultList.add(numb, examRezult);

        mapper.writeValue(file1, examResultList);

        System.out.println("file: " + "is written");
    }

}

