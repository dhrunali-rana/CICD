package framework.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pageobjects.CartPage;
import framework.pageobjects.CheckoutPage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.LandingPage;
import framework.pageobjects.ProductCatalog;
import framework.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidations extends BaseTest{
		
		@Test
		public void submitorder() throws IOException, InterruptedException {
		
			String productName = "ZARA COAT 3";
			ProductCatalog productcatalog = landingpage.logingApplication ("dhrunalirana2@gmail.com","Dhrunali@12345"); //login with credentials
			Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
			
	
	
	}
}
