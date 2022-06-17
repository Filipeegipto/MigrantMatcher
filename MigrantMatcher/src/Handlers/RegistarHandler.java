package Handlers;

import java.util.LinkedList;
import java.util.List;

import Classes.CatUtilizadores;
import Classes.Familia;
import Classes.Migrante;

public class RegistarHandler {
	
	private CatUtilizadores catUtilizadores;
	private List<Familia> famList;
	private Familia currentFam;
	
	public RegistarHandler() {
		this.catUtilizadores = new CatUtilizadores();
		this.famList = new LinkedList<>();
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
		this.famList.add(currentFam);
	}
}
