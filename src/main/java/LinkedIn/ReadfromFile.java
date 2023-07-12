package LinkedIn;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadfromFile {
	int numOfRows;
	int numOfColumns;
	public XSSFWorkbook wb;

	public String[][] readCsv(String filePath) throws InvalidFormatException, IOException {

		File searchDataFile = new File(filePath);
		wb = new XSSFWorkbook(searchDataFile);
		XSSFSheet searchDataSheet = wb.getSheet("Sheet1");
		numOfRows = searchDataSheet.getPhysicalNumberOfRows();
		numOfColumns = searchDataSheet.getRow(0).getLastCellNum();
		String[][]dataArray = new String[numOfRows-1][numOfColumns];

		for (int i = 1; i < numOfRows; i++) {
			for (int j = 0; j < numOfColumns; j++) {
				XSSFRow row = searchDataSheet.getRow(i);
				dataArray[i-1][j] = row.getCell(j).getStringCellValue();
			}
		}
		return dataArray;
	}

}
