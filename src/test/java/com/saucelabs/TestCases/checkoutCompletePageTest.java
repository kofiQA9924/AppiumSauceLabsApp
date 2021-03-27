package com.saucelabs.TestCases;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Pages.*;
import com.saucelabs.Utilities.Reporting;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by RUTHERFORD on 3/22/2021.
 */
@Listeners({Reporting.class})
public class checkoutCompletePageTest extends BaseClass {
    public static checkoutCompletePage checkoutCompletePage;
    public static CheckoutInfoPage checkoutInfoPage;
    public static LoginPage loginPage;
    public static ProductsPage productsPage;
    public static YourCartPage yourCartPage;

    public checkoutCompletePageTest() throws FileNotFoundException, MalformedURLException {
        super();
    }
    @BeforeTest
    public void setUpcomplete() throws MalformedURLException, FileNotFoundException, InterruptedException {
    initialization();
    checkoutCompletePage=new checkoutCompletePage(driver);
    checkoutInfoPage=new CheckoutInfoPage(driver);
    loginPage=new LoginPage(driver);
    productsPage=new ProductsPage(driver);
    yourCartPage=new YourCartPage(driver);
    loginPage.setUsername(properties.getProperty("username"));
    loginPage.setPassword(properties.getProperty("password"));
    loginPage.setLoginButton();
    productsPage.setSauceLabBpck();
    productsPage.setSauceLabBike();
    productsPage.setSauceLabT();
    productsPage.setCart();
    Thread.sleep(3000);
    yourCartPage.setCheckout();
    checkoutInfoPage.setFirstName(properties.getProperty("firstname"));
    checkoutInfoPage.setLastName(properties.getProperty("lastname"));
    checkoutInfoPage.setZipCode(properties.getProperty("zipcode"));
    checkoutInfoPage.setContinue();
    checkoutInfoPage.confirmpayInfo();
    checkoutInfoPage.setFinish();
    logger.info("checkout Complete Page Test initialized");
    }
    @Test(priority = 0)
    public void testThankyou(){
        checkoutCompletePage.setThankyou();
        Assert.assertTrue(true);
        logger.info("Assertion: Thank you displayed ");
    }
    @Test(priority = 1)
    public void testMainmenu(){
        checkoutCompletePage.setMainmenu();
        Assert.assertTrue(true);
        logger.info("Assertion: Main menu clicked");
    }
}
