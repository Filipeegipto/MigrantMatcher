package Classes;

public class Alojamento extends Ajuda {
	
	public Alojamento(String descri��o, boolean �Aloj, Volunt�rio v) {
		super(descri��o, �Aloj, v);
	}

	public String toString() {
		return "Alojamento: " + super.getDescri��o();
	}
}
