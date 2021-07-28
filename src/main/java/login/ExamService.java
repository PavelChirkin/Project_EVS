package login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import files.ExamAttempt;
import files.ExamSet;

import java.io.File;
import java.io.IOException;
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
        System.out.println("*** To take Oop-basics exam, please press [1] ***");
        String examId = sc.nextLine();
        return  examId;
    }

    public void tryExam(String examId, String userName, String dir) throws IOException {
        //check time run from last trying

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File(dir + "\'"+ "testrez.json");
        if(!file.exists())
        {
            file.createNewFile();
        }

        ExamAttempt examAttempt = new ExamAttempt(examId, userName, new ExamSet( "a", "b", "c", "d"));
        mapper.writeValue(file, examAttempt);
    }

}

