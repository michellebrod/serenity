package br.com.selenium.driver;

import java.io.InputStream;
import java.util.Properties;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

/**
 * @see readme.txt dentro do pacote dessa mesma classe Classe que fabrica as
 *      instancias de WebDriver para o Serenity
 *
 */
public class Driver implements DriverSource {

	public WebDriver newDriver() {

		Properties prop = new Properties();
		String propFileName = "driver.properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		// QUAL SISTEMA OPERACIONAL
		try {
			if (inputStream != null)
				prop.load(inputStream);
			else
				throw new Exception("Driver Property file '" + propFileName + "' not found");

			String browser = prop.getProperty("driver.browser");

			if (browser.toLowerCase().equals("chrome")) {
				return new ChromeDriverSettings().Setup(prop);
			} else if ((browser.toLowerCase().equals("ie")) || (browser.toLowerCase().equals("internetexplorer"))) {
				return new IeDriverSettings().Setup(prop);
			} else
				throw new Exception("Browser not exists");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}

	public boolean takesScreenshots() {
		return true;
	}
}
