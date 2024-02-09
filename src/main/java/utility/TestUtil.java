package utility;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import base.TestBase;

public class TestUtil extends TestBase{
	
	public static int IMPLICIT_WAIT = 10;
	public static int THREAD_SLEEP  = 500;
	public static final String TEST_DATA_FILE_NAME = "TricentisTestData.xlsx";
	public static final String TEST_DATA_PATH = System.getProperty("user.dir") + "/src/main/resources/" + TEST_DATA_FILE_NAME;
	static String actDate;
	
	public static void hoverOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
    public static Object[] getTestData(String sheetName) {
        List<String> dropdownValues = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(TEST_DATA_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                if (cell != null) {
                    String data;
                    if (cell.getCellType() == CellType.NUMERIC) {
                        data = String.valueOf((int) cell.getNumericCellValue());
                    } else {
                        data = cell.getStringCellValue();
                    }
                    dropdownValues.add(data);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dropdownValues.toArray();
    }
	public static void captureScreenshot(String filename) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String SSPath = System.getProperty("user.dir") + "/Reports/Screenshots/" + filename + TestUtil.getDateTime() + ".jpg";
		File destFile = new File(SSPath);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		test.addScreenCaptureFromPath(SSPath, "Failed Test Screenshot");
	}

	
    public static void waits(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static String getDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		return actDate = format.format(date);
    }
    
    public static String currentMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM"));
    }
    
    public static String nextMonth() {
        return LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MMMM"));
    }

    public static String prevMonth() {
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MMMM"));
    }

    
    public static String futureDate() {
    	LocalDate today = LocalDate.now();
    	LocalDate futureDate = today.plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
        String futureDay = futureDate.format(formatter);
        return futureDay;
    }
}

