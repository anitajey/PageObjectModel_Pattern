package automationPractice.SmokeTestSuite;
import automationPractice.Pages.*;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.concurrent.TimeUnit;

//predefines the Test run flow
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SmokeTestSuite extends BaseTest {
    //Test Data1
    static String email1 = "srikanth123@gmail.com";
    static String title1 = "Mr";
    static String firstName1 = "srikanth";
    static String lastName1 = "Sri";
    static String dobDay1 = "2  ";
    static String dobMonth1 = "April ";
    static String dobYear1 = "2005  ";
    static String stateName1 = "Alaska";

    //Test Data2
    static String email2 = "srikanth456@gmail.com";
    static String title2 = "Mrs";
    static String firstName2 = "test";
    static String lastName2 = "test";
    static String dobDay2 = "15  ";
    static String dobMonth2 = "July ";
    static String dobYear2 = "1984  ";
    static String stateName2 = "Alaska";

    //Test Data 3
    static String email3 = "testaccount123@mailinator.com";
    static String password = "Password123";

    //Test Data 4
    static String forgotpassword = "testaccount123@mailinator.com";

    //Test Data 7
    static String productType = "Dresses";



    //Create objects for Page classes to use the page class methods
    AuthenticationPage authenticationPage = new AuthenticationPage();
    CommonPage commonPage = new CommonPage();
    HomePage homePage = new HomePage();
    SignUpPage signUpPage = new SignUpPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    MyOrderPage myOrderPage = new MyOrderPage();
    ForgotPassword forgotPasswordPage = new ForgotPassword();

    //TestCase:1
    @Test
    public void verifyUserCannotRegisterWithInvalidData1() {
        //verify user is on the HomePage
        Assert.assertTrue(homePage.isUserOnHomePage());
        //navigate to AuthenticationPage
        commonPage.gotoAuthenticationPage();
        //verify that the user is on the AuthenticationPage
        Assert.assertTrue(authenticationPage.isUserOnAuthenticationPage());
        //select the signIn link
        authenticationPage.enterEmailAndContinue(email1);
        //verify user is on the Registration
        Assert.assertTrue(signUpPage.isUserOnSignUpPage());
        signUpPage.selectTitle(title1);
        signUpPage.enterFirstName(firstName1);
        signUpPage.enterLastName(lastName1);
        signUpPage.enterDOB(dobDay1, dobMonth1, dobYear1);
        signUpPage.selectNewsLetter();
        signUpPage.selectState(stateName1);
        signUpPage.submitRegistrationForm();
    }

    //TestCase:2
    @Test
    public void verifyUserCannotRegisterWithInvalidData2() {
        //verify user is on HomePage
        Assert.assertTrue(homePage.isUserOnHomePage());
        //navigate to AuthenticationPage
        commonPage.gotoAuthenticationPage();
        //verify if user is on the AuthenticationPage
        Assert.assertTrue(authenticationPage.isUserOnAuthenticationPage());
        authenticationPage.enterEmailAndContinue(email2);
        Assert.assertTrue(signUpPage.isUserOnSignUpPage());
        signUpPage.selectTitle(title2);
        signUpPage.enterFirstName(firstName2);
        signUpPage.enterLastName(lastName2);
        signUpPage.enterDOB(dobDay2, dobMonth2, dobYear2);
        signUpPage.selectNewsLetter();
        signUpPage.submitRegistrationForm();
    }

    //TestCase:3
    @Test
    public void verifyUserCanLoginWithEmailAndPassword() {
        //verify user is on HomePage
        Assert.assertTrue(homePage.isUserOnHomePage());
        //navigate to AuthenticationPage
        commonPage.gotoAuthenticationPage();
        //verify if user is on the AuthenticationPage
        Assert.assertTrue(authenticationPage.isUserOnAuthenticationPage());
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
    }

    //TestCase: 4
    @Test
    public void verifyUserIsAbleToRetrievePassword(){
        commonPage.gotoAuthenticationPage();
        authenticationPage.forgotPassword();
        Assert.assertTrue(forgotPasswordPage.isUserOnForgotPasswordPage());
        forgotPasswordPage.forgotPassword(forgotpassword);
        forgotPasswordPage.isForgotPasswordMsgDisplayed();
        Assert.assertEquals("A confirmation email has been sent to your address: testaccount123@mailinator.com",forgotPasswordPage.forgotPasswordMsgText());
    }

    //TestCase:5
    @Test
    public void verifyMyAccountPageDisplayName() {
        commonPage.gotoAuthenticationPage();
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
        Assert.assertTrue(myAccountPage.isUserNameDisplayed());
        Assert.assertEquals("John Test", myAccountPage.getUserNameDisplayed());
    }

    //TestCase:6
    @Test
    public void verifyUserCanLogoutSuccessfully() {
        commonPage.gotoAuthenticationPage();
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
        //verify if user is on the MyAccountPage
        Assert.assertTrue(myAccountPage.isUserOnMyAccountPage());
        //verify if Username is Displayed
        Assert.assertTrue(myAccountPage.isUserNameDisplayed());
        myAccountPage.SignOut();

    }

    //TestCase:7
    @Test
    public void verifyUserCanSearchProductType() {
        commonPage.gotoAuthenticationPage();
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
        //search a Product Type
        myAccountPage.searchProductType(productType);
    }

    //TestCase:8
    @Test
    public void verifyUserIsAbleToAddProductToCart() {
        commonPage.gotoAuthenticationPage();
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
        myAccountPage.searchProductType(productType);
        myAccountPage.selectProduct();
        myAccountPage.selectColor("Black");
        myAccountPage.selectProductSize("S");
        myAccountPage.addToCart();
    }

    //TestCase:8
    @Test
    public void verifyUserIsAbleToProceedToConfirmation() {
        commonPage.gotoAuthenticationPage();
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
        myAccountPage.searchProductType(productType);
        myAccountPage.addToCart();
    }

    //TestCase:9
    @Test
    public void verifyUserIsAbleToAddProductToWishlist(){
        commonPage.gotoAuthenticationPage();
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
        myAccountPage.searchProductType(productType);
        myAccountPage.addToWishlist();
        Assert.assertTrue(myAccountPage.isAddToWishlistMessageDisplayed());
        Assert.assertEquals("Added to your wishlist.",myAccountPage.addToWishlistMessageText());

    }

    //TestCase:10
    @Test
    public void verfiyUserCanIncreaseQuantityfromMyOrder(){
        commonPage.gotoAuthenticationPage();
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
        myAccountPage.searchProductType(productType);
        myAccountPage.addToCart();
        Assert.assertTrue(myOrderPage.isUserOnMyOrderPage());
        myOrderPage.increaseQuntity();
        //Assert.assertTrue(myOrderPage.isQuantityDisplayed());
        Assert.assertEquals("4",myOrderPage.verifyQuantityDisplayed());
        //myOrderPage.proceedToCheckout();

    }

    //TestCase:11
    @Test
    public void verifyUserCanDecreaseQuantityfromMyOrder(){
        commonPage.gotoAuthenticationPage();
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
        myAccountPage.searchProductType(productType);
        myAccountPage.addToCart();
        Assert.assertTrue(myOrderPage.isUserOnMyOrderPage());
        myOrderPage.increaseQuntity();
        myOrderPage.decreaseQuantity();
        //Assert.assertTrue(myOrderPage.isQuantityDisplayed());
        Assert.assertEquals("3",myOrderPage.verifyQuantityDisplayed());
        //myOrderPage.proceedToCheckout();
    }

    //TestCase:12
    @Test
    public void verifyOrderSummary(){
        commonPage.gotoAuthenticationPage();
        authenticationPage.enterEmailandPasswordAndSignIn(email3, password);
        myAccountPage.searchProductType(productType);
        myAccountPage.addToCart();
        Assert.assertTrue(myOrderPage.isUserOnMyOrderPage());
        myOrderPage.increaseQuntity();
        Assert.assertEquals("117.92",myOrderPage.totalPriceDisplay());
    }



}
