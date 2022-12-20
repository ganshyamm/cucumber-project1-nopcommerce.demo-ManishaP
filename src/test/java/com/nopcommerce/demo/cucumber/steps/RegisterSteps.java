package com.nopcommerce.demo.cucumber.steps;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class RegisterSteps {
    @When("^I click on register link$")
    public void iClickOnRegisterLink() {
        new HomePage().clickOnRegisterLink();

    }

    @And("^I enters following users details$")
    public void iEntersFollowingUsersDetails(DataTable dataTable) {
       List<List<String>> userList = dataTable.asLists(String.class);
        for (List<String> e: userList ) {
            System.out.println(e);
            System.out.println(e.get(0));

        }
    }

    @Then("^registration successful$")
    public void registrationSuccessful() {
        new RegisterPage().getYourRegCompletedText();

    }

    @And("^I see the Register Text$")
    public void iSeeTheRegisterText() {
        Assert.assertEquals("Register link on display", new RegisterPage().getRegisterText());
    }

    @And("^I can click register Button$")
    public void iCanClickRegisterButton() {
        new RegisterPage().clickOnRegisterButton();
    }

    @Then("^I should verify the error message for mandatory field$")
    public void iShouldVerifyTheErrorMessageForMandatoryField() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("First name is required.",
                new RegisterPage().getValidationErrorMessageForField("FirstName"),
                "FirstName field error message not displayed");
        softAssert.assertEquals("Last name is required.",
                new RegisterPage().getValidationErrorMessageForField("LastName"),
                "LastName field error message not displayed");
        softAssert.assertEquals("Email is required.",
                new RegisterPage().getValidationErrorMessageForField("Email"),
                "Email field error message not displayed");
        softAssert.assertEquals("Password is required.",
                new RegisterPage().getValidationErrorMessageForField("Password"),
                "Password field error message not displayed");
        softAssert.assertEquals("Password is required.",
                new RegisterPage().getValidationErrorMessageForField("ConfirmPassword"),
                "ConfirmPassword field error message not displayed");
        softAssert.assertAll();

    }

    @And("^I can fill mandatory field \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void iCanFillMandatoryField(String gender, String firstN, String lastN, String date, String month, String year, String email, String password, String confirmP) {
new RegisterPage().selectGender(gender);
new RegisterPage().enterFirstName(firstN);
new RegisterPage().enterLastName(lastN);
new RegisterPage().selectDateOfBirth(date,month,year);
new RegisterPage().enterEmail(email);
new RegisterPage().enterPassword(password);
new RegisterPage().enterConfirmPassword(confirmP);

    }

    @Then("^I can verify message your registration is completed$")
    public void iCanVerifyMessageYourRegistrationIsCompleted() {
        org.testng.Assert.assertEquals("Your registration completed", new RegisterPage().getYourRegCompletedText(),
                "Registration not successful");


    }
}
