package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MultiThreadTest {

    @BeforeMethod
    public void beforeRest(Object[] jk) {
        System.out.println(Arrays.toString(jk)+" before M "+ Thread.currentThread().getId());
    }

    @AfterMethod
    public void afterRest(Object[] jk) {
        System.out.println(Arrays.toString(jk)+" after M "+ Thread.currentThread().getId());
    }

    @Test(dataProvider = "sample")
    public void jaffa(String jk,String jk2) {
        System.out.println(jk+" in Test "+ Thread.currentThread().getId());
    }

    @Test(dataProvider = "sample1")
    public void jaffa1(String jk,String jk2) {
        System.out.println(jk+" in Test 2 "+ Thread.currentThread().getId());
    }
//    @Test(dataProvider = "sample")
//    public void jaffa3(String jk,String jk2) {
//        System.out.println(jk+" in Test 3 "+ Thread.currentThread().getId());
//    }

    @DataProvider(name = "sample")
    public Object[][] some(){
        return new Object[][]
                {
                        { "Guru99", "India" },
                        { "Krishna", "UK" },
                        { "Bhupesh", "USA" }
                };
    }

    @DataProvider(name = "sample1")
    public Object[][] some1(){
        return new Object[][]
                {
                        { "Guru1", "India" },
                        { "Krishn111a", "UK" },
                        { "Bhupes1h", "USA" }
                };
    }
}
