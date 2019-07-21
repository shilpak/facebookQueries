
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragDropItem {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Sortable')]")).click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame1);
//		ArrayList<String> obtainedList = new ArrayList<>(); 
//		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='ui-sortable']/li"));
//		for(WebElement web:list){
//			   obtainedList.add(web.getText());
//			}
//		ArrayList<String> sortedList = new ArrayList<>();   
//		for(String s:obtainedList){
//		sortedList.add(s);
//		}
//		Collections.sort(sortedList);
//		//Collections.reverse(sortedList);
//		System.out.println(sortedList);
//		//Assert.assertTrue(sortedList.equals(obtainedList));
		

Actions action = new Actions(driver);
WebElement element = driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
WebElement toElement = driver.findElement(By.xpath("//li[contains(text(),'Item 2')]"));
Action dragdrop = action.clickAndHold(element).moveToElement(toElement).release(toElement).build();
dragdrop.perform();


		
	}

}

