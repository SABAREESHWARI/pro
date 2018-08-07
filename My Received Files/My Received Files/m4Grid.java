package Selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class m4Grid {

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D:/saipreetha/M4/chromedriver.exe");
		
		   
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName("chrome");
		capabilities.setCapability("webdriver.chromedriver.driver", "D:/saipreetha/M4/chromedriver.exe");
		

		
		capabilities.setPlatform(Platform.WINDOWS);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:6666/wd/hub"), capabilities);
try {
	//Launch the application browser
    driver.get("http://demo.opencart.com/");
    System.out.println("The application browser is launched");
    
    //Verify the title
    String title="Your Store";
    if(title.equals(driver.getTitle())){
    	System.out.println("The title of the page is verified successfully");
    }
    else{
    	System.out.println("The title of the page is not verified");
    }
    
    //wait for complete page gets load
    System.out.println("It is waiting for complete page to gets load");
    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    
    //Verify the number of links available on the home page
    int link=driver.findElements(By.tagName("a")).size();
    System.out.println("The number of links available on the home page is:"+link);
    if(link==driver.findElements(By.tagName("a")).size()){
    	System.out.println("The number of links available on the home page is verified successfully");
    }
    else{
    	System.out.println("The number of links available on the home page is not verified");
    }
    
    //click on 'My Account' link in main menu
    driver.findElement(By.partialLinkText("My Account")).click();
    System.out.println("Clicked on the My Account link in main menu");
    
    //Select 'Register' option
    driver.findElement(By.linkText("Register")).click();
    System.out.println("Clicked on the Register link ");
    
    //filling all mandatory fields
    System.out.println("Filling all the mandatory fields like First Name,Last Name,E-mail,Telephone,password,password Confirm");
    driver.findElement(By.id("input-firstname")).sendKeys("Sai Preetha");
    System.out.println("First name is entered");
    driver.findElement(By.name("lastname")).sendKeys("E");
    System.out.println("Last name is entered");
    
    //Verify appropriate error message for the mandatory fields
    System.out.println("Checking for error message");
    //driver.findElement(By.xpath("//input[@id='content']/form/div/div/input[2]")).click();
    
    
    //Validate if the email is in correct form
    String email="saikreha@gmail.com";
    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
    System.out.println("E-mail id is entered");
    if(email.contains("@gmail.com")){
    	System.out.println("Email is validated");
    }
    else{
    	System.out.println("Email id is wrong");
    }
    
    //Validate the telephone field
    String phone="8956423147";
    driver.findElement(By.cssSelector("input[id='input-telephone']")).sendKeys(phone);
    System.out.println("Telephone number is entered");
    if(phone.length()==10){
    	System.out.println("Telephone is validated");
    }
    else{
    	System.out.println("Telephone is not validated");
    }
    
    //Validate that the 'password' and 'password confirm' fields are matching
    String password="saipreethae89";
    driver.findElement(By.name("password")).sendKeys(password);
    System.out.println("Password is entered");
    String passwordConfirm="saipreethae89";
    driver.findElement(By.id("input-confirm")).sendKeys(passwordConfirm);
    System.out.println("Password is reentered");
    
    if(passwordConfirm.equals(password)){
    	System.out.println("Passwords are matching");
    }
    else{
    	System.out.println("Passwords are not matching");
    }
    
    //Verify subscribe radio button present on page
    if(driver.getPageSource().contains("Subscribe")){
    System.out.println("Susbscribe radio button is present");	
    }
    else{
    	System.out.println("Susbscribe radio button is not present");
    }
    System.out.println("newsletter is subscribed");
    //Clicking on the checkbox
    driver.findElement(By.name("agree")).click();
    System.out.println("Clicked on agree button");
		
   		 //click the continue button
	     driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		   
		   //wait for page load
		     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); 

		     //verify heading 
		    System.out.println(driver.getTitle());
	    	boolean titlepage=driver.getTitle().contains("Your Account Has Been Created");
	        System.out.println("Heading is verified"+titlepage);
	        
	        //click phones & PDAs
	        driver.findElement(By.linkText("Phones & PDAs")).click();
	        System.out.println("Phones & PDAs link is clicked");
	        
	        //click htc touch hd
	        driver.findElement(By.linkText("HTC Touch HD")).click();
	        System.out.println("HTC Touch HD link is clicked");
	        
	        //verify page htc touch pad
	        System.out.println(driver.getTitle());
	    	boolean htcpage=driver.getTitle().contains("HTC Touch HD");
	        System.out.println("Title is Verified:"+htcpage);
	    	
	        //click back button on the browser
	        driver.navigate().back();
	       System.out.println("back button of the browser is clicked");
	    	
	        //click add to cart
	        driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/div/div[2]/div[2]/button[1]")).click();
	        System.out.println("Add to cart is clicked");
	        
	        
	        //verify the message
	    	 
		      if(driver.getPageSource().contains("Success: You have added HTC Touch HD to your shopping cart!"))
		    	  System.out.println("The text Success: You have added HTC Touch HD to your shopping cart! is present in it ");
		      else
		    	  System.out.println("text not present");
		    
		      //click on Brand under extras
		        driver.findElement(By.linkText("Brands")).click();
		        System.out.println("click brands under the extras");
		      
		        //verify page title
		        System.out.println(driver.getTitle());
		    	boolean page=driver.getTitle().contains("Find Your Favorite Brand");
		        System.out.println(page);
		        
		        //click canon
		        driver.findElement(By.linkText("Canon")).click();
		        
		        //verify heading
		        System.out.println(driver.getTitle());
		    	boolean heading=driver.getTitle().contains("Canon");
		        System.out.println(heading);
		        
		        //click add to wish list
		        driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/div/div[2]/div[2]/button[2]")).click();
		        System.out.println("Add to Wish list is clicked");
		        
		        //verify message
		        boolean message=driver.getPageSource().contains("Success: You have added Canon EOS 5D to your wish list!");
			    System.out.println("The text  Success: You have added Canon EOS 5D to your wish list is present.");
			    System.out.println(message);
			    Thread.sleep(3000);
			   
			    //click wishlist under my accounts
			        driver.findElement(By.linkText("Wish List")).click();
			    
			      //verify the page title
			        System.out.println(driver.getTitle());
			        boolean pagetitle=driver.getTitle().contains("My Wish List"); 
			  				        
			        //wait for page to load
			        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); 
			      
			        //close the browser
			        System.out.println("Closing the browser");
			        driver.close();
	}
catch(Exception ex){
	System.out.println("It throws error");
}

	}
}

