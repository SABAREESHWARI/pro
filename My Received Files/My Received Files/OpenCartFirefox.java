package FireFox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenCartFirefox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.bin",
				"C:/Users/sarulr/AppData/Local/Mozilla Firefox/firefox.exe");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "10.219.96.26");
        profile.setPreference("network.proxy.http_port", 8080);
        profile.setPreference("network.proxy.ssl", "10.219.96.26");
        profile.setPreference("network.proxy.ssl_port", 8080);
        
        FirefoxDriver driver = new FirefoxDriver(profile);
		//driver.get("file:///D:/Users/chenitha/Desktop/Recipe_class_registration.html");
        driver.get("https://demo.opencart.com/");
        System.out.println("Web page has been loaded");
        
        //Verifying page title
        String title="Your Store";
        
        //Waiting till entire page load
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        System.out.println("Entire page has been Loaded");
        //Getting title of page
        String verifyTitle=driver.getTitle();
      
        if(title.equals(verifyTitle))
        		System.out.println("Title is same");
        else
        		System.out.println("Title is not same");

        //Verifying no.of links
    	List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No. of links in home page are "+links.size());
 
		//Clicking  My account in home page
		driver.findElement(By.linkText("My Account")).click();
		
		//Selecting register from My account
		driver.findElement(By.partialLinkText("Reg")).click();
		
		//Filling all mandatory fields in Registration Page
		driver.findElement(By.id("input-firstname")).sendKeys("Sarulatha");
		driver.findElement(By.id("input-lastname")).sendKeys("Rajendran");
		
		//Verifying fields are left empty or not
		boolean fname=driver.findElement(By.id("input-firstname")).getSize()==null;
		if(fname==true)
			System.out.println("First Name must be between 1 and 32 characters!");
		boolean lname=driver.findElement(By.id("input-lastname"))==null;
		if(lname==true)
			System.out.println("Last Name must be between 1 and 32 characters!");
		
		//entering email
		WebElement str=driver.findElement(By.name("email"));
		str.sendKeys("saurbakas@gmail.com");
		
		//Validating email
		String  email=str.getText();
		String pattern="[@.]";
		if(email.matches(pattern))
			System.out.println("Email is valid one");
		else
			System.out.println("Invalid email");
		
		//entering mobile number
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("8974563258");
		
		//validating mobile number
		WebElement mobilenum=driver.findElement(By.xpath("//input[@type='tel']"));
		String mobileno=mobilenum.getText();
		String regexStr = "^[0-9]{10}$";
		
		if(mobileno.matches(regexStr))
				System.out.println("Mobile number is valid");
		else
				System.out.println("Mobile number is invalid");
		
		//entering password
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("sararuja");
		driver.findElement(By.cssSelector("input[name='confirm']")).sendKeys("sararuja");
		
		//validating password and confirm password
		WebElement password=driver.findElement(By.cssSelector("input[name='password']"));
		WebElement confirmpass=driver.findElement(By.cssSelector("input[name='confirm']"));
		
		if(password.getText().equals(confirmpass.getText()))
				System.out.println("Password and confirm password fields are matching");
		else
				System.out.println("Password and confirm password fields are not matching");
		
		driver.findElement(By.xpath("html/body/div[2]/div/div/form/fieldset[3]/div/div/label[2]/input")).click();
		
		//Verifying radio button on page
		boolean radio=driver.getPageSource().contains("radio-inline");
		System.out.println("Radio buttion is "+radio);
		
	
		//Agreeing to policy
		driver.findElement(By.cssSelector("input[name='agree']")).click();
		
		//Clicking continue button
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		Thread.sleep(1500);
		
		//Waiting till page loads
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Verifying title
		String regTitle=driver.getTitle();
		boolean regTitleBool=regTitle.equals("Your Account has been created");
		
		//Clicking Phones & PDA's
		driver.findElement(By.linkText("Phones & PDAs")).click();
		Thread.sleep(1500);
		//Clicking HTC Touch HD
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[2]/div[1]/h4/a")).click();;
		Thread.sleep(2000);
		
		//navigating back to previous page
		driver.navigate().back();
		
		//Adding HTC Touch HD to cart
		driver.findElement(By.cssSelector("#content > div:nth-child(3) > div:nth-child(1) > div > div:nth-child(2) > div.button-group > button:nth-child(1)")).click();
		Thread.sleep(1500);
		
		//Verifying successful or not
		boolean success=driver.getPageSource().contains("Success: You have added HTC Touch HD to your shopping cart!");
		if(success==true)
			System.out.println("Page displays the success mesaage: "+success);
		else
			System.out.println("Page displays failure message: "+success);
		
		//Clicking brand from bottom of page
//		driver.findElement(By.partialLinkText("Brand")).click();
		WebElement elementBrand=driver.findElement(By.linkText("Brands"));
		elementBrand.click();
		
		//Verifying title
		String brandTitle=driver.getTitle();
		String actualTitle="Find Your Favourite Brand";
		System.out.println("Checking title : Find Your Favourite Brand is equal "+brandTitle.equals(actualTitle));
		
		//Clicking c canon
		WebElement element=driver.findElement(By.partialLinkText("Canon"));
		element.click();
		
		//verifying title
		String canonTitle=driver.getTitle();
		String actTitle="Canon";
		System.out.println("Checking title : Canon title "+canonTitle.equals(actTitle));
		
	}

}
