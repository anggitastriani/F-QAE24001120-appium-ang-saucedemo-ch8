package appiumsaucedemo.stepDefinitions;

import appiumsaucedemo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("User is on Login page")
    public void user_is_on_login_page(){
        loginPage.validateOnPage();
    }

    @And("User input username with {string}")
    public void user_input_username(String username){
        loginPage.inputUsername(username);
    }

    @And("User input password with {string}")
    public void user_input_password(String password){
        loginPage.inputPassword(password);
    }

    @When("User click login button")
    public void user_click_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("User redirect to Login page")
    public void user_redirect_to_login_page(){
        loginPage.validateOnPage();
    }

    @And("Error message appears")
    public void error_message_appears(){
        Assert.assertEquals(loginPage.errorMessageFailedLogin(), "Username and password do not match any user in this service.");
    }
}
