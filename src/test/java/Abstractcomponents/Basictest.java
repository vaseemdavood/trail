package Abstractcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageobjects.Landingpage;

public class Basictest {
	public WebDriver driver;
	public Landingpage landing;

	public WebDriver initialisedriver()  {

		Properties prop = new Properties();
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(
					"C:\\Users\\maccell\\eclipse-workspace\\SeleniumFrameworkdesign\\src\\test\\java\\Abstractcomponents\\Globaldata.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //System.getProperty("browser")!=null? System.getProperty("browser"): 
		String browsername = System.getProperty("browser")!=null? System.getProperty("browser"): prop.getProperty("browser");
		//String browsername=prop.getProperty("browser");
		if (browsername.contains("chrome")) {
			ChromeOptions option=new ChromeOptions();
			if(browsername.contains("headless"))
			{
			option.addArguments("headless");
			}
			WebDriver driver = new ChromeDriver(option);
			driver.manage().window().setSize(new Dimension(1440, 900));
			this.driver=driver;
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriver driver= new FirefoxDriver();
			this.driver=driver;
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriver driver=new EdgeDriver();
		}
			
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(4));
			Actions a = new Actions(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	//{map, map}

	}
	
	
	
	
	public String getscreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";

	}
	
	

	 
	
	
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchapplication() throws IOException {
		driver = initialisedriver();
		landing = new Landingpage(driver);
		landing.gotos();
		return landing;

	}

	@AfterMethod(alwaysRun=true)
	public void teardown() {
		if (driver != null) {
	        driver.close();
	    }
	}

}
