package com.webOrder.stepDefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;
import com.webOrder.pages.WebOrderFoodOrderPage;

public class WebOrderFoodOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderFoodOrderPage webOrderFoodOrderPage=new WebOrderFoodOrderPage(driver);
    @Given("User provides {string} and {string} for WebOrder")
    public void user_provides_and_for_web_order(String username, String password) throws InterruptedException {
     webOrderFoodOrderPage.signInButton(username, password);
    }

    @Given("User validates the {string} title from homepage")
    public void user_validates_the_title_from_homepage(String titlee) {
      webOrderFoodOrderPage.validateTitle(titlee);
    }

    @When("User clicks Group Order Box and Next Button")
    public void user_clicks_group_order_box_and_next_button() throws InterruptedException {
  webOrderFoodOrderPage.ClickGroupNextButton();
    }

    @When("User sends the word {string} for note to the Invitees Section")
    public void user_sends_the_word_for_note_to_the_invitees_section(String text) {
webOrderFoodOrderPage.provideMessage(text);
    }

    @When("User sends e-mail address which are {string} and {string} to the Invite List")
    public void user_sends_e_mail_address_which_are_and_to_the_invite_list(String email1, String email2) {
     webOrderFoodOrderPage.provideEmails(email1,email2);
    }

    @When("User chooses the delivery adress {string} and validates the address {string}")
    public void user_chooses_the_delivery_adress_and_validates_the_address(String house, String address) throws InterruptedException {
     webOrderFoodOrderPage.deliveryAddress(house, address);
    }

    @When("User clicks the create Group Order Button")
    public void user_clicks_the_create_group_order_button() throws InterruptedException {
     webOrderFoodOrderPage.clickButton();
    }

    @Then("User validates the header of page {string}")
    public void user_validates_the_header_of_page(String headerpage) {
     webOrderFoodOrderPage.header(headerpage);
    }
}
