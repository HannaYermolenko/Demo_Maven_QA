package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {
    public SidePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement login;

    public LoginPage selectLogin() {
        //span[contains(text(),'Login')]
        click(login);
        return new LoginPage(driver);

    }

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public WidgetsPage selectSelectMenu() {
        click(selectMenu);
        return new WidgetsPage(driver);
    }

    //* BrowserWindows
    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BasePage selectBrowserWindows() {
        click(browserWindows);
        return this;
    }
    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;
    public BasePage selectButtons() {
        click(buttons);
        return new ButtonsPage(driver);
    }
    @FindBy(id = "item-0")
    WebElement textBox;
    public BasePage selectTextBox() {
        click(textBox);
        return this;
    }
    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;
    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }
    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoCompleteMenu;
    public AutoCompletePage selectAutoComplete() {
        click(autoCompleteMenu);
        return new  AutoCompletePage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinks;
    public BrokenLinksImagesPage selectBrokenLinksImages() {
        click(brokenLinks);
        return new BrokenLinksImagesPage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public ToolTipsPage selectToolTips() {
        click(toolTips);
        return new ToolTipsPage(driver);
    }
}
