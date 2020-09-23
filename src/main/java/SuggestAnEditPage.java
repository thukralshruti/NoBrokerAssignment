import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SuggestAnEditPage extends BasePage{

    @FindBy(id = "sp_bhk_type")
    private WebElement correctConfigurationDropdown;

    @FindBy(id = "btn_save")
    private WebElement saveChanges;

    @FindBy(id = "edt_others")
    private List<WebElement> addNote;

    @FindBy(className = "android.widget.TextView")
    private WebElement thankyouWidget;

    public SuggestAnEditPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void addCorrectConfiguration(String actualConfig){
        waitForElementToBeVisible(correctConfigurationDropdown);
        correctConfigurationDropdown.click();
        wait(2000);
        WebElement selectConfig = driver.findElement(By.xpath("//*[@text = '"+actualConfig+"']"));
        selectConfig.click();


    }

    public void addANote(String note) {
        while (addNote.size() <=1) {
            if(addNote.size()>0) {
                System.out.println("Add Note Size"+ addNote.size());
                wait(2000);
                addNote.get(0).sendKeys(note);
                break;

            }
            else {
                scroll();
            }


        }
        saveChanges.click();
    }

    public void verifyFeedbackIsSubmitted() {
        //tuning value
        wait(10000);
        Assert.assertTrue(thankyouWidget.isDisplayed(),"Feedback successful widget is not displayed");
        Assert.assertEquals(thankyouWidget.getText(),"Thank you for the feedback","Feedback string is not matching");

    }
}
