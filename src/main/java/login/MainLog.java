package login;

import com.sun.tools.javac.Main;
import login.UserInfo;

import java.util.Scanner;

public class MainLog {

    public static void main(String[] args) {
        MainLog main = new MainLog();
        main.menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        UserInfo userInfo = new UserInfo();
        boolean isLoading = true;
        while(isLoading) {
            System.out.println(" ___________________________________");
            System.out.println("| 1 - User registration             |");
            System.out.println("| 2 - User login                    |");
            System.out.println("| 3 - Exit                          |");
            System.out.println("|___________________________________|");

            String select = sc.nextLine();
            switch (select) {
                case "1" -> {
                    userInfo.registration(sc);
                }
                case "2" -> {
                    if(userInfo.login(sc)) {
                        System.out.println("darom viska");
                    }
                    //System.out.println("ku-ku");
                   // System.out.println("ku-ku");
                    //System.out.println("ku-ku");
                }
                case "3" -> {
                    isLoading = false;
                }
                default -> {
                    System.out.println("Please select menu item");
                }
            }
        }
    }
}

