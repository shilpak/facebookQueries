import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class salesforce {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sangeetakod2@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sangeeta123");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(5);
        driver.findElement(By.xpath("//a[@title='New user']")).click();
        Thread.sleep(5);
        driver.findElement(By.xpath("//input[@name='name_firstName']")).click();
        driver.findElement(By.xpath("//input[@name='name_firstName']")).sendKeys("champ");
        driver.findElement(By.xpath("//input[@id='name_lastName']")).click();
        driver.findElement(By.xpath("//input[@id='name_lastName']")).sendKeys("champ123");
	}

}
