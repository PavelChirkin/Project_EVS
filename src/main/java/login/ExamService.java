package login;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import files.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamService {
    //ExamResult examResult = new ExamResult();
    List<ExamResult> examResultList = new ArrayList<>();
    ExamTest examTest = new ExamTest();
    List<ExamTest> examTestList = new ArrayList<>();
    LocalDateTime currentTime = LocalDateTime.now();
    String formatToday = currentTime.format(DateTimeFormatter.BASIC_ISO_DATE);

    public void initArrayLists(String dir2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File fileResults = FileUtils.createFileIfNotExist(dir2 + "\\"+ "examresults.json");
       // if (fileResults.equals(examResultList)) {
            examResultList = mapper.readValue(fileResults, new TypeReference<>() { });
       // }

        File fileExamList = FileUtils.createFileIfNotExist(dir2 + "\\"+"examList.json");
        // if (fileExamList.equals(examTestList)) {
            examTestList = mapper.readValue(fileExamList, new TypeReference<>() {});
        // }
    }
    public ExamTest choseExam(Scanner sc) {
        System.out.println("*** Chose exam from list below ***");
        // Show list of exams
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
                if(LocalDate.parse(rez.getDateStamp(), DateTimeFormatter.BASIC_ISO_DATE).plusDays(2).
                       isAfter(ChronoLocalDate.from(currentTime))&&rez
                       .getExamId().equals(examTest.getExamId())&&rez.getUserName().equals(userName)) {

                    System.out.println("You don't pass 2 days from last attempt. Try later");
                    return;
                }
            }
        }
        ExamSet examSet;
        examSet = tryQuestions(sc,examTest);
        ObjectMapper mapper = new ObjectMapper();
        File fileAttempt = FileUtils.createFileIfNotExist(dir1 + "\\"+ examTest.getExamId() + userName + "examAttempt.json");
        ExamAttempt examAttempt = new ExamAttempt(examTest.getExamId(), userName, examSet);
        mapper.writeValue(fileAttempt, examAttempt);
        System.out.println("examAttempt.json file: " + "is written");

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File fileResults = FileUtils.createFileIfNotExist(dir2 + "\\"+ "examresults.json");
        int numb = examResultList.size() + 1;
        ExamResult examResult = new ExamResult("" + numb, userName, examSet.getExamId(),formatToday,examSet.getCounter());
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
            boolean badChoise = true;
            String answer = "";
            while (badChoise) {
                 answer = sc.nextLine();
                switch (answer) {
                    case "A", "B", "C", "D" -> badChoise = false;
                    default -> {
                        badChoise = true;
                        System.out.println("*** Wrong answer ***");
                        System.out.println("*** Please choose between A B C D variants ***");
                    }
                }
            }
            answerSet.add(answer);
            if (q.getGoodAnswer().equals(answer)){
                counter++;
            }
        }
        examSet.setExamId(examTest.getExamId());
        examSet.setQuestion(answerSet);
        // according 10 ball evaluating system
        examSet.setCounter(counter*10/answerSet.size());
        return examSet;
    }

    public void getStatistics() {
        for (ExamResult rez : examResultList) {
            System.out.println(rez.toString());
        }
    }


}

