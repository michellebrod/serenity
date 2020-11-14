package br.com.selenium.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverSettings {
	
	public ChromeDriverSettings() {

		return;
		
	}
	
	public WebDriver Setup(Properties prop) throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		
		options.setCapability("browserName", "chrome");
		options.setCapability("platform", prop.getProperty("driver.platform").toLowerCase());
		
		/*
		 * SE A PLATAFORMA FOR WINDOWS, É NECESSÁRIO DEFINIR CHROME.DRIVER E O BINÁRIO
		 * SE FOR LINUX, DEFINIR CHROME DRIVER APENAS SE FOR EXECUÇÃO LOCAL
		 */
		if(prop.getProperty("driver.platform").toLowerCase().equals("windows")) {					
			options.setBinary(new File (prop.getProperty("chrome.options.setBinary")));
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver"));
		}
		else if (!prop.getProperty("driver.type").toLowerCase().equals("remote"))
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver"));
		
		if(prop.getProperty("chrome.options.no-sandbox").equals("true"))
			options.addArguments("--no-sandbox");
		
		if(prop.getProperty("chrome.options.incognito").equals("true"))
			options.addArguments("--incognito");
		
		if(prop.getProperty("chrome.options.disable-gpu").equals("true"))
			options.addArguments("--disable-gpu");
		
		if(prop.getProperty("chrome.options.start-maximized").equals("true"))
			options.addArguments("--start-maximized");
		
		if(prop.getProperty("chrome.options.ignore-certificate-errors").equals("true"))
			options.addArguments("--ignore-certificate-errors");
		
		if(prop.getProperty("chrome.options.ignore-urlfetcher-cert-requests").equals("true"))
			options.addArguments("--ignore-urlfetcher-cert-requests");
		
		if(prop.getProperty("chrome.options.headless").equals("true"))
			options.setHeadless(true);
						
		if(prop.getProperty("chrome.options.setAcceptInsecureCerts").equals("true"))
			options.setAcceptInsecureCerts(true);
		
		if(prop.getProperty("chrome.options.disable-dev-shm-usage").equals("true"))
			options.addArguments("--disable-dev-shm-usage");
		
		options.setCapability("version", prop.getProperty("driver.version"));
		
		if(prop.getProperty("driver.type").toLowerCase().equals("remote")) {					
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + prop.getProperty("driver.hostname") + ":" + prop.getProperty("driver.port") + "/wd/hub"), options);
			driver.setFileDetector(new LocalFileDetector());
			return driver;
		}
		else
			return new ChromeDriver(options);
	}

}
