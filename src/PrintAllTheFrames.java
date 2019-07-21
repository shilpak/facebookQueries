import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PrintAllTheFrames {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.hdfcbank.com/");
		List<WebElement>framelist = driver.findElements(By.tagName("iframe"));
		System.out.println(framelist.size());
		//to get all the frame or frame id
		for(WebElement singleFrame : framelist) {
			System.out.println(singleFrame.getAttribute("id"));
			System.out.println(singleFrame.getAttribute("name"));
		}

	}
}