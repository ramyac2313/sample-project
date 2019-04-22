package step_defination;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.support.ui.Select;
import pageobjects.Filters_NewUserPage;


public class FiltersUserPageStepdef  extends  BaseTest {

    Filters_NewUserPage fp = page.GetInstance(Filters_NewUserPage.class);

    @Before
    public void opentheapplication() {
        fp.Openhomepage();
    }

    @Given("^As user open the browser and enter the application url$")
    public void as_user_open_the_browser_and_enter_the_application_url() throws Throwable {
        //page.GetInstance(Filters_NewUserPage.class).Openhomepage();

    }

    @When("^As user validate the ladingpage and click on Users on menu bar$")
    public void as_user_validate_the_ladingpage_and_click_on_Users_on_menu_bar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        fp.getMenuusers().click();

    }

    @Then("^validate fields usernamedropdown,userinputvalue,emildropdown,emailinput,frominput,toinput$")
    public void validate_fields_usernamedropdown_userinputvalue_emildropdown_emailinput_frominput_toinput() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (fp.getSelusername().isDisplayed()) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getSelusername());
            Assert.assertTrue("Select User not displayed", fp.getSelusername().isDisplayed());
        } else {
            Assert.assertFalse("Select User not displayed", fp.getSelusername().isDisplayed());
        }


        if (fp.getInputusername().isDisplayed()) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getInputusername());
            Assert.assertTrue("Select User not displayed", fp.getInputusername().isDisplayed());
        } else {
            Assert.assertFalse("Select User not displayed", fp.getInputusername().isDisplayed());
        }


        if (fp.getSelectemail().isDisplayed()) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getSelectemail());
            Assert.assertTrue("Select email not displayed", fp.getSelectemail().isDisplayed());
        } else {
            Assert.assertFalse("Select email not displayed", fp.getSelectemail().isDisplayed());
        }


        if (fp.getInputemail().isDisplayed()) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getInputemail());
            Assert.assertTrue("Select email not displayed", fp.getInputemail().isDisplayed());
        } else {
            Assert.assertFalse("Select email not displayed", fp.getInputemail().isDisplayed());
        }


        if (fp.getInputfromdate().isDisplayed()) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getInputfromdate());
            Assert.assertTrue("input date  displayed", fp.getInputfromdate().isDisplayed());
        } else {
            Assert.assertFalse("input date not displayed", fp.getInputfromdate().isDisplayed());
        }

        if (fp.getInputtodate().isDisplayed()) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getInputtodate());
            Assert.assertTrue("input to displayed", fp.getInputtodate().isDisplayed());
        } else {
            Assert.assertFalse("input to not displayed", fp.getInputtodate().isDisplayed());
        }

    }


    @And("^Enter the values in \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheValuesIn(String usernamedropdown, String userinputvalue, String emildropdown, String emailinput, String frominput, String toinput) throws Throwable {
        if (usernamedropdown.length() > 0) {
            Select selusername = new Select(fp.getSelusername());
            selusername.selectByVisibleText(usernamedropdown);
        }
        //
        if (userinputvalue.length() > 0) {
            fp.getInputusername().clear();
            fp.getInputusername().sendKeys(userinputvalue);
        }
        //
        if (emildropdown.length() > 0) {
            Select selemail = new Select(fp.getSelectemail());
            selemail.selectByVisibleText(emildropdown);
        }
        //
        if (emailinput.length() > 0) {
            fp.getInputemail().clear();
            fp.getInputemail().sendKeys(emailinput);
        }
        //
        if (frominput.length() > 0) {
            fp.getInputfromdate().clear();
            fp.getInputfromdate().sendKeys(frominput);
        }
        if (toinput.length() > 0) {
            fp.getInputtodate().clear();
            fp.getInputtodate().sendKeys(toinput);
        }

    }

    @And("^Click on Clear Filters button$")
    public void clickOnClearFiltersButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        fp.getBtnclearfilter().click();
    }

    @Then("^Verify input fields reset back default values \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void verifyInputFieldsResetBackDefaultValues(String resetusernamedropdown, String resetuserinputvalue, String resetemildropdown, String resetemailinput, String resetfrominput, String resettoinput) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Select selusername = new Select(fp.getSelusername());
        if (selusername.getFirstSelectedOption().getText().equalsIgnoreCase(resetusernamedropdown)) {
            Assert.assertEquals("option selected matched with ", selusername.getFirstSelectedOption().getText(), resetusernamedropdown);
        } else {
            Assert.assertEquals("option selected not matched with ", selusername.getFirstSelectedOption().getText(), resetusernamedropdown);

        }
        //

        if (fp.getInputusername().getText().equalsIgnoreCase(resetuserinputvalue)) {
            Assert.assertEquals("user inputs ", fp.getInputusername().getText(), resetuserinputvalue);

        } else {
            Assert.assertEquals("user inputs ", fp.getInputusername().getText(), resetuserinputvalue);
        }

        //
        Select selemail = new Select(fp.getSelectemail());
        if (selemail.getFirstSelectedOption().getText().equalsIgnoreCase(resetemildropdown)) {
            Assert.assertEquals("option selected matched with ", selemail.getFirstSelectedOption().getText(), resetemildropdown);
        } else {
            Assert.assertEquals("option selected not matched with ", selemail.getFirstSelectedOption().getText(), resetemildropdown);

        }
        //

        if (fp.getInputemail().getText().equalsIgnoreCase(resetuserinputvalue)) {
            Assert.assertEquals("user inputs ", fp.getInputemail().getText(), resetemailinput);

        } else {
            Assert.assertEquals("user inputs ", fp.getInputemail().getText(), resetemailinput);
        }
        //

        if (fp.getInputfromdate().getText().equalsIgnoreCase(resetfrominput)) {
            Assert.assertEquals("form date inputs ", fp.getInputfromdate().getText(), resetfrominput);

        } else {
            Assert.assertEquals("form date inputs ", fp.getInputfromdate().getText(), resetfrominput);
        }


        if (fp.getInputtodate().getText().equalsIgnoreCase(resettoinput)) {
            Assert.assertEquals("form date inputs ", fp.getInputtodate().getText(), resettoinput);

        } else {
            Assert.assertEquals("form date inputs ", fp.getInputtodate().getText(), resettoinput);
        }


    }


    @After
    public void close() {
        page.driver.close();
    }

    @When("^As user validate \"([^\"]*)\" and \"([^\"]*)\"$")
    public void asUserValidateAnd(String fromdate, String todate) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        fp.getInputfromdate().sendKeys(fromdate);
        fp.getInputtodate().sendKeys(todate);
        fp.getBtnfilter().click();
        Thread.sleep(5000);
    }

    @Then("^validate Error Message for different input \"([^\"]*)\"$")
    public void validateErrorMessageForDifferentInput(String messaage) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (fp.getLblsearchstusdate().getText().contains(messaage)) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getLblsearchstusdate());
            Thread.sleep(3000);
        }
    }

    @And("^Click on Filter button$")
    public void clickOnFilterButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        fp.getBtnfilter().click();
        Thread.sleep(5000);
    }

    @Then("^validate data output based input data\"([^\"]*)\"$")
    public void validateDataOutputBasedInputData(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //td[3][contains(text(),'ra')]
        //page.driver.findElement(By.xpath("//td[3][contains(text(),'ra')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (message.equalsIgnoreCase("No Users found")) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getlblsearchstusnodatafound());
            Thread.sleep(3000);
        } else if (message.equalsIgnoreCase(fp.getlblsearchstusnodatafound().getText())) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getlblsearchstusnodatafound());
            Thread.sleep(3000);
        }

    }







    @Given("^As user Click on  New User button$")
    public void asUserClickOnNewUserButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        fp.getBtnNewUsers().click();
        Thread.sleep(4000);
    }

    @When("^As user Enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void asUserEnterUserNamePasswordEmailid(String username,String password,String emilid) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        fp.getInputUsersname().sendKeys(username);
        fp.getInputPassword().sendKeys(password);
        fp.getinputemailnewuser().sendKeys(emilid);
    }

    @And("^User click on CreateUser$")
    public void userClickOnCreateUser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        fp.getBtncreateuser().click();
        Thread.sleep(3000);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        if(fp.getLblSaveed().isDisplayed()){
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", fp.getLblSaveed());
            Thread.sleep(3000);
        }
        Thread.sleep(3000);
    }



    @Then("^As User verify the data from the list$")
    public void asUserVerifyTheDataFromTheList() {
        // Write code here that turns the phrase above into concrete actions

    }






}