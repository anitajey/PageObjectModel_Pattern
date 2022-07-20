package automationPractice.Pages;

import automationPractice.Utils.BasePage;
import automationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage {
    //list out the web elements
    //Simple POM
    @FindBy(css = "#account-creation_form")
    WebElement signUpForm;

    @FindBy(css = "#id_gender1")
    WebElement titleMr;

    @FindBy(css = "#id_gender2")
    WebElement titleMrs;

    @FindBy(css = "#customer_firstname")
    WebElement fName;

    @FindBy(css = "#customer_lastname")
    WebElement lName;

    @FindBy(css = "#days")
    WebElement date;

    @FindBy(css = "#months")
    WebElement monthSelection;

    @FindBy(css = "#years")
    WebElement yearSelection;

    @FindBy(css = "#id_state")
    WebElement stateSelection;

    @FindBy(css = "#submitAccount")
    WebElement submitButton;

    @FindBy(css = "#submitAccount")
    WebElement newsLetterSelection;

    public SignUpPage() {
        PageFactory.initElements(driver,this);
    }

    //verify that user is on the SignUp page
    public boolean isUserOnSignUpPage() {
        return Utils.isElementDisplayed(signUpForm);
    }

    public void selectTitle(String title) {
        //        x. Select the title
        if (title == "Mr") {
            titleMr.click();
        } else if (title == "Mrs") {
            titleMrs.click();
        }
    }


    public void enterFirstName(String firstname) {
        //        Enter the first name
        Utils.type(fName, firstname);
    }

    public void enterLastName(String lastname){
        Utils.type(lName,lastname);
    }


    public void enterDOB(String day, String month, String year) {
        //        select DOBDate(day and month and year)
        Utils.selectFromListWithText(date, day);

//        select DOBMonth(day and month and year)
        Utils.selectFromListWithText(monthSelection,month);

//        select DOBYear(day and month and year)
        Utils.selectFromListWithText(yearSelection,year);

    }

    public void selectState(String state) {
        //        Select the state
        Utils.selectFromListWithText(stateSelection,state);
    }

    public void submitRegistrationForm() {
        //        xi.  click register button
        submitButton.click();
    }

    public void selectNewsLetter() {
        newsLetterSelection.click();
    }

}
