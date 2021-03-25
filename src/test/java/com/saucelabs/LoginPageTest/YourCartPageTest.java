package com.saucelabs.LoginPageTest;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Pages.LoginPage;
import com.saucelabs.Pages.ProductsPage;
import com.saucelabs.Pages.YourCartPage;
import com.saucelabs.Utilities.Reporting;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by RUTHERFORD on 3/15/2021.
 */
@Listeners({Reporting.class})
public class YourCartPageTest extends BaseClass {
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public YourCartPage yourCartPage;

    public YourCartPageTest() throws FileNotFoundException, MalformedURLException {
        super();
    }
    @BeforeTest
    public void setUpCart() throws MalformedURLException, FileNotFoundException, InterruptedException {
        initialization();
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        yourCartPage= new YourCartPage(driver);
        loginPage.setUsername(properties.getProperty("username"));
        loginPage.setPassword(properties.getProperty("password"));
        loginPage.setLoginButton();
        Thread.sleep(3000);
        productsPage.setSauceLabBpck();
        productsPage.setSauceLabBike();
        productsPage.setSauceLabT();
        productsPage.setCart();
        Thread.sleep(3000);
    }
    @Test
    public void testCheckout(){
        yourCartPage.setCheckout();
    }

}
