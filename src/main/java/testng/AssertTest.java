package testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTest {
    SoftAssert so=new SoftAssert();
    @Test
    public void nakem(){
        String hello="hai";
        so.assertTrue(false,"happ: "+hello);
        so.assertEquals(1,2,"happ2: "+hello);
        so.assertEquals(1,2,"happ3: "+hello);
        so.assertAll();
    }
}
