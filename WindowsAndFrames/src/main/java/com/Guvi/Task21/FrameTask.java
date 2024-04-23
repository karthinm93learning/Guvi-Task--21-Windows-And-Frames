package com.Guvi.Task21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTask {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // Maximize the Screen
		
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		driver.switchTo().frame(0); //Switching to frame with Index
		
		WebElement textArea = driver.findElement(By.tagName("p")); // Finding element using tag
		textArea.clear(); // Clearing existing text
		textArea.sendKeys("Hello People"); //Adding new texts
						
		driver.quit(); // Closing the browser
	}

}
