package login;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * user authentication and registration
 */
public class UserInfo {

    private final Map<String, String> users = new HashMap<>();

    public void registration(Scanner sc) {
        System.out.println("*** User Registration ***");
        String userName = getUniqueUserName(sc);
        String password = getCorrectPassword(sc);

        users.put(userName, password);
        System.out.println("User successfully registered");
    }

    public boolean login(Scanner sc) {     // return logRez [success and role]
        boolean logRez = false;
        System.out.println("*** User login ***");
        System.out.println("Insert username");
        String userName = sc.nextLine();
        System.out.println("Insert password");
        String password = sc.nextLine();

        // if teacher --> password hardcoded

        String encodedPassword = users.get(userName);

        if(encodedPassword != null && encodedPassword.equals(DigestUtils.sha256Hex(password))){
            System.out.println("User login successfully");
            logRez = true;
        }else {
            System.out.println("Login error, please check credentials or create account");
        }
        return logRez;
    }

    private String getCorrectPassword(Scanner sc) {
        String password;
        String repeatPassword;
        String text = "";
        do {
            System.out.println(text);
            System.out.println("Please insert password");
            password = sc.nextLine();
            System.out.println("Repeat you password");
            repeatPassword = sc.nextLine();
            text = "Passwords not equals";
        } while(!password.equals(repeatPassword));

        return DigestUtils.sha256Hex(password);
    }

    private String getUniqueUserName(Scanner sc) {
        String userName;
        String text = "Please insert username";
        do {
            System.out.println(text);
            userName = sc.nextLine();
            text = "This name exist please insert another one";
        }while(users.get(userName) != null);

        return userName;
    }
}