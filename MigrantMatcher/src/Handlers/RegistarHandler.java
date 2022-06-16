package Handlers;
import Classes.CatUtilizadores;
import Classes.Familia;
import Classes.Migrante;

public class RegistarHandler {
	
	private CatUtilizadores catUtilizadores;
	
	private Familia currentFam;
	
	public RegistarHandler() {
		this.catUtilizadores = new CatUtilizadores();
	}
	
	public Migrante criarMigrante(String nome, int numTelefone) {
		return this.catUtilizadores.criarMigrante(nome, numTelefone);		
	}
	
	public Migrante criarMigranteCabeça(String nome, int numTelefone) {
		Migrante m = this.catUtilizadores.criarMigrante(nome, numTelefone);		
		currentFam.setCabeça(m);
		return m;
	}	
	
	public void criarMigrante(String nome) {
		Migrante m = this.catUtilizadores.criarMigrante(nome);
		currentFam.adicionarMembro(m);
	}
	
	public void criarFamilia(int agregado) {
		this.currentFam = new Familia(agregado);
	}
}
