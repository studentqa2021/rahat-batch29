package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicLogin {

	public void getLogin() {
		
		WebDriver driver =DriverManager.getBrowser("chrome");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
		//URL
		driver.navigate().to(Constants.URL);
		ScreenShot.getScreenShot(driver,"HomePage");
		//sign in
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0), 3);
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		//wait.until(ExpectedConditions.elementToBeClickable(pf.getSigninBtn().get(0)));
		//sign in click btn
		HighLighter.getColor(driver,pf.getSigninBtn().get(0));
		pf.getSigninBtn().get(0).click();
		//user
		HighLighter.getColor(driver, pf.getEmail());
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		//pass
		HighLighter.getColor(driver,pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);
		//second sign in 
		HighLighter.getColor(driver, pf.getSecondSigninBtn());
		pf.getSecondSigninBtn().click();
		ScreenShot.getScreenShot(driver, "Login Validation");
		//validation 
		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false
		
		sa.assertAll();//validation
		
		
	}
 

}

