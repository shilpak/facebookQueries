import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class pickdate {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		try {
			entertext();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void entertext() throws InterruptedException, TestException {
		//To handle unexpected alert on page load.
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.alertIsPresent());

			try{   
				driver.switchTo().alert().dismiss(); 
				driver.findElement(By.xpath("//input[@id='fromCity']")).click();
				driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Atl");		

				List<WebElement> autosearchList = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
				autosearchList.get(0).click();
			}catch(Exception e){ 
				System.out.println("unexpected alert not present");   
			}

		}finally {
			System.out.println("timeout"); 
		}
	}




}


//driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Mumbai");

//img id=second-img
//driver.switchTo().alert().accept();
//WebDriverWait(driver).until(ExpectedConditions.alertIsPresent())