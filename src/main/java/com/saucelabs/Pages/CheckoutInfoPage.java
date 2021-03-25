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
 * Created by RUTHERFORD on 3/16/2021.
 */
public class CheckoutInfoPage extends BaseClass{
    public CheckoutInfoPage(AndroidDriver<MobileElement>driver) throws FileNotFoundException, MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    @CacheLookup
    MobileElement firstName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    @CacheLookup
    MobileElement lastName;

    @AndroidFindBy(xpath ="//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    @CacheLookup
    MobileElement zipCode;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    @CacheLookup
    MobileElement Continue;

    @AndroidFindBy(xpath ="//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[2]")
    @CacheLookup
    MobileElement paymentInfo;

   @AndroidFindBy(xpath = "\t\n" +
           "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    @CacheLookup
    MobileElement finish;

    public void setFirstName(String fname){
        firstName.sendKeys(fname);
    }
    public void setLastName(String lname){
        lastName.sendKeys(lname);
    }
    public void setZipCode(String zpcde){
        zipCode.sendKeys(zpcde);
    }
    public void setContinue(){
        Continue.click();
    }
    public boolean confirmpayInfo(){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                " (new UiSelector().textContains(\"Payment Information:\").instance(0))");
        paymentInfo.isDisplayed();
        return true;
    }
    public void setFinish(){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                " (new UiSelector().textContains(\"FINISH\").instance(0))");
        finish.click();
    }
}
