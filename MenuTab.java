package www.rldatix.com.Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import www.rldatix.com.utility.Utility;

import java.util.List;

public class MenuTab extends Utility {
    public static final Logger log = LogManager.getLogger(MenuTab.class.getName());
    public MenuTab(){PageFactory.initElements(driver,this);}

    @CacheLookup
    @FindBy(xpath = "//div[@id='header-nav']/nav/ul/li")
    List<WebElement>menu;

    public void clickOnMenuTab(String Menu){
        for (WebElement m1:menu) {
            if (m1.getText().equalsIgnoreCase(Menu)){
                m1.click();
                System.out.println(m1);
            }

        }

    }
}
