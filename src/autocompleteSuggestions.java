import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autocompleteSuggestions {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		WebElement element = driver.switchTo().activeElement();
		element.sendKeys("Selenium");
		List<WebElement> lstGoogle = driver.findElement(By.xpath("//ul[@role='listbox']"))
				.findElements(By.xpath("//li[@role='presentation']"));
		System.out.println(lstGoogle.size());
		for(WebElement option : lstGoogle) {
			if(option.getText().equals("selenium interview questions")) {
				option.click();
				break;
			}

		}

	}

}








