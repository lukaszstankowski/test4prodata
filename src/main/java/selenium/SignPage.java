package selenium;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


class SignPage extends Page {

    SignPage(WebDriver driver) {
        super(driver);
    }

    AccountPage registerNewUser() throws InterruptedException {
        String email = randomEmail();
        insertText(By.name("email_create"), email);
        clickButton(By.id("SubmitCreate"));
        clickButton(By.id("id_gender1"));
        insertText(By.id("customer_firstname"), "John");
        insertText(By.id("customer_lastname"), "Doe");
        driver.findElement(By.id("email")).clear();
        insertText(By.id("email"), email);
        insertText(By.id("passwd"), "123456");

        selectDropDownList(By.id("days"), "21");
        selectDropDownList(By.id("months"), "12");
        selectDropDownList(By.id("years"), "1984");

        insertText(By.id("firstname"), "John");
        insertText(By.id("lastname"), "Doe");
        insertText(By.id("address1"), "street Corner 1");
        insertText(By.id("city"), "Los Angeles");


        selectDropDownList(By.id("id_state"), "23");

        insertText(By.id("postcode"), "12345");

        selectDropDownList(By.id("id_country"), "21");


        insertText(By.id("phone_mobile"), "555777333");
        driver.findElement(By.id("alias")).clear();
        insertText(By.id("alias"), "test");
        clickButton(By.xpath("//*[@id=\"submitAccount\"]/span"));
        return new AccountPage(driver);
    }

    private String randomEmail() {
        return RandomStringUtils.randomAlphabetic(5).concat("@test.com");
    }
}
