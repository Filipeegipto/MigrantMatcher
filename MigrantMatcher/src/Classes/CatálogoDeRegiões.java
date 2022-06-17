package Classes;
import java.util.LinkedList;
import java.util.List;

import Handlers.SMSHandler;

public class CatálogoDeRegiões {
	private List<Região> catRegiões;
	private Região lastReqRegion;
	
	public CatálogoDeRegiões() {
		this.catRegiões = new LinkedList<>();
	}
	
	public void criarRegião(String nome) {
		this.catRegiões.add(new Região(nome, 
				this.catRegiões.size() > 0 ? this.catRegiões.get(0) : null));
	}

	public CatálogoDeOfertas escolherRegião(String nome) throws NoSuchRegionException {
		this.lastReqRegion = null;
		for(Região r: this.catRegiões)
			if(r.getNome().equals(nome))
				this.lastReqRegion = r;
		if (this.lastReqRegion == null)
			throw new NoSuchRegionException();
		return this.lastReqRegion.pedirListaDeOfertas();
		
	}

	public void criarPedido(int index, Migrante m) throws NoSuchHelpException {
		this.lastReqRegion.criarPedido(index, m);
	}

	public Voluntário confirmarPedido(int index) {
		return this.lastReqRegion.confirmarPedido(index);
	}
	
	public Região getRegião(String nome) {
		Região r = null;
		for(Região reg: this.catRegiões)
			if (reg.getNome().equals(nome))
				r = reg;
		return r;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Região r: this.catRegiões) 
			if(!r.getNome().equals("geral"))
				sb.append(r.getNome() + "\n");
		return sb.toString();
	}

	public void criarNotificação(Migrante m, SMSHandler sh) {
		Notificação n = new Notificação(this.lastReqRegion, m, sh);
		this.lastReqRegion.criarNotificação(n);
		this.getRegião("geral").criarNotificação(n); 
	}
}
