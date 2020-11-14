#language: pt
#encoding: UTF-8
 
### Informações do JIRA ###
 
# @Project:QAV         - Nome do projeto no JIRA
# @TestRunKey:QAV-R165 - ID da Execução no TMJ - caso não seja informado, uma nova execução será criada com os Casos de Testes da @Issues
# @Issues:QAV-T156     - Lista de Casos de Teste que pertencem à execução - deve ser informada se for necessária a criação da execução
# @TMJ                 - Tag que permite que sejam executados os passos iniciais para capturar as informações do TMJ

@Project:QAV
@TestRunKey:QAV-R165
@Issues:QAV-T156
@TMJ

@SmokeTeste
Funcionalidade: Smoke Login

@Issue:QAV-T156
Esquema do Cenario: Acesso com Usuario e Senha
	Dado que estou na pagina "<URL>"
	Quando preencho o campo usuário com o valor "<Usuario>" e senha	
	E clico no botão "Entrar"
	Entao visualizo a mensagem "<Mensagem>"

Exemplos:
	|URL														                        |Usuario		  |Mensagem				        	|
	|		|USER_SENHA1	|Erro ao efetuar login		|