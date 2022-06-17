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
import Classes.Volunt�rio;
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
		
		Volunt�rio v = ih.criarVolunt�rio(num);
		Volunt�rio v2 = ih.criarVolunt�rio(num);
		Volunt�rio v3 = ih.criarVolunt�rio(num + 1);
		
		assertEquals(true, v.equals(v2));
		assertEquals(false, v.equals(v3));
		
		String[] reg = {"geral", "Lisboa"};
		PedirAjudaHandler ph = new PedirAjudaHandler(reg);
		CriarAjudaHandler ch = new CriarAjudaHandler();
		
		ch.criarAlojamento("9 pessoas", v);
		ch.defineRegi�o(ph.getRegi�o("Lisboa"));
		Ajuda a = ch.criarOfertaDeAjuda();
		
		assertEquals(v, a.getVolunt�rio());
		assertEquals("9 pessoas", a.getDescri��o());
		assertEquals(true, ph.getRegi�o("Lisboa").equals(a.getRegi�o()));
		assertEquals(true, a.�Alojamento());
		assertEquals("Alojamento: 9 pessoas", a.toString());
		
		ch.criarItem("Cama", v3);
		Ajuda b = ch.criarOfertaDeAjuda();
		
		assertNotEquals(ph.getRegi�o("Lisboa"), b.getRegi�o());
		assertEquals(false, b.�Alojamento());
		
		CriarOfertaDeAjudaHandler coh = new CriarOfertaDeAjudaHandler(ph.pedirListaDeRegi�es());
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
		f.setCabe�a(m);
		
		assertEquals(n, f.getTamanho());
		assertEquals(m, f.getCabe�a());
		
		ph.escolherRegi�o("Lisboa");
		ph.criarPedido(0, m);
		ph.criarPedido(1, m);
		
		assertEquals("Lisboa\n", ph.pedirListaDeRegi�es().toString());
		assertNotEquals("0 - " + a.toString() + "\n", ph.escolherRegi�o("Lisboa").toString(0));
		assertEquals("0 - " + a.toString() + "\n1 - " + b.toString() + "\n", ph.escolherRegi�o("Lisboa").toString(0));
		
		ph.confirmarPedido(0);
		
		assertEquals("0 - " + b.toString() + "\n", ph.escolherRegi�o("Lisboa").toString(0));
		
		ph.confirmarPedido(0);
		
		assertEquals("N�o existem ajudas disponiveis nesta regi�o. \n", ph.escolherRegi�o("Lisboa").toString(0));		
		
		SMSHandler sh = new SMSHandler();
		Integer code = rd.nextInt(99999);
		sh.send(((Integer) rd.nextInt(999999999)).toString(), code.toString());
		
		assertEquals(true, sh.confirmar(code.toString()));
		
		ph.serNotificado(m, sh);
		coh.criarOfertaDeAjuda(a);
		
		assertEquals("J� existem ajudas disponiveis na regi�o Lisboa", sh.toString());
		assertThrows(NoSuchHelpException.class, () -> ph.criarPedido(3, m3));
		assertThrows(NoSuchRegionException.class, () -> ph.escolherRegi�o("�vora"));
	}

}
