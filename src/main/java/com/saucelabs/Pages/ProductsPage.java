package com.saucelabs.Pages;

import com.saucelabs.Base.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by RUTHERFORD on 3/12/2021.
 */
public class ProductsPage extends BaseClass {
    public ProductsPage(AndroidDriver<MobileElement>driver) throws FileNotFoundException, MalformedURLException {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
    @CacheLookup
    MobileElement SauceLabBpck;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]/android.widget.TextView")
    @CacheLookup
    MobileElement SauceLabBike;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
    @CacheLookup
    MobileElement SauceLabT;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    @CacheLookup
    MobileElement Cart;

    public void setSauceLabBpck() {
        SauceLabBpck.click();
    }
    public void setSauceLabBike() {
        SauceLabBike.click();
    }

    public void setSauceLabT(){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                " (new UiSelector().textContains(\"All Rights Reserved.\").instance(0))");
        SauceLabT.click();
    }
    public void setCart(){
        Cart.click();
    }
}
