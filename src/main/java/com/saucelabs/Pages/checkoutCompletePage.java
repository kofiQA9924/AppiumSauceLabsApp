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
 * Created by RUTHERFORD on 3/22/2021.
 */
public class checkoutCompletePage extends BaseClass {
    public checkoutCompletePage(AndroidDriver<MobileElement>driver) throws FileNotFoundException, MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
    @CacheLookup
    MobileElement Thankyou;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    @CacheLookup
    MobileElement Mainmenu;

    public boolean setThankyou(){
        Thankyou.isDisplayed();
        return true;
    }
    public void setMainmenu(){
        Mainmenu.click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                " (new UiSelector().textContains(\"LOGOUT\").instance(0))").click();
    }
}
