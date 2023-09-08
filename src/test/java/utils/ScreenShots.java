package utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenShots {

    // create an object of AndroidDriver;

    public static void takeScreenShot(AndroidDriver driver,String screenShot){

        // use try and catch block to handle the exceptions
        try{
            // store the screenshot as file
            File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            // convert file format of screenshot in .jpg format
            FileUtils.copyFile(file,new File("C:\\Users\\divjot.kaur\\IdeaProjects\\finalassessmentmobiletesting\\src\\test\\resources\\screenshots\\"+screenShot+".jpg"));
        }
        // user handles the exception using catch block
        catch(Exception e){

            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
}
