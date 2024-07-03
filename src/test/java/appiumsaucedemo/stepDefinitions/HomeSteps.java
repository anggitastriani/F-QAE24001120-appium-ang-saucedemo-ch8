package appiumsaucedemo.stepDefinitions;

import appiumsaucedemo.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.testng.Assert;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @Then("User is on Home page")
    public void user_is_on_homepage(){
        homePage.validateOnPage();
    }

    @And("User is click filter button")
    public void user_is_click_filter_button(){
        homePage.clickSortingButton();
    }

    @When("User is select price low to high button")
    public void user_select_price_low_to_high(){
        homePage.clickSortingLowtoHighOption();
    }

    @Then("User can see products from lowest to highest price")
    public void User_can_see_products_from_lowest_to_highest_price(){
        homePage.validateOnPage();
        homePage.validateFirstItemSmallerThanSecondItem();
    }

    @And("User add first item into the shopping cart")
    public void User_add_first_item_into_the_shopping_cart(){
        homePage.clickAddToCartItem1();
    }

    @And("User scrolls to element with {string}")
    public void User_scrolls_to_element_with(String text){
        homePage.swipeToElementWithText(text);
    }

    @And("User add second item into the shopping cart")
    public void User_add_second_item_into_the_shopping_cart(){
        homePage.clickAddToCartItem2();
        homePage.clickCartButtton();
    }
}
