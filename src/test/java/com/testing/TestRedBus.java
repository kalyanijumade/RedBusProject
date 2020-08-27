package com.testing;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.base.TestBase;

public class TestRedBus extends TestBase {


	@Test
	public void browserInvoke() throws IOException, InterruptedException {
			
		// browser lunched
		driver.get(pro.getProperty("URL"));
			
		// Click on the Bus tickets tab
		driver.findElement(By.linkText("BUS TICKETS")).click();
		
		String fromCity = "Nagpur";
		String toCity = "Pune";
		
		// After landing to page will input data into From field 
		driver.findElement(By.xpath("//*[@id=\"txtSource\"]")).sendKeys(fromCity);
		List<WebElement> fromLocationList = driver.findElements(By.cssSelector("ul[id=\"C120_suggestion-wrap\"] li"));
		for(WebElement fl : fromLocationList)
		{
			String locationName = fromCity +" (All Locations)";
			if(fl.getText().equalsIgnoreCase(locationName)) {
				fl.click();
				break;
			}
		
		}
		
		// Input data in To Field
		driver.findElement(By.xpath("//*[@id=\"txtDestination\"]")).sendKeys(toCity);
		List<WebElement> toLocationList = driver.findElements(By.cssSelector("ul[id=\"C120_suggestion-wrap\"] li"));
		for(WebElement tl : toLocationList)
		{
			String locationName = toCity +" (All Locations)";
			if(tl.getText().equalsIgnoreCase(locationName)) {
				tl.click();
				break;
			}
		
		}
		
		
		//Date to be set in text box 
        String dateTime ="31-Aug-2020";
        driver.findElement(By.xpath("//*[@id=\"txtOnwardCalendar\"]")).sendKeys(dateTime);

	
		// Click on Search
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button")).click();
		
	}
}
