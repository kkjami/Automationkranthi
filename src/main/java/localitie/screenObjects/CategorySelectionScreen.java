package localitie.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import localitie.util.DeviceConnector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CategorySelectionScreen {
    public CategorySelectionScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /*Groups */
    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[1]")
    public WebElement bring_me_that_from_there;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[2]")
    public WebElement flat_n_flatmates;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[3]")
    public WebElement food_n_restaurant;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[4]")
    public WebElement garage_sale;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[5]")
    public WebElement health_n_wellness;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[6]")
    public WebElement last_minute_deals;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[7]")
    public WebElement lost_n_found;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[8]")
    public WebElement mom_n_parenting;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[9]")
    public WebElement never_miss_anyone;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[10]")
    public WebElement pet_lover_n_adoption;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[11]")
    public WebElement put_me_in_touch;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[12]")
    public WebElement sports_n_hobbies;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGroups\"]/android.widget.FrameLayout[13]")
    public WebElement tourist_queries;

    /* Governance */
    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement consumer_issue;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement environment_n_greenery;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement inclusive_n_diversity;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement news_n_politics;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement medical_needs;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement policies_law_crime;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement public_safety;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement roads_n_infrastructure;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement school_n_education;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement sewage_issues;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement traffic_issues;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewGovernance\"]/android.widget.FrameLayout[1]")
    public WebElement water_issues;
    /*Directories*/

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement beauty_service;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement car_n_bike_services;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement carpentry_service;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement day_care_n_play_school;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement electrical_services;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement laundry_services;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement interior_designers;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement nanny_maid_n_cooking;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement photographers;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement plumber_services;

    @AndroidFindBy(xpath = "//*[@id=\"com.localities:id/recyclerViewServices\"]/android.widget.FrameLayout[1]")
    public WebElement tutor_n_classes;
    /* save n exit*/

    @AndroidFindBy(id = "com.localities:id/btnSave")
    public WebElement save_n_next;


}
