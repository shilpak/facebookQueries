import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipWithActionsClass {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/tooltip.html");
        
        String expectedTooltip = "What's new in 3.2";
	
        WebElement downloadButton = driver.findElement(By.cssSelector("#download_now"));
        
        Actions builder = new Actions(driver);
        
        builder.clickAndHold().moveToElement(downloadButton).build().perform();
        
        WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));
        
        String actualTooltip = toolTipElement.getText();
        
        System.out.println("Actual Title of Tool Tip  "+actualTooltip);							
        if(actualTooltip.equals(expectedTooltip)) {							
            System.out.println("Test Case Passed");					
        }
        
	}
	

}
