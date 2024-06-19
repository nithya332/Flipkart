package testpracticefolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class baseclass {
	public WebDriver driver;
	public WebDriver browserInitialisation(String BrowserName) throws Exception
	{
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid Name exception");
		}
		return driver;
}
}
