import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTest {
    WebDriver driver;
    private String url = "https://demoqa.com/automation-practice-form";
    private By firstname = By.id("firstName");
    private By lastname = By.id("lastName");
    private By genderMale = By.cssSelector("label[for='gender-radio-1']"); // xpath("//label[text()='Male']")
    private By genderFemale = By.cssSelector("label[for='gender-radio-2']");
    private By genderOther = By.cssSelector("label[for='gender-radio-3']");
    private By date = By.id("dateOfBirthInput");
    private By year = By.className("react-datepicker__year-select");
    private By month = By.className("react-datepicker__month-select");
    private By firstDay = By.className("react-datepicker__day--001");
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNameElement() throws InterruptedException {
        try {
            WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(firstname));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameInput);

            driver.findElement(firstname).sendKeys("Furkan");
            driver.findElement(lastname).sendKeys("Nargul");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void testGenderElement() throws InterruptedException {
        try {
            // Gender
            WebElement genderMaleInput = wait.until(ExpectedConditions.elementToBeClickable(genderMale));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderMaleInput);
            driver.findElement(genderMale).click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    public void testDateElement() throws InterruptedException {
        try {
            // Date
            WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(date));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateInput);
            dateInput.click();

            Select selectYear = new Select(driver.findElement(year));
            selectYear.selectByVisibleText("1998");

            Select selectMonth = new Select(driver.findElement(month));
            selectMonth.selectByVisibleText("August");

            driver.findElement(firstDay).click();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
