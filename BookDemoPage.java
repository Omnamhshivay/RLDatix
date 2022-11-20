package www.rldatix.com.Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import www.rldatix.com.utility.Utility;

public class BookDemoPage extends Utility {
    public static final Logger log = LogManager.getLogger(BookDemoPage.class.getName());
    public BookDemoPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@role='dialog']/div[2]/button[2]")
    WebElement cookies;
    @CacheLookup
    @FindBy(xpath = "//a[@class='btn dark-blue header-top__cta']")
    WebElement bookDemo;
    @CacheLookup
    @FindBy(xpath = "//form[@class='form']/p[1]/input")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//form[@class='form']/p[2]/input")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//form[@class='form']/p[4]/input")
    WebElement organization;
    @CacheLookup
    @FindBy(xpath = "//form[@class='form']/p[5]/input")
    WebElement title;
    @CacheLookup
    @FindBy(xpath = "//form[@class='form']/p[7]/select")
    WebElement country;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Schedule Me']")
    WebElement scheduleMeButton;
    @CacheLookup
    @FindBy(xpath = "//p[@class='errors']")
    WebElement errorMessage;



    public void clickOnCookies(){
        clickOnElement(cookies);
    }

    public void clickOnBooDemo(){
        clickOnElement(bookDemo);
    }

    public void filledDetails() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
       WebElement iframeElement= driver.findElement(By.xpath("//iframe[@title='Book A Demo Form']"));
       driver.switchTo().frame(iframeElement);
       new BookDemoPage().enterFirstName();
       new BookDemoPage().enterLastName();
       new BookDemoPage().enterOrganization();
       new BookDemoPage().enterTitle();
       new BookDemoPage().clickOnCountry();
       new BookDemoPage().clickOnScheduleMeButton();
    }
    public void enterFirstName(){
        sendTextToElement(firstName,"Mitesh");
    }
    public void enterLastName(){
        sendTextToElement(lastName,"Patel");
    }
    public void enterOrganization(){
        sendTextToElement(organization,"Tester");
    }
    public void enterTitle(){
        sendTextToElement(title,"Mr");
    }
    public void clickOnCountry() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        selectByVisibleTextFromDropDown(country,"United Kingdom");
    }
    public void clickOnScheduleMeButton() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        clickOnElement(scheduleMeButton);
        //driver.switchTo().defaultContent();
    }
    public String verifyErrorMessage() throws InterruptedException {
        Thread.sleep(2000);
        return getTextFromElement(errorMessage);
    }


}
