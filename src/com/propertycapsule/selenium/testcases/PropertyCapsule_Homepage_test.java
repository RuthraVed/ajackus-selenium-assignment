package com.propertycapsule.selenium.testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.propertycapsule.selenium.pom_pkg.PropertyCapsule_Homepage;

public class PropertyCapsule_Homepage_test {
	WebDriver driver;

	
	@BeforeMethod
	@Parameters({ "browserName", "url" })
	public void setup(String browser, String url1) {
		String basePath = "/home/ruthra/Selenium_Setup/";
		System.setProperty("webdriver.chrome.driver",basePath+"chromedriver");
		driver = new ChromeDriver();
		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@AfterMethod
	public void tearup() {
		driver.quit();
	}
	

	@Test(enabled = true)
	public void verifylogoIsVisible() {
		PropertyCapsule_Homepage p = new PropertyCapsule_Homepage(driver);
		boolean actual = p.logoIsVisible();
		boolean expected = true;
		Assert.assertEquals(actual, expected);

	}
	
	@Test(enabled = true)
	public void verifymarketingAutomationTabRedirection() throws InterruptedException {
		PropertyCapsule_Homepage p = new PropertyCapsule_Homepage(driver);
		boolean actual = p.marketingAutomationTabRedirection("https://www.propertycapsule.com/");
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled = true)
	public void verifymapMakerTabRedirection() {
		PropertyCapsule_Homepage p = new PropertyCapsule_Homepage(driver);
		boolean actual = p.mapMakerTabRedirection("https://maps.propertycapsule.com/");
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled = true)
	public void verifytourbooksTabRedirection() throws InterruptedException {
		PropertyCapsule_Homepage p = new PropertyCapsule_Homepage(driver);
		boolean actual = p.tourbooksTabRedirection("https://tours.propertycapsule.com/");
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled = true)
	public void verifyenterpriseAdminLoginRedirection() throws InterruptedException {
		PropertyCapsule_Homepage p = new PropertyCapsule_Homepage(driver);
		boolean actual = p.enterpriseAdminLoginRedirection("https://propertycapsule.com/property/admin/login/form");
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled = true)
	public void verifydealMakerLoginRedirection() throws InterruptedException {
		PropertyCapsule_Homepage p = new PropertyCapsule_Homepage(driver);
		boolean actual = p.dealMakerLoginRedirection("https://maps.propertycapsule.com/map/sign-up");
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled  = true)
	public void verifyrequestDemoHyperlinkRedirection() throws InterruptedException {
		PropertyCapsule_Homepage p = new PropertyCapsule_Homepage(driver);
		boolean actual = p.requestDemoHyperlinkRedirection();
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled = true)
	public void verifyfindOutMoreHyperlinkRedirection() throws InterruptedException {
		PropertyCapsule_Homepage p = new PropertyCapsule_Homepage(driver);
		boolean actual = p.findOutMoreHyperlinkRedirection("https://www.vts.com/propertycapsule");
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}

}
