package framework.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver inializeDriver() throws IOException {
		
		//properties class
		Properties prop = new Properties();
		FileInputStream fts = new FileInputStream(System.getProperty("user.dir") 
				+ "//src//main//java//framework//resources//GlobalData.properties");
		prop.load(fts);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();		
		
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().create();
			driver = new FirefoxDriver();		
			
		}else if(browserName.equals("edge")){
			WebDriverManager.edgedriver().create();
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver = inializeDriver();
		//1. landing page login scenario
		landingpage = new LandingPage(driver);
		landingpage.goTo();  //call url
		return landingpage;
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
