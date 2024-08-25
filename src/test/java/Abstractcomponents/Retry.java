package Abstractcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


public class Retry implements IRetryAnalyzer {

	int count=0;
	int max=5;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<max)
		{
			count++;
			System.out.println(count);
			return true;
		}
		return false;
	}

	

}
