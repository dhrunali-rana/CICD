package framework.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchbrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");

		//ChromeDriver driver = new ChromeDriver();
//		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com");

        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        driver.quit();
	}

}
