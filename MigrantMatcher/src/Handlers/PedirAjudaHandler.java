package Handlers;
import Classes.Cat�logoDeOfertas;
import Classes.Cat�logoDeRegi�es;
import Classes.Migrante;
import Classes.NoSuchHelpException;
import Classes.NoSuchRegionException;
import Classes.Regi�o;
import Classes.Volunt�rio;

public class PedirAjudaHandler {
	private Cat�logoDeRegi�es catRegi�es;
	
	public PedirAjudaHandler(String[] rNomes) {
		this.catRegi�es = new Cat�logoDeRegi�es();
		for(String s: rNomes)
			this.catRegi�es.criarRegi�o(s);
	}
	
	public Cat�logoDeRegi�es pedirListaDeRegi�es() {
		return this.catRegi�es;
	}
	
	public Cat�logoDeOfertas escolherRegi�o(String nome) throws NoSuchRegionException {
		return this.catRegi�es.escolherRegi�o(nome);
	}
	
	public void criarPedido(int index, Migrante m) throws NoSuchHelpException {
		this.catRegi�es.criarPedido(index, m);
	}
	
	public Volunt�rio confirmarPedido(int index) {
		return this.catRegi�es.confirmarPedido(index);
	}
	
	public Regi�o getRegi�o(String nome) {
		return this.catRegi�es.getRegi�o(nome);
	}

	public void serNotificado(Migrante m, SMSHandler sh) {
		this.catRegi�es.criarNotifica��o(m, sh);
	}
}
