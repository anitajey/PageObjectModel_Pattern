package automationPractice.Pages;

import automationPractice.Utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends BasePage {
    @FindBy(css = ".login")
    WebElement singInLink;

    public CommonPage() {
        PageFactory.initElements(driver,this);
    }

    //navigate to authentication or signIn page
    public void gotoAuthenticationPage() {
        singInLink.click();
    }
}
