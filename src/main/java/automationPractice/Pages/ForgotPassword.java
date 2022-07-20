package automationPractice.Pages;
import automationPractice.Utils.BasePage;
import automationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword extends BasePage{
    @FindBy(css = ".page-subheading")
    WebElement forgotPasswordPage;

    @FindBy (css = "#email")
    WebElement forgotEmailAddressTextbox;

    @FindBy (xpath = "//button[@class='btn btn-default button button-medium']")
    WebElement retrievePasswordButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement forgotPasswordMessage;

    public ForgotPassword(){
        PageFactory.initElements(driver,this);
    }

    public boolean isUserOnForgotPasswordPage(){
        return Utils.isElementDisplayed(forgotPasswordPage);
    }

    public void forgotPassword(String forgotpasswordemail){
        forgotEmailAddressTextbox.sendKeys(forgotpasswordemail);
        retrievePasswordButton.click();
    }

   public boolean isForgotPasswordMsgDisplayed(){
        boolean textPresent = Utils.isTextPresent(forgotPasswordMessage, "A confirmation email has been sent to your address: testaccount123@mailinator.com");
        return textPresent;
   }

   public String forgotPasswordMsgText(){
        return forgotPasswordMessage.getText();
   }


}
