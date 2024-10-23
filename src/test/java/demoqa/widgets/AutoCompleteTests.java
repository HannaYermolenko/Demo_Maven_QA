package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.AutoCompletePage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectAutoComplete().hideAds();
    }

    @Test
    public void autoCompleteSingleTest(){
        new AutoCompletePage(app.driver)
                .autoComplete("m")
               .verifyAutocomplete("Magenta");
    }

    @Test
    public void autoCompleteArrayTest(){
        String[] autoCompleteArray = {"m", "b", "b"};
        String[] autoCompleteArrayVerify = {"Magenta", "Black", "Blue"};

        new AutoCompletePage(app.driver)
                .autoCompleteArray(autoCompleteArray)
                .verifyAutocompleteArray(autoCompleteArrayVerify)
        ;
    }
}
