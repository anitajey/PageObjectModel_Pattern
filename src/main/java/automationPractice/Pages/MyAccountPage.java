package automationPractice.Pages;

import automationPractice.Utils.BasePage;
import automationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.invoke.SwitchPoint;

public class MyAccountPage extends BasePage {

    //List out web elements
    //PageFactory POM

    @FindBy(css = ".account")
    WebElement myAccountInfoPage;

    @FindBy(css = ".logout")
    WebElement signOutTab;

    @FindBy(css = "#search_query_top")
    WebElement searchProductTextbox;

    @FindBy(name = "submit_search")
    WebElement submitSearchButton;

    @FindBy(xpath = "//img[@alt='Printed Summer Dress']")
    WebElement selectProduct;

    @FindBy(css = "#color_11")
    WebElement ColorBlack;

    @FindBy(css = "#color_13")
    WebElement ColorOrange;

    @FindBy(css = "#color_14")
    WebElement ColorBlue;

    @FindBy(css = "#color_16")
    WebElement ColorYellow;

    @FindBy(css = "#group_1")
    WebElement ProductSize;

    @FindBy(css = "#add_to_cart")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//a[@id='wishlist_button']")
    WebElement wishlistButton;

    @FindBy(xpath = "//p[@class='fancybox-error']")
    WebElement validationMessageBox;



    public MyAccountPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean isUserOnMyAccountPage(){
        return Utils.isElementDisplayed(myAccountInfoPage);
    }

    public boolean isUserNameDisplayed(){
        return Utils.isElementDisplayed(signOutTab);
    }

    public String getUserNameDisplayed(){
        String displayName;
        return displayName = myAccountInfoPage.getText();
    }

    public void SignOut(){
        signOutTab.click();
    }

    public void searchProductType(String productType){
        Utils.type(searchProductTextbox,productType);
        submitSearchButton.click();

    }

    public void selectProduct(){
        selectProduct.click();
    }

    public void selectProductSize(String sizeVar){
        switch (sizeVar){
            case  "S":
                Utils.selectFromListWithIndex(ProductSize,0);
                break;
                case  "M":
                Utils.selectFromListWithIndex(ProductSize,1);
                break;
            case "L":
                Utils.selectFromListWithIndex(ProductSize,2);
                break;
        }

    }
    public void selectColor(String colourVar){

        switch(colourVar){
            case "Black":
                ColorBlack.click();
                break;
            case "Blue":
                ColorBlue.click();
                break;
            case "Yellow":
                ColorYellow.click();
            case "Orange":
                ColorOrange.click();
        }

    }

    public void addToCart(){
        addToCartButton.click();
        proceedToCheckoutButton.click();
    }

    public void addToWishlist(){
        selectProduct.click();
        wishlistButton.click();
    }

    public boolean isAddToWishlistMessageDisplayed(){
        return Utils.isElementDisplayed(validationMessageBox);
    }

    public String addToWishlistMessageText(){
        return validationMessageBox.getText();
    }


}
