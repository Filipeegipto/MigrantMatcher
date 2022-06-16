package Classes;
import java.util.ArrayList;
import java.util.List;

public class CatUtilizadores {

	private List<Voluntário> catVoluntários;
	private List<Migrante> catMigrantes;	
	
	public CatUtilizadores() {
		this.catVoluntários = new ArrayList<Voluntário>();
		this.catMigrantes = new ArrayList<Migrante>();
	}
	
	public Voluntário criarVoluntário(int numTelefone) {
		Voluntário v = null;
		for(Voluntário v1: this.catVoluntários) {
			if(v1.getNumero() == numTelefone)
				return v1;
		}
		v = new Voluntário(numTelefone);
		this.catVoluntários.add(v);
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
