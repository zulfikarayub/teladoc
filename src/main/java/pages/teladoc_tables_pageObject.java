package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.security.util.Password;
import utilities.BaseClass;

import java.util.List;


public class teladoc_tables_pageObject extends BaseClass {


    public static Logger log = LogManager.getLogger(teladoc_tables_pageObject.class);

    @FindBy(xpath = "//button[contains(text(),'Add User')]")
    public WebElement addUserButton;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement fnameField;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement LnameField;

    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement userNameField;

    @FindBy(xpath = "//input[@name='Password']")
    public WebElement passwordField;
    @FindBy(xpath = "//select[@name='RoleId']")
    public WebElement selectRole;
    @FindBy(xpath = "//input[@name='Email']")
    public WebElement emailField;
    @FindBy(xpath = "//label[text()='Company AAA']")
    public WebElement customerOptions;

    @FindBy(xpath = "//input[@name='Mobilephone']")
    public WebElement cellPhoneField;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement saveButton;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    public WebElement okButton;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> tableRows;
    @FindBy(xpath = "//td[3]")
    public WebElement tableRowsUserName;

    @FindBy(xpath = "/td/button[not(@type='edit')]")
    public WebElement tableRowsDeleteOption;

    public teladoc_tables_pageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void pageTitle() {
        String actualTitle = "";
        String ExpectedTitle = "Protractor practice website - WebTables";

        try {
            actualTitle = driver.getTitle();
            Assert.assertEquals(ExpectedTitle, actualTitle);
            log.info("The actual title is " + actualTitle);
            log.info("The Expected title is " + ExpectedTitle);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("The actual title is " + actualTitle);
            log.error("The Expected title is " + ExpectedTitle);
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }

    public int verifyUserIsCreated(String expText) {
        String actText;
        int j = 0, i;

        try {
            log.info("checking the table for user is displayed");
            int size = tableRows.size();
            for (i = 0; i < size; i++) {
                actText = tableRows.get(i).findElements(By.xpath("//td[3]")).get(i).getText();
                if (actText.equalsIgnoreCase(expText)) {
                    log.info("value has been displayed in the table in the row... " + i);
                    j = i;
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }

        return j;
    }

    public void deleteUser(int count) {


        try {


            tableRows.get(count).
                    findElements(By.xpath("//td/button[not(@type='edit')]")).get(count).click();
            waitForVisibility(okButton, 5);
            okButton.click();


        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed due to :::" + e.getMessage());
            Assert.fail(e.getMessage());
        }


    }


}


