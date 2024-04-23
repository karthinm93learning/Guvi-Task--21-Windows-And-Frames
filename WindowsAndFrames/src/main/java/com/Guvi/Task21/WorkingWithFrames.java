package com.Guvi.Task21;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithFrames {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // Maximize the Screen
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.switchTo().frame(0); //Switching to frame with Index
		
		List <WebElement> count = driver.findElements(By.tagName("frame"));
		int framecount = count.size(); //Finding Total Count on Top Frames 
		
		System.out.println("Top Frame Count : "+framecount);
		
		driver.switchTo().frame(0);
		WebElement textLeft = driver.findElement(By.xpath("/html/body"));
		String text = textLeft.getText();
		System.out.println("Text in the Left Frame is: "+text);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(1);
		WebElement textMiddle = driver.findElement(By.xpath("//div[@id = 'content']"));
		String text1 = textMiddle.getText();
		System.out.println("Text in the Middle Frame is: "+text1);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(2);
		WebElement textRight = driver.findElement(By.xpath("/html/body"));
		String text2 = textRight.getText();
		System.out.println("Text in the Right Frame is: "+text2);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame-bottom");
		WebElement textBottom = driver.findElement(By.xpath("/html/body"));
		String text3 = textBottom.getText();
		System.out.println("Text in the Bottom Frame is: "+text3);
		
		driver.switchTo().defaultContent(); //Switching out of the frames
				
		driver.quit();
		
	}

}
