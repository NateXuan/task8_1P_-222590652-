package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testLoginSuccess() {
        // login successful
        boolean result = LoginService.login("wenzong", "wenzong_pass", "2000-01-01");
        Assert.assertTrue(result);
    }

    @Test
    public void testLoginFailureByPassword() {
        // wrong password
        boolean result = LoginService.login("wenzong", "wrong_pass", "2000-01-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testLoginFailureByDoB() {
        // wrong DoB
        boolean result = LoginService.login("wenzong", "wenzong_pass", "2001-01-01");
        Assert.assertFalse(result);
    }
    
    
}
