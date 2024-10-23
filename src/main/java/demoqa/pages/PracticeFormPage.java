package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String name, String surname, String mail, String number) {
        type(firstName, name);
        type(lastName, surname);
        type(userEmail, mail);
        type(userNumber, number);
        return this;
    }


    public PracticeFormPage selectGender(String gender) {
        try {
            String xpathGender = "//label[contains(text(),'" + gender + "')]";
            WebElement genderLocator = driver.findElement(By.xpath(xpathGender));
            click(genderLocator);
        } catch (NoSuchElementException e) {
            System.out.println("Gender not found [" + gender + "]");
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: selecting gender");
            throw new RuntimeException(e);


        }
        return this;
    }
    //id = "dateOfBirthInput"
    //react-datepicker__month-select
    //react-datepicker__year-select

    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthOfBirthInput;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearOfBirthInput;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage chooseDate(String day, String month, String year) {
        click(dateOfBirthInput);
        new Select(monthOfBirthInput).selectByVisibleText(month);
        new Select(yearOfBirthInput).selectByVisibleText(year);
        ////div[@class='react-datepicker__week']//div[.='4']
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage enterSubject(String[] subjects) {
        for (String subject : subjects) {
            if (subject != null) {
                type(subjectsInput, subject);
                subjectsInput.sendKeys(Keys.ENTER);
            }

        }


        return this;
    }
// //label[contains(text(),'Sports')]
//    @FindBy(xpath = "//label[.='Reading']")
//    WebElement hobby;

    public PracticeFormPage chooseHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            try {
                driver.findElement(By.xpath("//label[.='" + hobby + "']")).click();
            } catch (Exception e) {
                System.out.println("Hobby not found [" + hobby + "]");
                throw new RuntimeException(e);
            }

        }

        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadPicture(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterCurrentAddress(String address) {
        type(currentAddress, address);
        return this;
    }

    @FindBy(id = "state")
    WebElement stateContainer;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;


    public PracticeFormPage selectState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage selectCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);


        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submitForm() {
        click(submit);
        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement formSubmit;

    public PracticeFormPage verifySucsessRegistration(String form) {
        scrollWithPageDown(1);
        shouldHaveText(formSubmit, form, 5000);
        //   Assert.assertEquals(form, formSubmit.getText());

        return this;
    }

    public PracticeFormPage chooseDateAsString(String text) throws AWTException {
        click(dateOfBirthInput);
        String os = System.getProperty("os.name");
        if(os.contains("Mac")){
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        }else {
            Robot robot = new Robot();
            highlight(robot);
        }

        dateOfBirthInput.sendKeys(text);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }
}

