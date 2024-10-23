package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;

public class PracticeFormTests extends TestBase {
    @BeforeMethod
    public void preCondition() {

        new HomePage(app.driver).getForms().hideAds();
        new SidePage(app.driver).selectPracticeForm().hideAds();
    }
//.enterSubject("Maths", "English")
    @Test
    public void practiceFormTest() throws AWTException {
        new PracticeFormPage(app.driver)
                .enterPersonalData("Name", "Surname", "email@gmail.com", "01234567890")
                .selectGender("Male")
               //.chooseDate("4", "June", "2000")
        .chooseDateAsString("21 Oct 2024")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
               .uploadPicture("C:/Users/hanna/Videos/Bandicam/bandicam 2024-09-26 15-35-31-308.jpg")
                .enterCurrentAddress("Germany, Hessen")
                .selectState("NCR")
                .selectCity("Delhi")
               .submitForm()
               .verifySucsessRegistration("Thanks for submitting the form");
    }


    //"Name", "Surname", "email@gmail.com", "01234567890"
    @Test
    @Parameters({"firstName", "lastName", "email", "phone"})
    public void practiceFormParametersTest(String firstName, String lastName, String email, String phone) throws AWTException {
        new PracticeFormPage(app.driver)
                .enterPersonalData(firstName, lastName, email, phone)
                .selectGender("Male")
                //.chooseDate("4", "June", "2000")
                .chooseDateAsString("21 Oct 2024")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/Users/hanna/Videos/Bandicam/bandicam 2024-09-26 15-35-31-308.jpg")
                .enterCurrentAddress("Germany, Hessen")
                .selectState("NCR")
                .selectCity("Delhi")
                .submitForm()
                .verifySucsessRegistration("Thanks for submitting the form");
    }


}
