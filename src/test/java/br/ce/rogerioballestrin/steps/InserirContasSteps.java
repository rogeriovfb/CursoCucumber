package br.ce.rogerioballestrin.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class InserirContasSteps {
	
private WebDriver driver = new ChromeDriver();

@Dado("^que estou acessando a aplicação$")
public void queEstouAcessandoAAplicação() throws Throwable {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rogerio Ballestrin\\eclipse-workspace\\CursoCucumber\\chromedriver.exe");
    driver.get("https://srbarriga.herokuapp.com");
}

@Quando("^informo o usuário \"([^\"]*)\"$")
public void informoOUsuário(String arg1) throws Throwable {
    driver.findElement(By.id("email")).sendKeys(arg1);
}

@Quando("^a senha \"([^\"]*)\"$")
public void aSenha(String arg1) throws Throwable {
	driver.findElement(By.id("senha")).sendKeys(arg1);
}

@Quando("^seleciono entrar$")
public void selecionoEntrar() throws Throwable {
    driver.findElement(By.tagName("button")).click();
}

@Então("^visualizo a página inicial$")
public void visualizoAPáginaInicial() throws Throwable {
    Assert.assertEquals("Bem vindo, Rogério Ballestrin!", driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
}

@Quando("^seleciono Contas$")
public void selecionoContas() throws Throwable {
    driver.findElement(By.linkText("Contas")).click();
}

@Quando("^seleciono Adicionar$")
public void selecionoAdicionar() throws Throwable {
    driver.findElement(By.linkText("Adicionar")).click();
}

@Quando("^informo a conta \"([^\"]*)\"$")
public void informoAConta(String arg1) throws Throwable {
    driver.findElement(By.id("nome")).sendKeys(arg1);
}

@Quando("^seleciono Salvar$")
public void selecionoSalvar() throws Throwable {
    driver.findElement(By.tagName("button")).click();
}

@Então("^a conta é inserida com sucesso$")
public void aContaÉInseridaComSucesso() throws Throwable {
    Assert.assertEquals("Conta adicionada com sucesso!", driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
}

@Então("^sou notificado que o nome da conta é obrigatório$")
public void souNotificadoQueONomeDaContaÉObrigatório() throws Throwable {
    Assert.assertEquals("Informe o nome da conta", driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText());
}

@Então("^sou notificado que já existe uma conta com esse nome$")
public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable {
    Assert.assertEquals("Já existe uma conta com esse nome!", driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText());

}


}
