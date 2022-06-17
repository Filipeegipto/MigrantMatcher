package Classes;
import java.util.LinkedList;
import java.util.List;

public class Região {
	private String nome;
	private CatálogoDeOfertas catOfertas;
	private List<Notificação> listNotis;
	
	public Região(String r, Região geral){
		this.nome = r;
		if(geral != null) {
			this.catOfertas = new CatálogoDeOfertas(geral.pedirListaDeOfertas());
		} else {
			this.catOfertas = new CatálogoDeOfertas();
		}
		this.listNotis = new LinkedList<>();
	}

	public void criarOfertaDeAjuda(Ajuda a) {
		this.catOfertas.criarOfertaDeAjuda(a);	
		if(this.listNotis.size() > 0) {
			for(Notificação n: this.listNotis) {
				n.send();
				this.listNotis.remove(0);
			}
		}
	}

	public String getNome() {
		return this.nome;
	}

	public CatálogoDeOfertas pedirListaDeOfertas() {
		return this.catOfertas;
	}

	public void criarPedido(int index, Migrante m) {
		this.catOfertas.criarPedido(index, m);
	}

	public Voluntário confirmarPedido(int index) {
		return this.catOfertas.confirmar(index);
	}

	public void criarNotificação(Notificação notificação) {
		this.listNotis.add(notificação);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Região))
			return false;
		Região other = (Região) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
