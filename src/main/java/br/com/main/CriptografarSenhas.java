package br.com.main;

import br.com.selenium.utils.CryptoUtils;

public class CriptografarSenhas {
	public static void main( String[] args )
    {
        System.out.println("Iniciando criptografia da senha informada");
        System.out.println("");
        System.out.println(CryptoUtils.encryptBase64(args[0]));
        System.out.println("");
        System.out.println("Processo finalizado");
    }
}