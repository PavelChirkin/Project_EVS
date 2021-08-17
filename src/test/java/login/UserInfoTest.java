package login;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoTest {
    UserInfo userInfo = new UserInfo();


    @Test
    public void testCheckPasswordLengthIsShort(){

        boolean result = userInfo.checkPasswordLength("Bb");
        assertFalse(result);
    }
    @Test
    public void testCheckPasswordLengthIsNormal(){

        boolean result = userInfo.checkPasswordLength("Bbbb");
        assertTrue(result);
    }
    @Test
    public void testCheckPasswordLengthIsNull(){

        boolean result = userInfo.checkPasswordLength("");
        assertFalse(result);
    }
    @Test
    public void testCheckPasswordIsOnlyLowLetters(){

        boolean result = userInfo.checkPasswordLength("bbbbb");
        assertFalse(result);
    }
    @Test
    public void testCheckPasswordIsOnlyCapitalLetters(){

        boolean result = userInfo.checkPasswordLength("BBBBB");
        assertFalse(result);
    }
    @Test
    public void testCheckUserNameLengthIsShort(){

        boolean result = userInfo.checkUserNameLength("Bb");
        assertFalse(result);
    }
    @Test
    public void testCheckUserNameLengthIsNormal(){

        boolean result = userInfo.checkUserNameLength("Bbbb");
        assertTrue(result);
    }
    @Test
    public void testCheckUserNameLengthIsNull(){

        boolean result = userInfo.checkUserNameLength("");
        assertFalse(result);
    }
    @Test
    public void testCheckUserNameIsOnlyLowLetters(){

        boolean result = userInfo.checkUserNameLength("bbbbb");
        assertFalse(result);
    }
    @Test
    public void testCheckUserNameIsOnlyCapitalLetters(){

        boolean result = userInfo.checkUserNameLength("BBBBB");
        assertFalse(result);
    }

}