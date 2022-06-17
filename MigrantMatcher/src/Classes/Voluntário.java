package Classes;

public class Volunt�rio {

	private int numTelefone;
	
	public Volunt�rio(int num) {
		this.numTelefone = num;
	}

	public int getNumero() {
		return this.numTelefone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Volunt�rio))
			return false;
		Volunt�rio other = (Volunt�rio) obj;
		if (numTelefone != other.numTelefone)
			return false;
		return true;
	}
}
