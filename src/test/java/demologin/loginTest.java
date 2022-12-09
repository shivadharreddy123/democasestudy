package demologin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginTest {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  //WebDriverMnanager.chromedriver().setup();
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training1\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://demowebshop.tricentis.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }
  @Test
  public void verifyLogin() {
	  WebElement loginbtn = driver.findElement(By.linkText("Log in"));
	  loginbtn.click();
	 // driver.findElement(By.linkText("Log in")).click();
	  driver.findElement(By.id("Email")).sendKeys("email@selinium.test");
	  driver.findElement(By.xpath("//input[@class='password']")).sendKeys("abcd123");
	  driver.findElement(By.xpath("//*[@value='Log in']")).click();
	  WebElement logoutlink = driver.findElement(By.linkText("Log out"));
	  String text = logoutlink.getText();
	  Assert.assertEquals(text,  "Log out");
	  driver.findElement(By.linkText("Apparel & Shoes")).click();
	  driver.findElement(By.linkText("Casual Golf Belt")).click();
	  driver.findElement(By.xpath("//input[@id='small-searchterms']"));//.sendKeys("10");
	  driver.findElement(By.xpath("//input[@id=\"addtocart_40_EnteredQuantity\"]")).click();
	  driver.findElement(By.xpath("//input[@id=\"addtocart_40_EnteredQuantity\"]")).sendKeys("0");
	  driver.findElement(By.xpath("//input[@id='add-to-cart-button-40']")).click();
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//a[@href=\'/cart\']")).click();
	  driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
	  driver.findElement(By.xpath("//button[@class=\'button-1 checkout-button\']")).click();
	  driver.findElement(By.xpath("//input[@onclick=\'Billing.save()\']")).click();
	  driver.findElement(By.xpath("//div[@id=\"shipping-buttons-container\"]/input")).click();
	  driver.findElement(By.xpath("//*[@id=\"shippingoption_0\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
	  driver.findElement(By.xpath("//*[@id=\"paymentmethod_2\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
	  driver.findElement(By.xpath("//*[@id='CardholderName']")).sendKeys("Barbara Gordon");
	  driver.findElement(By.xpath("//*[@id=\"CardNumber\"]")).sendKeys("4485564059489345");
	  driver.findElement(By.xpath("//*[@id=\"ExpireMonth\"]")).sendKeys("04");
	  driver.findElement(By.xpath("//*[@id=\"ExpireYear\"]")).sendKeys("2023");
	  driver.findElement(By.xpath("//*[@id=\"CardCode\"]")).sendKeys("123");
	  driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
	  driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
	  if(driver.getPageSource().contains("Your order has been successfully processed!"));
	    driver.findElement(By.linkText("Log out")).click();
	    driver.close();
	  
	  
	  
	  
	  	  
	  
	 }

}
