package stepdefinitions;

import implementations.Implementations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static implementations.Implementations.*;

public class StepDefinitions {
    @Given("User launches the {string} Application")
    public void launchApp(String app){
        getDesiredCapabilities();
    }
    @When("User allows the {string} Application to access {string}")
    public void allowAccess(String app, String access){
        allowAccessUser();
    }
    @And("User creates {int} notes in the {string} Application")
    public void createNotes(int notes, String app){
        userCreateNotes();
    }
    @Then("User verifies {int} are displayed")
    public void verifyNotes(int notes){
        userVerifyNotes();
    }
    @Given("User changes the color of each text in the {string} Application as {string}")
    public void changeColor(String app, String color){
        userChangesColor();
    }
    @Given("User got the time of each text in the {string} Application")
    public void getTime(String time){
        userGetTime();
    }
    @Given("User tap on the icon to open {string}")
    public void clickOnIcon(String icon){
        tapIcon();
    }
    @When("User selects the option {string}")
    public void openSettings(String settings){
        tapSettings();
    }
    @And("User scrolls till option {string}")
    public void scroll(String scroll){
        scrollTillOption();
    }
    @Then("User selects the first day of the week as {string}")
    public void selectDay(String day){
        userSelectsDay();
    }
    @Given("User is on the {string}")
    public void home(String home){
        homePage();
    }
    @When("User searches for the {int} text note in the {string} Application")
    public void searchBox(int note, String app){
        userSearches();
    }
    @Then("User verify for {string} the text note")
    public void verifyText(String note){
        userVerifyText();
    }
    @Given("User is navigated to the {string}")
    public void navigateHomePage(String home){
        navigateToHomePage();
    }
    @When("User deletes the {string} text note from the {string} Application")
    public void deleteNotes(String note, String app){
        userDeletesNote();
    }
    @And("User again deletes the {string} text note from the {string} Application")
    public void deleteAgain(String note, String app){
        userDeleteAgain();
    }
    @Then("^User verifies for the deleted text notes$")
    public void verifyDeleteNotes(){
        userVerifyDeletedNotes();
    }
    @Given("User visit {string} again")
    public void homePageAgain(String home){
        tapHome();
    }
    @When("User tap on {string} note")
    public void tapFirstNote(String note){
        userTapFirstNote();
    }
    @And("User tap on {string} button to choose option {string}")
    public void chooseArchive(String button, String option){
        userChooseArchive();
    }
    @Then("^User verifies for the archived text note$")
    public void verifyArchiveText(){
        userVerifyArchiveText();
    }
}
