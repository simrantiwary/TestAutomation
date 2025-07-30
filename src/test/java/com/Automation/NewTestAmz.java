package com.Automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class NewTestAmz {
	
	WebDriver driver;

  @Test
  public void test1() throws InterruptedException {

	  //Searching for products by giving inputs
	  
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple Watch");
		Thread.sleep(3000);
		
		ArrayList<WebElement> suggestedElements = new ArrayList<WebElement>(driver.findElements(By.className("s-suggestion-container")));
		
		System.out.println("No of elements in search suggestion box = " +suggestedElements.size());
		
		
		for(WebElement element :suggestedElements )
		{
			System.out.println("Suggested elements are:" +element.getText());
		}
		
		Thread.sleep(3000);
		
		System.out.println("------------------------------------------------------------------------------");
		
		System.out.println("10th Product is:" +suggestedElements.get(9).getText());

		
		Select SearchDropDown = new Select(driver.findElement(By.id("searchDropdownBox")));
		SearchDropDown.selectByVisibleText("Electronics");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> SearchedResultELements = new ArrayList<WebElement>(driver.findElements(By.className("s-title-instructions-style")));
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println("No of all products are :--" +SearchedResultELements.size());
		
		for(WebElement allProduct : SearchedResultELements)
		{
			System.out.println("all products are:--" +allProduct.getText());
		}
		
		System.out.println("10th product from the searched items results are :- " +SearchedResultELements.get(9).getText());
		
  }
  
  @Test
	public void test2() throws InterruptedException
	{
		WebElement elementNavigation = driver.findElement(By.className("s-pagination-strip"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementNavigation);
		Thread.sleep(3000); 

		WebElement nextButton = driver.findElement(By.xpath("//span[@class='a-list-item']/a[text()='Next']"));
		
		if(!(elementNavigation.isDisplayed()))
		{
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementNavigation);
			Thread.sleep(3000); 
			
			System.out.println("Next Button is here");
			
		}
			
		
		while((nextButton.isEnabled()))
		{
		
		nextButton.click();
		
		Thread.sleep(3000);
		
		System.out.println("hiiiiiiiiiii nexttt");
		}
		
		System.out.println("i am nexttt");
	}

  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  
	  driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);

  }

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
