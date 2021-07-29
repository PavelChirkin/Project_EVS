package login;

//import com.sun.tools.javac.Main;
//import login.UserInfo;

import files.ExamSet;

import java.io.IOException;
import java.util.Scanner;

public class MainLog {

    public static void main(String[] args) throws IOException {
        String dir1 = "C:"+ "\\"+"exams"+"\\"+"oop-basics";  //args[0];
        MainLog main = new MainLog();

        main.menu(dir1);
    }

    private void menu(String dir1) throws IOException {
        Scanner sc = new Scanner(System.in);
        UserInfo userInfo = new UserInfo();
        ExamService examService = new ExamService();
        boolean isLoading = true;
        while(isLoading) {
            System.out.println(" ___________________________________");
            System.out.println("| 1 - User registration             |");
            System.out.println("| 2 - User login                    |");
            System.out.println("| 3 - Exit                          |");
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
                        }else{
                            //System.out.println("it's a student");
                            String examId = examService.choseExam(sc);
                            //System.out.println(examId + logRez[2] + dir1);
                            ExamSet examSet = examService.tryQuestions(sc);
                            examService.tryExam(examId, logRez[2],dir1, examSet);
                        }
                    }
                }
                case "3" -> isLoading = false;
                default ->  System.out.println("Please select menu item");

            }
        }
    }
}

