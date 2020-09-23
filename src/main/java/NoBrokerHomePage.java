import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NoBrokerHomePage extends BasePage{

    @FindBy(xpath = "//*[@text = 'Buy']")
    private WebElement buyOption;

    @FindBy(xpath = "//android.widget.TextView[@resource-id ='com.nobroker.app:id/searchEditHome']")
    private WebElement searchBox;


    public NoBrokerHomePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void selectBuyOption(){
        waitForElementToBeVisible(buyOption);
        buyOption.click();

    }

    public void clickOnSearchTextBox() {
        waitForElementToBeVisible(searchBox);
        searchBox.click();
    }
}
