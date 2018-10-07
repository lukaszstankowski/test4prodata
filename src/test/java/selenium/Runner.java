package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Runner extends WebdriverInitializer {

    @Test
    public void shouldRegisterNewUser() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        SignPage signPage = homePage.signIn();

        signPage.registerNewUser();
        String messageAfterAuthorization = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();

        assertEquals(
                messageAfterAuthorization,
                "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Test
    public void shouldAuthorizedExistUser() {
        HomePage homePage = new HomePage(driver);

        homePage.authorize();

        String messageAfterAuthorization = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
        assertEquals(
                messageAfterAuthorization,
                "Welcome to your account. Here you can manage all of your personal information and orders.");
    }

    @Test
    public void shouldAddProductToCart() throws InterruptedException {
        AccountPage accountPage = new AccountPage(driver);

        accountPage.makeOrder();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        Boolean expectedCondition = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2"), "Product successfully added to your shopping cart"));

        Assert.assertTrue(expectedCondition);

    }
}
