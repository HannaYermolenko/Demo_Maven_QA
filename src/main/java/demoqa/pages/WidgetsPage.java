package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class WidgetsPage extends BasePage {

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public WidgetsPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    @FindBy(css = "html")
    WebElement body;


    public WidgetsPage multiSelect(String[] colors) {

        for (String color : colors) {
            if (color != null) {
                inputSelect.sendKeys(color);
                inputSelect.sendKeys(Keys.ENTER);
            }
            inputSelect.sendKeys(Keys.ESCAPE);
            //click(body);

        }

        return this;
    }

    @FindBy(className = "css-12jo7m5")
    List<WebElement> selectedColors;

    public boolean areColorsSelected(String[] colors) {
        List<String> selectedText = new ArrayList<>();
        for (WebElement element : selectedColors) {
            selectedText.add(element.getText());
        }
        for (String color : colors) {
            if (!selectedText.contains(color)) {
                return false;
            }
        }
        return true;
    }

    @FindBy(css = "option[value='volvo']")
    WebElement volvo;
    @FindBy(css = "option[value='saab']")
    WebElement saab;

    @FindBy(css = "option[value='opel']")
    WebElement opel;

    @FindBy(css = "option[value='audi']")
    WebElement audi;

    public WidgetsPage selectStandartMultiSelect(String car) {
        WebElement carSelect = null;
        switch (car.toLowerCase()) {
            case "volvo":
                carSelect = volvo;
                break;
            case "saab":
                carSelect = saab;
                break;
            case "opel":
                carSelect = opel;
                break;
            case "audi":
                carSelect = audi;
                break;
            default:
                System.out.println("Wrong command");

        }
        if (carSelect != null) {
            click(carSelect);
        }

        assertTrue(carSelect.isSelected());
        return this;
    }


    public WidgetsPage multiSelectCars(String[] cars) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).perform();
        for (String car : cars) {
            try {
                WebElement carOption = driver
                        .findElement(By.cssSelector("option[value='" + car.toLowerCase() + "']"));
                click(carOption);
            } catch (NoSuchElementException e) {
                System.out.println(car + "not found");
            }
        }
        actions.keyUp(Keys.CONTROL).perform();
        for (String car : cars) {
            WebElement carOption = driver.findElement(By.cssSelector("option[value='" + car.toLowerCase() + "']"));
            assertTrue(carOption.isSelected(), car + "not selected");
        }

        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;

    public WidgetsPage standartMultiSelectByIndex(int index) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            select.selectByIndex(index);
        }
        List<WebElement> options = select.getOptions();
        String selectedText = options.get(index).getText();
        System.out.println(selectedText);

        return this;
    }

    public WidgetsPage verifyByIndex(int index) {
        Select select = new Select(cars);
        List<WebElement> options = select.getOptions();
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        String selectedText = options.get(index).getText();
        boolean textFound = false;
        for (WebElement element : selectedOptions) {
            if (element.getText().equals(selectedText)) {
                textFound = true;
                break;
            }

        }
        Assert.assertTrue(textFound);
        //assert textFound;

        return this;
    }

    public WidgetsPage multiSelectByCars(String[] car) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            for (String element : car) {
                select.selectByVisibleText(element);
            }

        }
        return this;

    }

    public WidgetsPage varifyByCars(String[] expected) {
        Select select = new Select(cars);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> selectedText = new ArrayList<>();
        for (WebElement element : selectedOptions) {
            selectedText.add(element.getText());
        }

        List<String> expectedText = Arrays.asList(expected);
       assert new HashSet<>(selectedText).containsAll(expectedText);

        return this;

    }
}

