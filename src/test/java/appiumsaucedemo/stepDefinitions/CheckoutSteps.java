package appiumsaucedemo.stepDefinitions;

import appiumsaucedemo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutSteps {
    CartPage cartPage = new CartPage();
    CheckoutInformationForm checkoutInformationForm = new CheckoutInformationForm();
    CheckoutOverview checkoutOverview = new CheckoutOverview();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @And("User is on cart page")
    public void user_is_on_cart_page(){
        cartPage.validateOnCartPage();
        cartPage.assertion();
    }

    @And("User scrolls to element with {string} on chart page")
    public void user_scrolls_to_element_with(String checkout){
        cartPage.swipeToElementWithText(checkout);
    }

    @And("User click checkout button")
    public void user_click_checkout_button(){
        cartPage.clickCheckoutButton();
    }

    @And("User is on checkout information page")
    public void user_is_on_checkout_information_page(){
        checkoutInformationForm.validateOnCheckoutInformationPage();
    }

    @And("user enter first name with {string}")
    public void user_enter_first_name(String firstname){
        checkoutInformationForm.inputFirstName(firstname);
    }

    @And("user enter last name with {string}")
    public void user_enter_last_name(String lastname){
        checkoutInformationForm.inputLastName(lastname);
    }

    @And("user enter postal code with {string}")
    public void user_enter_postalcode(String postalcode){
        checkoutInformationForm.inputPostalCode(postalcode);
    }

    @And("user click continue button")
    public void user_click_continue_button(){
        checkoutInformationForm.clickContinueButton();
    }

    @And("user is on checkout overview page")
    public void user_is_on_checkout_overview_page(){
        checkoutOverview.validateOnCheckoutOverviewPage();
    }

    @And("User scrolls to element with text {string}")
    public void user_scrolls_to_element_with_text(String finishText){
        checkoutOverview.swipeToElementWithText(finishText);
    }

    @When("user click finish button")
    public void user_click_finish_button(){
        checkoutOverview.clickFinishButton();
    }

    @Then("user can see successful order message")
    public void user_can_see_successful_order_message(){
        checkoutCompletePage.validateOnCheckoutCompletePage();
        Assert.assertEquals(checkoutCompletePage.getCompleteText(), "THANK YOU FOR YOU ORDER");
    }





}
