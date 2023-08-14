package com.Sampleselenium.TestCase;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

			public class StaticTable {
				
				WebDriver driver;
				@Test
				public void rowCount() 
				{
					WebDriverManager.chromedriver().setup();
				    driver = new ChromeDriver();
				    driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
				    driver.manage().window().maximize();
				    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				    /*List <WebElement> row = driver.findElements(By.xpath("//table[@id='customers']//tbody/tr"));
				    System.out.println("RowCount:" + row.size());
				    List <WebElement> column = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[1]/th"));
				    System.out.println("ColmnCount:" + colmn.size());
				    for(WebElement r:row ) {
				    	System.out.println(r.getText());*/
				    int rows = driver.findElements(By.xpath("//table[@id='customers']//tbody/tr")).size(); 
				    System.out.println("RowCount:" + rows);
				    int colm = driver.findElements(By.xpath("//table[@id='customers']//tbody/tr/th")).size(); 
				    System.out.println("ColmnCount:" + colm);
				    for(int r = 2;r <=rows;r++) {
				    	//System.out.println(c[0].getText());
				    	
				    	for(int c = 1; c<=colm; c++ ) {
				    		//System.out.println(c.getText());
				    		
				    		String data = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr["+r+"]/td["+c+"]")).getText();
				    		System.out.print(data + "           ");
				    	}
				    	System.out.println();
				    }
				    driver.quit();
				    
				}   
				
			
			}
