package appium;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by kranthikumar on 05/07/17.
 */
    public class ListenerImpl implements ITestListener {
    private File file;
    private FileWriter filewriter;
    private BufferedWriter bufferedwriter;
    private final Logger log=Logger.getLogger(ListenerImpl.class);
    @Override
    public void onTestStart(ITestResult iTestResult) {

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
        file = new File("target/content.html");
        try {
            filewriter = new FileWriter(file);
            bufferedwriter = new BufferedWriter(filewriter);
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
