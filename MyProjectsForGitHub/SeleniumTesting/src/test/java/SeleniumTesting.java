import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTesting {
    public static final String WebDriver = "webdriver.chrome.driver";
    public static final String DriverPath = "src/main/drivers/chromedriver.exe";
    public static final String URL = "https://books.toscrape.com";
    public static WebDriver driver;

    @BeforeClass
    public void initialize() {
        System.setProperty(WebDriver, DriverPath);
        driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void testURLChange() {
        driver.get(URL);
        WebElement enrollButton = driver.findElement(By.xpath("/html/body/div/div/div/div/section/div[2]/div/ul/li[2]/a"));
        enrollButton.click();
        String expectedUrl = "https://books.toscrape.com/catalogue/page-2.html";
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void testGetText() {
        driver.get(URL);
        WebElement text = driver.findElement(By.cssSelector("div > small"));
        String expectedUrl = "We love being scraped!";
        String actualUrl = text.getText();
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void testBookAppearance() {
        driver.get(URL);
        WebElement category = driver.findElement(By.cssSelector("li:nth-child(30) > a"));
        category.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"default\"]/div/div/div/div/section/div[2]/ol/li[1]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        assertTrue(element.isDisplayed());
    }

    @Test
    public void testGetWarningMessage() {
        driver.get(URL);
        WebElement text = driver.findElement(By.cssSelector("div.alert.alert-warning"));
        String expectedUrl = "Warning! This is a demo website for web scraping purposes. Prices and ratings here were randomly assigned and have no real meaning.";
        String actualUrl = text.getText();
        assertEquals(expectedUrl, actualUrl);
    }


    @Test
    public void testClickBook() {
        driver.get(URL);
        WebElement book = driver.findElement(By.xpath("//*[@id=\"default\"]/div/div/div/div/section/div[2]/ol/li[1]/article/h3"));
        book.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("https://books.toscrape.com/catalogue/a-light-in-the-attic_1000"));
        WebElement element = driver.findElement(By.cssSelector(".col-sm-6.product_main > h1"));
        String expectedText = "A Light in the Attic";
        String actualText = element.getText();
        assertEquals(expectedText, actualText);
    }


}
