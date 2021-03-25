package com.saucelabs.LoginPageTest;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Pages.LoginPage;
import com.saucelabs.Utilities.Reporting;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by RUTHERFORD on 3/11/2021.
 */
@Listeners({Reporting.class})
public class LoginPageTest extends BaseClass {
    public LoginPageTest loginPageTest;
    public LoginPage loginPage;
    public LoginPageTest() throws FileNotFoundException, MalformedURLException {
        super();
    }
    @BeforeTest
    public void setUp() throws FileNotFoundException, MalformedURLException {
        initialization();
        loginPage=new LoginPage(driver);
    }
    @Test(priority = 0)
    public void testOne(){
        loginPage.setUsername(properties.getProperty("username"));
    }
    @Test(priority = 1)
    public void testTwo(){
        loginPage.setPassword(properties.getProperty("password"));
    }
    @Test(priority = 2)
    public void testThree(){
        loginPage.setLoginButton();
    }
}
