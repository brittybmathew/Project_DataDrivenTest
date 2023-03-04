package testng;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datadriventest {
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
	}
	@Test
	public void upload() throws IOException {
		FileInputStream ob=new FileInputStream("C:\\Users\\Britty\\OneDrive\\Desktop\\Luminar\\Datadriven1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(ob);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int rowsize=sh.getLastRowNum();
		for(int i=1; i<=rowsize; i++) {
			String email=sh.getRow(i).getCell(0).getStringCellValue();
			String pass=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("emailid= "+email);
			System.out.println("password= "+pass);
			driver.get("https://www.netflix.com/in/login");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@name='userLoginId']")).clear();
			driver.findElement(By.xpath("//*[@name='userLoginId']")).sendKeys(email);
			driver.findElement(By.xpath("//*[@name='password']")).clear();
			driver.findElement(By.xpath("//*[@name='password']")).sendKeys(pass);
			driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/form/button")).click();
		}		
	}
}
