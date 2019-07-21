
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.openqa.selenium.chrome.ChromeDriver;

public class SikuliTest {

	public static void main(String[] args) throws FindFailed {

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		String filepath = "C:\\Users\\Shilpa\\Desktop\\";
		String inputFilePath = "C:\\Users\\Shilpa\\Desktop\\";
		
		Screen s = new Screen();
		Pattern fileInputTextBox = new Pattern(filepath + "FileTextBox.PNG");
        Pattern openButton = new Pattern(filepath + "OpenButton.PNG");
        WebDriver driver;

        // Open Chrome browser    
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/image_upload/index.php");

        // Click on Browse button and handle windows pop up using Sikuli
        driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilePath + "Tests.docx");
        s.click(openButton);

        // Close the browser C:\Users\Shilpa\AppData\Local\Android\Sdk
        //driver.close();
		
	}

}
