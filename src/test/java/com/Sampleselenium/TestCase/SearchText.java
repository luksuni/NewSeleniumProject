package com.Sampleselenium.TestCase;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class SearchText extends BaseClass{
		
		@Test
		public void enterText()
		{
			//driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement element = driver.findElement(By.xpath("//*[@id='APjFqb']"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].value= 'seleniumtutorial'", element);
			logger.info("successfull search");
			
			//element.sendKeys("selenium");		
				}
	@Test
	public void compareTitle() 
	{
		//driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String pagetitle = driver.getTitle();
		System.out.println("Page Title:" + pagetitle);
		String ActTitle = "Google";
		Assert.assertEquals(pagetitle, ActTitle);
		System.out.println("Test Completed");
		
	}
	}
