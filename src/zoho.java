import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zoho {
	
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
    driver.get("https://www.zoho.com");
    driver.findElement(By.xpath("//a[@class='zh-login']")).click();
    driver.findElement(By.xpath("//input[@placeholder='Email / Phone']")).sendKeys("kotharishilpa93@gmail.com");
    driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Selenium1234!");
    
    driver.findElement(By.xpath("//div[@id='signin_submit']")).click();

}
}