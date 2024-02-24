package demo.automationtesting.in.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionClass {

	public static void sendKeys(WebElement ele, String text) {
		if (ele.isDisplayed() && ele.isEnabled()) {
			ele.clear();
			try {
				ele.sendKeys(text);
			} catch (IllegalArgumentException e) {
				System.out.println("Null values are not allowed." + ele);
			}
		}
	}

	public static void click(WebElement ele) {
		if (ele.isDisplayed() && ele.isEnabled()) {
			try {
				ele.click();
			} catch (StaleElementReferenceException e) {
				System.out.println("Element is not longer attach to DOM." + ele);
			}
		}
	}

	public static void radioClick(List<WebElement> radios, String value) {
		for (WebElement radio : radios) {
			if (radio.getAttribute("value").equalsIgnoreCase(value)) {
				click(radio);
			}
		}
	}

	public static void groupElementClick(List<WebElement> elelist, String value) {
		for (WebElement ele : elelist) {
			if (ele.getText().equalsIgnoreCase(value)) {
				click(ele);
			}
		}
	}

	public static void checkBoxClick(List<WebElement> checkBoxes, String values) {
		String[] valuesSplit = values.split(",");
		List<String> list = new ArrayList<String>(Arrays.asList(valuesSplit));
		for (String value : list) {
			for (WebElement checkBox : checkBoxes) {
				if (checkBox.getAttribute("value").equalsIgnoreCase(value)) {
					click(checkBox);
					break;
				}
			}
		}

	}

	public static void selectByVisibleText(WebElement ele, String value) {
		Select s = new Select(ele);
		List<WebElement> dropdownoptions = s.getOptions();

		for (WebElement option : dropdownoptions) {
			if (option.getText().equalsIgnoreCase(value)) {
				try {
					// click(option);
					s.selectByVisibleText(value);
					break;
				} catch (Exception e) {
				}
			}

		}
	}

	public static void selectListOptions(WebElement element, List<WebElement> listElements, String values) {
		String[] valuesSplit = values.split(",");
		List<String> list = new ArrayList<String>(Arrays.asList(valuesSplit));
		click(element);
		for (String value : list) {
			for (WebElement option : listElements) {
				if (option.getText().equalsIgnoreCase(value)) {
					click(option);
					break;
				}

			}
		}
	}

	public static void selectSubMenu() {

	}

}
