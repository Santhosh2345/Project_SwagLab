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

public class Project_Swag extends Base_Class {
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

	@Test(priority = -1)
	private void add_TO_Cart_Button() throws InterruptedException, IOException {
		Thread.sleep(3000);
		WebElement AtC = find_by(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		AtC.click();
		screen(".\\ScreenShot\\Add_to_Cart.png");
		Thread.sleep(3000);
		WebElement Remove = find_by(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
		Remove.click();
		Thread.sleep(2000);
		WebElement a = find_by(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
		a.click();
		Thread.sleep(3000);
		find_by(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']")).click();
	}

	@Test(priority = 1)
	private void particular_Item_Page_Select_Functionalities() throws InterruptedException, IOException {
		Thread.sleep(3000);
		find_by(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).click();
		impli();
		find_by(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
		screen(".\\ScreenShot\\Item_Page.png");
		Thread.sleep(3000);
		find_by(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")).click();
		WebElement back = find_by(By.xpath("//button[@id='back-to-products']"));
		if (back.isSelected()) {
			System.out.println("Bact To Product Button worked correctly");
		}

	}

	@Test(priority = 2)
	private void select_Deselct_Functionalites_In_Cart_Section() throws InterruptedException, IOException {
		find_by(By.xpath("//a[@class='shopping_cart_link']")).click();
		screen(".\\ScreenShot\\Cart_Page.png");
		Thread.sleep(3000);
		find_by(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();
		Thread.sleep(3000);
		find_by(By.xpath("//input[@id='first-name']")).click();
		find_by(By.id("last-name")).click();
		find_by(By.id("postal-code")).click();
		screen(".\\ScreenShot\\Data_Entry_Page.png");
		Thread.sleep(3000);
		find_by(By.id("continue")).click();
		Thread.sleep(3000);
		find_by(By.name("cancel")).click();
		Thread.sleep(3000);
		find_by(By.id("continue-shopping")).click();

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
	}

	@Test(priority = 4)
	private void menu_Button_Select_Functionalities() throws InterruptedException, IOException {
		Thread.sleep(3000);
		WebElement menu = find_by(By.xpath("//button[@id='react-burger-menu-btn']"));
		menu.click();
		Thread.sleep(2000);
		screen(".\\ScreenShot\\Menu_Button.png");
		Thread.sleep(2000);
		find_by(By.xpath("//a[text()='About']")).click();
		Thread.sleep(3000);
		back();
		Thread.sleep(3000);
		find_by(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		find_by(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(2000);
		find_by(By.xpath("//a[@id='reset_sidebar_link']")).click();
		find_by(By.xpath("//button[@id='react-burger-cross-btn']")).click();
		refresh();
		find_by(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(2000);
		find_by(By.id("logout_sidebar_link")).click();
		screen(".\\ScreenShot\\Logout_Page.png");
		Thread.sleep(2000);
		quit();
	}
}
