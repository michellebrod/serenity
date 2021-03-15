package br.com.selenium.bdd.stepDefinition;

import br.com.selenium.bdd.pageObject.CadastroPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastroSteps {
	CadastroPage cadastroPage = new CadastroPage();


	@Quando("preencho o campo senha com o valor {string}")
	public void preencho_o_campo_senha_com_o_valor(String string) {
		cadastroPage.preencherSenha(string);
	}

	@Dado("que estou na pagina {string}")
	public void queEstouNaPaginaDeLogin(String url) {
		cadastroPage.getDriver().get(url);
	}

	
	@Quando("insiro o nome {string}")
	public void insiro_o_nome(String string) {
		cadastroPage.preencherNome(string);
	}

	@Quando("insiro o email {string}")
	public void insiro_o_email(String string) {
		cadastroPage.preencherEmail(string);
	}

	@Quando("insiro a senha {string}")
	public void insiro_a_senha(String string) {
		cadastroPage.preencherSenha(string);
	}

	@Quando("clico no botao cadastrar")
	public void clico_no_botao_cadastrar() {
		cadastroPage.clicarBotaoCadastrar();
	}

	@Então("valido o cadastro na tabela")
	public void valido_o_cadastro_na_tabela() {
		cadastroPage.validarUsuarioCadastrado();
	}
	
	@Então("excluo o cadastro realizado")
	public void excluo_o_cadastro_realizado() {
		cadastroPage.clicarBotaoExcluir();
	}
	
	@Então("valido a mensagem de erro nos campos obrigatorios")
	public void valido_a_mensagem_de_erro_nos_campos_obrigatorios() {
	    cadastroPage.validarMensagemCampoObrigatorio();
	}
	

	@Então("valido a mensagem de erro dados invalidos")
	public void valido_a_mensagem_de_erro_dados_invalidos() {
		cadastroPage.validarMensagemCampoDadoInvalido();
	}


}
