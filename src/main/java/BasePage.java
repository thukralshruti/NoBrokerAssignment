import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage {

    protected AndroidDriver driver;

    protected void waitForElementToBeVisible(WebElement element) {

        new WebDriverWait(driver, 60).until(
                ExpectedConditions.visibilityOf(element));

    }

    protected void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void scroll() {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int)(size.getWidth()/2);
        int startPoint = (int) (size.getHeight() * 0.5);
        int endPoint = (int) (size.getHeight() * 0.2);
        System.out.println("inside");
        new TouchAction(driver)
                .press(point(anchor,startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(point(anchor,endPoint))
                .release().perform();
    }

}
