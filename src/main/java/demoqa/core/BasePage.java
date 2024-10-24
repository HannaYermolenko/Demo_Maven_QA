package demoqa.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public  JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public static void enter(Robot robot) {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void paste(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static void tab(Robot robot) {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    public static void copy(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static void highlight(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void click(WebElement element) {
        scrollToElement(element);
        element.click();
        // logger.info("[" + locator + "] is pressed");
        // logger.error("[" + locator + "] is pressed");
        // logger.warn("[" + locator + "] is pressed");

    }

    public void scrollToElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    protected void clickWitJS(WebElement element, int x, int y) {
        //window.scrollBy(0,100)
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        //js.executeScript("window.scrollBy({},{})",x,y);
        click(element);

    }



    protected void scrollTo(int y) {
        js.executeScript("window.scrollBy(" + 0 + "," + y + ")");
    }

    protected void scrollWithPageDown(int times) {
        try {
            Robot robot = new Robot();
            for (int i = 0; i < times; i++) {
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                robot.delay(100);
            }

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }

    public void typeScrollWithJs(WebElement element, String text, int y) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void hideAds() {
        js.executeScript("document.getElementById('adplus-anchor').style.display='none';");
        js.executeScript("document.querySelector('footer').style.display='none';");
    }


    protected void shouldHaveText(WebElement element, String text, int timeOut) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(timeOut));
        try {
            boolean isTextPresent = wait1.until(ExpectedConditions.textToBePresentInElement(element, text));
            Assert.assertTrue(isTextPresent,
                    "Expected text: [" + text + "], actual text: [" + element.getText() + "] in element: [" + element + "]");
        } catch (TimeoutException e) {
           // throw new TimeoutException(e.getMessage());
        }

    }

    public void verifyLink(String urlCheck) {
        try {
            URL url = new URL(urlCheck);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            if(responseCode>=400){
                //broken
                System.out.println("URL to check: " + "[" + urlCheck +"]," +
                        " response Code: [" + responseCode +"]," +
                        " response Message: [" + responseMessage + "] is broken link");
            }else {
                //correct
                System.out.println("URL to check: " + "[" + urlCheck +"]," +
                        " response Code: [" + responseCode +"]," +
                        " response Message: [" + responseMessage + "] is valid link");
            }

        } catch (MalformedURLException e) {
            System.err.println("error: MalformedURL" + "[" + urlCheck +"]");
            //throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("error: [" + e.getMessage() + "]");
           // throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementNotPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
