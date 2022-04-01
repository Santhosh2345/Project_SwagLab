package com.Medal;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Project_Swag_FIlter extends Base_Class {
		static WebDriver driver;

		@BeforeSuite
		private void browser_Launch() {
			base();
		}

		@BeforeTest
		private void url() {
			url("https://www.saucedemo.com/");
		}

		@BeforeClass
		private void login() throws InterruptedException, IOException {
			Thread.sleep(3000);
			find_by(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys("standard_user");
			find_by(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");
			screen(".\\ScreenShot\\Login_Page.png");
			find_by(By.xpath("//input[@type='submit']")).click();
}

		@Test(priority = 3)
		private void filter_Funtionalities() throws AWTException, InterruptedException, IOException {
			WebElement filter = find_by(By.xpath("//select[@class='product_sort_container']"));
			filter.click();
			Thread.sleep(2000);
			bot(1);
			Thread.sleep(2000);
			find_by(By.xpath("//select[@class='product_sort_container']")).click();
			Thread.sleep(2000);
			bot(2);
			Thread.sleep(2000);
			find_by(By.xpath("//select[@class='product_sort_container']")).click();
			Thread.sleep(2000);
			bot(3);
			screen(".\\ScreenShot\\Filter_Funtionality.png");
			Thread.sleep(3000);
			quit();
		}
	}
