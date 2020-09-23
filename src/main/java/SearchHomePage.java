import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchHomePage extends BasePage{

    @FindBy(id = "android:id/text1")
    private WebElement cityDropDown;

    @FindBy(id = "localityAutoCompleteTxt")
    private WebElement searchTextBox;

    @FindBy(id = "nearByRadio")
    private WebElement includeNearByProperties;

    @FindBy(xpath = "//*[@text = 'SEARCH']")
    private WebElement searchButton;

    @FindBy(id = "bhktwo")
    private WebElement twoBhk;

    @FindBy(id = "bhkthree")
    private WebElement threeBhk;

    public SearchHomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void selectCity(String city) {
        waitForElementToBeVisible(cityDropDown);
        cityDropDown.click();
        wait(2000);
        WebElement selectCity = driver.findElement(By.xpath("//*[@text = '"+city+"']"));
        selectCity.click();
    }

    public void enterAreaInSearchBox(String area) {

        searchTextBox.sendKeys(area);
        int x = searchTextBox.getLocation().getX();
        int y = searchTextBox.getLocation().getY();
        System.out.println("X value: "+ x+ "Y Value: "+ y);
        new TouchAction(driver).tap(PointOption.point(x+60,y+260)).release().perform();
    }

    public void clickIncludeNearByProperty() {

        includeNearByProperties.click();

    }

    public void selectBedrooms(String bedroom) {

        //can be done by enum as well
        switch (bedroom){
            case "2BHK":
                twoBhk.click();
                break;

            case "3BHK":
                threeBhk.click();
                break;
        }


    }

    public void clickSearchButton() {
      searchButton.click();

    }
}
