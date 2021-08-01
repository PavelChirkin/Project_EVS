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
    List<AnswersToQuestions> answersToQuestionsList = new ArrayList<>();
    LocalDateTime currentTime = LocalDateTime.now();

    public void initArrayLists(String dir1,String dir2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(dir2 + "\\"+ "examrezults.json");
        examResultList = mapper.readValue(file, new TypeReference<>() {});

        File file1 = new File(dir2 + "\\"+"oop_basics_answer.json");
        answersToQuestionsList = mapper.readValue(file1, new TypeReference<>() {});
    }
    public String choseExam(Scanner sc) {
        System.out.println("*** Chose exam from list below ***");
        for (AnswersToQuestions atq : answersToQuestionsList) {
            System.out.println("["+ atq.getExamId()+ "]" + atq.getExamName());
        }
        System.out.println("*** please exam ID - number in the brackets []***");
        String examId = sc.nextLine();
        return  examId;
    }

    public void tryExam(String examId, String userName, String dir1, String dir2, ExamSet examSet) throws IOException {
        //check time run from last trying
        if(!examResultList.isEmpty()) {
            for (ExamResult rez : examResultList) {
                if(rez.getDateStamp().plusDays(2).isBefore(currentTime)&&rez.getExamId().equals(examId)&&rez.getUserName().equals(userName)) {
                    System.out.println("You don't pass 2 days from last attempt. Try later");
                    return;
                }
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        File file1 = FileUtils.createFileIfNotExist(dir1 + "\\"+ examId + userName + "exam.json");
        ExamAttempt examAttempt = new ExamAttempt(examId, userName, examSet);
        mapper.writeValue(file1, examAttempt);
        System.out.println("file: " + "is written");
    }
    public ExamSet tryQuestions(Scanner sc, String examId) {
        ExamSet examSet = new ExamSet();
        String[] question = new String[4];
        System.out.println("*** To take Oop-basics exam, please press [124] ***");
        for (AnswersToQuestions atq : answersToQuestionsList) {
            if (atq.getExamId().equals(examSet.getExamId())) {
                for(int j = 0; j < atq.getQuest_body().length; j++) {
                    System.out.println(atq.getQuest_body()[j]);
                    question[j] = (sc.nextLine());
                }
            }
        }

        examSet.setQuestion(question);
        return examSet;
    }
    public void CheckExam(String userName, ExamSet examSet, String dir1,String dir2) throws IOException {
        //bring answers to questions set from list and match them with examset
        int counter = 0;
        for (AnswersToQuestions atq : answersToQuestionsList){
            if(atq.getExamId().equals(examSet.getExamId())){
                for (int i=0; i<atq.getAnswers().length; i++)
                {
                    if(atq.getAnswers()[i].equals(examSet.getQuestion()[i])){
                        counter++;
                    }
                }
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file1 = FileUtils.createFileIfNotExist(dir2 + "\\"+ "examrezults.json");
        int numb = examResultList.size() + 1;
        ExamResult examRezult = new ExamResult("" + numb, userName, examSet.getExamId(),currentTime,counter);
        examResultList.add(numb, examRezult);
        mapper.writeValue(file1, examResultList);
        System.out.println("file: " + "is written");
    }

}

