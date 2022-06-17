package Handlers;
import Classes.CatálogoDeOfertas;
import Classes.CatálogoDeRegiões;
import Classes.Migrante;
import Classes.NoSuchHelpException;
import Classes.NoSuchRegionException;
import Classes.Região;
import Classes.Voluntário;

public class PedirAjudaHandler {
	private CatálogoDeRegiões catRegiões;
	
	public PedirAjudaHandler(String[] rNomes) {
		this.catRegiões = new CatálogoDeRegiões();
		for(String s: rNomes)
			this.catRegiões.criarRegião(s);
	}
	
	public CatálogoDeRegiões pedirListaDeRegiões() {
		return this.catRegiões;
	}
	
	public CatálogoDeOfertas escolherRegião(String nome) throws NoSuchRegionException {
		return this.catRegiões.escolherRegião(nome);
	}
	
	public void criarPedido(int index, Migrante m) throws NoSuchHelpException {
		this.catRegiões.criarPedido(index, m);
	}
	
	public Voluntário confirmarPedido(int index) {
		return this.catRegiões.confirmarPedido(index);
	}
	
	public Região getRegião(String nome) {
		return this.catRegiões.getRegião(nome);
	}

	public void serNotificado(Migrante m, SMSHandler sh) {
		this.catRegiões.criarNotificação(m, sh);
	}
}
