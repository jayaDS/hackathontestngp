package stepDefinations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basepackage.basic;
//import io.cucumber.java.en.*;
import pageobject.ForCorporate;
import pageobject.Homepage;
//import pageobject.ThankYou;


public class FormValidation extends hooks {
	WebDriver driver;
	Homepage hp;
	ForCorporate fc;
//	ThankYou ty;
	@Test(priority=10)
	public void user_present_on_practo_com_website_three() {
	    // Write code here that turns the phrase above into concrete actions
		hp=new Homepage(basic.getDriver());
		fc=new ForCorporate(basic.getDriver());
		basic.getlogger().info("*****User present on practo.com Website_three**********");
	}
	@Test(priority=11)
	public void user_clicks_on_for_corporates() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		hp.for_corporate();
		basic.getlogger().info("User clicks on For Corporates");
	}

	@Test(priority=12)
	public void user_clicks_on_health_and_wellness_plan() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		hp.healthAndWellnessPlan();
		basic.screenShot("Corporates_health_and_wellness_plan_click");
		basic.getlogger().info("User clicks on Health and Wellness Plan");
	}

	@Test(priority=13)
	public void user_enters_all_non_email_fields_in_the_form() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		fc.entersAllNon_emailFieldsInTheForm();
		basic.getlogger().info("User enters all non-email fields in the form");
	}

	@Test(priority=14)
	public void user_enters_invalid_email() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		fc.entersInvalidEmail();
		basic.getlogger().info("User enters invalid email");
	}

	@Test(priority=15)
	public void validate_if_schedule_a_demo_button_is_disabled() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		basic.screenShot("schedule_a_demo_disabled(invalid_email)");
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet s = wb.getSheet("Sheet4");
		if(fc.validateScheduleADemoButton())
		{
			s.createRow(2).createCell(0).setCellValue("Schedule a demo button is enabled");
			System.out.println("Schedule a demo button is enabled");
		}
		else
		{
			s.createRow(2).createCell(0).setCellValue("Schedule a demo button is disabled");
			System.out.println("Schedule a demo button is disabled");
		}
		basic.getlogger().info("validate if Schedule a Demo button is disabled");
		FileOutputStream fo= new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx");
		  wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
	}

	@Test(priority=16)
	public void user_enters_valid_email() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		fc.entersValidEmail();
		basic.getlogger().info("User enters valid email");
		//validate_if_schedule_a_demo_button_is_disabled();
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet s = wb.getSheet("Sheet4");
		if(fc.validateScheduleADemoButton())
		{
			s.getRow(2).createCell(1).setCellValue("Schedule a demo button is enabled");
			System.out.println("Schedule a demo button is enabled");
		}
		else
		{
			s.getRow(2).createCell(1).setCellValue("Schedule a demo button is disabled");
			System.out.println("Schedule a demo button is disabled");
		}
		FileOutputStream fo= new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx");
		  wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
	}

	@Test(priority=17)
	public void user_clicks_on_schedule_a_demo_button() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		basic.screenShot("schedule_a_demo_click(valid_email)");
		fc.clickScheduleADemoButton();
		basic.getlogger().info("User clicks on Schedule a Demo button");
	}

	@Test(priority=18)
	public void validate_if_thank_you_message_is_displayed() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		if(fc.msg()) {
			System.out.println("Thank you is displayed");
		}
		else {
			System.out.println("Thank you is not displayed ");
		}
		basic.screenShot("Thank_you");
		basic.getlogger().info("validate if Thank You message is displayed");
	}

}
