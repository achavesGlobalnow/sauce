package com.yourcompany.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class BasePage {

    protected WebDriver driver;

    private String xPath = "/html[@class='gr__saucelabs-sample-test-frameworks_github_io']/body/div[%d]";
    
    
   
    public BasePage(WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    

    public WebElement waitForElementToBePresent(String xPath) {

    	WebElement element= driver.findElement(By.xpath(xPath));

	return element;

	}

	public void click(String xpath){

		waitForElementToBePresent(xpath).click();

	}

	public void sendKeys(String xpath, String text){

		waitForElementToBePresent(xpath).sendKeys(text);

	}

	public boolean isTextPresent(String text) {
		
		String path;
		for(int i=2;i<5;i++){
			
			path = String.format(xPath,i);
			
			if(!waitForElementToBePresent(path).getText().equals(text)){
				
				return false;
			}
		}
		
		return true;
		
	}

}
