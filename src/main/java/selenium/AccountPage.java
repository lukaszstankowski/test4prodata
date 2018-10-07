package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

class AccountPage extends Page {

    AccountPage(WebDriver driver) {
        super(driver);
    }

    OrderPage makeOrder() throws InterruptedException {
        Actions actions = new Actions(driver);

        clickButton(By.className("login"));
        insertText(By.id("email"), "test008@gmail.com");
        insertText(By.id("passwd"), "123456");
        clickButton(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
        clickButton(By.xpath("//a[@title='Women']"));
        clickButton(By.id("layered_category_8"));
        checkCheckbox(By.xpath("//input[@type = 'button']"));
        Thread.sleep(3000);

        WebElement fieldAddToCart = driver.findElement(By.xpath("//div[@class='right-block']"));
        actions.moveToElement(fieldAddToCart).perform();
        clickButton(By.xpath("//span[contains(., 'Add to cart')]"));
        visibilityOfElementLocated(By.xpath("//span[contains(., 'Add to cart')]"));
        return new OrderPage(driver);
    }
}
