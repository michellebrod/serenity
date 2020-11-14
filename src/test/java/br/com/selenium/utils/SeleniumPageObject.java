package br.com.selenium.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPageObject extends PageObject {

    @Override
    public void clickOn(WebElement element){
        super.clickOn(element);
    }

    @Override
    public void typeInto(WebElement element, String text){
        waitFor(element);
        super.typeInto(element, text);
    }
    
    public void typeIntoSlowly(WebElement element, String text) throws Exception {
    	waitFor(element);
    	element.clear();
    	for(String ch: text.split("")) {
    		element.sendKeys(ch);
    		Thread.sleep(200);
    	}
    }
    
    public void typeIntoSlowlyWithoutClear(WebElement element, String text) throws Exception {
    	waitFor(element);
    	
    	for(String ch: text.split("")) {
    		element.sendKeys(ch);
    		Thread.sleep(200);
    	}
    }
    
    public void doubleClickOn(WebElement element){
    	Actions act = new Actions(getDriver());
    	act.doubleClick(element).perform();
    }
    
    public void rightClickOn(WebElement element){
    	Actions act = new Actions(getDriver());
    	act.contextClick(element).perform();
    }

	public void setValue(WebElementFacade element, String text){
		waitFor(element);
		element.clear();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='"+ text +"';", element);
	}
    
    public void checkBoxGeneric(String desc, boolean check) {
		WebElementFacade checkbox = findBy("//td[label[text() = '" + desc + "']]/input[@type='checkbox']");
		
		checkBoxSelector(checkbox, check);
	}

	public void checkBoxSelector(WebElement element, boolean check){
		if(element.isEnabled()) {
			if((check) && (!element.isSelected()))
				clickOn(element);
			else if((!check) && (element.isSelected()))
				clickOn(element);
		}
	}

	public void waitToNumberOfWindowsEquals(int number, int timeout){
		long startTime = System.currentTimeMillis();
        while (getDriver().getWindowHandles().size()!=number && (System.currentTimeMillis() - startTime) < (timeout*1000)){
            //System.out.println("Quantidade de telas: "+getDriver().getWindowHandles().size());
            //System.out.println("Tempo decorrido: "+(System.currentTimeMillis() - startTime));
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
	}
	
	public void clickGenericButton(String desc) {
		WebElementFacade button = findBy("//button[contains(@value,'" + desc + "')]");
		
		if(!elementIsPresent(button))
			button = findBy("//input[@value='" + desc + "']");
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", button);		
	}
	
	public void clickGenericLink(String desc) {
		WebElementFacade link = findBy("//a[text() ='" + desc + "' or *[text() = '" + desc + "']]");
		link.click();
	}
	
	public void clickTab(String desc) {
		WebElementFacade tab = findBy("//ul[@class='tabs']/li/div[text() = '" + desc + "']");
		tab.click();
	}
	
	public void switchToWindowByName(String name) {
		Set<String> janelas = getDriver().getWindowHandles();
		
		for (String janela : janelas) {			
			getDriver().switchTo().window(janela);
			
			if(getDriver().getTitle().equals(name))
				break;
		}
	}
	
	public static String calcularData(String valorInformado) throws Exception {
		int varAux = Integer.parseInt(valorInformado.replace("DATE(", "").replace(")", ""));
		
		DateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dateFrom = Calendar.getInstance();
		
		List<String> listFeriados = new ArrayList<String>();		
		dateFrom.setTime(new Date());
		
		String detail;
		String[] auxDetail;
		String dirJar = new File(".").getCanonicalPath().replace("\\", "/");
		
		File feriadosCSV = new File(dirJar + "/src/test/resources/files/feriados.csv");
		
		if(feriadosCSV.exists()) {
			FileReader fileReader = new FileReader(feriadosCSV.getAbsolutePath()); //dirJar + "src/test/resources/files/feriados.csv");					
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fileReader);
			
			while((detail = br.readLine()) != null)
			{
				auxDetail = detail.split(";");
				if(auxDetail.length > 0)				
					listFeriados.add(auxDetail[0]);			
			}
		}
		
		if(varAux < 0)
		{				
			varAux = varAux * (-1);
			for (int daysBack = 0; daysBack < varAux; ++daysBack) {
				do {				
					dateFrom.add(Calendar.DAY_OF_YEAR, -1);
				} while ((isWeekend(dateFrom)) || (listFeriados.contains(dtFormat.format(dateFrom.getTime()))));
			}
			
		}
		else {
			for (int daysForward = 0; daysForward < varAux; ++daysForward) {
				do {				
					dateFrom.add(Calendar.DAY_OF_YEAR, 1);
				} while ((isWeekend(dateFrom)) || (listFeriados.contains(dtFormat.format(dateFrom.getTime()))));
			}			
		}
		
		return dtFormat.format(dateFrom.getTime());	
	}
	
	private static boolean isWeekend(Calendar dateAtual) {		
		return dateAtual.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || dateAtual.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}
	
	public void selectClickAndChooseOption(WebElement element, String option) {
		clickOn(element);
		String optionsAux = "";
		String[] arrayOption = option.split(" ");
		for(int i = 0; i < arrayOption.length; i++) {
			optionsAux += "contains(text(), '" + arrayOption[i] + "')";
			
			if(i < arrayOption.length-1)
				optionsAux += " and ";
		}
		WebElementFacade opcaoLayout = findBy("//ul[@aria-hidden='false']/li/a[" + optionsAux + "]");
		clickOn(opcaoLayout);
	}
	
	public void switchToFrame(String frameName) {
		if(frameName.isEmpty())
			getDriver().switchTo().defaultContent();		
		else {
			//getDriver().switchTo().parentFrame();
			getDriver().switchTo().frame(frameName);
		}
	}
	
	public void switchToFrame(int frameIndex) {
		getDriver().switchTo().defaultContent();		
		getDriver().switchTo().frame(frameIndex);
	}

	public void switchToParentFrame(){
    	getDriver().switchTo().parentFrame();
	}
			
	public void switchToLastWindow() {
		try {
            Thread.sleep(3000);
        }catch (Exception e){
		    e.printStackTrace();
        }
		

		Set<String> windows = getDriver().getWindowHandles();		
		for (String window : windows) 		{
			getDriver().switchTo().window(window);					
		}		
		getDriver().manage().window().maximize();		
	}
	
	public void switchToFirstWindow(boolean closeOthers) {
		try {
            Thread.sleep(3000);
        }catch (Exception e){
		    e.printStackTrace();
        }
		
		Set<String> windows = getDriver().getWindowHandles();		
		String[] windowsArray = windows.toArray(new String[windows.size()]);
		
		for(int i = windows.size() - 1; i >= 0; i--) {
			getDriver().switchTo().window(windowsArray[i]);	
			
			if((i > 0) && (closeOthers)) {
				getDriver().close();
			}
		}

		getDriver().manage().window().maximize();		
	}
	
	public void waitAndSwitchToLastWindow(int qtdeMinJanelas) throws Exception {
		
		int iLimite = 0;
		while(getDriver().getWindowHandles().size() < qtdeMinJanelas) {
			Thread.sleep(3000);
			
			iLimite++;
			
			if(iLimite == 15)
				break;
		}

		Set<String> windows = getDriver().getWindowHandles();

		for (String window : windows) 		
			getDriver().switchTo().window(window);		
		
		getDriver().manage().window().maximize();
		
	}
	
	public boolean elementIsPresent(WebElementFacade element) {
		getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		if(element.isPresent())
			return true;
					
		return false;
	}
	
	public void waitForPageLoad() throws Exception {
		
		int iLimite = 0;
		while(!((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete")) {
			Thread.sleep(2000);
			
			iLimite++;
			
			if(iLimite == 20)
				break;
		}
	}
	
	public void closePopUpWindow() throws Exception {
		getDriver().close();
		switchToLastWindow();
	}
	
	public void waitSeconds(int seconds) throws Exception {	
		Thread.sleep(seconds * 1000);
	}
	
	public void switchToDefaultContent() throws Exception {
		getDriver().switchTo().defaultContent();
	}
	
	public void salvaPrints(WebDriver driver) {
		String pathResult = "target";
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Date date = new Date();
			DateFormat formato = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
			String formattedDate = formato.format(date);
			
			FileUtils.copyFile(scrFile, new File(pathResult + File.separator + "screenshot_" + formattedDate + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deslogarSistema() throws Exception {
		System.out.println("Realizando logout");
		System.out.println("Qtde Janelas: " + getDriver().getWindowHandles().size());
		getDriver().switchTo().defaultContent();
		if(getDriver().getWindowHandles().size() > 1) {
			switchToFirstWindow(true);
		}
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("sair();");
		Thread.sleep(2000);
		acceptAlertIfPresent();
		waitForPageLoad();
		Thread.sleep(3000);
	}
	
	public String processarComando(String comando) throws Exception{
		String retorno = comando;
		
		if(comando.startsWith("DATE(")) {
			retorno = calcularData(comando);
		}
		
		return retorno;
	}
	
	private static final Short TIMEOUT_SECONDS = 30;
	private static final Long SLEEP_MILLIS = 250l;
	
	public static WebDriverWait getWebDriverWait(final WebDriver webDriver) {
		final WebDriverWait webDriverWait;		
		webDriverWait = new WebDriverWait(webDriver, TIMEOUT_SECONDS, SLEEP_MILLIS);	
		return webDriverWait;
	}
		
	public void acceptAlertIfPresent(){
		try{
			getAlert().accept();
		}
		catch(NoAlertPresentException e){
			// Não realiza nenhuma ação
		} finally {
			resetImplicitTimeout();
		}
	}
	
	public void selectByVisibleText(WebElementFacade element, String value) {
		element.selectByVisibleText(value);
	}
	
}
