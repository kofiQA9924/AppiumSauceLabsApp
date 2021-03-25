package com.saucelabs.LoginPageTest;

import com.google.common.base.Verify;
import com.saucelabs.Base.BaseClass;
import com.saucelabs.Pages.CheckoutInfoPage;
import com.saucelabs.Pages.LoginPage;
import com.saucelabs.Pages.ProductsPage;
import com.saucelabs.Pages.YourCartPage;
import com.saucelabs.Utilities.Reporting;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by RUTHERFORD on 3/16/2021.
 */
@Listeners({Reporting.class})
public class CheckoutInfoPageTest extends BaseClass {
    public static LoginPage loginPage;
    public static ProductsPage productsPage;
    public static YourCartPage yourCartPage;
    public static CheckoutInfoPage checkoutInfoPage;

    public CheckoutInfoPageTest() throws FileNotFoundException, MalformedURLException {
        super();
    }
    @BeforeTest
    public void setUpCheckInfo() throws MalformedURLException, FileNotFoundException {
        initialization();
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        yourCartPage=new YourCartPage(driver);
        checkoutInfoPage=new CheckoutInfoPage(driver);
        loginPage.setUsername(properties.getProperty("username"));
        loginPage.setPassword(properties.getProperty("password"));
        loginPage.setLoginButton();
        productsPage.setSauceLabBpck();
        productsPage.setSauceLabBike();
        productsPage.setSauceLabT();
        productsPage.setCart();
        yourCartPage.setCheckout();
    }
    @Test(priority = 0)
    public void testfirstName()
    {
        checkoutInfoPage.setFirstName(properties.getProperty("firstname"));
        Verify.verify(true);
        logger.info("firstname entered & Verified");
    }
    @Test(priority = 1)
    public void testlastName()
    {
        checkoutInfoPage.setLastName(properties.getProperty("lastname"));
        Verify.verify(true);
        logger.info("lastname entered & Verified");
    }
    @Test(priority = 2)
    public void testzipcode()
    {
        checkoutInfoPage.setZipCode(properties.getProperty("zipcode"));
        Verify.verify(true);
        logger.info("zipcode entered & Verified");
    }
    @Test(priority = 3)
    public void testcontinue()
    {
        checkoutInfoPage.setContinue();
        Verify.verify(true);
        logger.info("Continue button clicked & Verified");
    }
    @Test(priority = 4)
    public void testConfirmPay(){
        checkoutInfoPage.confirmpayInfo();
        Verify.verify(true);
        logger.info("Confirm pay checked & Verified");
    }
    @Test(priority = 5)
    public void testfinish(){
        checkoutInfoPage.setFinish();
        Assert.assertTrue(true);
        logger.info("checkout Info checked & Verified");
    }
}
