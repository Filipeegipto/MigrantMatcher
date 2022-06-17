package Classes;
import java.util.LinkedList;
import java.util.List;

import Handlers.SMSHandler;

public class Cat�logoDeRegi�es {
	private List<Regi�o> catRegi�es;
	private Regi�o lastReqRegion;
	
	public Cat�logoDeRegi�es() {
		this.catRegi�es = new LinkedList<>();
	}
	
	public void criarRegi�o(String nome) {
		this.catRegi�es.add(new Regi�o(nome, 
				this.catRegi�es.size() > 0 ? this.catRegi�es.get(0) : null));
	}

	public Cat�logoDeOfertas escolherRegi�o(String nome) throws NoSuchRegionException {
		this.lastReqRegion = null;
		for(Regi�o r: this.catRegi�es)
			if(r.getNome().equals(nome))
				this.lastReqRegion = r;
		if (this.lastReqRegion == null)
			throw new NoSuchRegionException();
		return this.lastReqRegion.pedirListaDeOfertas();
		
	}

	public void criarPedido(int index, Migrante m) throws NoSuchHelpException {
		this.lastReqRegion.criarPedido(index, m);
	}

	public Volunt�rio confirmarPedido(int index) {
		return this.lastReqRegion.confirmarPedido(index);
	}
	
	public Regi�o getRegi�o(String nome) {
		Regi�o r = null;
		for(Regi�o reg: this.catRegi�es)
			if (reg.getNome().equals(nome))
				r = reg;
		return r;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Regi�o r: this.catRegi�es) 
			if(!r.getNome().equals("geral"))
				sb.append(r.getNome() + "\n");
		return sb.toString();
	}

	public void criarNotifica��o(Migrante m, SMSHandler sh) {
		Notifica��o n = new Notifica��o(this.lastReqRegion, m, sh);
		this.lastReqRegion.criarNotifica��o(n);
		this.getRegi�o("geral").criarNotifica��o(n); 
	}
}
