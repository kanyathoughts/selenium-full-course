package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDrivenTest {

	public static void main(String[] args) throws IOException {
		
	}
	
	public List<Object> getData(String testcaseName) throws IOException {
		List<Object> purchaseRowData = new ArrayList<Object>();
		int colValue = 0;
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\kdarisi\\Downloads\\Temp_Data.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("testdata");
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell.toString().equals("Testcases")) {
					colValue = j;
					break;
				}
			}
			if (row.getCell(colValue).getStringCellValue().equals(testcaseName)) {
				for (int k = 0; k < row.getLastCellNum(); k++) {
					if (row.getCell(k).getCellType()==CellType.STRING) {
						purchaseRowData.add(row.getCell(k).getStringCellValue());
					} else {
						//Converting Double value to String
						String value = NumberToTextConverter.toText(row.getCell(k).getNumericCellValue());
						purchaseRowData.add(value);
					}
				}
				break;
			}
		}
		wb.close();
		return purchaseRowData;
	}

}
