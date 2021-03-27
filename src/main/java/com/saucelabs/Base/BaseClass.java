package com.saucelabs.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by RUTHERFORD on 3/11/2021.
 */
public class BaseClass {
    public static Properties properties;
    public static FileInputStream fileInputStream;
    public static DesiredCapabilities desiredCapabilities;
    public static WebDriverWait wait;
    public static AndroidDriver<MobileElement>driver;
    public static Logger logger;

    public BaseClass() throws FileNotFoundException, MalformedURLException {
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream("Configuration/configuration.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initialization() throws MalformedURLException {
        PropertyConfigurator.configure("Log4j.properties");
        logger=Logger.getLogger("log4j.properties");
        desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("udid","emulator-5554");
        desiredCapabilities.setCapability("deviceName","Galaxy Nexus API 24");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("platformVersion","7.0");
        desiredCapabilities.setCapability("appPackage","com.swaglabsmobileapp");
        desiredCapabilities.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
        driver=new AndroidDriver<MobileElement>(new URL("http:127.0.0.1:4723/wd/hub"),desiredCapabilities);
        wait=new WebDriverWait(driver,30);
    }
}
