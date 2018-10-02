package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Page {

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;


    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButton(By by) {
        driver.findElement(by).click();
    }

    public void insertText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void selectDropDownList(By by, String value) throws InterruptedException {
        Select element = new Select(driver.findElement(by));
        element.selectByValue(value);
        Thread.sleep(2000);
    }

    public void checkCheckbox(By by) {
        List<WebElement> listOfCheckboxes = driver.findElements(by);
        Random random = new Random();
        int value = random.nextInt(listOfCheckboxes.size());
        listOfCheckboxes.get(value).click();
    }

    public void wait4VisiblyAndClick(By by) {
        wait = new WebDriverWait(driver, 3);
//        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//        webElement.click();
    }

    public void scrollWindow(String valueScroll) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy" + valueScroll);
    }
}
