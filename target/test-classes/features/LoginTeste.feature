#language: pt
#encoding: UTF-8
 
### Informações do JIRA ###
 
# @Project:QAV         - Nome do projeto no JIRA
# @TestRunKey:QAV-R165 - ID da Execução no TMJ - caso não seja informado, uma nova execução será criada com os Casos de Testes da @Issues
# @Issues:QAV-T378     - Lista de Casos de Teste que pertencem à execução - deve ser informada se for necessária a criação da execução
# @TMJ                 - Tag que permite que sejam executados os passos iniciais para capturar as informações do TMJ

@Project:QAV            
@TestRunKey:QAV-R165
@Issues:QAV-T378
@TMJ

@TesteRegressivo
Funcionalidade: Login 
	
@Issue:QAV-T378
Esquema do Cenario: Acesso sem Senha
	Dado que estou na pagina "<URL>"
	Quando preencho o campo usuario com o valor "<Usuario>"
	E preencho o campo senha com o valor "<Usuario>"
	Entao clico no botão Entrar
	

Exemplos: 
	|URL				                                                                                               |Usuario|
	| https://login.webmotors.com.br/?&r:https://www.webmotors.com.br&inst=header:webmotors::logar-ou-cadastrar| WIL.AMORIM23@GMAIL.COM |