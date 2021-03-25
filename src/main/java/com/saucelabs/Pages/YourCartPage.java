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
 * Created by RUTHERFORD on 3/15/2021.
 */
public class YourCartPage extends BaseClass {
    public YourCartPage(AndroidDriver<MobileElement>driver) throws FileNotFoundException, MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]/android.widget.TextView")
    @CacheLookup
    MobileElement checkout;

    public void setCheckout(){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                " (new UiSelector().textContains(\"CONTINUE SHOPPING\").instance(0))");
        checkout.click();
    }
}
