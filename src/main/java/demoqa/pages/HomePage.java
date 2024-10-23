package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePage getBookStore() {
        // click(bookStore);
        //clickWitJS(bookStore, 0, 500);
       click(bookStore);
        return new SidePage(driver);
    }
    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertFrameWindows;
    public BasePage getAlertsFrameWindows() {
        click(alertFrameWindows);
        return new SidePage(driver);
    }

    @FindBy(css = ".top-card:nth-child(4)")
    WebElement widgets;
    public BasePage getWidgets() {
        click(widgets);
        return new SidePage(driver);
    }


    @FindBy(css = ".top-card:nth-child(1)")
    WebElement elements;
    public BasePage getElements() {
        click(elements);
        return new SidePage(driver);
    }
    @FindBy(css = ".top-card:nth-child(2)")
    WebElement forms;
    public BasePage getForms() {
        click(forms);
        return new SidePage(driver);
    }
}
