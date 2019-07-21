import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlinks {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		String homePage = "http://www.zlti.com";
		String url = "";
		HttpURLConnection huc = null;
		int responseCode = 200;
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(homePage);
		List <WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement>it = links.iterator();
		while(it.hasNext()) {
			
			url = it.next().getAttribute("href");
			System.out.println(url);
			
			if(url == null || url.isEmpty()) {
				System.out.println("URL belongs to another domain");
				continue;
			}
			
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
            	huc = (HttpURLConnection) (new URL(url).openConnection());
            	huc.setRequestMethod("Head");
            	huc.connect();
            	responseCode = huc.getResponseCode();
            	
            	if(responseCode >= 400){
                    System.out.println(url+" is a broken link");
            	}else {
            		System.out.println(url+" is a valid link");
            		}
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		
		
	}

}
