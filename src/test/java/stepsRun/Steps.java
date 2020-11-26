package stepsRun;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class Steps {

    public WebDriver driver;
    public LoginPage loginPage;

    @Given("User launches Chrome browser")
    public void user_launches_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        loginPage.setUserName(email);
        loginPage.setUserPassword(password);
    }

    @When("User clicks on Login")
    public void user_clicks_on_login() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(2000);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) throws InterruptedException {
        if (driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.assertTrue(false);
        }else {
            Assert.assertEquals(title, driver.getTitle());
        }
        Thread.sleep(2000);
    }

    @When("User clicks on Logout button")
    public void user_clicks_on_logout_button() throws InterruptedException {
        loginPage.clickLogout();
        Thread.sleep(2000);
    }

    @Then("Close Chrome browser")
    public void close_chrome_browser() {
        driver.quit();
    }

}