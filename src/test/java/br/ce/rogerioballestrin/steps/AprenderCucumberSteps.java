package br.ce.rogerioballestrin.steps;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.ce.rogerioballestrin.converters.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumberSteps {
	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
		
	}

	@Quando("^executá-lo$")
	public void executáLo() throws Throwable {
		
	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
		
	}
	
	private int contador = 0;
			
	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) {
	    contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) {
	    contador += arg1;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) {
	    Assert.assertEquals(arg1, contador);
	}
	
	private Date entrega = new Date();
	
	@Dado("^que a entrega é dia (.*)$")
	public void queAEntregaÉDia(@Transform(DateConverter.class) Date data) {
	    entrega = data;
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(entrega);
	    if(tempo.equals("dias")) {
	    	cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }
	    else if(tempo.equals("meses")) {
	    	cal.add(Calendar.MONTH, arg1);
	    }
	    entrega = cal.getTime();

	}

	@Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaEm(@Transform(DateConverter.class) Date data) {
		Assert.assertEquals(entrega, data);
	}
	
	@Dado("^que o ticket( especial)? é (A[A-F]{1}\\d{3})$")
	public void queOTicketÉAF(String tipo, String arg1) throws Throwable {

	}

	@Dado("^que o valor da passagem é R\\$ (.*)$")
	public void queOValorDaPassagemÉR$(Double numero) throws Throwable {
		//Double possui um construtor que aceita string
	}

	@Dado("^que o nome do passageiro é \"(.{5,20})\"$")
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable {

	}

	@Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable {

	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {

	}

	@Então("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
		
	}
}
