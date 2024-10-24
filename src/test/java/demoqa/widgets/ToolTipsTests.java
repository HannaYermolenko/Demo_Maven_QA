package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.ToolTipsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests  extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectToolTips().hideAds();
    }

    @Test
    public void toolTipsTest(){
        new ToolTipsPage(app.driver)
                .hoverToolTip()
                .verifyToolTipText("You hovered over the Contrary");
    }
}
