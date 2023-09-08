package locators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Locators {

    // the purpose of this class is to store all the locators inside it to avoid as much hard-coding as possible

//    public static AndroidDriver driver;
    public static By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
    public static By skipButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip");
    public static By addNotesButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn1");
    public static By chooseTextButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/text");
    public static By saveButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/back_btn");
    public static By textBox = By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note");
    public static By homePage = By.id("com.socialnmobile.dictapps.notepad.color.note:id/note_list");
    public static By editButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_btn");
    public static By colorButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/color_btn");
    public static By icon = By.id("com.socialnmobile.dictapps.notepad.color.note:id/icon_nav");
    public static By settings = By.xpath("//android.widget.TextView[contains(@text,'Settings')]");
    public static By day = By.xpath("(//android.widget.CheckedTextView[@resource-id='android:id/text1'])[2]");
    public static By search = By.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn2");
    public static By searchBox = By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_search");
    public static By textNote = By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_title");
    public static By thirdNote = By.id("com.socialnmobile.dictapps.notepad.color.note:id/title");
    public static By searchBack = By.id("com.socialnmobile.dictapps.notepad.color.note:id/search_back");
    public static By fourthNote = By.xpath("(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/title'])[2]");
    public static By secondNote = By.xpath("(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/title'])[4]");
    public static By firstNote = By.xpath("(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/title'])[3]");
    public static By archiveOption = By.xpath("//android.widget.TextView[contains(@text,'Archive')]");

    public static By menuButton = By.id("com.socialnmobile.dictapps.notepad.color.note:id/menu_btn");
    public static By deleteButton = By.xpath("//android.widget.TextView[contains(@text,'Delete')]");
    public static By deletePopup = By.id("android:id/button1");
    public static By trash = By.xpath("//android.widget.TextView[contains(@text,'Trash Can')]");
    public static By archive = By.xpath("//android.widget.TextView[contains(@text,'Archive')]");
    public static By firstDeletedNote = By.xpath("(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/title'])[1]");
    public static By secondDeletedNote = By.xpath("(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/title'])[2]");
    public static By archiveArea = By.xpath("(//android.widget.ListView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/note_list'])[1]");
    public static MobileElement getChooseColorElement(AndroidDriver driver,int index) {
        String locator = "com.socialnmobile.dictapps.notepad.color.note:id/txt" + index;
        return (MobileElement) driver.findElementById(locator);
    }
    public static MobileElement getClickTextBoxElement(AndroidDriver driver, int index) {
        String xpathLocator = "(//android.widget.TextView[contains(@text,'user created')])[" + index + "]";
        return (MobileElement) driver.findElement(By.xpath(xpathLocator));
    }
    public static MobileElement getTimeElement(AndroidDriver driver,int index) {
        String xpathLocator = "(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/date'])[" + index + "]";
        return (MobileElement) driver.findElement(By.xpath(xpathLocator));
    }
}
