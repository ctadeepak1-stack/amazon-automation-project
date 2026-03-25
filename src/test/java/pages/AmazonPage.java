package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonPage {

    WebDriver driver;
    WebDriverWait wait;
    //Constructor
    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    //locators
    By searchBox = By.id("twotabsearchtextbox");
    By searchBtn = By.id("nav-search-submit-button");

    By firstProduct = By.xpath("(//div[@data-component-type='s-search-result'])[1]");

    By addToCart = By.id("add-to-cart-button");

    public void searchProduct(String product) {

        // Wait until search box is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchBtn).click();
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        driver.findElement(firstProduct).click();
    }

    public void clickAddToCart() {

        // Scroll down
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,500)");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
            driver.findElement(addToCart).click();
        } catch (Exception e) {

            System.out.println("Add to Cart not found, trying alternate button");

            // Alternate button (Amazon fallback)
            By buyNow = By.id("buy-now-button");

            wait.until(ExpectedConditions.visibilityOfElementLocated(buyNow));
            driver.findElement(buyNow).click();
        }
    }
}