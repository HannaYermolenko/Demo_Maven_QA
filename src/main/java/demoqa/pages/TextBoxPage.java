package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage enterPersonalData(String name, String mail, String address) throws AWTException {
        type(userName, name);
        type(userEmail, mail);
        type(currentAddress, address);
        return this;
    }

//    public TextBoxPage keyboardEvent() throws AWTException {
//        Robot robot = new Robot();
//        highlight(robot);
//        copy(robot);
//        tab(robot);
//        paste(robot);
//        tab(robot);
//
//        enter(robot);
//
//        return this;
//    }

    public TextBoxPage keyboardEvent() throws AWTException {
        Robot robot = new Robot();
        // Ctrl + A
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Ctrl + C
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Tab
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // Ctrl + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Tab
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        return this;
    }

    @FindBy(xpath = "//p[@id='currentAddress']")
    WebElement current;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement permanent;

    public TextBoxPage verifyCopyPasteAddress() {
        String currentAddress = current.getText();
        String permanentAddress = permanent.getText();
        String expected = currentAddress.substring(currentAddress.indexOf(":") + 1).trim();
        String actual = permanentAddress.substring(permanentAddress.indexOf(":") + 1).trim();
        Assert.assertEquals(actual, expected);
        return this;
    }

    public TextBoxPage verifyCopyPasteAddress2() {
        String[] currentRes = current.getText().split(":");
        String[] permanentRes = permanent.getText().split(":");
        Assert.assertEquals(currentRes[1], permanentRes[1]);
//        String currentAddress = current.getText();
//        String permanentAddress = permanent.getText();
//        String expected = currentAddress.substring(currentAddress.indexOf(":") + 1).trim();
//        String actual = permanentAddress.substring(permanentAddress.indexOf(":") + 1).trim();
//        Assert.assertEquals(actual, expected);
        return this;
    }
}
