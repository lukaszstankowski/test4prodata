package selenium;

import org.junit.Test;

public class Runner extends WebdriverInitializer {

    @Test
    public void shouldRegisterNewUser() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        SignPage signPage = homePage.signIn();
        AccountPage createdAccount = signPage.createAccount();
    }
}
