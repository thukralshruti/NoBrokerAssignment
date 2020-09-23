import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class PropertiesListingPage extends BasePage {


    @FindBy(id = "sub_title")
    private WebElement propertySubTitle;

    @FindBy(id = "tv_report_wrong_info")
    private List<WebElement> wrongInfo;

    public PropertiesListingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void selectTheProperty(int index) {

        wait(6000);
        List<String> subtitleList = new ArrayList<>();
        wait(3000);



        while(subtitleList.size() <index) {
            subtitleList.add(propertySubTitle.getText());
            System.out.println(subtitleList);
            if (subtitleList.size() == index) {
                propertySubTitle.click();
                wait(5000);
            } else {
                scroll();
            }

        }
    }

    public void clickOnWrongInfo() {

        System.out.println("Inside Wrong Info");
        while(wrongInfo.size()<=1){
            System.out.println("Wrong Info Size"+ wrongInfo.size());
        if(wrongInfo.size()>0) {
            System.out.println("Wrong Info Size"+ wrongInfo.size());
            wait(2000);
            wrongInfo.get(0).click();
            break;

        }
        else {
            scroll();
        }
        }
    }

}