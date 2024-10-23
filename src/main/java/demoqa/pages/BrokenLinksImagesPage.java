package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenLinksImagesPage extends BasePage {
    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    //(//h1[text()='Broken Links - Images']/following-sibling::img)[2]
    @FindBy(css = "img")
    List<WebElement> allImages;

    public BrokenLinksImagesPage checkBrokenLinksImages() {
        for (WebElement image : allImages){
            String imageURL = image.getAttribute("src");
          //  System.out.println(imageURL);
            if (imageURL != null) {
                verifyLink(imageURL);

            }
            boolean isDisplayed = (Boolean) js.executeScript("return arguments[0].naturalWidth > 0", image);
            System.out.println("Image ["+imageURL+ (isDisplayed ? "is displayed " : "is not displayed"));
        }

        System.out.println(allImages.size());

        return this;
    }


}
