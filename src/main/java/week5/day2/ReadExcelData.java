package week5.day2;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) {


		try {
			XSSFWorkbook workbook=new XSSFWorkbook("./data/testDataExcel.xlsx");
			XSSFSheet sheet=workbook.getSheetAt(0);
			int rowNum=sheet.getLastRowNum();

			int colNum=sheet.getRow(0).getLastCellNum();

			System.out.println("Row No "+rowNum + " Column No "+colNum);

			for(int i=1;i<=rowNum;i++) {

				for(int j=0;j<colNum;j++) {

					CellType cellType = sheet.getRow(i).getCell(j).getCellType();
					//				System.out.println(cellType);

					switch(cellType) {
					case STRING:
						String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
						System.out.println(stringCellValue);
						break;
					case NUMERIC:
						double numericCellValue = sheet.getRow(i).getCell(j).getNumericCellValue();
						System.out.println(String.valueOf(numericCellValue));
						break;
					default:
						break;
					}
 System.out.println("_________________________________________________________________________________________________");

				}}











		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}
