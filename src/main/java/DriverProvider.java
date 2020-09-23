import io.appium.java_client.android.AndroidDriver;

public class DriverProvider {

    private static DriverProvider instance = null;
    private static AndroidDriver driver;


    public static DriverProvider getInstance() {
        if (null == instance) {
            instance = new DriverProvider();
        }
        return instance;
    }

    public static AndroidDriver getDriver() {
        return driver;
    }


    public static void setDriver(AndroidDriver driver) {
        DriverProvider.driver = driver;
    }
}
