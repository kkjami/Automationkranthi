package testng;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssertTest {
    Logger log = Logger.getLogger(this.getClass().getName());
    private SoftAssert so;

    @BeforeMethod
    public void aser() {
//        so =
    }

    @Test
    public void nakem() {
        String hello = "hai";
        so.assertTrue(false, "happ: " + hello);
        log.info("123");
        log.debug("123");
        log.error("123");
        so.assertEquals(1, 2, "happ2: " + hello);
        so.assertEquals(1, 2, "happ3: " + hello);
        so.assertAll();
        log.info("verify url : http://web.demo.reportportal.io/ui/#default_personal/launches/all/5bf14f1a4ce7110001b614e1?");
    }

    @Test
    public void jaffa() {
        String expected = "USSDGW0100You have successfully transferred amount 100.00 USD to 0889100000 on Nov 16, [0-9]{4,4}. Your updated balance is 99,800.00 USD. Transaction ID: [0-9]{25,25} ";
        String actual = "USSDGW0100You have successfully transferred amount 100.00 USD to 0889100000 on Nov 16, 2018. Your updated balance is 99,800.00 USD. Transaction ID: 2018116108110008720100031 ";
        String txnIdRegex = ": [0-9]{25,25}";
//        Assert.assertTrue("expected"+expected+"\nactual"+actual,expected.replaceAll(txnIdRegex, "").equals(actual.replaceAll(txnIdRegex, "")));
//    Assert.assertTrue(actual.matches(expected));

        Pattern expect = Pattern.compile(expected);
        Matcher m = expect.matcher(actual);
        Assert.assertTrue(m.matches(), "\n Expected pattern: " + expected + "\n Actual   pattern: " + actual + "\n");
    }
}
