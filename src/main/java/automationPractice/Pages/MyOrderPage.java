package automationPractice.Pages;

import automationPractice.Utils.BasePage;
import automationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class MyOrderPage extends BasePage{
    //List out web elements
    //PageFactory POM
    @FindBy(css=".page-heading")
    WebElement myOrderPage;

    @FindBy(xpath = "//a[@id='cart_quantity_up_5_25_0_443690']")
    WebElement increaseQuantityButton;

    @FindBy(xpath = "//a[@id='cart_quantity_down_5_25_0_443690']")
    WebElement decreaseQuantityButton;

    @FindBy(xpath = "//input[@name='quantity_5_25_0_443690_hidden']")
    WebElement quantityDisplayHidden;

    @FindBy(xpath = "//span[@id='total_price']")
    WebElement totalPriceDisplay;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedToCheckoutButton;

    public MyOrderPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean isUserOnMyOrderPage(){ return Utils.isElementDisplayed(myOrderPage);}

    public void increaseQuntity(){
        increaseQuantityButton.click();
        increaseQuantityButton.click();
        increaseQuantityButton.click();
        driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
    }

    public void decreaseQuantity(){
        decreaseQuantityButton.click();
    }

    public boolean isQuantityDisplayed(){
        return Utils.isElementDisplayed(quantityDisplayHidden);
    }
    public String verifyQuantityDisplayed(){

         return quantityDisplayHidden.getAttribute("value");
    }

    public String totalPriceDisplay(){
        return totalPriceDisplay.getText();
    }


    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }


    








}
