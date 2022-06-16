package Classes;
import java.util.LinkedList;
import java.util.List;

public class Regi�o {
	private String nome;
	private Cat�logoDeOfertas catOfertas;
	private List<Notifica��o> listNotis;
	
	public Regi�o(String r, Regi�o geral){
		this.nome = r;
		if(geral != null) {
			this.catOfertas = new Cat�logoDeOfertas(geral.pedirListaDeOfertas());
		} else {
			this.catOfertas = new Cat�logoDeOfertas();
		}
		this.listNotis = new LinkedList<>();
	}

	public void criarOfertaDeAjuda(Ajuda a) {
		this.catOfertas.criarOfertaDeAjuda(a);	
		if(this.listNotis.size() > 0) {
			for(Notifica��o n: this.listNotis) {
				n.send();
				this.listNotis.remove(0);
			}
		}
	}

	public String getNome() {
		return this.nome;
	}

	public Cat�logoDeOfertas pedirListaDeOfertas() {
		return this.catOfertas;
	}

	public void criarPedido(int index, Migrante m) {
		this.catOfertas.criarPedido(index, m);
	}

	public Volunt�rio confirmarPedido(int index) {
		return this.catOfertas.confirmar(index);
	}

	public void criarNotifica��o(Notifica��o notifica��o) {
		this.listNotis.add(notifica��o);
	}
}
