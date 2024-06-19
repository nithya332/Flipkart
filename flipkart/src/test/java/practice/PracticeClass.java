package practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testpracticefolder.baseclass;

public class PracticeClass extends baseclass {
	private static final String BrandVerify = null;
	public WebDriver driver;
	private Assert softassert;
	@BeforeMethod
	@Parameters("browzer")
	public void initialisation(String browzer) throws Exception {
		
		driver = browserInitialisation(browzer);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println("Before Method Example");
	}
	//public void initialisation() throws Exception 
	//{
	//	driver = browserInitialisation("Chrome");
	//	driver.get("https://www.amazon.in/");
	//}
	@Test
	public void tc01() throws InterruptedException
	{
		System.out.println("tc 1");
		//tables
		driver.navigate().to("https://selenium.qabible.in/table-sort-search.php");//inspect search,then inspect age
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Bradley");
		String age=driver.findElement(By.xpath("(//tr[@class='odd']//child::td)[4]")).getText();
		System.out.println(age);
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.navigate().refresh();
		//to find all the listed elements in table by using findelements()
		List<WebElement> num=driver.findElements(By.xpath("//tr[@class='odd' or @class='even']"));//inspect the whole table
		ArrayList<String> value1=new ArrayList<String>();
		for(int i=0;i<num.size();i++)
		{
			value1.add(num.get(i).getText());
		}
		//System.out.println(value1);
		String name= value1.get(5);//fetch value
		System.out.println(name);
		
		
		
}
	@Test
	public void tc02() {
		
	System.out.println("tc 02");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart tv");
	//driver.findElement(By.id("nav-search-submit-button")).click();
	WebElement element = driver.findElement(By.id("nav-search-submit-button"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	String Brandverify=driver.findElement(By.xpath("//span[text()='Brands']")).getText();
	SoftAssert softassert=new SoftAssert();
	softassert.assertEquals(Brandverify,"Brands");
	softassert.assertAll();
	
	//page scrolling
	//executor.executeScript("window.scrollBy(0,1000)", " ");//vertical case scrolling
	}
	@BeforeSuite
	public void beforeSuiteExample() {
		System.out.println("Before Suite Example");
	}
	@AfterSuite
	public void afterSuiteExample() {
		System.out.println("After Suite Example");
	}
	@BeforeTest
	public void beforeTestExample() {
		System.out.println("Before Test Example");
	}
	@AfterTest
	public void afterTestExample() {
		System.out.println("After Test Example");
	}
	@AfterMethod
	public void afterMethodExample() {
		System.out.println("After Method Example");
		//driver.quit();
	}
	@BeforeClass
	public void beforeClassExample() {
		System.out.println("Before Class Example");
	}
	@AfterClass
	public void afterClassExample() {
		System.out.println("After Class Example");
		
	}
	@Test
	public void tc03() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart tv");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int productsize = products.size();
		System.out.println("No of Products = "+productsize);
		Assert.assertEquals(productsize, 23);//soft assertion

	}
	@Test(dataProvider = "testData")
	public void tc04(String value1, String value2) {
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		driver.findElement(By.id("value-a")).sendKeys(value1);
		driver.findElement(By.id("value-b")).sendKeys(value2);
		driver.findElement(By.id("button-two")).click();	
	}
	@DataProvider(name="testData")
	public Object[][] testDataFeed(){
		Object[][] dataSet = new Object[2][2];
		dataSet[0][0] = "5";
		dataSet[0][1] = "1";
		dataSet[1][0] = "6";
		dataSet[1][1] = "2";
		return dataSet;

	
	}
	}
	
	
	

