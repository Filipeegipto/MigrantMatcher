package Classes;

public class Migrante {
	
	private int numTelefone;
	private String nome;
	
	public Migrante(String nome, int num) {
		this.numTelefone = num;
		this.nome = nome;
	}
	
	public Migrante(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return this.numTelefone;
	}
}
