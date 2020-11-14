package br.com.selenium.utils;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Interface para declaracao de constantes commons para todo o projeto
 *
 */
public interface GlobalConstants {

	/**
	 * constantes
	 */
	public static final String LINE_SEPARATOR = System.lineSeparator();
	
	/**
	 * Regionalizacao Brasil seguindo i18n
	 */
	public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
	
	/**
	 * Encoding de arquivos
	 */
	public static final Charset CHARSET_ISO8859_1 = Charset.forName("ISO-8859-1");
	public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

	/**
	 * Formatador de Valores numericos reais para o Brasil
	 */
	public static final DecimalFormat DECIMAL_FORMAT_PT_BR = new DecimalFormat("######9.99",
			DecimalFormatSymbols.getInstance(LOCALE_PT_BR));
	
	/**
	 * Formato data hora para o Brasil
	 */
	public static final String DATETIME_PATTERN_PT_BR = "dd/MM/yyyy HH:mm:ss.SSS";
	
	/**
	 * Formatador data para Brasil
	 */
	public static final DateFormat DATETIME_FORMAT_PT_BR = new SimpleDateFormat(DATETIME_PATTERN_PT_BR);
	
	/**
	 * Formato data para Brasil
	 */
	public static final String DATE_PATTERN_PT_BR = "dd/MM/yyyy";
	
	/**
	 * Formatador data para Brasil
	 */
	public static final DateFormat DATE_FORMAT_PT_BR = new SimpleDateFormat(DATE_PATTERN_PT_BR);
	
	/**
	 * Formato de CSV utilizado no engine de persistencia
	 */
	public static final CSVFormat CSV_BASE_FORMAT = CSVFormat.RFC4180;

	/**
	 * <p>nome da variavel de ambiente na qual o RQM informa
	 * o ambiente selecionado pelo usuario para execucao.</p>
	 * 
	 * <p>Para executar no eclipse abrir janela 'RUN CONFIGURATIONS', e
	 * na aba 'MAIN' configurar este parametro.</p>
	 */
	public static final String SYS_VARIABLE_RQM_ENVIRONMENT = "RQM_ENVIRONMENT";

	/**
	 * <p>nome da variavel de ambiente do serenity webdriver.base.url que
	 * informa o servidor que sera utilizado.</p>
	 * <p>Esta configuracao modifica o servidor das annotation DefaultUrl aplicadas
	 * nos PageObjects.</p>
	 * 
	 * @see DefaultUrl
	 * @see EnvironmentUtils#registerDefaultUrl(String)
	 */
	public static final String SYS_VARIABLE_WEBDRIVER_BASE_URL = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.getPropertyName();

	/**
	 * <p>Chave de configuracao DEFAULT_ENVIRONMENT.</p>
	 * <p>Utilizada para discover automatico da URL do ambiente, afetando 
	 * as Default URLs dos PageObjects.</p>
	 * 
	 * @see EnvironmentUtils#getEnvironmentURL(String)
	 * @see EnvironmentUtils#getEnvironmentURL(String, String)
	 * @see EnvironmentUtils#registerDefaultUrl(String)
	 */
	public static final String KEY_SETTING_DEFAULT_ENVIRONMENT = "DEFAULT_ENVIRONMENT";

	/**
	 * <p>Session variable para armazenar a pilha de janelas do browser.</p>
	 * <p>Utilizada para suportar {@link BrowserWindowUtils#switchToPreviousWindow(org.openqa.selenium.WebDriver)} e
	 *  {@link BrowserWindowUtils#switchToOpenedWindow(org.openqa.selenium.WebDriver, Integer)}.</p>
	 * 
	 * @see BrowserWindowUtils#registerWindowHandler(org.openqa.selenium.WebDriver)
	 * @see BrowserWindowUtils#switchToOpenedWindow(org.openqa.selenium.WebDriver, Integer)
	 * @see BrowserWindowUtils#switchToPreviousWindow(org.openqa.selenium.WebDriver)
	 * @see BrowserWindowUtils#cleanBrowserWindowsStack()
	 */
	public static final String SESSION_VARIABLE_BROWSER_WINDOWS_STACK = "SESSION_VARIABLE_BROWSER_WINDOWS_STACK";
	
	/**
	 * <p>Session variable para registrar a informacao identificadora da iteracao anterior de teste.</p>
	 * <p>Normalmente utilizado para suportar reaproveitamento de login e captcha, armazenando o valor
	 * do usuario da iteracao anterior de teste.</p>
	 * 
	 */
	public static final String SESSION_VARIABLE_PREVIOUS_TEST_CATEGORY_IDENTIFIER= "SESSION_VARIABLE_PREVIOUS_TEST_CATEGORY_IDENTIFIER";
	
	/**
	 * <p>Session variable para registrar a url inicial antes de iniciar um teste.</p>
	 * <p>Utilizada para suportar {@link BrowserWindowUtils#isReusedBrowserWindow()}.</p>
	 * 
	 * @see BrowserWindowUtils#isReusedBrowserWindow()
	 * @see BrowserWindowUtils#cleanInitialTestUrl()
	 */
	public static final String SESSION_VARIABLE_BEFORE_TEST_INITIAL_URL = "SESSION_VARIABLE_INITIAL_TEST_URL";
	
		
	/**
	 * <p>Constante que identifica URL de browser recem aberto.</p>
	 * <p>utilizado para suportar {@link BrowserWindowUtils#isReusedBrowserWindow()}.</p>
	 * 
	 * @see BrowserWindowUtils#isReusedBrowserWindow()
	 * @see BrowserWindowUtils#registerInitialTestUrl()
	 * @see BrowserWindowUtils#cleanInitialTestUrl()
	 */
	public static final String NEW_OPENED_WINDOW_URL = "data:,";
	
	/**
	 * <p>Constante que identifica caracter separador de items na lista.</p>
	 * <p>Utilizado para entradas de configuracao que contem lista de valores.</p>
	 * 
	 * @see AutomationSettingsUtils
	 */
	public static final char VALUE_SETTING_ITEM_SEPARADOR = ':';
	
	/**
	 * Chave de configuracao (parcial) para obter url do service bus/middleware/portal api 
	 */
	public static final String KEY_SETTING_PORTAL_API = "PORTAL_API";
	
	/**
	 * Formato/mascara da chave de configuracao portal do sistema/sigla.
	 * 
	 * @see EnvironmentUtils
	 */
	public static final String KEY_SETTING_SYSTEM_PORTAL_FORMAT = "%s.portal";

	/**
	 * Formato/mascara da chave configuracao do path de autenticacao do portal.
	 * 
	 * @see EnvironmentUtils
	 */
	public static final String KEY_SETTING_PASSWORD = "%s.%s.password";
	
	
	/**
	 * Formato/mascara da chave de configuracao url base do portal.
	 * 
	 * @see EnvironmentUtils
	 */
	public static final String KEY_SETTING_ENVIRONMENT_BASE_URL_FORMAT = "%s.%s.base_url";

	/**
	 * Formato/mascara da chave configuracao do path de autenticacao do portal.
	 * 
	 * @see EnvironmentUtils
	 */
	public static final String KEY_SETTING_ENVIRONMENT_BASE_AUTH_URL_FORMAT = "%s.%s.base_auth_url";
	
	/**
	 * Formato/mascara da chave de configuracao do APIKEY da APP CLIENTE DO REST SERVICE
	 * 
	 * @see ApiServiceUtils
	 */
	public static final String KEY_SETTING_SERVICE_APP_API_KEY = "%s.App.%s.api_key";
	
	/**
	 * Formato/mascara da chave de configuracao do KEYSECRET da APP CLIENTE DO REST SERVICE
	 * 
	 * @see ApiServiceUtils
	 */
	public static final String KEY_SETTING_SERVICE_APP_KEY_SECRET = "%s.App.%s.key_secret";
	
	/**
	 * Formato/mascara da chave de configuracao do ID da API (REST SERVICE)
	 * 
	 * @see ApiServiceUtils
	 */
	public static final String KEY_SETTING_SERVICE_API_ID = "%s.Api.%s.id";
	
	/**
	 * Formato/mascara da chave de configuracao do PATH da API (REST SERVICE)
	 * 
	 * @see ApiServiceUtils
	 */
	public static final String KEY_SETTING_SERVICE_API_PATH = "%s.Api.%s.path";
	
	/**
	 * <p>Chave de configuracao do path/storage do engine de persistencia.</p>
	 * <p>Normalmente armazenara' caminho no filesystem dos arquivos CSVs</p>
	 * 
	 * @see EntityManager
	 */
	public static final String KEY_SETTING_DATA_MANAGER_ENGINE_STORAGE = "DATA_MANAGER_ENGINE_STORAGE";
	
	/**
	 * <p>Chave  de configuracao da classe concreta/implementacao do engine de persistencia.</p>
	 * <p>Normalmente armazenara' classe CSVEntityManager.</p>
	 * 
	 * @see EntityManagerFactory
	 */
	public static final String KEY_SETTING_DATA_MANAGER_ENGINE_ENTITY_MANAGER_CLASS = "DATA_MANAGER_ENGINE_ENTITY_MANAGER_CLASS";	
	
	/**
	 * Chave de configuracao dos headers/colunas padroes do CSV utilizados como PK 
	 */
	public static final String KEY_SETTING_DATA_MANAGER_ENGINE_DEFAULT_PK_HEADERS = "DATA_MANAGER_ENGINE_DEFAULT_PK_HEADERS";
	
	/**
	 * Chave de configuracao dos delimitadores de campos do arquivo CSV
	 */
	public static final String KEY_SETTING_DATA_MANAGER_ENGINE_CSV_DELIMITER = "DATA_MANAGER_ENGINE_CSV_DELIMITER";
	
	/**
	 * Chave de configuracao do host do proxy
	 */
	public static final String KEY_SETTING_PROXY_HOST = "Proxy.host";
	
	/**
	 * Chave de configuracao da porta TCP do proxy
	 */
	public static final String KEY_SETTING_PROXY_PORT = "Proxy.port";
	
	/**
	 * Chave de configuracao do usuario do proxy
	 */
	public static final String KEY_SETTING_PROXY_USERNAME = "Proxy.username";
	
	/**
	 * Chave de configuracao da senha criptografada do proxy
	 */
	public static final String KEY_SETTING_PROXY_PASSWORD = "Proxy.password";
	
	/**
	 * Prefixo dos arquivos CSV do engine de persistencia
	 * 
	 * @see CSVEntityManager
	 */
	public static final String CSV_FILE_PREFIX = "TEST.DATA.";
	
	/**
	 * Sufixo dos arquivos CSV do engine de persistencia
	 * 
	 * @see CSVEntityManager
	 */
	public static final String CSV_FILE_SUFFIX = ".CSV";
	
	/**
	 * <p>Session variable para armazenar o objeto para chamar a primeira fase da chamada OAuth.</p>
	 * 
	 * @see AbstractApiObject#authenticate()
	 */
	public static final String SESSION_VARIABLE_OAUTH2_API_OBJECT = "OAUTH2_API_OBJECT";
	
	/**
	 * <p>Session variable para armazenar o ServiceRest(API) alvo da segunda fase da chamada OAuth.</p>
	 * 
	 * @see TestRestAPIObject#execute()
	 */
	public static final String SESSION_VARIABLE_OAUTH2_TARGET_API = "OAUTH2_TARGET_API";

	/**
	 * <p>Session variable para armazenar o AccessToken(SESSAO) para uso na segunda fase da chamada OAuth.</p>
	 * 
	 * @see TestRestAPIObject#execute()
	 */
	public static final String SESSION_VARIABLE_OAUTH2_ACCESS_TOKEN = "OAUTH2_ACCESS_TOKEN";	

	/**
	 * <p>Nome Api(RestService) cadastrada PortalAPI(ServiceBus) e
	 * no arquivo api.properties para autenticacao oAuth2.</p>
	 */
	public static final String API_NAME_OAUTH2_TOKEN = "oauth2_token";
	
	/**
	 * <p>Session variable para armazenar AutoItX/Driver.</p>
	 * 
	 * @see AutoItUtils#open(String, String)
	 * @see AbstractWindowObject
	 */
	public static final String SESSION_VARIABLE_AUTOIT_DRIVER = "AUTOITX_DRIVER";
	
	/**
	 * <p>Session variable para armazenar o Id do processo gerenciado via AutoIT.</p>
	 * 
	 * @see AutoItUtils#open(String, String)
	 * @see AbstractWindowObject
	 */
	public static final String SESSION_VARIABLE_AUTOIT_PROCESS_ID = "AUTOITX_PROCESS_ID";
	
}
