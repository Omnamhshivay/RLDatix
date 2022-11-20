package www.rldatix.com.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import www.rldatix.com.Pages.BookDemoPage;

public class BookDemoSteps {
    @When("^I click on book a demo tab$")
    public void iClickOnBookADemoTab() throws InterruptedException {
        new BookDemoPage().clickOnBooDemo();
    }

    @And("^I accept cookies$")
    public void iAcceptCookies() {
        new BookDemoPage().clickOnCookies();
    }

    @And("^I enter mandatory filled$")
    public void iEnterMendetaryFilled() throws InterruptedException {
        new BookDemoPage().filledDetails();
    }

    @Then("^I should get error message$")
    public void iShouldGetErrorMessage() throws InterruptedException {
        String actualMessage = "Please correct the errors below:";
        String expectedMessage = new BookDemoPage().verifyErrorMessage();
        Assert.assertEquals("Please correct the errors below:",expectedMessage,actualMessage);
    }
}
