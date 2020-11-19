package com.propertycapsule.selenium.pom_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;



public class PropertyCapsule_Homepage 
{
	private WebDriver driver;

	static Logger logger = Logger.getLogger("PropertyCapsule_Homepage.class"); // For logging execution information using apache logj4

	By logoImage = By.xpath("/html/body/header/div[1]/a/img");
	By marketingAutomationTab = By.id("search-btn");
	By mapMakerTab = By.id("market-btn");
	By tourbooksTab = By.id("manage-btn");
	By enterpriseAdminLoginBtn = By.linkText("Enterprise Admin Login");
	By dealMakerLoginBtn = By.linkText("Deal Maker Signup/Login");
	By findOutMoreHyperlink = By.linkText("Find out more");
	By requestDemoHyperlink = By.linkText("request a demo");
	By seeForYourselfBtn = By.linkText("See for yourself");
	By termsClickableText = By.linkText("Terms of Service ");
	By helpClickableText = By.linkText(" Help");
	By contactUsClickableText = By.linkText(" Contact Us ");
	By firstNameContactForm = By.id("FirstName");
	By lastNameContactForm = By.id("LastName");
	By workEmailContactForm = By.id("Email");
	By validFirstNameErrMsg = By.id("ValidMsgFirstName");
	By validLastNameErrMsg = By.id("ValidMsgLastName");
	By validEmailErrMsg = By.id("ValidMsgEmail");
	By submitBtnContactForm = By.xpath("/html/body/div[3]/div/form/div[11]/span/button");


	public PropertyCapsule_Homepage(WebDriver driver2)
	{
		driver=driver2;
	}

	public boolean elementIsVisible(By elementName) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
		return driver.findElement(elementName).isDisplayed();

	}

	public boolean logoIsVisible() {
		return elementIsVisible(logoImage);
	}


	public boolean marketingAutomationTabIsVisible() {
		return elementIsVisible(marketingAutomationTab);
	}

	public boolean mapMakerTabIsVisible() {
		return elementIsVisible(mapMakerTab);
	}

	public boolean tourbooksTabIsVisible() {
		return elementIsVisible(tourbooksTab);
	}

	public boolean enterpriseAdminLoginVisible() {
		return elementIsVisible(enterpriseAdminLoginBtn);
	}

	public boolean dealMakerLoginVisible() {
		return elementIsVisible(dealMakerLoginBtn);
	}

	public boolean marketingAutomationTabRedirection(String expectedURL) throws InterruptedException {
		BasicConfigurator.configure();
		logger.info("Executing marketingAutomationTabRedirection()...");

		if(marketingAutomationTabIsVisible()) {
			logger.info("Found marketingAutomationTab.");

			driver.findElement(marketingAutomationTab).click();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(marketingAutomationTab));
			String actualURL = driver.getCurrentUrl();
			return expectedURL.equals(actualURL);

		}

		return false;
	}


	public boolean mapMakerTabRedirection(String expectedURL) {
		BasicConfigurator.configure();
		logger.info("Executing mapMakerTabRedirection()...");

		if(mapMakerTabIsVisible()) {
			logger.info("Found mapMakerTab.");

			driver.findElement(mapMakerTab).click();

			Set<String> windowHandles = driver.getWindowHandles();
			logger.info("Number of opened windows: " + windowHandles.size());

			int temp=0;
			//Iterate through all the available windows
			for (String string : windowHandles) {
				driver.switchTo().window(string);
				String newtabURL = driver.getCurrentUrl();

				//check whether the url post switch is the desired page
				if (newtabURL.equals(expectedURL)) {
					temp = 1;
					driver.switchTo().defaultContent();
					break;
				} else {
					temp = 0;
				}
			}
			if (temp == 1) {
				logger.info("Redirection successful.");
				return true;
			}
			else if (temp == 0) {
				logger.info("Redirection unsuccessful.");
				return false;
			}
		}
		return false;
	}


	public boolean tourbooksTabredirection(String expectedURL) {
		BasicConfigurator.configure();
		logger.info("Executing tourbooksTabredirection()...");

		if(mapMakerTabIsVisible()) {
			logger.info("Found tourbooksTab.");

			driver.findElement(tourbooksTab).click();

			Set<String> windowHandles = driver.getWindowHandles();
			logger.info("Number of opened windows: " + windowHandles.size());

			int temp=0;
			//Iterate through all the available windows
			for (String string : windowHandles) {
				driver.switchTo().window(string);
				String newtabURL = driver.getCurrentUrl();

				//check whether the url post switch is the desired page
				if (newtabURL.equals(expectedURL)) {
					temp = 1;
					driver.switchTo().defaultContent();
					break;
				} else {
					temp = 0;
				}
			}
			if (temp == 1) {
				logger.info("Redirection successful.");
				return true;
			}
			else if (temp == 0) {
				logger.info("Redirection unsuccessful.");
				return false;
			}
		}
		return false;
	}


	public boolean enterpriseAdminLoginRedirection(String expectedURL) throws InterruptedException {
		BasicConfigurator.configure();
		logger.info("Executing enterpriseAdminLoginRedirection()...");

		if(marketingAutomationTabIsVisible()) {
			logger.info("Found enterpriseAdminLoginBtn.");

			driver.findElement(enterpriseAdminLoginBtn).click();
			String actualURL = driver.getCurrentUrl();
			return expectedURL.equals(actualURL);

		}
		return false;
	}

	public boolean dealMakerLoginRedirection(String expectedURL) throws InterruptedException {
		BasicConfigurator.configure();
		logger.info("Executing dealMakerLoginRedirection()...");

		if(marketingAutomationTabIsVisible()) {
			logger.info("Found dealMakerLoginBtn.");

			driver.findElement(dealMakerLoginBtn).click();
			String actualURL = driver.getCurrentUrl();
			return expectedURL.equals(actualURL);

		}
		return false;
	}

}