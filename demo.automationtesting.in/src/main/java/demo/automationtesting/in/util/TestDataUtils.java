package demo.automationtesting.in.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import demo.automationtesting.in.base.BaseClass;

public class TestDataUtils extends BaseClass {
	
	public static Object[][] readExcel(String filePath, String sheetName) throws Exception {

		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String[][] Arr = new String[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];

		for (int i = 0; i < sh.getLastRowNum(); i++) {
			for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) {
				Arr[i][j] = df.formatCellValue(sh.getRow(i + 1).getCell(j));
			}
		}
		return Arr;
	}

}
