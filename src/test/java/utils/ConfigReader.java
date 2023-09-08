package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    // create static variable for device name, platform name, automation name,
    // also create a static variable to store the path of apk file
    public static String deviceName;
    public static String platformName;
    public static String automationName;
    public static String app;
    // create an object of Properties class :
    public static Properties properties = new Properties();
    public static void getProperties(){

        // use try and catch block to handle the exceptions
        try{

            // create an object of FileInputStream class and store the path of
            // config.properties file inside it
            FileInputStream inputStream = new FileInputStream("C:\\Users\\divjot.kaur\\IdeaProjects\\finalassessmentmobiletesting\\src\\config.properties");

            // load the config.properties file
            properties.load(inputStream);

            // get the device name from the config.properties file
            deviceName = properties.getProperty("deviceName");

            // get the platform name from the config.properties file
            platformName = properties.getProperty("platformName");

            // get the automation name from the config.properties file
            automationName = properties.getProperty("automationName");

            // get the path of the apk (Android Application Package) file from the config.properties file
            app = properties.getProperty("app");

        }
        // user handles the exception using catch block
        catch(Exception e){

            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
}
