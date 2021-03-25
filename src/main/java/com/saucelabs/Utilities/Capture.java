package com.saucelabs.Utilities;

import com.saucelabs.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by RUTHERFORD on 3/23/2021.
 */
public class Capture extends BaseClass {
    public Capture() throws FileNotFoundException, MalformedURLException {
        super();
    }
    public void screenshot() throws IOException {
        File screenshotsFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotsFile,new File(System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+"ErrorImg.png"));
    }
}
