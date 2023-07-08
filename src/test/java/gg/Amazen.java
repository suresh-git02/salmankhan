package gg;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazen {

	
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Accessories')]")).click();
		driver.findElement(By.linkText("Anti Radiation Stickers & Chips")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Most gifted')]/../a/span")).click();
		String ag=driver.findElement(By.xpath("//span[text()='Amazon Gift Ideas']")).getText();
		System.out.println(ag);
	}
}
