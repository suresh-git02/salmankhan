package gg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium {

	
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		driver.findElement(By.xpath("//span[text()='Search']")).click();

		driver.findElement(By.className("DocSearch-Input")).sendKeys(Keys.SHIFT,"webdriver");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]/div[1]/div[2]/span[1]")).click();
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
Thread.sleep(2000);
		WebElement ag = driver.findElement(By.xpath("//a[text()='Actions API']"));
		System.out.println(ag.getCssValue("color"));
		System.out.println(ag.getCssValue("font"));
		System.out.println(ag.getRect().getX());
		System.out.println(ag.getRect().getY());
		System.out.println(ag.getLocation());
		System.out.println(ag.getSize());
		System.out.println(ag.getTagName());
		System.out.println(ag.getText());
		
		 TakesScreenshot ts=(TakesScreenshot)driver;
		  File src =ts.getScreenshotAs(OutputType.FILE);
		  File trg=new File("./tapu/selinum.png");
		  FileUtils.copyFile(src, trg);


	}
}
