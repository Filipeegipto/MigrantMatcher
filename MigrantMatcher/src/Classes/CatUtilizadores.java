package Classes;
import java.util.ArrayList;
import java.util.List;

public class CatUtilizadores {

	private List<Volunt�rio> catVolunt�rios;
	private List<Migrante> catMigrantes;	
	
	public CatUtilizadores() {
		this.catVolunt�rios = new ArrayList<Volunt�rio>();
		this.catMigrantes = new ArrayList<Migrante>();
	}
	
	public Volunt�rio criarVolunt�rio(int numTelefone) {
		Volunt�rio v = null;
		for(Volunt�rio v1: this.catVolunt�rios) {
			if(v1.getNumero() == numTelefone)
				return v1;
		}
		v = new Volunt�rio(numTelefone);
		this.catVolunt�rios.add(v);
		return v;
	}

	
	public Migrante criarMigrante(String nome, int numTelefone) {
		Migrante m = new Migrante(nome, numTelefone);
		this.catMigrantes.add(m);
		return m;
	}
	
	public Migrante criarMigrante(String nome) {
		Migrante m = new Migrante(nome);
		this.catMigrantes.add(m);
		return m;
	}
}
