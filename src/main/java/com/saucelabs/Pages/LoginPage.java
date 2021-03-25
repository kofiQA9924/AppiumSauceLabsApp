package com.saucelabs.Pages;

import com.saucelabs.Base.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by RUTHERFORD on 3/11/2021.
 */
public class LoginPage extends BaseClass {
    public LoginPage(AndroidDriver<MobileElement>driver) throws FileNotFoundException, MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    @CacheLookup
    MobileElement username;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    @CacheLookup
    MobileElement password;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    @CacheLookup
    MobileElement loginButton;

    public void setUsername(String uname){
        username.sendKeys(uname);
    }
    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }
    public void setLoginButton(){
        loginButton.click();
    }
}
