package testng;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssertTest {
    SoftAssert so = new SoftAssert();

    @Test
    public void nakem() {
        String hello = "hai";
        so.assertTrue(false, "happ: " + hello);
        so.assertEquals(1, 2, "happ2: " + hello);
        so.assertEquals(1, 2, "happ3: " + hello);
        so.assertAll();
    }

    @Test
    public void jaffa() {
        String expected = "USSDGW0100You have successfully transferred amount 100.00 USD to 0889100000 on Nov 16, [0-9]{4,4}. Your updated balance is 99,800.00 USD. Transaction ID: [0-9]{25,25} ";
        String actual = "USSDGW0100You have successfully transferred amount 100.00 USD to 0889100000 on Nov 16, 2018. Your updated balance is 99,800.00 USD. Transaction ID: 2018116108110008720100031 ";
        String txnIdRegex = ": [0-9]{25,25}";
        String processedexpected;

//        Assert.assertTrue("expected"+expected+"\nactual"+actual,expected.replaceAll(txnIdRegex, "").equals(actual.replaceAll(txnIdRegex, "")));
//    Assert.assertTrue(actual.matches(expected));

        Pattern expect = Pattern.compile(expected);
        Matcher m = expect.matcher(actual);
        Assert.assertTrue(m.matches(), "\n Expected pattern: " + expected + "\n Actual   pattern: " + actual + "\n");
    }
}
