package selenium;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

public class BrowserRuleFactory {

        @Rule
        public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
                .withDesiredCapabilities(DesiredCapabilities.chrome());

        @Test
        public void simplePlainSeleniumTest() {
            RemoteWebDriver driver = chrome.getWebDriver();

            driver.get("https://www.google.com");
            WebElement searchInput = driver.findElementById("lst-ib");

            searchInput.sendKeys("Rick Astley");
            searchInput.submit();

            WebElement otherPage = driver.findElementByPartialLinkText("Rick");
        }
}
