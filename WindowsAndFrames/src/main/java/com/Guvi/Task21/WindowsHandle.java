package com.Guvi.Task21;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.manage().window().maximize();
		
		String HomeWindow = driver.getWindowHandle();
		
		WebElement Link = driver.findElement(By.partialLinkText("Click"));
		Link.click();
		
		Set <String> Windows = driver.getWindowHandles();
		List <String> ChildWindow = new ArrayList<String>(Windows);
		driver.switchTo().window(ChildWindow.get(1));
		
		WebElement Text = driver.findElement(By.xpath("//div[@class = 'example']"));
		String ActualText = Text.getText();
		
		String ExpectedText = "New Window";
		
		if(ActualText.contentEquals(ExpectedText))
		{
			System.out.println("Child Windows has Correct Text");
		}
		else
		{
			System.out.println("Child Windows has Wrong Text");
		}

		driver.close();
		
		driver.switchTo().window(ChildWindow.get(0));
		
		String ExpHomeTitle = "The Internet";
		
		String ActHomeTitle = driver.getTitle();
		
		if(ExpHomeTitle.contentEquals(ActHomeTitle))
		{
			System.out.println("Original Window is Active");
		}else
		{
			System.out.println("Original Window is not Active");
		}
		
		driver.quit();
	}

}
