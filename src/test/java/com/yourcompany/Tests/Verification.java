package com.yourcompany.Tests;

import com.yourcompany.Pages.BasePage;
import com.yourcompany.Pages.GuineaPigPage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

/**
 * Created by mehmetgerceker on 12/7/15.
 */

public class Verification extends TestBase {

	private static String text= "i appear 3 times on the page";
	/**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyText(String browser, String version, String os, Method method)

    throws MalformedURLException, InvalidElementStateException, UnexpectedException {

    		//create webdriver session

    		this.createDriver(browser, version, os, method.getName());

    		WebDriver driver = this.getWebDriver();

    		GuineaPigPage page = new GuineaPigPage(driver);
    		BasePage validationPage = new BasePage(driver);

    		page.visitPage();

    		Assert.assertTrue(validationPage.isTextPresent(text));
    		System.out.println(validationPage.isTextPresent(text));

    		

     }

}