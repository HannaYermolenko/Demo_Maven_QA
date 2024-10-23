package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage clickAlertWithtimer() {
        click(timerAlertButton);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }


    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnConfirmButton() {
        click(confirmButton);
        return this;
    }

    public AlertsPage selectResult(String text) {
        if (text != null && text.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (text != null && text.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        } else {
            System.out.println("Wrong command");
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage verifyResult(String result) {
        shouldHaveText(confirmResult, result, 5000);

        return this;
    }


    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage clickOnPromButton() {
        click(promtButton);
        return this;
    }


    public AlertsPage sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage verifyAlertText(String text) {
        shouldHaveText(promptResult, text, 5000);
        assert promptResult.getText().contains(text);


        return this;
    }
}
