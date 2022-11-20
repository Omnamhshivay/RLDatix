package www.rldatix.com.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import www.rldatix.com.Pages.MenuTab;

public class MenuSteps {
    @Given("^I am on home page$")
    public void iAmOnHomePage() {
    }

    @When("^I am able to click on all menu tabe \"([^\"]*)\"$")
    public void iAmAbleToClickOnAllMenuTabe(String Menu)  {
     new MenuTab().clickOnMenuTab(Menu);
    }
}
