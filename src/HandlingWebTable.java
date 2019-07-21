import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWebTable {
	
	static WebDriver driver;

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("C:/Users/Shilpa/Desktop/webtable.html");
		
		List <WebElement> allHeadersOfTable = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));
		System.out.println("Total headers found: "+allHeadersOfTable.size());
		for(WebElement header : allHeadersOfTable) {
			System.out.println(header.getText());
		}
		System.out.println("=====================================================================");
		
		//find the number of rows in the table
		List <WebElement>allRows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		System.out.println(allRows.size()-1);
		System.out.println("=====================================================================");
		
		//find the number of column in each rows /html/body/table/tbody/tr[2]/td[1]
		for(int i = 2; i<=allRows.size();i++) {
			List <WebElement> allColInRows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td"));
			System.out.println("Num of column in "+(i-1)+" data row is : "+allColInRows.size());
		}
		List <WebElement> allColInRows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[text()='Mukesh']/../td[1]"));
		for(WebElement e : allColInRows)
		{
			System.out.println(e.getText());
		}
		System.out.println("Books with price greater than and equal to 500 are below:");
		for(int i = 2; i<=allRows.size();i++) {
			List <WebElement> priceColumn = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td[4]"));
			for(WebElement y : priceColumn) {
			if(Integer.parseInt(y.getText())>=1000) {
				WebElement bookName = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[\"+i+\"]/td[1]"));
				System.out.println(bookName.getText());
			}
			}
			
		}
	}

}
