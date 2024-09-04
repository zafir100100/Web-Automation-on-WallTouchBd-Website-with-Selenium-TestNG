package testrunner;

import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductSearchResultPage;
import setup.Setup;

public class LoginTestRunner extends Setup {
    HomePage homePage;
    LoginPage loginPage;
    ProductSearchResultPage productSearchResultPage;
    ProductDetailsPage productDetailsPage;

    @Test(priority = 1, description = "Verify valid login functionality with correct credentials")
    public void verifyValidLogin() throws InterruptedException {
        homePage=new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.navigateToLoginPage();
        loginPage=new LoginPage(driver);
        loginPage.doLogin(config.getAdminUserName(),config.getAdminPassword());
        loginPage.verifyValidLogin();
        Allure.description("Valid login functionality with correct credentials");
    }

    @Test(priority = 2, description = "Verify valid search result with provided text")
    public void verifyValidSearchResult() throws InterruptedException {
        homePage=new HomePage(driver);
        homePage.initiateSearch("toys.");
        productSearchResultPage = new ProductSearchResultPage(driver);
        productSearchResultPage.verifyValidSearchResult();
        Allure.description("Verify valid search result with provided text");
    }

    @Test(priority = 3, description = "Verify valid product details with provided search result")
    public void verifyValidProductDetails() throws InterruptedException {
        productSearchResultPage = new ProductSearchResultPage(driver);
        productSearchResultPage.navigateToFirstSearchResult();
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.verifyValidSearchResult(productSearchResultPage.getSelectedProductName(), productSearchResultPage.getSelectedProductPrice());
        Allure.description("Valid product details with provided search result");
    }
}
