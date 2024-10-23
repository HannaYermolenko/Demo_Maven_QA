package demoqa.alerts_frames_windows;

import demoqa.core.TestBase;
import demoqa.pages.AlertsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        new HomePage(app.driver).getAlertsFrameWindows().hideAds();
        new SidePage(app.driver).selectAlerts().hideAds();
    }

    @Test
    public void waitAlertTest(){
        new AlertsPage(app.driver).clickAlertWithtimer();

    }

    @Test
    public void alertWithSelectTest(){
        new AlertsPage(app.driver)
                .clickOnConfirmButton()
                .selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlert(){
        new AlertsPage(app.driver)
                .clickOnPromButton()
               .sendTextToAlert("Ok")
                .verifyAlertText("Ok");
    }




}
