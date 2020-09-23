import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BuyPropertyTests extends TestBase  {

    @Test(dataProvider = "TestData")
    public void verifyAbuseReportForTheBuyProperty(PropertyTestData propertyTestData) {

        noBrokerHomePage.selectBuyOption();
        logger.info("Buy Option is selected");
        noBrokerHomePage.clickOnSearchTextBox();
        logger.info("Search Bar is clicked");
        searchHomePage.selectCity(propertyTestData.city);
        logger.info(propertyTestData.city + " city is selected");
        searchHomePage.enterAreaInSearchBox(propertyTestData.area1);
        logger.info(propertyTestData.area1 + " area is selected");
        searchHomePage.enterAreaInSearchBox(propertyTestData.area2);
        logger.info(propertyTestData.area2 + " area is selected");
        searchHomePage.clickIncludeNearByProperty();
        logger.info("Include Property Check Box is Clicked");
        searchHomePage.selectBedrooms(propertyTestData.bedroom1);
        logger.info(propertyTestData.bedroom1 + " room is selected");
        searchHomePage.selectBedrooms(propertyTestData.bedroom2);
        logger.info(propertyTestData.bedroom2 + " room is selected");
        searchHomePage.clickSearchButton();
        logger.info("Search Button is clicked");
        propertiesListingPage.selectTheProperty(propertyTestData.propertyIndex);
        logger.info(propertyTestData.propertyIndex + "th index is clicked");
        propertiesListingPage.clickOnWrongInfo();
        logger.info("Wrong Info is clicked");
        wrongInfoPage.clickOnAllCheckBoxes();
        logger.info("selected all check boxes");
        wrongInfoPage.clickOnReportButton();
        logger.info("Report Button is clicked");
        suggestAnEditPage.addCorrectConfiguration(propertyTestData.correctConfig);
        logger.info(propertyTestData.correctConfig + " correct configuration is added");
        suggestAnEditPage.addANote(propertyTestData.note);
        logger.info(propertyTestData.note + " details note is added");
        suggestAnEditPage.verifyFeedbackIsSubmitted();
        logger.info("Feedback popup is verified");

    }

    @DataProvider(name = "TestData")
    public static Object[][] getNumbers() {
        return new Object[][] { {new PropertyTestData("Bangalore", "Marathahalli","HSR Layout","2BHK","3BHK","4+ BHK","wrong bedroom",4)}};
    }

}
