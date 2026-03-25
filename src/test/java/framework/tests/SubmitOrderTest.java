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

public class SubmitOrderTest extends BaseTest{
		
		@Test
		public void submitorder() throws IOException, InterruptedException {
		
			String productName = "ZARA COAT 3";
			LandingPage landingPage = launchApplication();
			ProductCatalog productcatalog = landingPage.logingApplication ("dhrunalirana1@gmail.com","Dhrunali@12345"); //login with credentials
			
			//2. Get all products from the product list on page and wait for a duration for getting product
			//ProductCatalog productcatalog = new ProductCatalog(driver);
			List<WebElement> products = productcatalog.getProductList();
			
			//added product into cart
			productcatalog.addProductToCart(productName);
			
			//go to cart page
			CartPage cartPage = productcatalog.goToCartPag();
			
			//done checkout		
			Boolean match = cartPage.verifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = cartPage.goTocheckout();
			
			//select country from checkout page
			checkoutPage.selectCountry("India");
			ConfirmationPage confirmationpage = checkoutPage.submitOrder();
	
			//Verification for confirmation for order placed 
			String confirmMessage = confirmationpage.getConfirmMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	
	
	}
}
