package TestUtilpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
public static long page_load_time=40;
public static long implicit_wait_time=50;
public static String testdatafile="C:\\Users\\admin\\eclipse-workspace\\OpenCart\\src\\test\\java\\DataDrivenclass\\TestData-OpenCart.xlsx";
public static Workbook wb;
public static Object[][] gettestData(String sheetName)
{
	File f=new File(testdatafile);
	
	try {
		FileInputStream fin=new FileInputStream(f);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		wb = new XSSFWorkbook(new FileInputStream(f));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Sheet sh = wb.getSheet(sheetName);
	int row_count = sh.getLastRowNum();
	int cell_count = sh.getRow(0).getLastCellNum();
	Object[][] data=new Object[row_count][cell_count];
for(int i=0;i<row_count;i++)
{
	for(int j=0;j<cell_count;j++)
	{
	
		Cell cell=sh.getRow(i+1).getCell(j);
		CellType celltype=cell.getCellType();
		
		if(celltype.equals(CellType.STRING))
		{
			data[i][j]=cell.getStringCellValue();
		}
		else if(celltype.equals(CellType.NUMERIC))
		{
			double d=cell.getNumericCellValue(); 
			long l=(long)d;
			data[i][j]=String.valueOf(l);
		}
		
		}
}
return data;

}

}
