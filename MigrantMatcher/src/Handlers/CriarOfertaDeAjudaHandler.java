package Handlers;
import Classes.Ajuda;
import Classes.CatálogoDeRegiões;

public class CriarOfertaDeAjudaHandler {
	private CatálogoDeRegiões catRegiões;
	
	public CriarOfertaDeAjudaHandler(CatálogoDeRegiões catálogo) {
		this.catRegiões = catálogo;
	}
	
	public void criarOfertaDeAjuda(Ajuda a) {
		if (a.éAlojamento()) {
			a.getRegião().criarOfertaDeAjuda(a);
		} else {
			this.catRegiões.getRegião("geral").criarOfertaDeAjuda(a);
		}
	}
}
