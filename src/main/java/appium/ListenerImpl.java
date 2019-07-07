package appium;

import org.apache.log4j.Logger;
import org.testng.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by kranthikumar on 05/07/17.
 */
public class ListenerImpl  implements ITestListener {

    private BufferedWriter bufferedwriter;
    private Logger log = Logger.getLogger(this.getClass());

    public ListenerImpl() {
        System.setProperty("rp.description","jkl");
    }

    @Override
    public synchronized void onTestStart(ITestResult iTestResult) {
        log.info(iTestResult.getParameters());
        log.info(iTestResult.getHost());
        log.info(iTestResult.getEndMillis());
        log.info(iTestResult.getMethod());
        log.info(iTestResult.getInstanceName());
        log.info(iTestResult.getName());
        log.info(iTestResult.getStartMillis());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        try {
            bufferedwriter = new BufferedWriter(new FileWriter(new File("target/content.html")));
            bufferedwriter.write(iTestContext.getSuite().getName());
        } catch (IOException e) {
            log.info(e.getStackTrace());
        }

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        try {
            bufferedwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void testInfo(Boolean status,String stepDesc){

    }

}
