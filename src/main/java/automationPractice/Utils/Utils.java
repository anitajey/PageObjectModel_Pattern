package automationPractice.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utils extends BasePage{
    public static boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static void selectFromListWithText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectFromListWithIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectFromListWithValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static boolean isTextPresent(WebElement element,String text) {
        return element.getText().contains(text);
    }

    public static boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }


    public static void sleep(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
