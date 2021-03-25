package com.saucelabs.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

/**
 * Created by RUTHERFORD on 3/23/2021.
 */
public class Reporting extends TestListenerAdapter {
    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static Capture capture;

    @Override
    public void onStart(ITestContext testContext) {
        extentHtmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Test-output/"+System.currentTimeMillis()+"reports.html");
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        extentHtmlReporter.config().setDocumentTitle("Android Test Report");
        extentHtmlReporter.config().setReportName("SauceLabs Android Test");

        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("OS","Windows 10");
        extentReports.setSystemInfo("Department","Quality Assurance");
        extentReports.setSystemInfo("PlatformName","Android");
        extentReports.setSystemInfo("PlatformVersion","7.0");
        extentReports.setSystemInfo("DeviceName","Galaxy Nexus API 24");
        extentReports.setSystemInfo("","");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        if(tr.getStatus()==ITestResult.FAILURE){
            try {
                capture.screenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }
}