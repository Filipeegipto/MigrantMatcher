package Classes;

import java.util.LinkedList;
import java.util.List;

public class Familia {
	
	private List<Migrante> familia;
	private Migrante cabeça;
	private int tamanho;
	
	public Familia(int n){
		this.familia = new LinkedList<Migrante>();
		this.tamanho = n;
	}
	
	public void setCabeça (Migrante m) {
		this.cabeça = m;
		this.familia.add(m);
	}
	
	public void adicionarMembro(Migrante m) {
		this.familia.add(m);
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	public Migrante getCabeça() {
		return this.cabeça;
	}
}
