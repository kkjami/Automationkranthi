package localitie.tests;

import localitie.util.ConfigReader;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class Master {

    public ConfigReader config=new ConfigReader();
    private Logger log = Logger.getLogger(Master.class);
    SoftAssert softassert=new SoftAssert();


    @BeforeSuite
    public void initDriver(){

        }


    @AfterSuite
    public void finilizeTests(){

    }
}
