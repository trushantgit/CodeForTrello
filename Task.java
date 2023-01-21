package trushant;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Task {
	
    @Test
	public void Task() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\download\\software\\New folder\\chromedriver_win32(3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trello.com/en/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement user = driver.findElement(By.id("user"));
		user.sendKeys("trushantsolat29@gmail.com");
		WebElement continuebutton= driver.findElement(By.id("login"));
		continuebutton.click();
		WebDriverWait wt = new WebDriverWait(driver,30);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Trushant##1234");
	    WebElement submit = driver.findElement(By.id("login-submit"));
		submit.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Create']")).click();
		WebElement createnewboard = driver.findElement(By.xpath("//*[text()='Create new board']"));
		createnewboard.click();
		WebElement boardtitle = driver.findElement(By.xpath("//*[@type='text']"));
		boardtitle.sendKeys("trushanttask");
		WebElement create = driver.findElement(By.xpath("//button[text()='Create']"));
		create.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='list-name-input']")).sendKeys("List A");
		WebElement addlist = driver.findElement(By.xpath("//input[@type='submit']"));
		addlist.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("List B");
		WebElement adlist = driver.findElement(By.xpath("//*[@class='nch-button nch-button--primary mod-list-add-button js-save-edit']"));
		adlist.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@aria-label='Cancel list editing']")).click();
		List<WebElement>addcard = driver.findElements(By.xpath("//*[text()='Add a card']"));
		addcard.get(0).click();
	    WebElement cardname = driver.findElement(By.xpath("//*[@placeholder='Enter a title for this card…']"));
		cardname.sendKeys("Full Creative");
		Actions act = new Actions(driver);
		cardname.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']")).click();
		Thread.sleep(3000);
		WebElement dragcard = driver.findElement(By.xpath("//*[@class='list-card-details js-card-details']"));
		WebElement drop = driver.findElement(By.xpath("//textarea[text()='List B']"));
		WebElement location = driver.findElement(By.xpath("//*[@class='list-card js-member-droppable ui-droppable']"));
		act.dragAndDrop(dragcard, drop).build().perform();
		Point p = location.getLocation();
		System.out.println("x point of dragcard is "+p.getX());
		System.out.println("y point of dragcard is "+p.getY());
		WebElement account = driver.findElement(By.xpath("//div[@title='Trushant solat (trushantsolat29)']"));
		account.click();
		WebElement logout = driver.findElement(By.xpath("//*[@data-testid='account-menu-logout']"));
		logout.click();
		
	}

}
