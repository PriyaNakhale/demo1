package demo.automationtesting.in.testclasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demo.automationtesting.in.base.BaseClass;
import demo.automationtesting.in.pages.RegisterPage;
import demo.automationtesting.in.util.TestDataUtils;

public class RegisterTest extends BaseClass {

	RegisterPage r;

//	public RegisterTest() {
//		super();
//		
//	}	@BeforeMethod
	public void setup() {
		intilization();
		r = new RegisterPage();
	}
	
//	@Test(priority=0)
//	public void registerPageTitleTest() {
//		String title = r.validateRegisterTitle();
//		System.out.println("Title: "+title);
//		Assert.assertEquals(title, "Register");
//		
//	}
	@DataProvider
	public Object[][] registrationData() throws Exception {
		Object[][] testObjArray = TestDataUtils.readExcel(prop.getProperty("filePath"),prop.getProperty("sheetName"));
		return testObjArray;
	}
	@Test(priority=1,dataProvider="registrationData")
	public void registerUserTest(String firstname,String lastname,String address, String emailid, String phone, String gender, String hobbies,String language,String skill,String country1,String country2){
		r.registerUser(firstname, lastname,address,emailid,phone,gender,hobbies,language,skill,country1,country2);
		System.out.println("data is entered for "+firstname);
	
	}
}
