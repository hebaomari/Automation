package LinkedIn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToFile {

	private XSSFWorkbook wb;

	public void writeCsv(int row, int col, String cellValue, String filePath) throws InvalidFormatException, IOException {

		File resultFile = new File(filePath);
		FileInputStream fis = new FileInputStream(resultFile);
		wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		sheet.getRow(row).createCell(col).setCellValue(cellValue);
		FileOutputStream fos = new FileOutputStream(resultFile);
		wb.write(fos);
		wb.close();

	}
}