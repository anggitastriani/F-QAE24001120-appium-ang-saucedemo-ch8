package appiumsaucedemo.pages;

import appiumsaucedemo.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutCompletePage extends BaseTest {

    By pageTitle = By.xpath("//*[@text='CHECKOUT: COMPLETE!']");
    By completeLogo = By.xpath("//*[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.ImageView");
    By completeText = By.xpath("//*[@text='THANK YOU FOR YOU ORDER']");
    By descCompleteText = By.xpath("//*[@text='Your order has been dispatched, and will arrive just as fast as the pony can get there!']");
    By backHomeButton = AppiumBy.accessibilityId("test-BACK HOME");

    public void validateOnCheckoutCompletePage(){
        Assert.assertEquals(getPageTitle(), "CHECKOUT: COMPLETE!");
        completeLogoIsDisplayed();
//        Assert.assertEquals(getCompleteText(), "THANK YOU FOR YOU ORDER");
        Assert.assertEquals(getDescCompleteText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        backHomeButtonIsDisplayed();
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    public void completeLogoIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeLogo)).isDisplayed();
    }

    public String getCompleteText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeText)).getText();
    }

    public String getDescCompleteText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descCompleteText)).getText();
    }

    public void backHomeButtonIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(backHomeButton)).isDisplayed();
    }
}
