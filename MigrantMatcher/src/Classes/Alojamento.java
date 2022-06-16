package Classes;

public class Alojamento extends Ajuda {
	
	public Alojamento(String descrição, boolean éAloj, Voluntário v) {
		super(descrição, éAloj, v);
	}

	public String toString() {
		return "Alojamento: " + super.getDescrição();
	}
}
