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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Migrante))
			return false;
		Migrante other = (Migrante) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numTelefone != other.numTelefone)
			return false;
		return true;
	}
	
	
}
