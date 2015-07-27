package nl.oa.demo.cucumber.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.oa.demo.cucumber.CucumberConfiguration;
import nl.oa.demo.cucumber.service.AppleService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.core.IsEqual.equalTo;

@ContextConfiguration(classes = {CucumberConfiguration.class})
public class AppleStepdefs {

    @Autowired
    private AppleService appleService;

    private int receivedApples;

    @Given("^the seller has '(\\d+)' apples to sell$")
    public void the_seller_has_apples_to_sell(int availableApples) throws Throwable {
        appleService.addApples(availableApples);
    }

    @When("^the customer asks for '(\\d+)' apple$")
    public void the_customer_asks_for_apple(int amountApplesAsked) throws Throwable {
        if (appleService.hasEnoughApples(amountApplesAsked)) {
            receivedApples = appleService.receiveApples(amountApplesAsked);
        }
    }

    @Then("^the customer gets '(\\d+)' apple from the seller$")
    public void the_customer_gets_apple_from_the_seller(int amountApplesAsked) throws Throwable {
        Assert.assertThat("The amount of apples does not match", receivedApples, equalTo(amountApplesAsked));
    }

}
