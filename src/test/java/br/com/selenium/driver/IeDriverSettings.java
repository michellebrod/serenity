package br.com.selenium.driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IeDriverSettings {
	public IeDriverSettings() {
		return;
	}

	public WebDriver Setup(Properties prop) throws MalformedURLException {
		System.setProperty("webdriver.ie.driver", prop.getProperty("ie.driver"));

		InternetExplorerOptions IEoptions = new InternetExplorerOptions();
		IEoptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				prop.getProperty("ie.options.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS"));
		IEoptions.setCapability("ignoreZoomSetting", prop.getProperty("ie.options.ignoreZoomSetting"));
		IEoptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, prop.getProperty("ie.options.NATIVE_EVENTS"));
		IEoptions.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,
				prop.getProperty("ie.options.ELEMENT_SCROLL_BEHAVIOR"));
		IEoptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,
				prop.getProperty("ie.options.REQUIRE_WINDOW_FOCUS"));
		IEoptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, prop.getProperty("ie.options.ACCEPT_SSL_CERTS"));

		if(prop.getProperty("ie.options.PRIVATE").equals("true")) {
			habilitaModoPrivate();
			IEoptions.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			IEoptions.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
		}
		
		retirarModoProtegidoAvancado();

		if (prop.getProperty("driver.type").toLowerCase().equals("remote")) {				
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + prop.getProperty("driver.hostname") + ":"
					+ prop.getProperty("driver.port") + "/wd/hub"), IEoptions);
			driver.setFileDetector(new LocalFileDetector());
			return driver;
		}
		else
			return new InternetExplorerDriver(IEoptions);
	}

	public static void retirarModoProtegidoAvancado() {

		try {
			new ProcessBuilder("cmd.exe", "/c",
					"REG ADD \"HKCU\\Software\\Microsoft\\Internet Explorer\\Main\" /v \"Isolation\" /t REG_SZ /d \"PMIL\" /f")
							.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void habilitaModoPrivate() {
		try {
			new ProcessBuilder("cmd.exe", "/c", "REG ADD \"HKCU\\Software\\Microsoft\\Internet Explorer\\Main\" /v \"TabProcGrowth\" /t REG_DWORD /d \"0\" /f").start();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
