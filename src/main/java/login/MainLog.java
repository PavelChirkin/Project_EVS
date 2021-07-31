package login;

//import com.sun.tools.javac.Main;
//import login.UserInfo;

import files.AnswersToQuestions;
import files.ExamSet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainLog {

    LocalDateTime currentTime = LocalDateTime.now();

    public static void main(String[] args) throws IOException {
        String dir1 = "C:"+ "\\"+"exams"+"\\"+"oop-basics";  //args[0];
        String dir2 = "C:"+ "\\"+"exams"+"\\"+"oop-basics"+"\\"+ "oop_basics_answer";  //args[1];
        MainLog main = new MainLog();

        main.menu(dir1, dir2);
    }

    private void menu(String dir1,String dir2) throws IOException {
        Scanner sc = new Scanner(System.in);
        UserInfo userInfo = new UserInfo();
        ExamService examService = new ExamService();
        TeacherMenu teacherMenu = new TeacherMenu();
        String[] answers = {"1", "2", "3", "4"};
        String[] quest_body = {"1", "2", "3", "4"};
        AnswersToQuestions answersToQuestions = new AnswersToQuestions();
        boolean isLoading = true;
        while(isLoading) {
            System.out.println(" ___________________________________");
            System.out.println("|   1 - User registration           |");
            System.out.println("|   2 - User login                  |");
            System.out.println("|   3 - Exit                        |");
            System.out.println("|___________________________________|");

            String select = sc.nextLine();
            switch (select) {
                case "1" -> userInfo.registration(sc);
                case "2" -> {
                    String[] logRez = userInfo.login(sc);
                    if(logRez[0].equals("1")) {  //login success
                        if(logRez[1].equals("1")){
                            System.out.println("teacher is here - anything is possible");
                            //call teachers menu
                            boolean teacherWork = true;
                            while(teacherWork) {
                                System.out.println(" ___________________________________");
                                System.out.println("|   1 - Set exam questions          |");
                                System.out.println("|   2 - Check exam answers          |");
                                System.out.println("|   3 - Get statistics              |");
                                System.out.println("|   4 - Exit                        |");
                                System.out.println("|___________________________________|");

                                String select1 = sc.nextLine();
                                switch (select1) {
                                    case "1" -> {
                                        answersToQuestions = teacherMenu.addNewExam(sc);
                                        teacherMenu.writeExamFile(answersToQuestions, dir2);
                                    }
                                    // case "2" -> teacherMenu
                                    // case "3" -> {
                                    case "4" -> {
                                        isLoading = false;
                                        teacherWork = false;
                                    }
                                    default -> System.out.println("Please select menu item");
                                }
                            }
                        }else{
                            //System.out.println("it's a student");
                            String examId = examService.choseExam(sc);
                            //Find examSet by examId
                            //System.out.println(examId + logRez[2] + dir1);
                            ExamSet examSet = examService.tryQuestions(sc);
                            examService.tryExam(examId, logRez[2],dir1, dir2, examSet);
                            examService.CheckExam(logRez[2],examSet, dir1, dir2);
                        }
                    }
                }
                case "3" -> isLoading = false;
                default ->  System.out.println("Please select menu item");

            }
        }
    }
}

