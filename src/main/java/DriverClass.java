import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverClass {


    private final static String APP_PACKAGE_NAME = "com.nobroker.app";
    private final static String APP_ACTIVITY_NAME = "com.nobroker.app.activities.NBSplashScreen";
    private final static String URL = "http://127.0.0.1:4723/wd/hub";



    public AndroidDriver getDriver() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        cap.setCapability("appPackage",APP_PACKAGE_NAME);
        cap.setCapability("appActivity",APP_ACTIVITY_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
        cap.setCapability(MobileCapabilityType.NO_RESET,"true");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

        AndroidDriver driver = new AndroidDriver(new URL(URL),cap);
        return  driver;



    }

}
