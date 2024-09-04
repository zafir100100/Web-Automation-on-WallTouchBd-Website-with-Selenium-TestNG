package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "user_id")
    public WebElement txtPhoneNumber;

    @FindBy(id = "si-password")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    public WebElement btnSubmit;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String username, String password) {
        txtPhoneNumber.clear();
        txtPhoneNumber.sendKeys(username);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }

    public void verifyValidLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.walltouchbd.com/"));

        Assert.assertTrue(driver.getPageSource().contains("Hello,"), "Expected text 'Hello,' not found on the page.");
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"), "Expected text 'Dashboard' not found on the page.");
    }
}
