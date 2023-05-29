package ui_tests.stepDefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import utilities.BaseClass;

import static utilities.ConfigReader.getProperty;

@RunWith(Cucumber.class)
public class teladoc_table_StepDef extends BaseClass {


    String fname,lname,username,email,password,cellphone;
    int rowCount;


    @Given("User launch the URL {string} successfully")
    public void user_launch_the_url_successfully(String url) {
        visit(getProperty(url));
    }
//
//
    @Given("verify page title")
    public void verify_page_title() {
        teladoc_tables_pageObject.pageTitle();

    }

    @Given("Click on add User")
    public void click_on_add_user() {
        waitForVisibility(teladoc_tables_pageObject.addUserButton, 5);
        teladoc_tables_pageObject.addUserButton.click();

    }
    @Then("fill out form")
    public void fill_out_form() {
        fname= dataFaker.name().firstName();
        lname= dataFaker.name().lastName();
        username= dataFaker.name().username();
        email= dataFaker.internet().emailAddress();
        password= dataFaker.internet().password();
        cellphone= dataFaker.phoneNumber().cellPhone();

        teladoc_tables_pageObject.fnameField.sendKeys(fname);
        teladoc_tables_pageObject.LnameField.sendKeys(lname);
        teladoc_tables_pageObject.userNameField.sendKeys(username);
        teladoc_tables_pageObject.passwordField.sendKeys(password);
        teladoc_tables_pageObject.customerOptions.click();
        teladoc_tables_pageObject.emailField.sendKeys(email);
        teladoc_tables_pageObject.cellPhoneField.sendKeys(cellphone);
        selectByVisibleText(teladoc_tables_pageObject.selectRole,"Customer");
    }
    @Then("click on save button")
    public void click_on_save_button() {
        teladoc_tables_pageObject.saveButton.click();
    }
    @Then("verify Data is added to the table")
    public void verify_data_is_added_to_the_table() {
        teladoc_tables_pageObject.verifyUserIsCreated(username);
    }
    @Given("verify userName is preset in the table {string}")
    public void verify_user_name_is_preset_in_the_table(String expUser) {
        rowCount = teladoc_tables_pageObject.verifyUserIsCreated(expUser);
    }
    @Then("verify user deleted from table")
    public void verify_user_deleted_from_table() {
        teladoc_tables_pageObject.deleteUser(rowCount);
    }

}