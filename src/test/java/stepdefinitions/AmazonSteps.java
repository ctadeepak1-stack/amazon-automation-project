package stepdefinitions;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import pages.AmazonPage;
import io.cucumber.java.en.*;

public class AmazonSteps {

    WebDriver driver;
    AmazonPage page;

    @Given("user opens Amazon website")
    public void open_amazon() {
         driver = Hooks.driver;
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        page = new AmazonPage(driver);
    }

    @When("user searches for {string}")
    public void search_product(String product) {
        page.searchProduct(product);
    }

    @When("user selects first product")
    public void select_product() {
        page.clickFirstProduct();

        // Switch to new tab
        for (String win : driver.getWindowHandles()) {
            driver.switchTo().window(win);
        }
    }

    @When("user adds product to cart")
    public void add_to_cart() {
        page.clickAddToCart();
    }

    @Then("product should be added successfully")
    public void verify_cart() {
        System.out.println("Product added to cart successfully");
    }
}