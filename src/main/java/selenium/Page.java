package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

class Page {

    WebDriver driver;

    Page(WebDriver driver) {
        this.driver = driver;
    }

    void clickButton(By by) {
        driver.findElement(by).click();
    }

    void insertText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    void selectDropDownList(By by, String value) throws InterruptedException {
        Select element = new Select(driver.findElement(by));
        element.selectByValue(value);
        Thread.sleep(2000);
    }

    void checkCheckbox(By by) {
        List<WebElement> listOfCheckboxes = driver.findElements(by);
        Random random = new Random();
        int value = random.nextInt(listOfCheckboxes.size());
        listOfCheckboxes.get(value).click();
    }

    void scrollWindow(String valueScroll) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy" + valueScroll);
    }
}
