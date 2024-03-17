package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"/Users/wenzongxuan/Downloads/chromedriver-mac-arm64/chromedriver");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
		driver.navigate().to("file:///Users/wenzongxuan/Desktop/Deakin/2024%20T1/SIT707/week8/login.html");

		sleep(5);
		
		// Find username element
		//
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("wenzong");
		
		// Find password element
		//
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("wenzong_pass");
		
		// Find DoB
		WebElement dobInput = driver.findElement(By.id("dob"));
        dobInput.clear();
        dobInput.sendKeys("01-01-2000");
        
        String dobValue = dobInput.getAttribute("value");
        System.out.println("DoB Input Value: " + dobValue);
		
		// Find Submit button, and click on button.
		//
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		/*
		 * On successful login, the title of page changes to 'success',
		 * otherwise, 'fail'.
		 */
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		Assert.assertEquals("success", title);
		
		driver.close();
	}
	
	@Test
    public void testLoginFail() {
        System.setProperty("webdriver.chrome.driver", "/Users/wenzongxuan/Downloads/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        try {
        	driver.navigate().to("file:///Users/wenzongxuan/Desktop/Deakin/2024%20T1/SIT707/week8/login.html");
            sleep(2); 

            WebElement usernameInput = driver.findElement(By.id("username"));
            usernameInput.clear();
            usernameInput.sendKeys("wrong_user");

            WebElement passwordInput = driver.findElement(By.id("passwd"));
            passwordInput.clear();
            passwordInput.sendKeys("wrong_password");

            WebElement dobInput = driver.findElement(By.id("dob"));
            dobInput.clear();
            dobInput.sendKeys("01-01-2000");

            WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
            submitButton.click();

            sleep(2); 

            String title = driver.getTitle();
            Assert.assertEquals("fail", title);
        } finally {
            driver.close(); 
        }
    }
}
