package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

@Getter
public class ProductSearchResultPage {

    private WebDriver driver;
    private String selectedProductName;
    private String selectedProductPrice;

    @FindBy(xpath = "//div[@class='text-center']/a")
    public List<WebElement> productNameTexts;

    @FindBy(xpath = "//span[contains(@class,'text-dark')]")
    public List<WebElement> productNamePrices;

    public ProductSearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyValidSearchResult(){
        int productCount = productNameTexts.size();
        Assert.assertTrue(productCount >= 1, "Expected at least one product in search results.");
    }

    public void navigateToFirstSearchResult(){
        int productCount = productNameTexts.size();
        if(productCount == 0){
            return;
        }
        WebElement firstProductNameText = productNameTexts.get(0);
        selectedProductName = firstProductNameText.getText();
        selectedProductName = selectedProductName.replaceAll("\\.+$", "");
        selectedProductPrice = productNamePrices.get(0).getText();
        firstProductNameText.click();
    }
}
