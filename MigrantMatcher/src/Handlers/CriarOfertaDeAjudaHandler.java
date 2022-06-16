package Handlers;
import Classes.Ajuda;
import Classes.Cat�logoDeRegi�es;

public class CriarOfertaDeAjudaHandler {
	private Cat�logoDeRegi�es catRegi�es;
	
	public CriarOfertaDeAjudaHandler(Cat�logoDeRegi�es cat�logo) {
		this.catRegi�es = cat�logo;
	}
	
	public void criarOfertaDeAjuda(Ajuda a) {
		if (a.�Alojamento()) {
			a.getRegi�o().criarOfertaDeAjuda(a);
		} else {
			this.catRegi�es.getRegi�o("geral").criarOfertaDeAjuda(a);
		}
	}
}
