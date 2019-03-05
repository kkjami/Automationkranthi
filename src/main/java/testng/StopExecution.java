package testng;

import org.testng.annotations.Test;

public class StopExecution {
    @Test
    public void method1(){

    }
    @Test
    public void method2(){
    System.exit(1);
    }
}
