package Classes;
import java.util.LinkedList;
import java.util.List;

public class CatálogoDeOfertas {
	private List<Ajuda> catOfertas;
	private CatálogoDeOfertas itens;

	public CatálogoDeOfertas(CatálogoDeOfertas itList) {
		this.catOfertas = new LinkedList<>();
		this.itens = itList;
	}
	
	public CatálogoDeOfertas() {
		this.catOfertas = new LinkedList<>();
	}
	
	public void criarOfertaDeAjuda(Ajuda a) {
		this.catOfertas.add(a);
	}

	public void criarPedido(int index, Migrante m) {
		if(index < this.catOfertas.size()) {
			this.catOfertas.get(index).setMigrante(m);
		} else {
			this.itens.criarPedido(index-this.catOfertas.size(), m);
		}
	}

	public Voluntário confirmar(int index) {
		if(index < this.catOfertas.size()) {
			Voluntário r = this.catOfertas.get(index).getVoluntário();
			this.catOfertas.remove(index);
			return r;
		} else {
			return this.itens.confirmar(index-this.catOfertas.size());
		}
	}
	
	public String toString(int i) {
		StringBuilder sb = new StringBuilder();
		if (this.catOfertas.size() > 0 && this.itens != null && this.itens.size() > 0) {
			for(Ajuda a: this.catOfertas)
				sb.append(i + " - " + a.toString() + "\n");
				i++;
			sb.append(this.itens.toString(i));
		} else if (this.catOfertas.size() == 0 && this.itens == null){
			sb.append("Não existem ajudas disponiveis nesta região. \n");
		} else if (this.catOfertas.size() > 0 && (this.itens == null || this.itens.size() == 0)) {
			for(Ajuda a: this.catOfertas)
				sb.append(i + " - " + a.toString() + "\n");
				i++;
		} else {
			sb.append(this.itens.toString(i));
		}
		return sb.toString();
	}

	private int size() {
		return this.catOfertas.size();
	}
}
