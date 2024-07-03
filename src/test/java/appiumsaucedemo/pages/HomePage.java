package appiumsaucedemo.pages;

import appiumsaucedemo.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseTest {

    By textProducts = By.xpath("//*[contains(@text, 'PRODUCTS')]");
    By sortingButton = AppiumBy.accessibilityId("test-Modal Selector Button");
    By sortingLowtoHighOption = By.xpath("//*[contains(@text, 'Price (low to high)')]");
    By priceAfterSorting = By.xpath("//*[@content-desc='test-Price']");
    By addToCartItem1 = By.xpath("(//*[@content-desc='test-ADD TO CART'])[1]");
    By addToCartItem2 = By.xpath("(//*[@content-desc='test-ADD TO CART'])[4]");
    By cartButton = AppiumBy.accessibilityId("test-Cart");

    public void swipeToElementWithText(String text) {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",text)));

    }

    public void validateOnPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Cart")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textProducts)).isDisplayed();
    }

    public void clickSortingButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortingButton)).click();
    }

    public void clickSortingLowtoHighOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortingLowtoHighOption)).click();
    }

    public List<Double> getItemPriceAfterSorting(){
        List<WebElement> itemPriceAfterSorting = driver.findElements(priceAfterSorting);
        List<Double> itemPriceAfterSortingList = new ArrayList<>();
        for (WebElement priceElement : itemPriceAfterSorting) {
            itemPriceAfterSortingList.add(Double.valueOf(priceElement.getText().replace("$", "")));
        }

        return itemPriceAfterSortingList;
    }

    public void validateFirstItemSmallerThanSecondItem(){
        Double firstItemPrice = getItemPriceAfterSorting().get(0);
        Double secondItemPrice = getItemPriceAfterSorting().get(1);
        Assert.assertTrue(firstItemPrice < secondItemPrice, "comparing first price smaller than second price");
    }

    public void clickAddToCartItem1(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartItem1)).click();
    }

    public void clickAddToCartItem2(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartItem2)).click();
    }

    public void clickCartButtton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton)).click();
    }
}
