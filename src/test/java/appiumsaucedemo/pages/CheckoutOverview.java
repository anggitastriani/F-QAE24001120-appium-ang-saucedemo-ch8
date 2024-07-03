package appiumsaucedemo.pages;

import appiumsaucedemo.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOverview extends BaseTest {

    By titlePage = By.xpath("//*[@text='CHECKOUT: OVERVIEW']");
    By inventoryItemPrice = By.xpath("//*[@content-desc='test-Price']");
    By paymentInfoValue = By.xpath("//*[@text='SauceCard #31337']");
    By shippingInformationValue = By.xpath("//*[@text='FREE PONY EXPRESS DELIVERY!']");
    By subTotal = By.xpath("//*[@text='Item total: $39.98']");
    By cancelButton = AppiumBy.accessibilityId("test-CANCEL");
    By finishButton = AppiumBy.accessibilityId("test-FINISH");

    public void swipeToElementWithText(String text) {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",text)));

    }

    public void validateOnCheckoutOverviewPage(){
        Assert.assertEquals(getTitlePage(), "CHECKOUT: OVERVIEW");
//        paymentInfoValueIsDisplayed();
//        shippingInformationValueIsDisplayed();
    }

    public String getTitlePage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage)).getText();
    }

    public void paymentInfoValueIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfoValue)).isDisplayed();
    }

    public void shippingInformationValueIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingInformationValue)).isDisplayed();
    }

    public void clickCancelButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton)).click();
    }

    public void clickFinishButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton)).click();
    }
}
