package br.com.selenium.utils;

import java.util.ResourceBundle;

public class ParametrosAmbienteUtils {

    private static final ResourceBundle PARAMETROS_AMBIENTE = ResourceBundle.getBundle("parametros-ambiente");
    private static final ResourceBundle AUTOMATION_SETTINGS = ResourceBundle.getBundle("automation-settings");

    public static String get(String parametro){
        StringBuilder sb = new StringBuilder();
        String enviroment = AUTOMATION_SETTINGS.getString("DEFAULT_ENVIRONMENT");
        if(enviroment.equals("UAT")){
            sb.append("UAT.");
        }else if(enviroment.equals("QA")){
            sb.append("QA.");
        }
        return PARAMETROS_AMBIENTE.getString(sb.append(parametro).toString());
    }

    public static Boolean getBoolean(String parametro){
        StringBuilder sb = new StringBuilder();
        String enviroment = AUTOMATION_SETTINGS.getString("DEFAULT_ENVIRONMENT");
        if(enviroment.equals("UAT")){
            sb.append("UAT.");
        }else if(enviroment.equals("QA")){
            sb.append("QA.");
        }
        return PARAMETROS_AMBIENTE.getString(sb.append(parametro).toString()).toLowerCase().equals("true");
    }

}
