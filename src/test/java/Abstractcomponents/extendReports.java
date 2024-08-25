package Abstractcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendReports {
	public static ExtentReports config()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("VASEEKKA");
		reporter.config().setDocumentTitle("shuttudu");
		ExtentReports extend=new ExtentReports();
		extend.attachReporter(reporter);
		extend.setSystemInfo("name", "duraisingam");
		return extend;
	}

}
