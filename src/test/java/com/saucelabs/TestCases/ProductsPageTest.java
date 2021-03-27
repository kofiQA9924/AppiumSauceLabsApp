package com.saucelabs.TestCases;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Pages.LoginPage;
import com.saucelabs.Pages.ProductsPage;
import com.saucelabs.Utilities.Reporting;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by RUTHERFORD on 3/12/2021.
 */
@Listeners({Reporting.class})
public class ProductsPageTest extends BaseClass {
    public static LoginPage loginPage;
    public static ProductsPage productsPage;

    public ProductsPageTest() throws FileNotFoundException, MalformedURLException {
        super();
    }
    @BeforeTest
    public void setUpProduct() throws MalformedURLException, FileNotFoundException, InterruptedException {
        initialization();
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        loginPage.setUsername(properties.getProperty("username"));
        loginPage.setPassword(properties.getProperty("password"));
        loginPage.setLoginButton();
        Thread.sleep(3000);
    }
    @Test(priority = 0)
    public void testBckpck(){
        productsPage.setSauceLabBpck();
        Assert.assertTrue(true);
    }
    @Test(priority = 1)
    public void testBike(){
        productsPage.setSauceLabBike();
        Assert.assertTrue(true);
    }
    @Test(priority = 2)
    public void testLabT(){
        productsPage.setSauceLabT();
        Assert.assertTrue(true);
    }
    @Test(priority = 3)
    public void testMain(){
        productsPage.setCart();
        Assert.assertTrue(true);
    }
}
