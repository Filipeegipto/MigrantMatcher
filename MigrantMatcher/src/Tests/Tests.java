package Tests;
 
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import Classes.Ajuda;
import Classes.Familia;
import Classes.Migrante;
import Classes.NoSuchHelpException;
import Classes.NoSuchRegionException;
import Classes.Voluntário;
import Handlers.CriarAjudaHandler;
import Handlers.CriarOfertaDeAjudaHandler;
import Handlers.IdentificarHandler;
import Handlers.PedirAjudaHandler;
import Handlers.SMSHandler;

class Tests {

	@Test
	void test() throws NoSuchRegionException, NoSuchHelpException {
		IdentificarHandler ih = new IdentificarHandler();
		Random rd = new Random();
		
		int num = rd.nextInt(999999999);
		
		Voluntário v = ih.criarVoluntário(num);
		Voluntário v2 = ih.criarVoluntário(num);
		Voluntário v3 = ih.criarVoluntário(num + 1);
		
		assertEquals(true, v.equals(v2));
		assertEquals(false, v.equals(v3));
		
		String[] reg = {"geral", "Lisboa"};
		PedirAjudaHandler ph = new PedirAjudaHandler(reg);
		CriarAjudaHandler ch = new CriarAjudaHandler();
		
		ch.criarAlojamento("9 pessoas", v);
		ch.defineRegião(ph.getRegião("Lisboa"));
		Ajuda a = ch.criarOfertaDeAjuda();
		
		assertEquals(v, a.getVoluntário());
		assertEquals("9 pessoas", a.getDescrição());
		assertEquals(true, ph.getRegião("Lisboa").equals(a.getRegião()));
		assertEquals(true, a.éAlojamento());
		assertEquals("Alojamento: 9 pessoas", a.toString());
		
		ch.criarItem("Cama", v3);
		Ajuda b = ch.criarOfertaDeAjuda();
		
		assertNotEquals(ph.getRegião("Lisboa"), b.getRegião());
		assertEquals(false, b.éAlojamento());
		
		CriarOfertaDeAjudaHandler coh = new CriarOfertaDeAjudaHandler(ph.pedirListaDeRegiões());
		coh.criarOfertaDeAjuda(a);
		coh.criarOfertaDeAjuda(b);
		
		int n = rd.nextInt(999999999);
		Migrante m = new Migrante("Filipe", n);
		Migrante m2 = new Migrante("Filipe", n);
		Migrante m3 = new Migrante("Filipe");
		
		assertEquals(true, m.equals(m2));
		assertEquals(false, m.equals(m3));
		
		n = rd.nextInt(10);
		Familia f = new Familia(n);
		f.setCabeça(m);
		
		assertEquals(n, f.getTamanho());
		assertEquals(m, f.getCabeça());
		
		ph.escolherRegião("Lisboa");
		ph.criarPedido(0, m);
		ph.criarPedido(1, m);
		
		assertEquals("Lisboa\n", ph.pedirListaDeRegiões().toString());
		assertNotEquals("0 - " + a.toString() + "\n", ph.escolherRegião("Lisboa").toString(0));
		assertEquals("0 - " + a.toString() + "\n1 - " + b.toString() + "\n", ph.escolherRegião("Lisboa").toString(0));
		
		ph.confirmarPedido(0);
		
		assertEquals("0 - " + b.toString() + "\n", ph.escolherRegião("Lisboa").toString(0));
		
		ph.confirmarPedido(0);
		
		assertEquals("Não existem ajudas disponiveis nesta região. \n", ph.escolherRegião("Lisboa").toString(0));		
		
		SMSHandler sh = new SMSHandler();
		Integer code = rd.nextInt(99999);
		sh.send(((Integer) rd.nextInt(999999999)).toString(), code.toString());
		
		assertEquals(true, sh.confirmar(code.toString()));
		
		ph.serNotificado(m, sh);
		coh.criarOfertaDeAjuda(a);
		
		assertEquals("Já existem ajudas disponiveis na região Lisboa", sh.toString());
		assertThrows(NoSuchHelpException.class, () -> ph.criarPedido(3, m3));
		assertThrows(NoSuchRegionException.class, () -> ph.escolherRegião("Évora"));
	}

}
