package appiumsaucedemo.pages;

import appiumsaucedemo.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BaseTest {
    By pageTitle = By.xpath("//*[@text='YOUR CART']");
    By totalItemInTheCart = By.xpath("//*[@content-desc='test-Item']");
    By checkoutButton = By.xpath("//*[@content-desc='test-CHECKOUT']");

    public void swipeToElementWithText(String text) {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",text)));

    }

    public void validateOnCartPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
    }

    public String getPageTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    public long getTotalItemInTheCart(){
        List<WebElement> totalCartItem = driver.findElements(totalItemInTheCart);
        return totalCartItem.stream().count();
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

    public void assertion(){
        // assertion 1 : validate page title
        Assert.assertEquals(getPageTitle(), "YOUR CART");

        // assertion 2 : validate total item in the cart
        Assert.assertEquals(getTotalItemInTheCart(), 2);
    }

}
