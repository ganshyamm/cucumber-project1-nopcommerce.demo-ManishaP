package com.nopcommerce.demo.cucumber.steps;

import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ComputerSteps {
    @When("^I click on Computer tab \"([^\"]*)\"$")
    public void iClickOnComputerTab(String Computer) {
        new HomePage().clickOnMenuTab(Computer);
    }

    @Then("^User should Verify Computer text$")
    public void userShouldVerifyComputerText() {
        Assert.assertEquals("Computers",new ComputerPage().getPageTitleText()
        );
    }

    @And("^I click on Desktops \"([^\"]*)\"$")
    public void iClickOnDesktops(String Desktops) {
        new ComputerPage().clickOnSubMenu(Desktops);

    }

    @Then("^user should verify Desktops text$")
    public void userShouldVerifyDesktopsText() {
        Assert.assertEquals("Desktops",new ComputerPage().getPageTitleText());
    }

    @And("^I click on product name Build your own computer \"([^\"]*)\"$")
    public void iClickOnProductNameBuildYourOwnComputer(String productName) {
        new DesktopsPage().selectProduct(productName);
    }

    @And("^I Select processor \"([^\"]*)\"$")
    public void iSelectProcessor(String processor) {
        new BuildYourOwnComputerPage().selectProcessor(processor);
    }

    @And("^I Select RAM \"([^\"]*)\"$")
    public void iSelectRAM(String Ram) {
        new BuildYourOwnComputerPage().selectRam(Ram);
    }

    @And("^I Select HDD \"([^\"]*)\"$")
    public void iSelectHDD(String HDD) {
        new BuildYourOwnComputerPage().selectHDD(HDD);

    }

    @And("^I Select OS \"([^\"]*)\"$")
    public void iSelectOS(String OS) {
        new BuildYourOwnComputerPage().selectHDD(OS);
    }

    @And("^I Select Software \"([^\"]*)\"$")
    public void iSelectSoftware(String software){
        new BuildYourOwnComputerPage().selectSoftware(software);
    }

    @And("^I Click on ADD TO CART Button$")
    public void iClickOnADDTOCARTButton() {
        new BuildYourOwnComputerPage().clickOnAddToCartButton();
    }

    @Then("^I should Verify message The product has been added to your shopping cart$")
    public void iShouldVerifyMessageTheProductHasBeenAddedToYourShoppingCart() {
        Assert.assertEquals("Product does not added to cart", "The product has been added to your shopping cart", new BuildYourOwnComputerPage().getProductAddedMessage());

    }
}
