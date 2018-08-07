package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CookingRecipie {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.ANY);
		capability.setVersion("44.0");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://10.51.91.73:4444/wd/hub"),capability);
		// new RemoteWebDriver(new
		try {
			driver.get("http://demo.opencart.com");
		} catch (Exception ex) {
			System.out.println("Hello");
		}

		
		driver.navigate().to("http://demo.opencart.com/");
		// Maximizing the Window
		driver.manage().window().maximize();
	}

}
