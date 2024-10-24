package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends BasePage {

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    //a[.='Contrary']
    @FindBy(xpath = "//a[.='Contrary']")
    WebElement contrary;

    public ToolTipsPage hoverToolTip() {
        pause(1000);
        new Actions(driver).moveToElement(contrary).perform();
        //pause(1000);
        return this;
    }

    @FindBy(className = "tooltip-inner")
    WebElement tooltipInner;
    public ToolTipsPage verifyToolTipText(String text) {
        shouldHaveText(tooltipInner,text,5000);
        return this;
    }
}
