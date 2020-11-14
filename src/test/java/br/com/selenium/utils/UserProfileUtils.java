/**
 * 
 */
package br.com.selenium.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.exec.environment.EnvironmentUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Classe utilitaria para parametrizacoes de usuarios (senhas, etc)</p>
 * 
 * <p>Tem como objetivo parametrizar as senhas dos usuarios permitindo assim 
 * a construcao de gherkins em alto nivel independentes da senha do usuario.</p>
 * 
 * <p>Trabalha em conjunto com CryptoUtils e EnvironmentUtils</p> 
 * 
 * @see EnvironmentUtils
 * @see CryptoUtils
 *
 */
public final class UserProfileUtils {

	/**
	 * Logger da classe
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserProfileUtils.class);

	/**
	 * constantes
	 */
	private static final Character ITEM_SEPARATOR = ':'; 
	
	/**
	 * Resource bundle do arquivo properties
	 */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle("passwd");

	
	/**
	 * Metodo construtor privado conforme pattern Utils
	 */
	private UserProfileUtils() {
	}

	/**
	 * Obtem a senha aberta a partir do arquivo de senhas criptografadas
	 * 
	 * @param userName nome do usuario
	 * @return senha aberta
	 */
	public static final String getPassword(final String userName) {
		final String[] userSettings;
		final String cryptPassword;
		userSettings = getUserSettings(userName);
		cryptPassword = (userSettings == null ? null
				: userSettings.length > 0 ? userSettings[0] : null);

		return CryptoUtils.decryptBase64(cryptPassword);
	}

	/**
	 * Obtem o profile/configuracoes do usuario a partir do arquivo de usuarios
	 * 
	 * @param userName nome do usuario
	 * @return array de configuracoes
	 */
	public static final String[] getUserSettings(String userName) {
		String userSettings;
		final String[] userSettingsArray;
		String ambiente = "";

		userName = StringUtils.upperCase(userName);
		
		if(!(System.getProperty(GlobalConstants.SYS_VARIABLE_RQM_ENVIRONMENT)==null)){
			ambiente = System.getProperty(GlobalConstants.SYS_VARIABLE_RQM_ENVIRONMENT);
		}
		
		
		LOGGER.trace("getting user settings from profile file [userName: {}]",
				userName);
		try {

			if(ambiente.isEmpty()){
				userSettings = RESOURCE_BUNDLE.getString(userName);
			}else{
				userSettings = RESOURCE_BUNDLE.getString(ambiente);
				
				userSettings = RESOURCE_BUNDLE.getString(
						(String.format(GlobalConstants.KEY_SETTING_PASSWORD, userSettings, userName)));
			}
			
			if (StringUtils.isEmpty(userSettings)){
				userSettingsArray = null;
			} else {
				userSettingsArray = StringUtils.split(userSettings, ITEM_SEPARATOR);
			}
			LOGGER.debug("user settings obtained from profile file [userName: {}, userSettings: {}]",
					userName, StringUtils.join(userSettingsArray, ITEM_SEPARATOR));
		
		} catch (final MissingResourceException mre)  {
			final RuntimeException rte = new RuntimeException(
					String.format("Usuario nao localizado no arquivo passwd.properties de senhas criptografadas [userName: %s]", userName), 
					mre);
			LOGGER.error(rte.getMessage(), rte);
			throw rte;
		}

		return userSettingsArray;
	}

}
