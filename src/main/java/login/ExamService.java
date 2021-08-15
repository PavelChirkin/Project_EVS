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
    ExamResult examResult = new ExamResult();
    List<ExamResult> examResultList = new ArrayList<>();
    //List<AnswersToQuestions> answersToQuestionsList = new ArrayList<>();
    ExamTest examTest = new ExamTest();
    List<ExamTest> examTestList = new ArrayList<>();
    LocalDateTime currentTime = LocalDateTime.now();

    public void initArrayLists(String dir1,String dir2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File fileResults = FileUtils.createFileIfNotExist(dir2 + "\\"+ "examresults.json");
        if (fileResults.equals(examResultList)) {
            examResultList = mapper.readValue(fileResults, new TypeReference<>() { });
        }

        File fileExamList = FileUtils.createFileIfNotExist(dir2 + "\\"+"examList.json");
        //answersToQuestionsList = mapper.readValue(file1, new TypeReference<>() {});
       // if (fileExamList.equals(examTestList)) {
            examTestList = mapper.readValue(fileExamList, new TypeReference<>() {});
       // }
    }
    public ExamTest choseExam(Scanner sc) {
        System.out.println("*** Chose exam from list below ***");
    /*    for (AnswersToQuestions atq : answersToQuestionsList) {
            System.out.println("["+ atq.getExamId()+ "]" + atq.getExamName());
        }   */
        //System.out.println(examTestList.size());
        for (ExamTest examTest : examTestList) {
            System.out.println("["+ examTest.getExamId()+ "]" + examTest.getExamNames());
        }
        System.out.println("*** please choose exam ID - number in the brackets []***");
        String examId = sc.nextLine();
        ExamTest ChosenExamTest =  examTest;
        for (ExamTest examTest : examTestList) {
            if(examTest.getExamId().equals(examId)) {
                 ChosenExamTest =  examTest;
            }
        }
         return  ChosenExamTest;
    }

    public void tryExam(Scanner sc,ExamTest examTest, String userName, String dir1, String dir2) throws IOException {
        //check time run from last trying
        if(!examResultList.isEmpty()) {
            for (ExamResult rez : examResultList) {
                if(rez.getDateStamp().plusDays(2).isBefore(currentTime)&&rez.getExamId().equals(examTest.getExamId())&&rez.getUserName().equals(userName)) {
                    System.out.println("You don't pass 2 days from last attempt. Try later");
                    return;
                }
            }
        }
        ExamSet examSet = new ExamSet();
        examSet = tryQuestions(sc,examTest);
        ObjectMapper mapper = new ObjectMapper();
        File fileAttempt = FileUtils.createFileIfNotExist(dir1 + "\\"+ examTest.getExamId() + userName + "examAttempt.json");
        ExamAttempt examAttempt = new ExamAttempt(examTest.getExamId(), userName, examSet);
        mapper.writeValue(fileAttempt, examAttempt);
        System.out.println("examAttempt.json file: " + "is written");

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File fileResults = FileUtils.createFileIfNotExist(dir2 + "\\"+ "examresults.json");
        int numb = examResultList.size() + 1;
        ExamResult examResult = new ExamResult("" + numb, userName, examSet.getExamId(),currentTime,examSet.getCounter());
        examResultList.add(examResult);
        mapper.writeValue(fileResults, examResultList);
        System.out.println("file: fileResults" + "is written");

    }
    public ExamSet tryQuestions(Scanner sc, ExamTest examTest) {
        ExamSet examSet = new ExamSet();
        List<String> answerSet = new ArrayList<>();
        System.out.println("*** To take Oop-basics exam, please press [124] ***");

        int counter = 0;
        for (Question q : examTest.questions) {
            System.out.println(q.getQuestBody());
            System.out.println("*** Answer variants below ***");
            System.out.println(q.getAnswerVariants());
            System.out.println("*** Please choose correct answer ***");
            String answer = sc.nextLine();
            answerSet.add(answer);
            if (q.getGoodAnswer().equals(answer)){
                counter++;
            }
        }
        examSet.setExamId(examTest.getExamId());
        examSet.setQuestion(answerSet);
        examSet.setCounter(counter);
        return examSet;
    }
 /*   public void CheckExam(String userName, ExamSet examSet, String dir1,String dir2) throws IOException {
        //bring answers to questions set from list and match them with examset
        int counter = 0;
        Question question = new Question();
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

        for (ExamTest examTest : examTestList){
            if(examTest.getExamId().equals(examSet.getExamId())){
                for (int i=0; i<examTest.questions.size(); i++)
                {
                    //if(examTest.getQuestions().getGoodAnswer   getAnswers()[i].equals(examSet.getQuestion()[i])){
                        counter++;
                   // }
                }
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File fileResults = FileUtils.createFileIfNotExist(dir2 + "\\"+ "examresults.json");
        int numb = examResultList.size() + 1;
        ExamResult examResult = new ExamResult("" + numb, userName, examSet.getExamId(),currentTime,counter);
        examResultList.add(examResult);
        mapper.writeValue(fileResults, examResultList);
        System.out.println("file: fileResults" + "is written");
    }   */

}

