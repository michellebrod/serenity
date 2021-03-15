package br.com.selenium.bdd.pageObject;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import br.com.selenium.utils.UserProfileUtils;
import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CadastroPage extends PageObject {

	@FindBy(id = "name")
	private WebElementFacade campoNome;

	@FindBy(id = "email")
	private WebElementFacade campoEmail;

	@FindBy(id = "password")
	private WebElementFacade campoSenha;

	@FindBy(id = "register")
	private WebElementFacade btnCadastrar;

	@FindBy(id = "removeUser1")
	private WebElementFacade btnExcluir;

	@FindBy(xpath = "//h2[contains(text(),'Usuários cadastrados')]")
	private WebElementFacade lblUserCadastrado;
	
	@FindBy(xpath = "//p[@class='error']")
	//private WebElementFacade lblError;
	private List<WebElementFacade> lblError;

	
	

	public void preencherNome(String nome) {
		clickOn(campoNome);
		campoNome.sendKeys(nome);
		clickOn(campoEmail);
	}

	public void preencherEmail(String email) {
		campoEmail.sendKeys(email);
		clickOn(campoSenha);
	}

	public void preencherSenha(String senha) {
		campoSenha.sendKeys(senha);
	}

	public void clicarBotaoCadastrar() {
		clickOn(btnCadastrar);
	}

	public void clicarBotaoExcluir() {
		clickOn(btnExcluir);
	}

	public void validarUsuarioCadastrado() {
		Assert.assertEquals("Usuários cadastrados", lblUserCadastrado.getText());
	}

	public void validarMensagemCampoObrigatorio() {
		Assert.assertEquals("O campo Nome é obrigatório.",lblError.get(0).getText());
		Assert.assertEquals("O campo E-mail é obrigatório.", lblError.get(1).getText());
		Assert.assertEquals("O campo Senha é obrigatório.",  lblError.get(2).getText());
	}
	
	public void validarMensagemCampoDadoInvalido() {
		Assert.assertEquals("Por favor, insira um nome completo.",lblError.get(0).getText());
		Assert.assertEquals("Por favor, insira um e-mail válido.", lblError.get(1).getText());
		Assert.assertEquals("A senha deve conter ao menos 8 caracteres.",  lblError.get(2).getText());
	}
}
