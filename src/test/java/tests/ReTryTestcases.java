package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class ReTryTestcases implements IRetryAnalyzer, ITestListener {


    int retryCount =0;
    int retryMaxCount = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (!iTestResult.isSuccess()){
            if (retryCount<retryMaxCount){
                retryCount++;
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
