$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features//Cadastro.feature");
formatter.feature({
  "name": "Cadastro",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@TesteRegressivo"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Cadastro de usuario com sucesso",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@Test1"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina \"\u003cURL\u003e\"",
  "keyword": "Dado "
});
formatter.step({
  "name": "insiro o nome \"\u003cNome\u003e\"",
  "keyword": "Quando "
});
formatter.step({
  "name": "insiro o email \"\u003cemail\u003e\"",
  "keyword": "E "
});
formatter.step({
  "name": "insiro a senha \"\u003csenha\u003e\"",
  "keyword": "E "
});
formatter.step({
  "name": "clico no botao cadastrar",
  "keyword": "E "
});
formatter.step({
  "name": "valido o cadastro na tabela",
  "keyword": "Então "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "URL",
        "Nome",
        "email",
        "senha"
      ]
    },
    {
      "cells": [
        "http://prova.stefanini-jgr.com.br/teste/qa/",
        "Teste da Silva",
        "teste@gmail.com",
        "teste123"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Cadastro de usuario com sucesso",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@TesteRegressivo"
    },
    {
      "name": "@Test1"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina \"http://prova.stefanini-jgr.com.br/teste/qa/\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.queEstouNaPaginaDeLogin(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insiro o nome \"Teste da Silva\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.insiro_o_nome(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insiro o email \"teste@gmail.com\"",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.insiro_o_email(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insiro a senha \"teste123\"",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.insiro_a_senha(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no botao cadastrar",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.clico_no_botao_cadastrar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido o cadastro na tabela",
  "keyword": "Então "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.valido_o_cadastro_na_tabela()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "validar campo obrigatorio",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@Test2"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina \"\u003cURL\u003e\"",
  "keyword": "Dado "
});
formatter.step({
  "name": "clico no botao cadastrar",
  "keyword": "Quando "
});
formatter.step({
  "name": "valido a mensagem de erro nos campos obrigatorios",
  "keyword": "Então "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "URL"
      ]
    },
    {
      "cells": [
        "http://prova.stefanini-jgr.com.br/teste/qa/"
      ]
    }
  ]
});
formatter.scenario({
  "name": "validar campo obrigatorio",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@TesteRegressivo"
    },
    {
      "name": "@Test2"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina \"http://prova.stefanini-jgr.com.br/teste/qa/\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.queEstouNaPaginaDeLogin(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no botao cadastrar",
  "keyword": "Quando "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.clico_no_botao_cadastrar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido a mensagem de erro nos campos obrigatorios",
  "keyword": "Então "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.valido_a_mensagem_de_erro_nos_campos_obrigatorios()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "validar cados invalidos nos campos",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@Test3"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina \"\u003cURL\u003e\"",
  "keyword": "Dado "
});
formatter.step({
  "name": "insiro o nome \"\u003cNome\u003e\"",
  "keyword": "Quando "
});
formatter.step({
  "name": "insiro o email \"\u003cemail\u003e\"",
  "keyword": "E "
});
formatter.step({
  "name": "insiro a senha \"\u003csenha\u003e\"",
  "keyword": "E "
});
formatter.step({
  "name": "clico no botao cadastrar",
  "keyword": "E "
});
formatter.step({
  "name": "valido a mensagem de erro dados invalidos",
  "keyword": "Então "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "URL",
        "Nome",
        "email",
        "senha"
      ]
    },
    {
      "cells": [
        "http://prova.stefanini-jgr.com.br/teste/qa/",
        "Teste",
        "testegmail.com",
        "teste"
      ]
    }
  ]
});
formatter.scenario({
  "name": "validar cados invalidos nos campos",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@TesteRegressivo"
    },
    {
      "name": "@Test3"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina \"http://prova.stefanini-jgr.com.br/teste/qa/\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.queEstouNaPaginaDeLogin(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insiro o nome \"Teste\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.insiro_o_nome(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insiro o email \"testegmail.com\"",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.insiro_o_email(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insiro a senha \"teste\"",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.insiro_a_senha(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no botao cadastrar",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.clico_no_botao_cadastrar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "valido a mensagem de erro dados invalidos",
  "keyword": "Então "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.valido_a_mensagem_de_erro_dados_invalidos()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "validar exclusao dos dados na tabela",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@Test4"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina \"\u003cURL\u003e\"",
  "keyword": "Dado "
});
formatter.step({
  "name": "insiro o nome \"\u003cNome\u003e\"",
  "keyword": "Quando "
});
formatter.step({
  "name": "insiro o email \"\u003cemail\u003e\"",
  "keyword": "E "
});
formatter.step({
  "name": "insiro a senha \"\u003csenha\u003e\"",
  "keyword": "E "
});
formatter.step({
  "name": "clico no botao cadastrar",
  "keyword": "E "
});
formatter.step({
  "name": "excluo o cadastro realizado",
  "keyword": "Então "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "URL",
        "Nome",
        "email",
        "senha"
      ]
    },
    {
      "cells": [
        "http://prova.stefanini-jgr.com.br/teste/qa/",
        "Teste da Silva",
        "teste@gmail.com",
        "teste123"
      ]
    }
  ]
});
formatter.scenario({
  "name": "validar exclusao dos dados na tabela",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@TesteRegressivo"
    },
    {
      "name": "@Test4"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina \"http://prova.stefanini-jgr.com.br/teste/qa/\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.queEstouNaPaginaDeLogin(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insiro o nome \"Teste da Silva\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.insiro_o_nome(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insiro o email \"teste@gmail.com\"",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.insiro_o_email(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insiro a senha \"teste123\"",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.insiro_a_senha(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no botao cadastrar",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.clico_no_botao_cadastrar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "excluo o cadastro realizado",
  "keyword": "Então "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.CadastroSteps.excluo_o_cadastro_realizado()"
});
formatter.result({
  "status": "passed"
});
});