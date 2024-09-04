package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductDetailsPage {

    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyValidSearchResult(String productName, String productPrice) {
        String productNameXpath = String.format("//span[contains(text(),'%s')]", productName);
        WebElement productNameText = driver.findElement(By.xpath(productNameXpath));

        String actualProductName = productNameText.getText();
        Assert.assertTrue(actualProductName.contains(productName), String.format("Product name does not contain expected text '%s'. Found: '%s'.", productName, actualProductName));

        String productPriceXpath = String.format("//span[contains(text(),'%s')]", productPrice);
        WebElement productPriceText = driver.findElement(By.xpath(productPriceXpath));

        String actualProductPrice = productPriceText.getText();
        Assert.assertTrue(actualProductPrice.contains(productPrice), String.format("Product price does not contain expected text '%s'. Found: '%s'.", productPrice, actualProductPrice));
    }
}
