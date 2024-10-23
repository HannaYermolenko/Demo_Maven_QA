package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        //User Hhh
        //password: Qwerty12@
        new HomePage(app.driver).getBookStore().hideAds();
        new SidePage(app.driver).selectLogin();

    }

    @Test(invocationCount = 1)
    public void loginPositive(){
        new LoginPage(app.driver)
                .enterPersonalData("Hhh","Qwerty12@")
                .clickOnLoginButton()
                .verifyUserName("Hhh");
    }


}
