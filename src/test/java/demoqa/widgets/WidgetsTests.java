package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.WidgetsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WidgetsTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectSelectMenu().hideAds();
    }

    @Test
    public void oldStyleSelectMenuTest(){
        new WidgetsPage(app.driver)
               .selectOldStyle("Indigo");
    }


    @Test
    public void multiselectDropDownTest(){
        String[] colorsSelect = {"Green", "Blue"};
        WidgetsPage page = new WidgetsPage(app.driver);
        page.multiSelect(colorsSelect);
       assertTrue(page.areColorsSelected(colorsSelect));

    }

    @Test
    public void standartMultiSelectOneCarTest(){
        new WidgetsPage(app.driver)
                .selectStandartMultiSelect("Volvo");

    }


    @Test
    public void standartMultiSelectTwoCars(){
        String[] carsSelect = {"Volvo", "Audi", "Opel"};
        WidgetsPage page = new WidgetsPage(app.driver);
        page.multiSelectCars(carsSelect);


    }

    @Test
    public void standartMultiSelectByIndexCars(){

        new WidgetsPage(app.driver)
                .standartMultiSelectByIndex(2)
                .verifyByIndex(2);


    }

    @Test
    public void standartMultiSelectByCarsTest(){
        String[] carsSelect = {"Volvo", "Audi", "Opel"};
        new WidgetsPage(app.driver)
                .multiSelectByCars(carsSelect)
                .varifyByCars(carsSelect);

    }






}
