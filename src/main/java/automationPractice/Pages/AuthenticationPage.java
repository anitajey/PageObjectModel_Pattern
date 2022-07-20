package automationPractice.Pages;

import automationPractice.Utils.BasePage;
import automationPractice.Utils.Utils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {
    //List out web elements
    //PageFactory POM
    @FindBy(css = "#create-account_form")
    WebElement singUpForm;

    @FindBy(css = "#email_create")
    WebElement singUpEmail;

    @FindBy(css = "#SubmitCreate")
    WebElement signUpButton;

    @FindBy(css = "#email")
    WebElement loginEmail;

    @FindBy(css = "#passwd")
    WebElement loginPasswd;

    @FindBy(css = "#SubmitLogin")
    WebElement loginSubmitBtn;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    WebElement forgotPasswordLink;


    public AuthenticationPage() {
        PageFactory.initElements(driver,this);
    }

    //verify that user is on the authentication page
    public boolean isUserOnAuthenticationPage() {
        return Utils.isElementDisplayed(singUpForm);
    }


    //navigate to SignUp page
    public void enterEmailAndContinue(String userEmail) {
        //Enter the email address and select create account button
        Utils.type(singUpEmail, userEmail);
        signUpButton.click();
        //Wait for page load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void enterEmailandPasswordAndSignIn(String userEmail, String userPassword){
        //Enter the email address
        Utils.type(loginEmail,userEmail);
        Utils.type(loginPasswd,userPassword);
        loginSubmitBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void forgotPassword(){
        forgotPasswordLink.click();

    }

}
