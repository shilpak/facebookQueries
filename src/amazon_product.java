import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class amazon_product {
	
	@Test
	public void product_Search_on_Amazon() throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("disable-notifications");
		options.addArguments("disable-geolocation");
		//options.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("http://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop"+Keys.ENTER);
		System.out.println(driver.getTitle());
		List<WebElement>productsName=(driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")));
		System.out.println(productsName.size());
		List<WebElement>productPrices=(driver.findElements(By.xpath("//span[contains(text(),laptop_name)]/following::span[@data-a-color='price']/child::span/child::span[@class='a-price-whole']")));
		System.out.println(productPrices.size());
		//Assert.assertEquals(productsName.size(), productPrices.size());
		
		HashMap<String, String> namePriceDetails = new HashMap<>();
	    for (int i = 0; i < productsName.size(); i++)
	    {
	    	namePriceDetails.put(productsName.get(i).getText(), productPrices.get(i).getText().replaceAll("[^0-9]", ""));
	    }
	    for(Map.Entry<String, String> entry : namePriceDetails.entrySet()) {
	    	System.out.println("Laptop name: " + entry.getKey() + " = Laptop Price: " + entry.getValue());
	    }
	    
	}
	

}
