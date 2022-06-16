package Handlers;
import Classes.Ajuda;
import Classes.Cat·logoDeRegiıes;

public class CriarOfertaDeAjudaHandler {
	private Cat·logoDeRegiıes catRegiıes;
	
	public CriarOfertaDeAjudaHandler(Cat·logoDeRegiıes cat·logo) {
		this.catRegiıes = cat·logo;
	}
	
	public void criarOfertaDeAjuda(Ajuda a) {
		if (a.ÈAlojamento()) {
			a.getRegi„o().criarOfertaDeAjuda(a);
		} else {
			this.catRegiıes.getRegi„o("geral").criarOfertaDeAjuda(a);
		}
	}
}
