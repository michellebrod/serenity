#language: pt
#encoding: UTF-8

@TesteRegressivo
Funcionalidade: Cadastro

  @Test1
  Esquema do Cenário: Cadastro de usuario com sucesso
    Dado que estou na pagina "<URL>"
    Quando insiro o nome "<Nome>"
    E insiro o email "<email>"
    E insiro a senha "<senha>"
    E clico no botao cadastrar
    Então valido o cadastro na tabela

    Exemplos: 
      | URL                                         | Nome           | email           | senha    |
      | http://prova.stefanini-jgr.com.br/teste/qa/ | Teste da Silva | teste@gmail.com | teste123 |
      
	@Test2
  Esquema do Cenário: validar campo obrigatorio
    Dado que estou na pagina "<URL>"
    Quando clico no botao cadastrar
    Então valido a mensagem de erro nos campos obrigatorios
	
	Exemplos: 
      | URL                                         |
      | http://prova.stefanini-jgr.com.br/teste/qa/ |
      
   @Test3
  Esquema do Cenário: validar cados invalidos nos campos
    Dado que estou na pagina "<URL>"
    Quando insiro o nome "<Nome>"
    E insiro o email "<email>"
    E insiro a senha "<senha>"
    E clico no botao cadastrar
    Então valido a mensagem de erro dados invalidos

    Exemplos: 
      | URL                                         | Nome    |email            | senha    |
      | http://prova.stefanini-jgr.com.br/teste/qa/ | Teste   | testegmail.com  | teste    |
	
	
	@Test4
  Esquema do Cenário: validar exclusao dos dados na tabela
    Dado que estou na pagina "<URL>"
    Quando insiro o nome "<Nome>"
    E insiro o email "<email>"
    E insiro a senha "<senha>"
    E clico no botao cadastrar
    Então excluo o cadastro realizado

    Exemplos:  
      | URL                                         | Nome           | email           | senha    |
      | http://prova.stefanini-jgr.com.br/teste/qa/ | Teste da Silva | teste@gmail.com | teste123 |
