package appiumsaucedemo.pages;

import appiumsaucedemo.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutInformationForm extends BaseTest {

    By titlePage = By.xpath("//*[@text='CHECKOUT: INFORMATION']");
    By firstNameField = AppiumBy.accessibilityId("test-First Name");
    By lastNameField = AppiumBy.accessibilityId("test-Last Name");
    By postalCodeField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    By cancelButton = AppiumBy.accessibilityId("test-CANCEL");
    By continueButton = AppiumBy.accessibilityId("test-CONTINUE");

    public void validateOnCheckoutInformationPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(titlePage));
        Assert.assertEquals(getTitlePage(), "CHECKOUT: INFORMATION");
    }

    public String getTitlePage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage)).getText();
    }

    public void inputFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).sendKeys(postalCode);
    }

    public void clickCancelButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton)).click();
    }

    public void clickContinueButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();

    }
}
