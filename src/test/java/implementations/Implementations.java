package implementations;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en_scouse.An;
import locators.Locators;
import logger.Loggers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.ScreenShots;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Implementations {
    // create an object of the AndroidDriver;
    public static AndroidDriver driver;

    public static void getDesiredCapabilities(){
        // use try and catch block to handle the exceptions
        try{
            // call getProperties() function from ConfigReader class to get the data from config.properties file
            ConfigReader.getProperties();

            // create an object of DesiredCapabilities class
            DesiredCapabilities dc = new DesiredCapabilities();

            // get the data about the device name, path of apk file, platform name, automation name
            dc.setCapability(MobileCapabilityType.DEVICE_NAME,ConfigReader.deviceName);
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.platformName);
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.automationName);
            dc.setCapability(MobileCapabilityType.APP, ConfigReader.app);

            // create an object of URL class to store the URL
            // URL consist of the remote host = 127.0.0.1 , remote port = 4723, remote path = /wd/hub
            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            // create an object of the AndroidDriver and store the URL plus DesiredCapabilities inside it
            driver = new AndroidDriver(url,dc);

            // provide implicit wait of 10 seconds to wait for the elements to load until this much time
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ScreenShots.takeScreenShot(driver,"screenshot1");
        }
        // user handles the exception using catch block
        catch(Exception e){

            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void clickOn(MobileElement element){
        // use try and catch block to handle the exceptions
        try{
            // create an object of TouchAction class and using tap() method, tap on one element
            TouchAction action = new TouchAction(driver);
            action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).release().perform();
        }
        // user handles the exception using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void allowAccessUser(){
        // use try and catch block to handle the exceptions
        try{
            // click on allow button
            MobileElement allowButton = (MobileElement) driver.findElement(Locators.allowButton);
            clickOn(allowButton);
            // press back key
            driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
            ScreenShots.takeScreenShot(driver,"screenshot2");
            // enter skip button
            MobileElement skipButton = (MobileElement) driver.findElement(Locators.skipButton);
            clickOn(skipButton);
        }
        // user handles the exception using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userCreateNotes(){
        // use try and catch block to handle the exceptions
        try{
            // for creating 5 notes, user starts a loop from 1 to 5 :
            for(int i=1; i<=5; i++){
                // click on add button
                MobileElement addButton = (MobileElement) driver.findElement(Locators.addNotesButton);
                clickOn(addButton);
                // choose text option
                MobileElement textButton = (MobileElement) driver.findElement(Locators.chooseTextButton);
                clickOn(textButton);

                // enter text inside the text-box
                MobileElement textBox = (MobileElement) driver.findElement(Locators.textBox);
                textBox.sendKeys("user created "+ i + " note in the ColorNote App");
                // user saves the text
                MobileElement saveButton = (MobileElement) driver.findElement(Locators.saveButton);
                clickOn(saveButton);
                // press back to visit the homepage
                clickOn(saveButton);
                ScreenShots.takeScreenShot(driver,"screenshot3");
            }
        }
        // user handles the exception using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userVerifyNotes(){
        // use try-catch block to handle the exceptions
        try{
            // get the text of all the items present inside the homepage
            String home = driver.findElement(Locators.homePage).getText();
//            String getTextOfHomepage = homePage.getText();
            Loggers.logger.info(home);
            ScreenShots.takeScreenShot(driver,"screenshot4");
        }
        // handle the exceptions using catch block
        catch(Exception e){

            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userChangesColor(){
        // use try-catch block to handle the exceptions
        try{
            // start a loop from 1 to 5 to change the color of each text note one by one
            for(int i=1; i<=5; i++){
                // click on each text note one by one
                MobileElement clickTextBox =Locators.getClickTextBoxElement(driver,i);
                clickOn(clickTextBox);
                // click on the edit button
                MobileElement editButton = (MobileElement) driver.findElement(Locators.editButton);
                clickOn(editButton);
                // click on the color button
                MobileElement colorButton = (MobileElement) driver.findElement(Locators.colorButton);
                clickOn(colorButton);
                // choose the colors
                MobileElement chooseColor = Locators.getChooseColorElement(driver,i);
                clickOn(chooseColor);
                // save the text again
                MobileElement saveButton = (MobileElement) driver.findElement(Locators.saveButton);
                clickOn(saveButton);
                // move to the home page again
                clickOn(saveButton);
                ScreenShots.takeScreenShot(driver,"screenshot5");
            }
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userGetTime(){
        // use try-catch block to handle the exceptions
        try{
            // start a loop from 1 to 5 to get the time of each text note one by one
            for(int i=1; i<=5;i++){
                // get the time of each text note
                MobileElement getTime = Locators.getTimeElement(driver,i);
                // store it in string
                String time = getTime.getText();
                // print the time of each text note
                Loggers.logger.info(time);
                ScreenShots.takeScreenShot(driver,"screenshot6");
            }
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void tapIcon(){
        // use try-catch block to handle the exceptions
        try{
            // click on icon
            MobileElement icon = (MobileElement) driver.findElement(Locators.icon);
            clickOn(icon);
            ScreenShots.takeScreenShot(driver,"screenshot7");
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void tapSettings(){
        // use try-catch block to handle the exceptions
        try{
            // click on settings option
            MobileElement settings = (MobileElement) driver.findElement(Locators.settings);
            clickOn(settings);
            ScreenShots.takeScreenShot(driver,"screenshot8");
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void scrollTillOption(){
        // use try-catch block to handle the exceptions
        try{
            // scroll till the expected option
            MobileElement scroll = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"First day of week\").instance(0))");
            clickOn(scroll);
            ScreenShots.takeScreenShot(driver,"screenshot9");
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userSelectsDay(){
        // use try-catch block to handle the exceptions
        try{
            // implicit wait of 5 seconds
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            // select the first day of the week as Monday
            MobileElement day = (MobileElement) driver.findElement(Locators.day);
            clickOn(day);
            ScreenShots.takeScreenShot(driver,"screenshot10");
            // verify the day selected is MONDAY
//            Loggers.logger.info("The first day of the week is : "+day.getText());
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void homePage(){
        // use try-catch block to handle the exceptions
        try{
            // press back 2 times using key-event to get back to homepage
            driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
            driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        }
        // handle the exception using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userSearches(){
        // use try-catch block to handle the exceptions
        try{
            // user clicks on search icon box
            MobileElement search = (MobileElement) driver.findElement(Locators.search);
            clickOn(search);

            // user enter data in the search box
            MobileElement searchBox = (MobileElement) driver.findElement(Locators.searchBox);
            searchBox.sendKeys("3");

            // press enter
            driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
            ScreenShots.takeScreenShot(driver,"screenshot11");

//            // user moves down to get the text of the 3rd note
//            driver.pressKey(new KeyEvent().withKey(AndroidKey.DPAD_DOWN));
//
//            // press enter
//            driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        }
        // handle the exception using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userVerifyText(){
        // use try-catch block to handle the exceptions
        try{
            // get the text which is written inside the text note
            MobileElement thirdNote = (MobileElement) driver.findElement(Locators.thirdNote);
            Loggers.logger.info("Verify the 3rd searched note by printing the obtained value :"+thirdNote.getText());
            ScreenShots.takeScreenShot(driver,"screenshot12");
        }
        // handle the exception using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void navigateToHomePage(){
        // use try-catch block to handle the exceptions
        try{
            // press back to get back to home page
            MobileElement searchBack = (MobileElement) driver.findElement(Locators.searchBack);
            clickOn(searchBack);
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userDeletesNote(){
        // use try-catch block to handle the exceptions
        try{
              // tap on the second note
                    MobileElement secondNote = (MobileElement) driver.findElement(Locators.secondNote);
                    clickOn(secondNote);
                    // tap on the menu bar
                    MobileElement menuButton = (MobileElement) driver.findElement(Locators.menuButton);
                    clickOn(menuButton);
                    // choose delete option
                    MobileElement deleteButton = (MobileElement) driver.findElement(Locators.deleteButton);
                    clickOn(deleteButton);
                    // press ok to delete
                    MobileElement deletePopup = (MobileElement) driver.findElement(Locators.deletePopup);
                  ScreenShots.takeScreenShot(driver,"screenshot13");
                    clickOn(deletePopup);

        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userDeleteAgain(){
        // use try-catch block to handle the exceptions
        try{
            // tap on the 4th note
            MobileElement forth = (MobileElement) driver.findElement(Locators.fourthNote);
            clickOn(forth);
            // tap on the menu button
            MobileElement menuButton = (MobileElement) driver.findElement(Locators.menuButton);
            clickOn(menuButton);
            // select the delete option
            MobileElement deleteButton = (MobileElement) driver.findElement(Locators.deleteButton);
            clickOn(deleteButton);

            // press ok to delete the note
            MobileElement deletePopup = (MobileElement) driver.findElement(Locators.deletePopup);
            ScreenShots.takeScreenShot(driver,"screenshot14");
            clickOn(deletePopup);
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userVerifyDeletedNotes(){
        // use try-catch block to handle the exceptions
        try{
            // press on the icon bar
            MobileElement icon = (MobileElement) driver.findElement(Locators.icon);
            clickOn(icon);
            // click on the trash option
            MobileElement trash = (MobileElement) driver.findElement(Locators.trash);
            clickOn(trash);
            // get the locator of both the two deleted notes
            MobileElement firstDeletedNote = (MobileElement) driver.findElement(Locators.firstDeletedNote);
            MobileElement secondDeletedNote = (MobileElement) driver.findElement(Locators.secondDeletedNote);

            // verify that the notes are deleted or not by printing their values :
            Loggers.logger.info("Data inside first deleted note : "+firstDeletedNote.getText());
            Loggers.logger.info("Data inside second deleted note : "+secondDeletedNote.getText());
            ScreenShots.takeScreenShot(driver,"screenshot15");
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void tapHome(){
        // use try-catch block to handle the exceptions
        try{
            //press back to get back to home page
            driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userTapFirstNote(){
        // use try-catch block to handle the exceptions
        try{
            // tap on first note
            MobileElement firstNote = (MobileElement) driver.findElement(Locators.firstNote);
            clickOn(firstNote);
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userChooseArchive(){
        // use try-catch block to handle the exceptions
        try{
            // click on menu button
            MobileElement menu = (MobileElement) driver.findElement(Locators.menuButton);
            clickOn(menu);
            // click on archive button
            MobileElement archiveOption = (MobileElement) driver.findElement(Locators.archiveOption);
            clickOn(archiveOption);
            // accept the popup to archive the text note
            MobileElement popup = (MobileElement) driver.findElement(Locators.deletePopup);
            ScreenShots.takeScreenShot(driver,"screenshot15");
            clickOn(popup);

        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
    public static void userVerifyArchiveText(){
        // use try-catch block to handle the exceptions
        try{
            // click on icon
            MobileElement icon = (MobileElement) driver.findElement(Locators.icon);
            clickOn(icon);
            // click on archive option
            MobileElement archive = (MobileElement) driver.findElement(Locators.archive);
            clickOn(archive);
            ScreenShots.takeScreenShot(driver,"screenshot16");
            // text area of archive
            MobileElement archiveArea = (MobileElement) driver.findElement(Locators.archiveArea);
            // verify this by printing the text to the console
            Loggers.logger.info("data inside archived text note "+archiveArea.getText());
        }
        // handle the exceptions using catch block
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
}
