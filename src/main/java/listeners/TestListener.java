package listeners;

import base.DriverFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LoggerUtils;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        LoggerUtils.info(
                "STARTING: " + result.getName()
        );

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        LoggerUtils.info(
                "PASSED: " + result.getName()
        );

    }

    @Override
    public void onTestFailure(ITestResult result) {

        LoggerUtils.error(
                "FAILED: " + result.getName()
        );

        ScreenshotUtils.captureScreenshot(
                DriverFactory.getDriver(),
                result.getName()
        );

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        LoggerUtils.info(
                "SKIPPED: " + result.getName()
        );

    }

}