package login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoTest {

   /* @BeforeEach
    public void setUp() {
        UserInfo userInfo = new UserInfo();
    } */
    @Test
    public void testCheckPasswordLengthIsShort(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkPasswordLength("Bb");
        assertFalse(result);
    }
    @Test
    public void testCheckPasswordLengthIsNormal(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkPasswordLength("Bbbb");
        assertTrue(result);
    }
    @Test
    public void testCheckPasswordLengthIsNull(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkPasswordLength("");
        assertFalse(result);
    }
    @Test
    public void testCheckPasswordIsOnlyLowLetters(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkPasswordLength("bbbbb");
        assertFalse(result);
    }
    @Test
    public void testCheckPasswordIsOnlyCapitalLetters(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkPasswordLength("BBBBB");
        assertFalse(result);
    }
    @Test
    public void testCheckUserNameLengthIsShort(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkUserNameLength("Bb");
        assertFalse(result);
    }
    @Test
    public void testCheckUserNameLengthIsNormal(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkUserNameLength("Bbbb");
        assertTrue(result);
    }
    @Test
    public void testCheckUserNameLengthIsNull(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkUserNameLength("");
        assertFalse(result);
    }
    @Test
    public void testCheckUserNameIsOnlyLowLetters(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkUserNameLength("bbbbb");
        assertFalse(result);
    }
    @Test
    public void testCheckUserNameIsOnlyCapitalLetters(){
        UserInfo userInfo = new UserInfo();
        boolean result = userInfo.checkUserNameLength("BBBBB");
        assertFalse(result);
    }

}