package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class HomePage extends Page {

    HomePage(WebDriver driver) {
        super(driver);
    }

    SignPage signIn() {
        clickButton(By.className("login"));
        return new SignPage(driver);
    }

    void authorize() {
        clickButton(By.className("login"));
        insertText(By.id("email"), "test008@gmail.com");
        insertText(By.id("passwd"), "123456");
        clickButton(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
    }
}
