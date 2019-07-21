import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handlingDynamicImages {
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://www.provogue.com/new-arrivals");
		
		 Actions actions = new Actions(driver);
	     WebElement productImage = driver.findElement(By.xpath("//div[@class='category-products']/ul[1]/li[2]/div[2]/a[@class='product-image']"));
	     actions.moveToElement(productImage).perform();
	     WebElement ViewLink = driver.findElement(By.xpath("//div[@class='category-products']/ul[1]/li[2]/div[2]/a[@class='fancybox']"));
	     actions.moveToElement(ViewLink);
	     actions.click();
	     actions.perform();
	     //wait for the iframe to load and then switch to it

	     WebDriverWait wait = new WebDriverWait(driver, 30000);
	     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By
	                     .className("fancybox-iframe"))));

	     //select size and then

	     //click on Add to cart button

	     driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();

	     //switch back to default content

	         driver.switchTo().defaultContent();
	}
		
	}


