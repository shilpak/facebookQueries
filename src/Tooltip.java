import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tooltip {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/social-icon.html");
        
        String expectedTooltip = "Github";
        WebElement github = driver.findElement(By.xpath("//a[@class='github']"));
        String actualTooltip = github.getAttribute("title");
        
        System.out.println("Actual Title of Tool Tip "+actualTooltip);							
        if(actualTooltip.equals(expectedTooltip)) {							
            System.out.println("Test Case Passed");					
        }	
        
	}

}
