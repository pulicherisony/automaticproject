package com.simplilearn.selenium;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonFinalProject{
 
	 public static void main(String[] args) {
	        //  Open the browser
			ChromeDriver driver = new ChromeDriver();
			
			//  Maximize it
			driver.manage().window().maximize();
			
			//	Navigate to url
			driver.get("https://www.amazon.in/");
			
			//	Click on ‘Mobiles’ in the navigation bar
			driver.findElement(By.linkText("Mobiles")).click();
			
			//	Hover the pointer over ‘Mobiles & Accessories’
			WebElement mobiles = driver.findElement(By.xpath("(//span[contains(@class,'nav-a-content')])[2]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(mobiles).build().perform();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'nav-a-content')])[2]")));
			
			//	Click on ‘Apple’ in the sub-menu
			driver.findElement(By.linkText("Apple")).click();
			
			//	Click on first available item.
			driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base a-text-normal')])[1]")).click();
			
			//	Switch focus on new tab
			ArrayList<String> newtab = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(newtab.get(1));
			
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("buy-now-button")));
			
			//	Click on ‘Buy Now’ button
			driver.findElement(By.id("buy-now-button")).click();
			
			//	Verify user sees the text ‘Sign in’ on the last page.
			String expectedText = "Sign in";
			
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'a-spacing-small')]")));
			
			String actualText = driver.findElement(By.xpath("//h1[contains(@class,'a-spacing-small')]")).getText();
			
			if(actualText.equals(expectedText)) {
				System.out.println("Test case passed");
			}
			else {
				System.out.println("Test case failed");
			}
			
			// Close the browser.
			driver.quit();

	}
}

