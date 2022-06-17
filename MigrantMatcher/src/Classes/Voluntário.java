package Classes;

public class Voluntário {

	private int numTelefone;
	
	public Voluntário(int num) {
		this.numTelefone = num;
	}

	public int getNumero() {
		return this.numTelefone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Voluntário))
			return false;
		Voluntário other = (Voluntário) obj;
		if (numTelefone != other.numTelefone)
			return false;
		return true;
	}
}
