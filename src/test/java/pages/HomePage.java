package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@type='button' and @data-toggle='dropdown']")
    public WebElement profileIcon;

    @FindBy(name = "name")
    public WebElement txtSearch;

    @FindBy(xpath = "//button[contains(@class,'search_button')]")
    public WebElement btnSearch;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get("https://www.walltouchbd.com/");
    }

    public void navigateToLoginPage() {
        profileIcon.click();
        WebElement signInText = driver.findElement(By.xpath("//a[@class='dropdown-item']//i[contains(@class,'sign-in')]"));
        signInText.click();
    }

    public void initiateSearch(String searchText) {
        txtSearch.clear();
        txtSearch.sendKeys(searchText);
        btnSearch.click();
    }
}
