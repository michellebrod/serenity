$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features//LoginTeste.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@Project:QAV"
    },
    {
      "name": "@TestRunKey:QAV-R165"
    },
    {
      "name": "@Issues:QAV-T378"
    },
    {
      "name": "@TMJ"
    },
    {
      "name": "@TesteRegressivo"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Acesso sem Senha",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@Issue:QAV-T378"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina \"\u003cURL\u003e\"",
  "keyword": "Dado "
});
formatter.step({
  "name": "preencho o campo usuario com o valor \"\u003cUsuario\u003e\"",
  "keyword": "Quando "
});
formatter.step({
  "name": "preencho o campo senha com o valor \"\u003cUsuario\u003e\"",
  "keyword": "E "
});
formatter.step({
  "name": "clico no botão Entrar",
  "keyword": "Entao "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "URL",
        "Usuario"
      ]
    },
    {
      "cells": [
        "https://login.webmotors.com.br/?\u0026r:https://www.webmotors.com.br\u0026inst\u003dheader:webmotors::logar-ou-cadastrar",
        "WIL.AMORIM23@GMAIL.COM"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Acesso sem Senha",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@Project:QAV"
    },
    {
      "name": "@TestRunKey:QAV-R165"
    },
    {
      "name": "@Issues:QAV-T378"
    },
    {
      "name": "@TMJ"
    },
    {
      "name": "@TesteRegressivo"
    },
    {
      "name": "@Issue:QAV-T378"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que estou na pagina \"https://login.webmotors.com.br/?\u0026r:https://www.webmotors.com.br\u0026inst\u003dheader:webmotors::logar-ou-cadastrar\"",
  "keyword": "Dado "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.LoginSteps.queEstouNaPaginaDeLogin(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho o campo usuario com o valor \"WIL.AMORIM23@GMAIL.COM\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.LoginSteps.preencho_o_campo_usuario_com_o_valor(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencho o campo senha com o valor \"WIL.AMORIM23@GMAIL.COM\"",
  "keyword": "E "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.LoginSteps.preencho_o_campo_senha_com_o_valor(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clico no botão Entrar",
  "keyword": "Entao "
});
formatter.match({
  "location": "br.com.selenium.bdd.stepDefinition.LoginSteps.clico_no_botão_Entrar()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});