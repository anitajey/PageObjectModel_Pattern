package automationPractice.Pages;

import automationPractice.Utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    @FindBy(css = "#home-page-tabs")
    WebElement homePageTabs;
    @FindBy(css = "#Login")
    WebElement signInTab;


    public HomePage() {

        PageFactory.initElements(driver,this);
    }

    public boolean isUserOnHomePage() {

        return homePageTabs.isDisplayed();
    }

    public void userLogin(){
        signInTab.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
