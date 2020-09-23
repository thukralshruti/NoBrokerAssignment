import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WrongInfoPage extends BasePage {

    @FindBy(className = "android.widget.CheckBox")
    private List<WebElement> checkBoxButtons;

    @FindBy(id = "btn_report")
    private WebElement reportButton;

    public WrongInfoPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void clickOnAllCheckBoxes() {
        wait(3000);
        for (WebElement checkBox:
             checkBoxButtons) {

            checkBox.click();
        }
    }

    public void clickOnReportButton() {
        reportButton.click();
    }
}
