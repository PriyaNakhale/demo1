package demo.automationtesting.in.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demo.automationtesting.in.base.BaseClass;
import demo.automationtesting.in.util.ActionClass;

public class RegisterPage extends BaseClass {

	@FindBy(xpath = "//*[@id='basicBootstrapForm']//input")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;

	@FindBy(xpath = "//*[@id='basicBootstrapForm']//textarea")
	WebElement address;

	@FindBy(xpath = "//*[@id='eid']//input")
	WebElement emailid;

	@FindBy(xpath = "//*[@id='basicBootstrapForm']/div[4]//input")
	WebElement phone;

	@FindBy(xpath = "//input[@name='radiooptions']")
	List<WebElement> genderList;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> hobbiesList;

	@FindBy(xpath = "//div[@id='msdd']")
	WebElement languagesBox;

	@FindBy(xpath = "//ul[contains(@class,'ui-corner-all' )]//a")
	List<WebElement> languagesMenus;

	@FindBy(xpath = "//select[@id='Skills']")
	WebElement skills;
	
	@FindBy(xpath = "//select[@id='countries']")
	WebElement country;
	
	@FindBy(xpath = "//span[@class='selection']")
	WebElement selectCountry;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	List<WebElement> selectCountryMenu;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateRegisterTitle() {
		// System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public void registerUser(String fn, String ln, String add, String email, String ph, String gender, String hobbies,String language, String skill,String country1,String country2) {
		ActionClass.sendKeys(firstName, fn);
		ActionClass.sendKeys(lastName, ln);
		ActionClass.sendKeys(address, add);
		ActionClass.sendKeys(emailid, email);
		ActionClass.sendKeys(phone, ph);
		ActionClass.radioClick(genderList, gender);
		ActionClass.checkBoxClick(hobbiesList, hobbies);
		ActionClass.selectListOptions(languagesBox, languagesMenus, language);
		ActionClass.selectByVisibleText(skills, skill);
		ActionClass.selectByVisibleText(country, country1);
		//ActionClass.selectListOptions(selectCountry, selectCountryMenu, country2);
		
	}
}
