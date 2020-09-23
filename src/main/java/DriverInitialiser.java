import io.appium.java_client.android.AndroidDriver;

public class DriverInitialiser {
    public AndroidDriver driver;


    public AndroidDriver init() throws Exception {

        driver = null;
        driver = new DriverClass().getDriver();

        DriverProvider.setDriver(driver);
        return driver;
    }
}
