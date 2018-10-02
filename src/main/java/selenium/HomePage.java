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
}
