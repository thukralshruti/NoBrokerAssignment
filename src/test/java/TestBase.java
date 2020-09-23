


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

    protected AndroidDriver driver;
    NoBrokerHomePage noBrokerHomePage;
    SearchHomePage searchHomePage;
    PropertiesListingPage propertiesListingPage;
    WrongInfoPage wrongInfoPage;
    SuggestAnEditPage suggestAnEditPage;

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;


    @BeforeMethod(alwaysRun = true)
    public void initialiseDriver(ITestResult result, Method methodName) throws Exception {

        this.driver = new DriverInitialiser().init();
        logger = extent.createTest(methodName.getName()); // create new entry in the report
        noBrokerHomePage = new NoBrokerHomePage(driver);
        searchHomePage = new SearchHomePage(driver);
        propertiesListingPage = new PropertiesListingPage(driver);
        wrongInfoPage = new WrongInfoPage(driver);
        suggestAnEditPage = new SuggestAnEditPage(driver);

    }

    @BeforeSuite(alwaysRun = true)
    public void reporting() {

        htmlReporter = new ExtentHtmlReporter(
                System.getProperty("user.dir") + "/ExtentReport/" + "TestReport" + ".html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "QA");
//        extent.setSystemInfo("Environment", System.getProperty("env").toString());
//        extent.setSystemInfo("GroupName", System.getProperty("groups").toString());

        htmlReporter.config().setDocumentTitle("No Broker Assignment Report"); // Tile of report
        htmlReporter.config().setReportName("No Broker Assignment Report"); // name of the report

        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

    }

    @AfterMethod(alwaysRun = true)
    public void captureScreen(ITestResult result, Method methodName) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
            String targetpath = "./ExtentReport/" + result.getName() + ".png";
            FileUtils.copyFile(source, new File(targetpath));
            System.out.println("screenshot captured");
            logger.log(Status.FAIL, MarkupHelper.createLabel(methodName.getName(), ExtentColor.RED));
            logger.fail(result.getThrowable().getMessage());
            try {
                logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath("." + targetpath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(methodName.getName(), ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(methodName.getName(), ExtentColor.ORANGE));
        }

        if (null != driver) {
            driver.quit();
            driver = null;
        }

    }

    @AfterSuite(alwaysRun = true)
    public void killDriver() throws Exception {

        extent.flush();


    }
}
