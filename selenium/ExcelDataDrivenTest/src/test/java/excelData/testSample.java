package excelData;

import java.io.IOException;
import java.util.List;

public class testSample {

	public static void main(String[] args) throws IOException {

		ExcelDataDrivenTest ed = new ExcelDataDrivenTest();
		List<Object> data = ed.getData("Add profile");
		System.out.println(data);
		for (Object val: data) {
			System.out.println(val);
		}
	}

}
