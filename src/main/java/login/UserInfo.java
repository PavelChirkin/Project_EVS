package login;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Locale;
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

    public String[] login(Scanner sc) {
        String[] logRez = {"0","0", "0"};                       //  logRez [success = "1", fail = "0"
        System.out.println("*** User login ***");           //  and role -> student = 0, teacher = 1 ]
        System.out.println("Insert username");              // and user name
        String userName = sc.nextLine();
        System.out.println("Insert password");
        String password = sc.nextLine();

        String encodedPassword = users.get(userName);
        // if teacher --> password hardcoded
        if(userName.equals("teacher")&& encodedPassword.equals(DigestUtils.sha256Hex("teacher"))){
            logRez[0] = "1";
            logRez[1] = "1";
            logRez[2] = "teacher";
        }else{
        if(encodedPassword != null && encodedPassword.equals(DigestUtils.sha256Hex(password))){
            System.out.println("User login successfully");
            logRez[0] = "1";
            logRez[2] = userName;
        }else {
            System.out.println("Login error, please check credentials or create account");
            //logRez[0] = "0";
        }
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
            boolean passwordLength = false;
            do {
                password = sc.nextLine();
                passwordLength = checkPasswordLength(password);
            }while(!passwordLength);
            System.out.println("Repeat you password");
            repeatPassword = sc.nextLine();
            text = "Passwords not equals";
        } while(!password.equals(repeatPassword));

        return DigestUtils.sha256Hex(password);
    }

    boolean checkPasswordLength(String password) {
        boolean passwordLength = true;
        if (password.length() < 3) {
            passwordLength = false;
            System.out.println("Yours password is too short, choose another password");
        }
        if (password.equals(password.toLowerCase())) {
            passwordLength = false;
            System.out.println("Yours password contain only lower case letters, choose another password");
        }
        if (password.equals(password.toUpperCase())) {
            passwordLength = false;
            System.out.println("Yours password contain only Capital letters, choose another password");
        }
        return passwordLength;
    }

    private String getUniqueUserName(Scanner sc) {
        String userName;
        String text = "Please insert username";
        do {
            //System.out.println(text);
            //userName = sc.nextLine();
            boolean userNameLength = false;
            do {
                userName = sc.nextLine();
                userNameLength = checkUserNameLength(userName);
            }while(!userNameLength);
            text = "This name exist please insert another one";
        }while(users.get(userName) != null);

        return userName;
    }
    boolean checkUserNameLength(String userName) {
        boolean userNameLength = true;
        if (userName.length() < 3) {
            userNameLength = false;
            System.out.println("Yours Users Name length is too short, choose another Users Name");
        }
        if (userName.equals(userName.toLowerCase())) {
            userNameLength = false;
            System.out.println("Yours password contain only lower case letters, choose another password");
        }
        if (userName.equals(userName.toUpperCase())) {
            userNameLength = false;
            System.out.println("Yours password contain only Capital letters, choose another password");
        }
        return userNameLength;
    }

}