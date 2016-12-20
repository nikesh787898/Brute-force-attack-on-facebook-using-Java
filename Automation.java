package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Automation {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","/home/nikesh/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "https:facebook.com";
        String expectedTitle = "";
        String actualTitle = "";
        driver.get(baseUrl);
        System.out.println("Page title  : " + driver.getTitle());
        actualTitle = driver.getTitle();
        
        //fill this array for all possible email and password
        String emailPass[][]=new String[][]{{"Nikesh","Joshi"},{"Email","password"}};
        for(int i = 0; i < emailPass.length ; i++ )
        {
        	WebElement email = driver.findElement(By.id("email"));
            WebElement password = driver.findElement(By.id("pass"));
            email.clear();
            password.clear();
        	email.sendKeys(emailPass[i][0]);
            password.sendKeys(emailPass[i][1]);
            email.submit();
            Thread.sleep(3000);
            if(driver.getTitle().toString().indexOf("Log")==-1)
            {
            	System.out.println("login SuccessFully.");
            	break;
            }
            else
            {
            	System.out.println("Error in Login.");
            }
        }
        
        //System.out.println("Page title  : " + driver.getTitle());
        driver.close();
        System.exit(0);
    }
}
